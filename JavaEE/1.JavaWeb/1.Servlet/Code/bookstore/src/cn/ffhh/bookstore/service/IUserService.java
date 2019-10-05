package cn.ffhh.bookstore.service;

import java.util.Map;
import java.util.Properties;

import cn.ffhh.bookstore.domain.User;
import cn.ffhh.bookstore.service.imp.UserException;

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
	 * @throws UserException 
	 */
	public void addUser(User user) throws UserException;
	/**
	 *  注册请求参数检测方法
	 *  实现post请求参数的检测功能，对用户名、邮箱和密码就行有效性检测，并处理前后空格
	 * @param form 要被检测的User对象
	 * @param password_confirmation 确认密码
	 * @return 返回一个携带错误提示信息的Map
	 */
	public Map<String,String> checkRegistParam(User form,String password_confirmation);
	/**
	 *  登录请求参数检测方法
	 *  实现post请求参数的检测功能，对用户名、邮箱和密码就行有效性检测，并处理前后空格
	 * @param form 要被检测的User对象
	 * @return 返回一个携带错误提示信息的Map
	 */
	public Map<String,String> checkLoginParam(User form);
	/**
	 * 用户激活邮件发送
	 * @param mailTemplate 邮箱设置properties
	 * @param user 用户
	 */
	public void seedActiveMail(Properties mailTemplate,User user) throws Exception;
	/**
	 * 用户激活
	 * @param code 激活码
	 * @throws Exception
	 */
	public void activeUser(String code) throws Exception;
	/**
	 * 用户登录
	 * @param form
	 * @throws Exception
	 */
	public User login(User form) throws Exception;
}
