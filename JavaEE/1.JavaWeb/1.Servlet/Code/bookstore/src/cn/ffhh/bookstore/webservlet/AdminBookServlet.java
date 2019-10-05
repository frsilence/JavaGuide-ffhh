package cn.ffhh.bookstore.webservlet;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.ffhh.bookstore.Factory.ServiceFactory;
import cn.ffhh.bookstore.domain.Book;
import cn.ffhh.bookstore.domain.Category;
import cn.ffhh.bookstore.service.IBookService;
import cn.ffhh.bookstore.service.ICategoryService;
import cn.ffhh.bookstore.service.imp.BookException;
import cn.itcast.servlet.BaseServlet;

@SuppressWarnings("serial")
@WebServlet("/adminbookservlet")
public class AdminBookServlet extends BaseServlet {
	private IBookService bookService = ServiceFactory.getBookServiceInstance();
	private ICategoryService categoryService = ServiceFactory.getCategoryServiceInstance();
	public String index(HttpServletRequest request,HttpServletResponse response) {
		List<Book> books = bookService.findAllDetail(null);
		List<Category> categories = categoryService.findallCategories();
		request.setAttribute("categories", categories);
		request.setAttribute("books", books);
		return "f:/WEB-INF/jsps/book/book.jsp";
	}
	public String delete(HttpServletRequest request,HttpServletResponse response) {
		String bid = request.getParameter("bid");
		Book book = new Book();
		try {
			book = bookService.findByBookId(bid);
			System.out.println(book);
			book.setDel(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println(book);
			bookService.delete(book);
		} catch (BookException e) {
			e.printStackTrace();
		}
		return "r:/adminbookservlet?method=index";
	}
	public String update(HttpServletRequest request,HttpServletResponse response) {
		Book book = new Book();
		try {
			BeanUtils.populate(book, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			request.getSession().setAttribute("error", "提供的信息不符合要求");
		}
		try {
			bookService.update(book);
		} catch (BookException e) {
			e.printStackTrace();
			request.getSession().setAttribute("updatemsg", e.getMessage());
		}
		return "r:/adminbookservlet?method=index";
	}
}
