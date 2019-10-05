package cn.ffhh.bookstore.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CartItem {
	private String iid;
	private Book book;
	private Cart cart;
	private Integer count;
	private Timestamp create_time;
	private Timestamp update_time;
	@SuppressWarnings("unused")
	private BigDecimal subtotal;
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
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
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public BigDecimal getSubtotal() {
		return book.getPrice().multiply(new BigDecimal(count));
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	@Override
	public String toString() {
		return "CartItem [iid=" + iid + ", book=" + book + ", count=" + count + ", create_time=" + create_time
				+ ", update_time=" + update_time + "]";
	}
	
}
