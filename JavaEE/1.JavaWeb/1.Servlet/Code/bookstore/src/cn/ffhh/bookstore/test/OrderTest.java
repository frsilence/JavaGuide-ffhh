package cn.ffhh.bookstore.test;

import org.junit.Test;

import cn.ffhh.bookstore.Factory.DaoFactory;

public class OrderTest {
	@Test
	public void OrderTest1() {
		DaoFactory.getOrderDaoInstance();
	}
}
