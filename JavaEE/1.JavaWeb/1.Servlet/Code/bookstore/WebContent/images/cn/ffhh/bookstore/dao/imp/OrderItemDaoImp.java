package cn.ffhh.bookstore.dao.imp;

import java.util.List;
import java.util.Set;

import cn.ffhh.bookstore.dao.IOrderItemDao;
import cn.ffhh.bookstore.domain.OrderItem;

public class OrderItemDaoImp implements IOrderItemDao {

	@Override
	public boolean doCreate(OrderItem vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(OrderItem vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<String> ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderItem findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}


}
