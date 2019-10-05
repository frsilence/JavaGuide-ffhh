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
}
