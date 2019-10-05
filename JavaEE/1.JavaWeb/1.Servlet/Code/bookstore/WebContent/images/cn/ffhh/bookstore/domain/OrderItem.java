package cn.ffhh.bookstore.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderItem {
	private String iid;
	private Integer count;
	private BigDecimal subtotal;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Book book;
	private Order order;
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderItem [iid=" + iid + ", count=" + count + ", subtotal=" + subtotal + ",  createTime=" + createTime + ", updateTime=" + updateTime + ", book=" + book + ", order=" + order
				+ "]";
	}
	
}
