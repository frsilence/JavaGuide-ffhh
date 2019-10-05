package cn.ffhh.bookstore.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.ffhh.bookstore.dao.ICartItemDao;
import cn.ffhh.bookstore.domain.CartItem;
import cn.itcast.jdbc.TxQueryRunner;

public class CartItemDaoImp implements ICartItemDao {
	
	private QueryRunner qr = new TxQueryRunner();
	@Override
	public boolean doCreate(CartItem vo) {
		String sqlString = "insert into cartitem (iid,count,bid,cid) values(?,?,?,?)";
		Number number = 0;
		Object[] params = new Object[] {
				vo.getIid(),
				vo.getCount(),
				vo.getBook().getBid(),
				vo.getCart().getCid()
		};
		try {
			number = qr.update(sqlString, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return number.intValue()==1;
	}

	@Override
	public boolean doUpdate(CartItem vo) {
		String sqlString = "update cartitem set count=?,update_time=? where iid=? and bid=?";
		Number number = 0;
		Object[] params = new Object[] {
				vo.getCount(),
				new Date(),
				vo.getIid(),
				vo.getBook().getBid()
		};
		try {
			number = qr.update(sqlString, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return number.intValue()==1;
	}

	@Override
	public boolean doRemoveBatch(Set<String> ids) {
		return false;
	}

	@Override
	public CartItem findById(String id) {
		if(id==null) return null;
		CartItem cartItem = null;
		String sqlString = "select * from cartitem where iid=?";
		try {
			cartItem = qr.query(sqlString, new BeanHandler<CartItem>(CartItem.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cartItem;
	}

	@Override
	public List<CartItem> findAllByCartId(String cartId) {
		String sqlString = "select * from cartitem where cid=?";
		List<CartItem> cartItems = new ArrayList<CartItem>();
		try {
			cartItems = qr.query(sqlString, new BeanListHandler<CartItem>(CartItem.class),cartId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cartItems;
	}

	@Override
	public List<CartItem> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) {
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) {
		return null;
	}
	public Map<String, CartItem> findByCartId(String cartId){
		Map<String, CartItem> cartItems = new HashMap<String, CartItem>();
		String sqlString = "select * from cartitem where cid=?";
		List<CartItem> cartList = new ArrayList<CartItem>();
		try {
			cartList = qr.query(sqlString, new BeanListHandler<CartItem>(CartItem.class),cartId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(CartItem cartItem:cartList) {
			cartItems.put(cartItem.getIid(), cartItem);
		}
		return cartItems;
	}

	@Override
	public boolean doClear(String cartId) {
		String sqlString = "delete from cartitem where cid=?";
		try {
			qr.update(sqlString,cartId);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public CartItem findByCartItem(CartItem cartItem) {
		String sqlString = "select * from cartitem where cid=? and bid=?";
		CartItem checkCartItem = null;
		Object[] params = new Object[] {
			cartItem.getCart().getCid(),
			cartItem.getBook().getBid(),
		};
		try {
			checkCartItem = qr.query(sqlString, new BeanHandler<CartItem>(CartItem.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkCartItem;
	}

	@Override
	public boolean doDelete(CartItem cartItem) {
		if(cartItem==null || cartItem.getIid()==null) return false;
		String sqlString = "delete from cartitem where iid=?";
		Number number = 0;
		try {
			number = qr.update(sqlString, cartItem.getIid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return number.intValue()==1;
	}

	@Override
	public List<CartItem> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
