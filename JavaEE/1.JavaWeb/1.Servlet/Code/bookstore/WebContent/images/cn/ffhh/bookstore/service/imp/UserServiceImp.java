package cn.ffhh.bookstore.service.imp;

import cn.ffhh.bookstore.Factory.DaoFactory;
import cn.ffhh.bookstore.dao.IUserDao;
import cn.ffhh.bookstore.domain.User;
import cn.ffhh.bookstore.service.IUserService;

public class UserServiceImp implements IUserService {
	private IUserDao userdao = DaoFactory.getUserDaoInstance();
	@Override
	public void addUser(User user) throws UserException {
		User userU = userdao.findByUesername(user.getUsername());
		if(userU!=null) throw new UserException("用户名已被注册");
		User userE = userdao.findByEmail(user.getEmail());if(userU!=null) throw new UserException("用户名已被注册");
		if(userE!=null) throw new UserException("邮箱已被注册");
		userdao.doCreate(user);
	}

}
