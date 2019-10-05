package cn.ffhh.bookstore.domain;

import java.sql.Timestamp;

public class Category {
	private int cid;
	private String cname;
	private Timestamp create_time;
	private Timestamp update_time;
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
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public Timestamp getUpdate_time() {
		/*
		 * SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 * if(this.update_time!=null) return
		 * Timestamp.valueOf(sdate.format(update_time));
		 */
		  return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", create_time=" + create_time + ", update_time="
				+ update_time + "]";
	}
	
	
}
