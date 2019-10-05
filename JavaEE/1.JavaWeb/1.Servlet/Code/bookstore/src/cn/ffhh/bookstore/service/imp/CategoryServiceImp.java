package cn.ffhh.bookstore.service.imp;

import java.sql.SQLException;
import java.util.List;

import cn.ffhh.bookstore.Factory.DaoFactory;
import cn.ffhh.bookstore.dao.ICategoryDao;
import cn.ffhh.bookstore.domain.Category;
import cn.ffhh.bookstore.service.ICategoryService;

public class CategoryServiceImp implements ICategoryService {

	private ICategoryDao categoryDao = DaoFactory.getCategoryDaoInstance();
	@Override
	public List<Category> findallCategories() {
		return categoryDao.findAll();
	}

	@Override
	public Category findCategory(Integer categoryId) {
		return categoryDao.findById(categoryId);
	}

	@Override
	public Boolean delete(Integer categoryId) {
		return categoryDao.doRemove(categoryId);
	}

	@Override
	public Boolean update(Category category) {
		return categoryDao.doUpdate(category);
	}

	@Override
	public Boolean add(Category category) {
		Boolean result = false;
		try {
			result =  categoryDao.doCreate(category);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	

}
