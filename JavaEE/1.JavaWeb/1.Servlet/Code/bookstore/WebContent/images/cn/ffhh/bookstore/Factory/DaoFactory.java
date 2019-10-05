package cn.ffhh.bookstore.Factory;

import cn.ffhh.bookstore.dao.IUserDao;
import cn.ffhh.bookstore.dao.imp.UserDaoImp;

public class DaoFactory {
	public static IUserDao getUserDaoInstance() {
		return new UserDaoImp();
	}
}
