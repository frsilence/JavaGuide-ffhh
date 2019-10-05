package cn.ffhh.bookstore.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.ffhh.bookstore.Factory.DaoFactory;
import cn.ffhh.bookstore.dao.IOrderDao;
import cn.ffhh.bookstore.domain.Order;
import cn.ffhh.bookstore.service.IOrderService;
import cn.itcast.jdbc.JdbcUtils;

public class OrderServiceImp implements IOrderService {
	private IOrderDao orderDao = DaoFactory.getOrderDaoInstance();
	@Override
	public void add(Order order){
		try {
			JdbcUtils.beginTransaction();
			orderDao.doCreate(order);
			orderDao.addOrderItemList(order.getOrderItem());
			JdbcUtils.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	@Override
	public List<Order> allOrderDetailByUserId(String userId) {
		List<Order> orders = new ArrayList<Order>();
		orders = orderDao.findAllOrderDetailByUserId(userId);
		return orders;
	}
	@Override
	public Order detail(String orderId) {
		return orderDao.findById(orderId);
	}
	@Override
	public boolean updateState(Order order) {
		return orderDao.doUpdate(order);
	}
	


}
