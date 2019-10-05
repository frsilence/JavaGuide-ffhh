package cn.ffhh.bookstore.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.ffhh.bookstore.dao.ICategoryDao;
import cn.ffhh.bookstore.domain.Category;
import cn.itcast.jdbc.TxQueryRunner;

public class CategoryDaoImp implements ICategoryDao {
	private QueryRunner qr = new TxQueryRunner();
	@Override
	public boolean doCreate(Category vo) {
		String sqlString = "insert into category (cid,cname) values(?,?)";
		int result = 0;
		try {
			result = qr.update(sqlString,new Object[] {vo.getCid(),vo.getCname()});
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return result==1;
	}

	@Override
	public boolean doUpdate(Category vo) {
		String sqlString = "update category set cname=?,create_time=? where cid=?";
		int result= 0 ;
		try {
			result = qr.update(sqlString,new Object[]{vo.getCname(),new Date(),vo.getCid()});
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return result==1;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category findById(Integer id) {
		Category category = null;
		String sqlString = "select * from category where cid=?";
		try {
			category = qr.query(sqlString, new BeanHandler<Category>(Category.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public List<Category> findAll() {
		String sqlString = "select * from category";
		List<Category> categories = new ArrayList<Category>();
		try {
			categories = qr.query(sqlString, new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public List<Category> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doRemove(Integer cid) {
		String sqlString = "delete from category where cid=?";
		int result = 0;
		try {
			result = qr.update(sqlString,cid);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return result==1;
	}
	

}
