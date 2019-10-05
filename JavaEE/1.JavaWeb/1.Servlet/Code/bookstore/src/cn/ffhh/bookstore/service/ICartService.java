package cn.ffhh.bookstore.service;

import cn.ffhh.bookstore.domain.Cart;
import cn.ffhh.bookstore.domain.CartItem;
import cn.ffhh.bookstore.domain.User;

public interface ICartService {
	/**
	 * 根据用户Id获得用户的购物车
	 * @param userId
	 * @return
	 */
	public Cart findCartByUserId(String userId) throws Exception;
	/**
	 * 用户增加购物车
	 * @param user
	 */
	public void addCart(User user) throws Exception;
	/**
	 * 清空购物车的清单项目
	 * @param cartId
	 */
	public void clearCartitem(String cartId) throws Exception;
	/**
	 * 购物车增加子项目
	 * @param cartItem 增加的子项，若子项的bookid已存在则增加数量，否则添加
	 */
	public void addCartitem(CartItem cartItem) throws Exception;
	/**
	 * 删除购物车子项
	 * @param cartItem
	 */
	public void deleteCartitem(CartItem cartItem) throws Exception;
}
