package cn.ffhh.bookstore.webservlet;

import cn.ffhh.bookstore.Factory.ServiceFactory;
import cn.ffhh.bookstore.domain.Cart;
import cn.ffhh.bookstore.domain.CartItem;
import cn.ffhh.bookstore.domain.Order;
import cn.ffhh.bookstore.domain.OrderItem;
import cn.ffhh.bookstore.domain.User;
import cn.ffhh.bookstore.service.ICartService;
import cn.ffhh.bookstore.service.IOrderService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/orderservlet")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private ICartService cartService = ServiceFactory.getCartServiceInstance();
    private IOrderService orderService = ServiceFactory.getOrderServiceInstance();
    public String add(HttpServletRequest request,HttpServletResponse response) {
    	request.getSession().removeAttribute("error");
    	String address = request.getParameter("address");
    	User user = (User)request.getSession().getAttribute("user");
    	Cart cart = null;
    	Order order = new Order();
    	try {
			cart = cartService.findCartByUserId(user.getUid());
		} catch (Exception e) {
			request.getSession().setAttribute("error", "用户购物车查询失败");
			return "r:/cartservlet?method=index";
		}
    	if(cart==null || cart.getCartitems().size()==0) {
    		request.getSession().setAttribute("error", "购物车中没有商品，无法生成订单");
    		return "r:/cartservlet?method=index";
    	}
    	order.setOid(CommonUtils.uuid());
    	order.setState(1);
    	order.setUser(user);
    	order.setTotal(cart.getTotal());
    	order.setAddress(address);
    	//添加订单子项
    	List<OrderItem> orderItems = new ArrayList<OrderItem>();
    	for(CartItem cartItem:cart.getCartitems()) {
    		OrderItem orderItem = new OrderItem();
    		orderItem.setIid(CommonUtils.uuid());
    		orderItem.setBook(cartItem.getBook());
    		orderItem.setCount(cartItem.getCount());
    		orderItem.setSubtotal(cartItem.getSubtotal());
    		orderItem.setOrder(order);
    		orderItems.add(orderItem);
    	}
    	//订单子项添加订单
    	order.setOrderItem(orderItems);
    	//清空购物车
    	try {
			cartService.clearCartitem(cart.getCid());
		} catch (Exception e) {
			request.setAttribute("error", "购物车清空失败");
		}
    	//添加订单
    	orderService.add(order);
    	request.setAttribute("order", order);
    	return "r:/orderservlet?method=index";
    }
    
    public String index(HttpServletRequest request,HttpServletResponse response) {
    	User user = (User) request.getSession().getAttribute("user");
    	List<Order> orders = orderService.allOrderDetailByUserId(user.getUid());
    	request.setAttribute("orders", orders);
    	return "f:/WEB-INF/jsps/order/order.jsp";
    }
    public String detail(HttpServletRequest request,HttpServletResponse response) {
		String oid = request.getParameter("oid");
		Order order = orderService.detail(oid);
		User user = (User)request.getSession().getAttribute("user");
		if(order!=null && user.getUid().equals(order.getUser().getUid())) {
			request.setAttribute("order", order);
			return "f:/WEB-INF/jsps/order/detail.jsp";
		}
		return "r:/orderservlet?method=index";
	}
    public String buy(HttpServletRequest request,HttpServletResponse response) {
    	String oid = request.getParameter("oid");
    	User user = (User)request.getSession().getAttribute("user");
    	Order order = orderService.detail(oid);
    	if(order!=null && user.getUid().equals(order.getUser().getUid())) {
    		order.setState(2);
    		if(orderService.updateState(order)) {
    			request.setAttribute("msg", "支付成功！");
    		}else {
    			request.setAttribute("msg", "支付失败！");
    		}
    	}
    	return "f:/orderservlet?method=detail&oid="+oid;
    }
    public String confirm(HttpServletRequest request,HttpServletResponse response) {
    	String oid = request.getParameter("oid");
    	User user = (User)request.getSession().getAttribute("user");
    	Order order = orderService.detail(oid);
    	if(order!=null && user.getUid().equals(order.getUser().getUid())) {
    		order.setState(4);
    		if(orderService.updateState(order)) {
    			request.setAttribute("msg", "确认收货成功！");
    		}else {
    			request.setAttribute("msg", "确认收货失败！");
    		}
    	}
    	return "f:/orderservlet?method=detail&oid="+oid;
    }

}
