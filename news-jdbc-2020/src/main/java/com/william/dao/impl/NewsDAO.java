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
		String sql = "INSERT INTO news(title, content, thumbnail, shortdescription, categoryid, createddate, createdby) VALUES(?, ?, ?, ?, ?, ?, ?)";
		return insert(sql, newsModel.getTitle(), newsModel.getContent(), newsModel.getThumbnail(), newsModel.getShortDescription(),
						newsModel.getCategoryId(), newsModel.getCreatedDate(), newsModel.getCreatedBy());
	}

	@Override
	public void update(NewsModel updateNews) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?, shortdescription = ?, content = ?, ");
		sql.append("categoryid = ?, createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateNews.getTitle(), updateNews.getThumbnail(), updateNews.getShortDescription(),
				updateNews.getContent(), updateNews.getCategoryId(), updateNews.getCreatedDate(), updateNews.getCreatedBy(),
				updateNews.getModifiedDate(), updateNews.getModifiedBy(), updateNews.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, id);
	}
}
