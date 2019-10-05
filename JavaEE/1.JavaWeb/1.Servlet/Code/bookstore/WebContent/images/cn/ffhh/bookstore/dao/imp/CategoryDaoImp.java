package cn.ffhh.bookstore.dao.imp;

import java.util.List;
import java.util.Set;

import cn.ffhh.bookstore.dao.ICategoryDao;
import cn.ffhh.bookstore.domain.Category;

public class CategoryDaoImp implements ICategoryDao {

	@Override
	public boolean doCreate(Category vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Category vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
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

}
