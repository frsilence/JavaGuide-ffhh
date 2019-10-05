package cn.ffhh.bookstore.dao;

import cn.ffhh.bookstore.domain.Cart;

public interface ICartDao extends IBookstoreDao<String, Cart> {
	public Cart findByUserId(String userId);
}
