package cn.ffhh.bookstore.webservlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.ffhh.bookstore.Factory.ServiceFactory;
import cn.ffhh.bookstore.domain.Cart;
import cn.ffhh.bookstore.domain.User;
import cn.ffhh.bookstore.service.ICartService;
import cn.ffhh.bookstore.service.IUserService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

@SuppressWarnings("serial")
public class UserServlet extends BaseServlet {
	
	public IUserService userService = ServiceFactory.getUserServiceInstance();
	public ICartService cartService = ServiceFactory.getCartServiceInstance();
	/**
	 * 用户注册
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		//GET请求，返回注册页面
		if(request.getMethod().equals("GET")) return "f:/WEB-INF/jsps/user/regist.jsp";
		//注册
		//获取请求参数
		User form  = new User();
		BeanUtils.populate(form, request.getParameterMap());
		//检验参数
		Map<String, String> errorMsg = userService
				.checkRegistParam(form, request.getParameter("password_confirmation"));
		System.out.println(form);
		if(errorMsg.size()>0) {
			request.setAttribute("form", form);
			request.setAttribute("errorMsg", errorMsg);
			return "f:/WEB-INF/jsps/user/regist.jsp";
		}else {
			form.setUid(CommonUtils.uuid());
			form.setCode(CommonUtils.uuid()+CommonUtils.uuid());
			form.setState(0);
			try {
				userService.addUser(form);
				Properties properties = new Properties();
				properties.load(this.getClass().getClassLoader().
						getResourceAsStream("mailtemplate.properties"));
				userService.seedActiveMail(properties, form);
				return "f:/WEB-INF/jsps/user/registmsg.jsp";
			} catch (Exception e) {
				errorMsg.put("errormsg", "注册出错："+e.getMessage()+"请重试");
				request.setAttribute("errorMsg", errorMsg);
				return "f:/WEB-INF/jsps/user/regist.jsp";
			}
		}
		
	}
	public String active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		try {
			userService.activeUser(code);
		} catch (Exception e) {
			request.setAttribute("errormsg", e.getMessage());
		}
		return "f:/WEB-INF/jsps/user/activemsg.jsp";
	}
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		//GET请求返回登录页面
		if(request.getMethod().equals("GET")) return "f:/WEB-INF/jsps/user/login.jsp";
		//处理登录请求
		User form = new User();
		User user = null;
		//检测请求参数
		BeanUtils.populate(form, request.getParameterMap());
		Map<String, String> errorMsg = userService.checkLoginParam(form);
		if(errorMsg.size()>0) {
			request.setAttribute("errorMsg", errorMsg);
			request.setAttribute("form", form);
			return "f:/WEB-INF/jsps/user/login.jsp";
		}else {
			
		}
		try {
			user = userService.login(form);
			if(user!=null) {
				//给登录用户添加购物车
				Cart cart = cartService.findCartByUserId(user.getUid());
				if(cart!=null) {
					request.getSession().setAttribute("cartId", cart.getCid());
				}else {
					cartService.addCart(user);
				}
				request.getSession().setAttribute("user", user);
				request.getSession().setMaxInactiveInterval(3000);
				if("yes".equals(request.getParameter("remember"))) {
					Cookie[] cookies = request.getCookies();
					for(Cookie cookie:cookies) {
						if("JSESSIONID".equals(cookie.getName())) {
							cookie.setMaxAge(30000);
							response.addCookie(cookie);
						}
					}
				}
				return "r:/index.jsp";
			}
		} catch (Exception e) {
			request.setAttribute("errormsg", e.getMessage());
			request.setAttribute("form", form);
			return "f:/WEB-INF/jsps/user/login.jsp";
		}
		return null;
	}
	public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")!=null) request.getSession().removeAttribute("user");
		return "r:/userservlet?method=login";
	}
	
	
}
