package cn.ffhh.bookstore.webservlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import cn.ffhh.bookstore.Factory.ServiceFactory;
import cn.ffhh.bookstore.domain.Book;
import cn.ffhh.bookstore.domain.Category;
import cn.ffhh.bookstore.service.IBookService;
import cn.ffhh.bookstore.service.ICategoryService;
import cn.ffhh.bookstore.service.imp.BookException;
import cn.itcast.commons.CommonUtils;

/**
 * Servlet implementation class AdminUpload
 */
@WebServlet("/adminaddbookservlet")
public class AdminAddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookService bookService = ServiceFactory.getBookServiceInstance();
	private ICategoryService categoryService = ServiceFactory.getCategoryServiceInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;chartset=utf-8");
		//封装数据
		//上传三步
		//创建工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//得到解析器
		ServletFileUpload sfu = new ServletFileUpload(factory);
		//使用解析器去解析request对象，得到List<FileItem>
		try {
			List<FileItem> fileItemList = sfu.parseRequest(request);
			/*
			 *  把fileItemList中的数据封装到Book对象中
			 *  1、把所有非文件字段数据先封装到Map中
			 *  2、再把普通字段Map封装到Book中
			 */
			System.out.println(fileItemList);
			Map<String, String> commonFiledMap = new HashMap<String, String>();
			FileItem fileItemImg = null;
			for(FileItem fileItem:fileItemList) {
				if(fileItem.isFormField()) {
					commonFiledMap.put(fileItem.getFieldName(), fileItem.getString("utf-8"));
				}else {
					fileItemImg = fileItem;
				}
			}
			//检查分类是否存在
			String cid = commonFiledMap.get("cid");
			Category category = categoryService.findCategory(Integer.valueOf(cid));
			if(category==null) {
				request.getSession().setAttribute("addmsg", "分类不存在");
				response.sendRedirect(request.getContextPath()+"/adminbookservlet?method=index");
				return;
			}
			Book book = new Book();
			try {
				BeanUtils.populate(book, commonFiledMap);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			/**
			 * 	保存上传的文件
			 * 	保存目录
			 *	保存的文件名称 
			 */
			//得到保存的目录
			String savepath = this.getServletContext().getRealPath("/images/book_images");
			//得到文件名称，给原文件重命名
			String filename = CommonUtils.uuid()+"_"+fileItemImg.getName();
			//使用目录和文件名称创建目标文件
			File destFile = new File(savepath,filename);
			//保存上传的文件到目标文件
			try {
				fileItemImg.write(destFile);
				book.setImage("images/book_images/"+filename);
				book.setBid(CommonUtils.uuid());
				book.setCategory(category);
			} catch (Exception e) {
				e.printStackTrace();
			}
			bookService.add(book);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (BookException e) {
			request.getSession().setAttribute("addmsg", e.getMessage());
		}
		response.sendRedirect(request.getContextPath()+"/adminbookservlet?method=index");
		
	}

}
