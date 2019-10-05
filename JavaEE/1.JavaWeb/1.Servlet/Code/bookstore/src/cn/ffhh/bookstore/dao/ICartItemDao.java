package cn.ffhh.bookstore.dao;

import java.util.List;

import cn.ffhh.bookstore.domain.CartItem;

public interface ICartItemDao extends IBookstoreDao<String, CartItem> {
	/**
	 * 清空购物车子项目
	 * @param cartId 购物车id
	 * @return 执行成功返回true
	 */
	public boolean doClear(String cartId);
	/**
	 * 根据传入的CartItem信息查找指定了CartId和BookId的Cartitem
	 * @param cartItem
	 * @return
	 */
	public CartItem findByCartItem(CartItem cartItem);
	/**
	 * 删除购物车子项
	 * @param cartItem
	 * @return
	 */
	public boolean doDelete(CartItem cartItem);
	/**
	 * 根据购物车id查找其子项
	 * @param cartId
	 * @return
	 */
	List<CartItem> findAllByCartId(String cartId);
}
