package cn.ffhh.bookstore.Factory;

import cn.ffhh.bookstore.dao.IBookDao;
import cn.ffhh.bookstore.dao.ICartDao;
import cn.ffhh.bookstore.dao.ICartItemDao;
import cn.ffhh.bookstore.dao.ICategoryDao;
import cn.ffhh.bookstore.dao.IOrderDao;
import cn.ffhh.bookstore.dao.IUserDao;
import cn.ffhh.bookstore.dao.imp.BookDaoImp;
import cn.ffhh.bookstore.dao.imp.CartDaoImp;
import cn.ffhh.bookstore.dao.imp.CartItemDaoImp;
import cn.ffhh.bookstore.dao.imp.CategoryDaoImp;
import cn.ffhh.bookstore.dao.imp.OrderDaoImp;
import cn.ffhh.bookstore.dao.imp.UserDaoImp;

public class DaoFactory {
	public static IUserDao getUserDaoInstance() {
		return new UserDaoImp();
	}
	public static ICartDao getCartDaoInstance() {
		return new CartDaoImp();
	}
	public static ICartItemDao getCartItemDaoInstance() {
		return new CartItemDaoImp();
	}
	public static IBookDao getBookDaoInstance() {
		return new BookDaoImp();
	}
	public static ICategoryDao getCategoryDaoInstance() {
		return new CategoryDaoImp();
	}
	public static IOrderDao getOrderDaoInstance() {
		return new OrderDaoImp();
	}
}
