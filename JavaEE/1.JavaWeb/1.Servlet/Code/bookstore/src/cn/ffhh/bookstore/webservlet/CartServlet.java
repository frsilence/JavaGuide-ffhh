package cn.ffhh.bookstore.webservlet;

import cn.ffhh.bookstore.Factory.ServiceFactory;
import cn.ffhh.bookstore.domain.Book;
import cn.ffhh.bookstore.domain.Cart;
import cn.ffhh.bookstore.domain.CartItem;
import cn.ffhh.bookstore.domain.User;
import cn.ffhh.bookstore.service.IBookService;
import cn.ffhh.bookstore.service.ICartService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cartservlet")
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private ICartService cartService = ServiceFactory.getCartServiceInstance();
	public IBookService bookService = ServiceFactory.getBookServiceInstance();
    /**
     * 	增加购物车子项   
     * @param request 需提供图书id和数量
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		if(user==null) return "r:/userservlet?method=login";
		String bid = request.getParameter("bid");
		String count = request.getParameter("count");
		CartItem cartItem = new CartItem();
		cartItem.setIid(CommonUtils.uuid());
		cartItem.setCount(Integer.valueOf(count));
		try {
			cartItem.setBook(bookService.findByBookId(bid));
			cartItem.setCart(cartService.findCartByUserId(user.getUid()));
			cartService.addCartitem(cartItem);
			Cart newCart = cartService.findCartByUserId(user.getUid());
			request.setAttribute("cart", newCart);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		return "r:/cartservlet?method=index";
	}
	public String index(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		User user = (User)request.getSession().getAttribute("user");
		System.out.println(user);
		Cart cart = null;
		List<Book> books = new ArrayList<Book>();
		try {
			cart = cartService.findCartByUserId(user.getUid());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		try {
			books = bookService.findAllDetail(null);
			request.setAttribute("books", books);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("cart", cart);
		return "f:/WEB-INF/jsps/cart/cart.jsp";
	}
	public String delete(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		CartItem cartItem = new CartItem();
		User user = (User)request.getSession().getAttribute("user");
		System.out.println(user);
		Cart ueserCart = new Cart();
		try {
			ueserCart = cartService.findCartByUserId(user.getUid());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		try {
			BeanUtils.populate(cartItem, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			request.setAttribute("error", "参数错误");
		}
		for(CartItem cartitem:ueserCart.getCartitems()) {
			if(cartitem.getIid().equals(cartitem.getIid())) {
				try {
					cartService.deleteCartitem(cartItem);
					Cart newCart = cartService.findCartByUserId(user.getUid());
					request.setAttribute("cart", newCart);
				} catch (Exception e) {
					request.setAttribute("error", e.getMessage());
				}
			}
		}
		request.setAttribute("error", "当前用户没有此购物车子项");
		return "r:/cartservlet?method=index";
	}
	
	public String clear(HttpServletRequest request,HttpServletResponse response) {
		User user = (User)request.getSession().getAttribute("user");
		Cart cart;
		try {
			cart = cartService.findCartByUserId(user.getUid());
			cartService.clearCartitem(cart.getCid());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		return "r:/cartservlet?method=index";
	}

}
