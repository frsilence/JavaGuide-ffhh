package cn.ffhh.bookstore.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import cn.ffhh.bookstore.dao.IBookDao;
import cn.ffhh.bookstore.domain.Book;
import cn.itcast.jdbc.TxQueryRunner;

public class BookDaoImp implements IBookDao {
	private QueryRunner qr = new TxQueryRunner();
	@Override
	public boolean doCreate(Book vo) {
		String sqlString = "insert into book (bid,bname,price,author,image,cid) values(?,?,?,?,?,?)";
		Number number = null;
		Object[] params = new Object[] {
				vo.getBid(),
				vo.getBname(),
				vo.getPrice(),
				vo.getAuthor(),
				vo.getImage(),
				vo.getCategory().getCid(),
		};
		try {
			number = qr.update(sqlString, params);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return number.intValue()==1;
	}

	@Override
	public boolean doUpdate(Book vo) {
		String sqlString = "update book	set bname=?,price=?,author=?,del=?,update_time=? where bid=? ";
		int result = 0;
		try {
			result = qr.update(sqlString,new Object[] {
					vo.getBname(),vo.getPrice(),vo.getAuthor(),vo.getDel(),
					new Date(),vo.getBid()});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result==1;
	}

	@Override
	public boolean doRemoveBatch(Set<String> ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Book findById(String id) {
		Book book = null;
		String sqlString = "select * from book where bid=?";
		try {
			book = qr.query(sqlString, new BeanHandler<Book>(Book.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findByCartitemId(String cartitemId) {
		Book book = null;
		String sqlString = "select bid from cartitem where iid=?";
		String bookId = null;
		try {
			bookId = qr.query(sqlString, new ScalarHandler<String>(),cartitemId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(bookId==null) return book;
		String sqlString2 = "select * from book where bid=?";
		try {
			book = qr.query(sqlString2, new BeanHandler<Book>(Book.class),bookId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
		
	}

	@Override
	public Integer findCategoryIdByBookId(String bookId) {
		Integer categoryId = null;
		String sqlString = "select cid from book where bid=?";
		try {
			categoryId = qr.query(sqlString, new ScalarHandler<Integer>(),bookId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryId;
	}

	@Override
	public List<Book> findAllByCategoryId(Integer categoryId) {
		List<Book> books = new ArrayList<Book>();
		String sqlString;
		if(categoryId!=null) {
			sqlString = "select * from book where cid=?";
			try {
				books = qr.query(sqlString, new BeanListHandler<Book>(Book.class),categoryId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			sqlString="select * from book";
			try {
				books = qr.query(sqlString, new BeanListHandler<Book>(Book.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return books;
		
	}

	@Override
	public Book findByName(String bname) {
		String sqlString = "select * from book where bname=?";
		Book book = null;
		try {
			book = qr.query(sqlString, new BeanHandler<Book>(Book.class),bname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	

}
