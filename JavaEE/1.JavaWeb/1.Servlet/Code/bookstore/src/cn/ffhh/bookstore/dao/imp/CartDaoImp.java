package cn.ffhh.bookstore.dao.imp;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.ffhh.bookstore.dao.ICartDao;
import cn.ffhh.bookstore.domain.Cart;
import cn.itcast.jdbc.TxQueryRunner;

public class CartDaoImp implements ICartDao {

	private QueryRunner qr = new TxQueryRunner();
	@Override
	public boolean doCreate(Cart vo) {
		String sqlString = "insert into cart (cid,uid) values (?,?)";
		Number number = 0;
		Object[] params = new Object[] {
				vo.getCid(),
				vo.getUser().getUid()
		};
		try {
			number = qr.update(sqlString, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return number.intValue()==1;
	}

	@Override
	public boolean doUpdate(Cart vo) {
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<String> ids) {
		return false;
	}

	@Override
	public Cart findById(String id) {
		if(id==null) return null;
		Cart cart = null;
		String sqlString = "select cid,uid,create_time,update_time from cart where cid=?";
		try {
			cart = qr.query(sqlString, new BeanHandler<Cart>(Cart.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cart;
	}

	@Override
	public List<Cart> findAll() {
		return null;
	}

	@Override
	public List<Cart> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) {
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) {
		return null;
	}
	/**
	 * 根据用户ID查询其购物车
	 * @param userId 用户id
	 * @return 查询到则返回Cart对象
	 */
	public Cart findByUserId(String userId) {
		if(userId==null) return null;
		Cart cart = null;
		String sqlString = "select cid,uid,create_time,update_time from cart where uid=?";
		try {
			cart = qr.query(sqlString, new BeanHandler<Cart>(Cart.class), userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cart;
	}

}
