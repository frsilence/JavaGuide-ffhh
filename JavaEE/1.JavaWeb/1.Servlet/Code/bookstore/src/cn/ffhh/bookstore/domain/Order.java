package cn.ffhh.bookstore.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Order {
	private String oid;
	private BigDecimal total;
	private Integer state;//四种状态：1未付款,2已付款未发货，3已发货未确认收货，4确认交易成功
	private String address;
	private Timestamp create_time;
	private Timestamp update_time;
	private User user;
	private List<OrderItem> orderItem;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", total=" + total + ", state=" + state + ", address=" + address + ", create_time="
				+ create_time + ", update_time=" + update_time + ", user=" + user + ", orderItem=" + orderItem + "]";
	}
	
	
	
	
}
