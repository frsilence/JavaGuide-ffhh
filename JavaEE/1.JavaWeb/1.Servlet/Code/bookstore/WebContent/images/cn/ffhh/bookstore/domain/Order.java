package cn.ffhh.bookstore.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {
	private String oid;
	private BigDecimal total;
	private Integer state;
	private String address;
	private Timestamp createTime;
	private Timestamp updateTime;
	private User user;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", total=" + total + ", state=" + state + ", address=" + address + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", user=" + user + "]";
	}
	
	
}
