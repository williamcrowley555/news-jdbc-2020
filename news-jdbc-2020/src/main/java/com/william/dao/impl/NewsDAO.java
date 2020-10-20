package com.william.dao.impl;

import java.util.List;

import com.william.dao.INewsDAO;
import com.william.mapper.NewsMapper;
import com.william.model.NewsModel;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {

	@Override
	public NewsModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewsModel> news = query(sql, new NewsMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewsMapper(), categoryId);
	}

	@Override
	public Long save(NewsModel newsModel) {
		String sql = "INSERT INTO news(title, content, categoryid) VALUES(?, ?, ?)";
		return insert(sql, newsModel.getTitle(), newsModel.getContent(), newsModel.getCategoryId());
	}

}
