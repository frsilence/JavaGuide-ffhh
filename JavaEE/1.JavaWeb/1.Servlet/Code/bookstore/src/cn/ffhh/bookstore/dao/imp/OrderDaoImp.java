package cn.ffhh.bookstore.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.ffhh.bookstore.dao.IOrderDao;
import cn.ffhh.bookstore.domain.Book;
import cn.ffhh.bookstore.domain.Order;
import cn.ffhh.bookstore.domain.OrderItem;
import cn.ffhh.bookstore.domain.User;
import cn.itcast.jdbc.TxQueryRunner;

public class OrderDaoImp implements IOrderDao {

	private QueryRunner qr = new TxQueryRunner();
	@Override
	public boolean doCreate(Order vo) throws SQLException {
		String sqlString = "insert into orders (oid,total,state,uid,address) values(?,?,?,?,?)";
		Object[] params = new Object[] {
				vo.getOid(),
				vo.getTotal(),
				vo.getState(),
				vo.getUser().getUid(),
				vo.getAddress(),
		};
		Number number = 0;
		number = qr.update(sqlString,params);
		return number.intValue()==1;
	}

	@Override
	public boolean doUpdate(Order vo) {
		String sqlString = "update orders set state=? where oid=?";
		int result = 0;
		Object[] params = new Object[] {
			vo.getState(),
			vo.getOid()
		};
		try {
			result = qr.update(sqlString,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result==1;
	}

	@Override
	public boolean doRemoveBatch(Set<String> ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order findById(String id) {
		String  sqlString = "select * from orders where oid=?";
		Order order = null;
		try {
			order = qr.query(sqlString, new BeanHandler<Order>(Order.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(order==null) return order;
		loadOrderItem(order);
		loadOrderUser(order);
		return order;
	}

	private void loadOrderUser(Order order) {
		String sqlString = "select * from orders o,tb_user u where o.uid=u.uid and o.oid=? limit 1";
		try {
			Map<String, Object> maps= qr.query(sqlString, new MapHandler(),order.getOid());
			User user = new User();
			BeanUtils.populate(user, maps);
			order.setUser(user);
		} catch (SQLException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
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

	@Override
	public boolean addOrderItemList(List<OrderItem> orderItems) throws SQLException {
		//使用批处理
		String  sqlString = "insert into orderitem (iid,count,subtotal,oid,bid)  values(?,?,?,?,?)";
		Object[][] params = new Object[orderItems.size()][];
		int i = 0;
		for(OrderItem orderItem:orderItems) {
			params[i++] = new Object[] {
				orderItem.getIid(),
				orderItem.getCount(),
				orderItem.getSubtotal(),
				orderItem.getOrder().getOid(),
				orderItem.getBook().getBid(),
			};
		}
		int[] result = qr.batch(sqlString, params);
		return (result.length==orderItems.size());
	}

	@Override
	public List<Order> findAllOrderDetailByUserId(String userId) {
		List<Order> orders = new ArrayList<Order>();
		String sqlString = "select * from orders where uid=?";
		try {
			orders = qr.query(sqlString, new BeanListHandler<Order>(Order.class),userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//为订单添加子项
		for(Order order:orders) {
			loadOrderItem(order);
		}
		return orders;
	}

	private void loadOrderItem(Order order) {
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		String sqlString = "select i.iid,i.count,i.subtotal,i.create_time icreate_time,i.update_time iupdate_time,"
				+ "b.bid,b.bname,b.price,b.author,b.image,b.create_time bcreate_time,b.update_time bupdate_time "
				+ " from orderitem i,book b where i.bid=b.bid and i.oid=?";
		try {
			List<Map<String, Object>> mapList = qr.query(sqlString, new MapListHandler(),order.getOid());
			for(Map<String, Object> map:mapList) {
				OrderItem orderItem = new OrderItem();
				Book book = new Book();
				book.setBid((String)map.get("bid"));
				book.setBname((String)map.get("bname"));
				book.setPrice((BigDecimal)map.get("price"));
				book.setAuthor((String)map.get("author"));
				book.setImage((String) map.get("image"));
				book.setCreate_time((Timestamp) map.get("bcreate_time"));
				book.setCreate_time((Timestamp) map.get("bupdate_time"));
				orderItem.setIid((String) map.get("iid"));
				orderItem.setCount((Integer) map.get("count"));
				orderItem.setBook(book);
				orderItem.setSubtotal((BigDecimal) map.get("subtotal"));
				orderItem.setCreate_time((Timestamp) map.get("icreate_time"));
				orderItem.setUpdate_time((Timestamp) map.get("iupdate_time"));
				orderItems.add(orderItem);
				order.setOrderItem(orderItems);
				//System.out.println("book测试"+book);
				//System.out.println("item测试"+orderItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
