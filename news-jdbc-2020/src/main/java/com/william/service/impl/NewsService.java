package com.william.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.william.dao.INewsDAO;
import com.william.model.NewsModel;
import com.william.service.INewsService;

public class NewsService implements INewsService {

	@Inject
	private INewsDAO newsDao;
	
	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		return newsDao.findByCategoryId(categoryId);
	}

}
