package cn.ffhh.bookstore.webservlet;

import cn.ffhh.bookstore.Factory.ServiceFactory;
import cn.ffhh.bookstore.domain.Book;
import cn.ffhh.bookstore.domain.Category;
import cn.ffhh.bookstore.service.IBookService;
import cn.ffhh.bookstore.service.ICategoryService;
import cn.itcast.servlet.BaseServlet;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class AdminCategoryServlet
 */
@WebServlet("/admincategoryservlet")
public class AdminCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private ICategoryService categoryService = ServiceFactory.getCategoryServiceInstance();
	private IBookService bookService = ServiceFactory.getBookServiceInstance();
    public String index(HttpServletRequest request,HttpServletResponse response) {
    	List<Category> categories = categoryService.findallCategories();
    	request.setAttribute("categories", categories);
    	return "f:/WEB-INF/jsps/category/list.jsp";
    }
    public String delete(HttpServletRequest request,HttpServletResponse response) {
    	String cid = request.getParameter("cid");
    	List<Book> books= bookService.findAllDetail(Integer.valueOf(cid));
    	if(books.size()>0) {
    		request.getSession().setAttribute("msg", "删除失败！该分类下存在图书，不允许删除");
    		return "r:/admincategoryservlet?method=index";
    	}
    	if(categoryService.delete(Integer.valueOf(cid))) {
    		request.getSession().setAttribute("msg", "删除失败！");
    	}else {
    		request.getSession().setAttribute("msg", "删除成功");
    	}
    	return "r:/admincategoryservlet?method=index";
    	
    }
    public String update(HttpServletRequest request,HttpServletResponse response) {
    	String cid = request.getParameter("cid");
    	String cname = request.getParameter("cname");
    	Category category  = categoryService.findCategory(Integer.valueOf(cid));
    	if(category==null || category.getCname().equals(cname)) {
    		request.getSession().setAttribute("msg", "分类不存在，或者该分类名称已存在");
    		return "r:/admincategoryservlet?method=index";
    	}
    	category.setCname(cname);
    	if(categoryService.update(category)) {
    		request.getSession().setAttribute("msg", "更新成功");
    	}else {
    		request.getSession().setAttribute("msg", "更新失败");
		};
		return "r:/admincategoryservlet?method=index";
    }
    public String add(HttpServletRequest request,HttpServletResponse response) {
    	Category category = new Category();
    	try {
			BeanUtils.populate(category, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
    	if(categoryService.add(category)) {
    		request.getSession().setAttribute("msg", "添加分类成功");
    	}else {
    		request.getSession().setAttribute("msg", "添加分类失败");
    	}
    	return "r:/admincategoryservlet?method=index";
    }

}
