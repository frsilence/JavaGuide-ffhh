package cn.ffhh.bookstore.Factory;

import cn.ffhh.bookstore.service.IBookService;
import cn.ffhh.bookstore.service.ICartService;
import cn.ffhh.bookstore.service.ICategoryService;
import cn.ffhh.bookstore.service.IOrderService;
import cn.ffhh.bookstore.service.IUserService;
import cn.ffhh.bookstore.service.imp.BookServiceImp;
import cn.ffhh.bookstore.service.imp.CartServiceImp;
import cn.ffhh.bookstore.service.imp.CategoryServiceImp;
import cn.ffhh.bookstore.service.imp.OrderServiceImp;
import cn.ffhh.bookstore.service.imp.UserServiceImp;

public class ServiceFactory {
	public static IUserService getUserServiceInstance() {
		return new UserServiceImp();
	}
	public static ICartService getCartServiceInstance() {
		return new CartServiceImp();
	}
	public static IBookService getBookServiceInstance() {
		return new BookServiceImp();
	}
	public static IOrderService getOrderServiceInstance() {
		return new OrderServiceImp();
	}
	public static ICategoryService getCategoryServiceInstance() {
		return new CategoryServiceImp();
	}
}
