package com.william.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.william.model.NewsModel;
import com.william.service.ICategoryService;
import com.william.service.INewsService;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private INewsService newsService;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsModel newsModel = new NewsModel();
		newsModel.setTitle("Bài viết 5");
		newsModel.setContent("bai viet 5");
		newsModel.setCategoryId(1L);
		newsService.save(newsModel);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}