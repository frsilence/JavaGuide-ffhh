package cn.ffhh.bookstore.service;

import java.util.List;

import cn.ffhh.bookstore.domain.Order;

public interface IOrderService {
	/**
	 * 	添加订单
	 * @param order
	 * @throws Exception
	 */
	public void add(Order order);
	/**
	 * 	根据用户id查询其所有的订单详细信息
	 * @param userId
	 * @return
	 */
	public List<Order> allOrderDetailByUserId(String userId);
	/**
	 * 	根据订单id查询其详细信息
	 * @param orderId
	 * @return
	 */
	public Order detail(String orderId);
	/**
	 * 	更新订单状态
	 * @param order
	 * @return
	 */
	public boolean updateState(Order order);
}
