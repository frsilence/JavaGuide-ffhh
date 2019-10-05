package cn.ffhh.bookstore.dao.imp;

import java.util.List;
import java.util.Set;

import cn.ffhh.bookstore.dao.IOrderDao;
import cn.ffhh.bookstore.domain.Order;

public class OrderDaoImp implements IOrderDao {

	@Override
	public boolean doCreate(Order vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Order vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<String> ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
