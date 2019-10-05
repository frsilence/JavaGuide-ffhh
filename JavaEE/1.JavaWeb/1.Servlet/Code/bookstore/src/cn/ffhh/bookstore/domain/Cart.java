package cn.ffhh.bookstore.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Cart {
	private String cid;
	private User user;
	private Timestamp create_time;
	private Timestamp update_time;
	private List<CartItem> cartitems;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public List<CartItem> getCartitems() {
		return cartitems;
	}
	public void setCartitems(List<CartItem> cartitems) {
		this.cartitems = cartitems;
	}
	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal(0);
		for(CartItem cartitem:this.cartitems) {
			if(cartitem.getSubtotal()!=null) {
				total = total.add(cartitem.getSubtotal());
			}
		}
		return total;
		
	}
	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", user=" + user + ", create_time=" + create_time + ", update_time=" + update_time
				+ ", cartitems=" + cartitems + "]";
	}
	
	
}
