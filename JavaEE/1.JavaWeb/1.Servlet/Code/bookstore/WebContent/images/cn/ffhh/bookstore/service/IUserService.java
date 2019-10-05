package cn.ffhh.bookstore.service;

import cn.ffhh.bookstore.domain.User;

/**
 * 定义User服务的操作标准
 * 此接口可通过DaoFactory获得IUserDao接口的实例化对象
 * @author yfzhao
 *
 */
public interface IUserService {
	/**
	 * 	注册功能
	 * 	实现雇员信息的增加，本操作要调用IEmpDAO接口的如下方法：<br>
	 * 	<li>调用IUserDAO.findByEmail()方法来查询要添加的用户email是否已存在
	 *  <li>调用IUserDAO.findByUsername()方法来查询要添加的用户username是否已存在
	 * 	<li>若要添加的用户不存在，则调用IUserDAO.doCreate(User user)方法添加用户信息
	 * @param user 要添加的用户信息，确保包含用户邮箱
	 * @throws Exception 
	 */
	public void addUser(User user) throws Exception;
}
