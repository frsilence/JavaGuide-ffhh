package cn.ffhh.bookstore.dao;

import cn.ffhh.bookstore.domain.Category;

public interface ICategoryDao extends IBookstoreDao<Integer, Category>{
	/**
	 * 	根据分类id删除分类
	 * @param cid
	 * @return
	 */
	public boolean doRemove(Integer cid);
}
