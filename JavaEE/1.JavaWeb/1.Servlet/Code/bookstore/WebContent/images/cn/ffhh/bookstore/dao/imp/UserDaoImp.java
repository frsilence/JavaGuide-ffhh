package cn.ffhh.bookstore.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import cn.ffhh.bookstore.dao.IUserDao;
import cn.ffhh.bookstore.domain.User;
import cn.itcast.jdbc.TxQueryRunner;

public class UserDaoImp implements IUserDao {
	
	private QueryRunner qr = new TxQueryRunner();
	@Override
	public boolean doCreate(User vo) {
		String sqlString = "insert into tb_user(uid,username,`password`,email,code,state) value(?,?,?,?,?,?)";
		Object[] params = new Object[] {
			vo.getUid(),vo.getUsername(),vo.getPassword(),
			vo.getEmail(),vo.getCode(),vo.isStatus()
		};
		Number num;
		try {
			num = qr.update(sqlString, params);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return num.intValue()==1;
	}

	@Override
	public boolean doUpdate(User vo) {
		String sqlString = "update tb_user set username=?,`password`=?,email=?,state=?,update_time=? where uid=?";
		Object[] params = new Object[]{
			vo.getUsername(),
			vo.getPassword(),
			vo.getEmail(),
			vo.isStatus(),
			vo.getUpdateTime(),
			vo.getUid(),
		};
		Number num;
		try {
			num = qr.update(sqlString,params);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return num.intValue()==1;
	}

	@Override
	public boolean doRemoveBatch(Set<String> ids) {
		String sqlString = "delete tb_user where id in ?";
		Number num = null;
		try {
			num = qr.update(sqlString, ids);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return num.intValue()==ids.size();
	}

	@Override
	public User findById(String id) {
		User user = null;
		String sqlString  ="selsect uid,username,password,email,code,state,create_time,update_time from tb_user where uid=?";
		try {
			user = qr.query(sqlString,new BeanHandler<User>(User.class),id);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		String sqlString = "select uid,username,password,email,code,state,create_time,update_time from tb_user";
		try {
			users = qr.query(sqlString, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return users;
	}

	@Override
	public List<User> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUesername(String username) {
		User user = null;
		String sqlString  ="selsect uid,username,password,email,code,state,create_time,update_time from tb_user where username=?";
		try {
			user = qr.query(sqlString,new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return user;
	}

	@Override
	public User findByEmail(String email) {
		User user = null;
		String sqlString  ="selsect uid,username,password,email,code,state,create_time,update_time from tb_user where email=?";
		try {
			user = qr.query(sqlString,new BeanHandler<User>(User.class),email);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return user;
	}

}
