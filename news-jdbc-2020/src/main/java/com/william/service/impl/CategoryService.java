package com.william.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.william.dao.ICategoryDAO;
import com.william.model.CategoryModel;
import com.william.service.ICategoryService;

public class CategoryService implements ICategoryService {
	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}
}
