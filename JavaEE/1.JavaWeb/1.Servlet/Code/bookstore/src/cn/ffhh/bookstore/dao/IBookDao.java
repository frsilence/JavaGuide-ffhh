package cn.ffhh.bookstore.dao;

import java.util.List;

import cn.ffhh.bookstore.domain.Book;

public interface IBookDao extends IBookstoreDao<String, Book>{
	/**
	 * 根据购物车子项寻找Book
	 * @return
	 */
	public Book findByCartitemId(String cartitemId);
	/**
	 * 	根据图书id得到分类id
	 * @param bookId
	 * @return
	 */
	public Integer findCategoryIdByBookId(String bookId);
	/**
	 * 	根据分类id查找其所有图书，若分类id不提供则查找所有分类的所有图书
	 * @param categoryId
	 * @return
	 */
	public List<Book> findAllByCategoryId(Integer categoryId);
	/**
	 * 	根据图书名称查找图书
	 * @param bname
	 * @return
	 */
	public Book findByName(String bname);
}
