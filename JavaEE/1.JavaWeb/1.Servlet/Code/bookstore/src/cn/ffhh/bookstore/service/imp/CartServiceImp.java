package cn.ffhh.bookstore.service.imp;

import java.sql.SQLException;
import java.util.List;

import cn.ffhh.bookstore.Factory.DaoFactory;
import cn.ffhh.bookstore.dao.IBookDao;
import cn.ffhh.bookstore.dao.ICartDao;
import cn.ffhh.bookstore.dao.ICartItemDao;
import cn.ffhh.bookstore.dao.IUserDao;
import cn.ffhh.bookstore.domain.Book;
import cn.ffhh.bookstore.domain.Cart;
import cn.ffhh.bookstore.domain.CartItem;
import cn.ffhh.bookstore.domain.User;
import cn.ffhh.bookstore.service.ICartService;
import cn.itcast.commons.CommonUtils;

public class CartServiceImp implements ICartService {
	private ICartDao cartDao = DaoFactory.getCartDaoInstance();
	private ICartItemDao cartItemDao = DaoFactory.getCartItemDaoInstance();
	private IUserDao userDao = DaoFactory.getUserDaoInstance();
	private IBookDao bookDao = DaoFactory.getBookDaoInstance();
	@Override
	public void addCart(User user) throws Exception {
		if (user==null) throw new CartException("用户不存在");
		User checkUser = userDao.findById(user.getUid());
		if(checkUser==null || checkUser.getState()!=1) throw new CartException("用户不存在或未激活");
		Cart cart = cartDao.findByUserId(user.getUid());
		if(cart==null) {
			Cart newCart = new Cart();
			newCart.setCid(CommonUtils.uuid());
			newCart.setUser(user);
			if(!cartDao.doCreate(newCart)) throw new CartException("创建购物车失败");
		}
	}

	@Override
	public void clearCartitem(String cartId) throws CartException {
		if(cartId==null) throw new CartException("购物车清空失败");
		Cart checkCart = cartDao.findById(cartId);
		if(checkCart!=null) {
			if(!cartItemDao.doClear(cartId)) throw new CartException("购物车清空失败");
		}
	}

	@Override
	public void addCartitem(CartItem cartItem) throws CartException {
		if(cartItem.getCart()==null) throw new CartException("购物车不存在");
		Cart checkCart = cartDao.findById(cartItem.getCart().getCid());
		Book book = bookDao.findById(cartItem.getBook().getBid());
		if(checkCart!=null && book!=null) {
			CartItem checkCartItem = cartItemDao.findByCartItem(cartItem);
			if(checkCartItem==null) {
				try {
					if(!cartItemDao.doCreate(cartItem)) throw new CartException("购物车条目增加失败");
				} catch (SQLException e) {
					throw new CartException("购物车条目增加失败");
				}
			}else {
				checkCartItem.setCount(checkCartItem.getCount()+cartItem.getCount());
				checkCartItem.setBook(cartItem.getBook());
				if(!cartItemDao.doUpdate(checkCartItem)) throw new CartException("购物车条目增加失败");
			}
		}else {
			throw new CartException("指定的购物车不存在或者图书不存在");
		}
	}

	@Override
	public void deleteCartitem(CartItem cartItem) throws CartException {
		if(!cartItemDao.doDelete(cartItem)) throw new CartException("删除购物车子项失败");
	}

	@Override
	public Cart findCartByUserId(String userId) throws CartException {
		if(userId==null) throw new CartException("用户不存在");
		Cart cart = cartDao.findByUserId(userId);
		if(cart==null) throw new CartException("用户购物车不存在");
		List<CartItem> cartItems = cartItemDao.findAllByCartId(cart.getCid());
		for(CartItem cartItem:cartItems) {
			Book book = bookDao.findByCartitemId(cartItem.getIid());
			cartItem.setBook(book);
		}
		cart.setCartitems(cartItems);
		return cart;
	}
	

}
