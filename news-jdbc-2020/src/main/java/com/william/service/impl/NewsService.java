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

	@Override
	public NewsModel save(NewsModel newsModel) {
		Long id = newsDao.save(newsModel);
		return newsDao.findOne(id);
	}

	@Override
	public NewsModel update(NewsModel updateNews) {
		NewsModel oldNews = newsDao.findOne(updateNews.getId());
		updateNews.setCreatedDate(oldNews.getCreatedDate());
		updateNews.setCreatedBy(oldNews.getCreatedBy());
		newsDao.update(updateNews);
		return newsDao.findOne(updateNews.getId());
	}

	@Override
	public void delete(Long[] ids) {
		for(Long id: ids) {
			newsDao.delete(id);
		}
	}
}
