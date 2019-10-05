package cn.ffhh.bookstore.service;

import java.util.List;

import cn.ffhh.bookstore.domain.Book;
import cn.ffhh.bookstore.service.imp.BookException;

public interface IBookService {
	/**
	 *  根据图书Id查找图书信息
	 * @param bookId
	 * @return
	 */
	public Book findByBookId(String bookId) throws Exception;
	/**
	 * 	根据图书Id查找图书详细信息，包含其分类信息
	 * @param bookId
	 * @return
	 * @throws Exception
	 */
	public Book findDetailByBookId(String bookId) throws Exception;
	/**
	 * 	根据分类id查找器所有的图书详细信息，若分类id为null，则查询所有分类的所有图书详细信息
	 * @param categoryId
	 * @return
	 */
	public List<Book> findAllDetail(Integer categoryId);
	/**
	 * 	根据book更新数据
	 * @param book
	 * @throws BookException 
	 */
	public void update(Book book) throws BookException;
	/**
	 * 	添加图书信息
	 * @param book
	 * @throws BookException
	 */
	public void add(Book book) throws BookException;
	/**
	 * 	删除图书
	 * @param book
	 * @throws BookException
	 */
	public void delete(Book book) throws BookException;
}
