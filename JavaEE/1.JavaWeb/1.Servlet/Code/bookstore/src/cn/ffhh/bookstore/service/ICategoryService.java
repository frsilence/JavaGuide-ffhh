package cn.ffhh.bookstore.service;

import java.util.List;

import cn.ffhh.bookstore.domain.Category;

public interface ICategoryService {
	/**
	 * 	获取所有分类
	 * @return
	 */
	public List<Category> findallCategories();
	/**
	 * 	根据分类id获得分类
	 * @param categoryId
	 * @return
	 */
	public Category findCategory(Integer categoryId);
	/**
	 * 	删除分类
	 * @param categoryId
	 * @return
	 */
	public Boolean delete(Integer categoryId);
	/**
	 * 	更新分类信息
	 * @param category
	 * @return
	 */
	public Boolean update(Category category);
	/**
	 * 	新增分类
	 * @param category
	 * @return
	 */
	public Boolean add(Category category);
}
