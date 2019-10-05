package cn.ffhh.bookstore.dao.imp;

import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;

import cn.ffhh.bookstore.dao.IBookDao;
import cn.ffhh.bookstore.domain.Book;
import cn.itcast.jdbc.TxQueryRunner;

public class BookDaoImp implements IBookDao {
	private QueryRunner qr = new TxQueryRunner();
	@Override
	public boolean doCreate(Book vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Book vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<String> ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Book findById(String id) {
		// TODO Auto-generated method stub
		return null;
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
	

}
