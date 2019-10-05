package cn.ffhh.bookstore.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import cn.ffhh.bookstore.Factory.DaoFactory;
import cn.ffhh.bookstore.Factory.ServiceFactory;
import cn.ffhh.bookstore.dao.imp.CartDaoImp;
import cn.ffhh.bookstore.dao.imp.CartItemDaoImp;
import cn.ffhh.bookstore.domain.Book;
import cn.ffhh.bookstore.domain.Cart;
import cn.ffhh.bookstore.domain.CartItem;
import cn.ffhh.bookstore.domain.User;
import cn.itcast.commons.CommonUtils;

public class CartTest {
	//@Test
	public void CartTest1() {
		CartDaoImp cartDaoImp = new CartDaoImp();
		Cart cart = cartDaoImp.findByUserId("96F3F59A97E94414A56595C31AB4822B");
		//Map<String, CartItem> cartItems = new CartItemDaoImp().findByCartId(cart.getCid());
		List<CartItem> cartItemss = new CartItemDaoImp().findAllByCartId(cart.getCid());
		cart.setCartitems(cartItemss);
		if(cart.getCartitems()!=null) {
			for(CartItem cartitem:cart.getCartitems()) {
				System.out.println(cartitem);
			}
		}
		
	}
	//@Test
	public void CartTest2() {
		User user =DaoFactory.getUserDaoInstance().findByEmail("1935605044@qq.com");
		try {
			ServiceFactory.getCartServiceInstance().addCart(user);
		} catch (Exception e) {
			System.out.println("错误信息："+e.getMessage());
		}
	}
	@Test
	public void CartTest3() {
		CartItem cartItem = new CartItem();
		Book book = new Book();
		book.setBid("4");
		book.setPrice(new BigDecimal(25));
		cartItem.setIid(CommonUtils.uuid());
		cartItem.setCount(4);
		cartItem.setBook(book);
		try {
			Cart cart = DaoFactory.getCartDaoInstance().findByUserId("6A6A6762646F470C82C1F243E0A36BFC");
			cartItem.setCart(cart);
		} catch (Exception e) {
			System.out.println("error："+e.getMessage());
		}
		
		try {
			ServiceFactory.getCartServiceInstance().addCartitem(cartItem);
		} catch (Exception e) {
			System.out.println("错误信息:"+e.getMessage());
			e.printStackTrace();
		}
	}
	//@Test
	public void CartTest4() {
		CartItem cartItem = DaoFactory.getCartItemDaoInstance().findById("E623D4ACC7834070A20A36E7725BE8A6");
		try {
			ServiceFactory.getCartServiceInstance().deleteCartitem(cartItem);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//@Test
	public void CartTest5() {
		Cart cart = DaoFactory.getCartDaoInstance().findByUserId("96F3F59A97E94414A56595C31AB4822B");
		try {
			ServiceFactory.getCartServiceInstance().clearCartitem(cart.getCid());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	//@Test
	public void CartTest6() {
		try {
			Cart cart = ServiceFactory.getCartServiceInstance().findCartByUserId("96F3F59A97E94414A56595C31AB4822B");
			System.out.println(cart);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
