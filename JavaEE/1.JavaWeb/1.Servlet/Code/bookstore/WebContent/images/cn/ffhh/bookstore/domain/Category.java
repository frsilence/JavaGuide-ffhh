package cn.ffhh.bookstore.domain;

import java.sql.Timestamp;

public class Category {
	private int cid;
	private String cname;
	private Timestamp createTime;
	private Timestamp updateTime;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
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
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ "]";
	}
	
}
