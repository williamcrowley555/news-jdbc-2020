package com.william.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.william.model.NewsModel;
import com.william.service.INewsService;
import com.william.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-news"})
public class NewsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private INewsService newsService;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel newsModel = HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		newsModel = newsService.save(newsModel);
		mapper.writeValue(response.getOutputStream(), newsModel);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel newsModel = HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		newsModel = newsService.update(newsModel);
		mapper.writeValue(response.getOutputStream(), newsModel);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel newsModel = HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		newsService.delete(newsModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}
