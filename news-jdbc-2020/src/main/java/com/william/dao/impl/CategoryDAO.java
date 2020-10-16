package com.william.dao.impl;

import java.util.List;

import com.william.dao.ICategoryDAO;
import com.william.mapper.CategoryMapper;
import com.william.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

}