package cn.ffhh.bookstore.service.imp;

import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;

import cn.ffhh.bookstore.Factory.DaoFactory;
import cn.ffhh.bookstore.dao.IUserDao;
import cn.ffhh.bookstore.domain.User;
import cn.ffhh.bookstore.service.IUserService;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;

public class UserServiceImp implements IUserService {
	private IUserDao userdao = DaoFactory.getUserDaoInstance();
	@Override
	public void addUser(User user) throws UserException {
		User userU = userdao.findByUesername(user.getUsername());
		if(userU!=null) throw new UserException("用户名已被注册");
		User userE = userdao.findByEmail(user.getEmail());
		if(userE!=null) throw new UserException("邮箱已被注册");
		try {
			if(!userdao.doCreate(user)) throw new UserException("用户添加失败");
		} catch (SQLException e) {
			throw new UserException("用户添加失败");
		}
	}
	@Override
	public Map<String, String> checkRegistParam(User form,String password_confirmation){
		Map<String, String> errorMsg = new HashMap<String, String>();
		if(form.getUsername()=="" || form.getUsername()==null) {
			errorMsg.put("username", "用户名不能为空！");
		}else if(form.getUsername().length() >20){
			errorMsg.put("username", "用户名长度必须小于20字符");
		}
		//去除用户名前后空格
		form.setUsername(form.getUsername().trim());
		if(form.getEmail()==null || form.getEmail()=="") {
			errorMsg.put("email", "email不能为空");
		}else if(!form.getEmail().matches("^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
			errorMsg.put("email", "email格式错误");
		}
		//去除邮箱前后空格
		form.setEmail(form.getEmail().trim());
		if(form.getPassword()==null || form.getPassword()=="") {
			errorMsg.put("password", "密码不能为空");
		}else if(!form.getPassword().matches("^[a-zA-Z0-9_-]{6,20}$")){
			errorMsg.put("password", "长度6到20 字符，只能包含字母、数字、_和-");
		}else if(!form.getPassword().equals(password_confirmation)) {
			errorMsg.put("password_confirmation", "两次输入的密码不一样");
		}
		return errorMsg;
	}
	@Override
	public void seedActiveMail(Properties mailTemplate,User user) throws MessagingException, IOException {
		Session session = MailUtils.createSession(mailTemplate.getProperty("host"),
				mailTemplate.getProperty("username"), mailTemplate.getProperty("password"));
		String content = mailTemplate.getProperty("content");
		content = MessageFormat.format(content, user.getCode(),user.getCode());
		MailUtils.send(session, new Mail(mailTemplate.getProperty("frommail"),user.getEmail(),
				mailTemplate.getProperty("subject"),content));
	}
	@Override
	public void activeUser(String code) throws Exception {
		System.out.println(code);
		User user  = userdao.findByCode(code);
		if(user==null) throw new UserException("激活码无效");
		System.out.println(user);
		if(user.getState()==1) throw new UserException("已经激活，无需重复激活");
		if(!userdao.doUpdateState(user,1)) throw new UserException("激活出错，请重试");
	}
	@Override
	public Map<String, String> checkLoginParam(User form) {
		Map<String, String> errorMsg = new HashMap<String, String>();
		if(form.getEmail()==null || form.getEmail()=="") {
			errorMsg.put("email", "email不能为空");
		}
		if(form.getPassword()==null || form.getPassword()=="") {
			errorMsg.put("password", "密码不能为空");
		}
		return errorMsg;
	}
	@Override
	public User login(User form) throws Exception {
		User user = userdao.findByEmail(form.getEmail());
		if(user==null) throw new UserException("用户名密码错误");
		if(user.getState()!=1) {
			throw new UserException("该用户未激活，清激活后在登录");
		}else if(user.getPassword().equals(form.getPassword())){
			System.out.println(user);
			return user;
		}else {
			throw new UserException("用户名密码错误");
		}
	}
	
	
	
}
