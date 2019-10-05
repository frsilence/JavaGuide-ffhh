package cn.ffhh.bookstore.dao;

import cn.ffhh.bookstore.domain.User;

public interface IUserDao extends IBookstoreDao<String, User>{
	
	/**
	 * 根据用户名查询(用户表用户名唯一)
	 * @param username 提供的用户名
	 * @return 若查询到则返回User对象，否则返回null
	 */
	public User findByUesername(String username);
	/**
	 * 根据用户email查询(用户表email唯一)
	 * @param email 提供的用户email
	 * @return 若查询到则返回User对象，否则返回null
	 */
	public User findByEmail(String email);
	/**
	 * 使用激活码搜索用户
	 * @param code 激活码
	 * @return 若搜索成功返回User对象，否则返回null
	 */
	public User findByCode(String code);
	/**
	 * 更新用户激活状态
	 * @param user
	 * @param state
	 * @return
	 */
	public boolean doUpdateState(User user,Integer state);
}
