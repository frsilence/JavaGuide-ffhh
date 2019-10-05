package cn.ffhh.bookstore.domain;

import java.sql.Timestamp;

/**
 * 领域对象
 * 对应于数据表tb_user
 * @author yfzhao
 *
 */
public class User {
	private String uid;
	private String username;
	private String password;
	private String email;
	private String code;
	private Integer state;
	private Timestamp create_time;
	private Timestamp update_time;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
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
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", email=" + email + ", code="
				+ code + ", state=" + state + ", createTime=" + create_time + ", updateTime=" + update_time + "]";
	}
	
}
