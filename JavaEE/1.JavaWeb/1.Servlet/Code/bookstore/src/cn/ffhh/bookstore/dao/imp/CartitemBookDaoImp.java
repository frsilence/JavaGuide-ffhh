package cn.ffhh.bookstore.dao.imp;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;

import cn.ffhh.bookstore.dao.ICartitemBookDao;
import cn.ffhh.bookstore.domain.CartitemBook;
import cn.itcast.jdbc.TxQueryRunner;

public class CartitemBookDaoImp implements ICartitemBookDao {

	private QueryRunner qr = new TxQueryRunner();
	@Override
	public boolean doCreate(CartitemBook vo) {
		String sqlString = "insert into cartitem_book iid,bid values(?,?)";
		Number number = 0;
		Object[] params = new Object[] {
			vo.getIid(),
			vo.getBid()
		};
		try {
			number = qr.update(sqlString,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return number.intValue()==1;
	}

	@Override
	public boolean doUpdate(CartitemBook vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CartitemBook findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartitemBook> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartitemBook> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

}
