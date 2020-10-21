package com.william.service;

import java.util.List;

import com.william.model.NewsModel;

public interface INewsService {
	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel save(NewsModel newsModel);
	NewsModel update(NewsModel updateNews);
	void delete(Long[] id);
}
