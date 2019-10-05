package cn.ffhh.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter("/*")
public class LoginFilter implements Filter {
	//不进行过滤的访问Servlet url字符串，由过滤器初始化参数获得
	private String excludedUrls;
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest requestH = (HttpServletRequest) request;
		HttpSession session = requestH.getSession();
		HttpServletResponse responseH = (HttpServletResponse) response;
		String[] urlStrings = this.excludedUrls.split(",");
		System.out.println(requestH.getServletPath());
		for(String url:urlStrings) {
			if(url.equals(requestH.getServletPath())) {
				chain.doFilter(request, response);
				return;
			}
		}
		if(session.getAttribute("user")==null) {
			session.setAttribute("lastUrl", requestH.getServletPath());
			responseH.sendRedirect(requestH.getContextPath()+"/userservlet?method=login");
			return;
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.excludedUrls = fConfig.getInitParameter("excludedUrls");
	}

}
