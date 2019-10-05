package cn.ffhh.bookstore.service.imp;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.ffhh.bookstore.Factory.DaoFactory;
import cn.ffhh.bookstore.dao.IBookDao;
import cn.ffhh.bookstore.dao.ICategoryDao;
import cn.ffhh.bookstore.domain.Book;
import cn.ffhh.bookstore.domain.Category;
import cn.ffhh.bookstore.service.IBookService;

public class BookServiceImp implements IBookService {

	private IBookDao bookDao = DaoFactory.getBookDaoInstance();
	private ICategoryDao categoryDao = DaoFactory.getCategoryDaoInstance();
	@Override
	public Book findByBookId(String bookId) throws Exception {
		Book book = bookDao.findById(bookId);
		return book;
	}
	@Override
	public Book findDetailByBookId(String bookId) throws Exception {
		Book book = bookDao.findById(bookId);
		Integer categoryId = bookDao.findCategoryIdByBookId(bookId);
		Category category = null;
		if(book!=null && categoryId!=null) {
			category = categoryDao.findById(categoryId);
		}
		book.setCategory(category);
		return book;
	}
	@Override
	public List<Book> findAllDetail(Integer categoryId){
		List<Book> books = new ArrayList<Book>();
		books = bookDao.findAllByCategoryId(categoryId);
		for(Book book:books) {
			Category category = categoryDao.findById(bookDao.findCategoryIdByBookId(book.getBid()));
			book.setCategory(category);
		}
		return books;
		
	}
	@Override
	public void update(Book book) throws BookException {
		Book checkBook = bookDao.findByName(book.getBname());
		if(checkBook!=null && !checkBook.getBid().equals(book.getBid())) throw new BookException("图书名称已存在");
		if(!bookDao.doUpdate(book)) throw new BookException("图书信息更新失败");
	}
	@Override
	public void add(Book book) throws BookException {
		Book checkBook = bookDao.findByName(book.getBname());
		Category category = categoryDao.findById(book.getCategory().getCid());
		if(category==null) throw new BookException("图书分类不存在");
		if(checkBook!=null) {
			throw new BookException("图书名称已存在，添加图书失败");
		}else {
			try {
				bookDao.doCreate(book);
			} catch (SQLException e) {
				throw new BookException("添加图书失败");
			}
		}
		
	}
	@Override
	public void delete(Book book) throws BookException {
		if(!bookDao.doUpdate(book)) throw new BookException("图书删除失败");
	}
	
	
	

}
