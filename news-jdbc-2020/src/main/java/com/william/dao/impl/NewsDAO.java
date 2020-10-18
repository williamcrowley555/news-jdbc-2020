package com.william.dao.impl;

import java.util.List;

import com.william.dao.INewsDAO;
import com.william.mapper.NewsMapper;
import com.william.model.NewsModel;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewsMapper(), categoryId);
	}

}
