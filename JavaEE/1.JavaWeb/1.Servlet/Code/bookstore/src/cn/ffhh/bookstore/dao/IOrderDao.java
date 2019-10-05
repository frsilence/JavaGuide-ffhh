package cn.ffhh.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import cn.ffhh.bookstore.domain.Order;
import cn.ffhh.bookstore.domain.OrderItem;

public interface IOrderDao extends IBookstoreDao<String, Order>{
	/**
	 * 	将订单子项添加到数据库
	 * @param orderItems
	 * @return
	 * @throws SQLException
	 */
	public boolean addOrderItemList(List<OrderItem> orderItems) throws SQLException;
	/**
	 * 	根据用户id查询其所有订单
	 * @param userId
	 * @return
	 */
	public List<Order> findAllOrderDetailByUserId(String userId);
}
