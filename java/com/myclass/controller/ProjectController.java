package com.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.service.ProjectService;
import com.myclass.util.ProjectConstant;
import com.myclass.util.ServletConstant;

@WebServlet(urlPatterns = {"/project" , "/project/add"})
public class ProjectController extends HttpServlet{
	private ProjectService projectService;
	public ProjectController() {
		projectService = new ProjectService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch (action) {
		case ServletConstant.PATH_PROJECT:
			req.setAttribute("projectList", projectService.getAll());
			req.getRequestDispatcher(ProjectConstant.URL_PROJECT_LIST).forward(req, resp);
			
			break;
		case ServletConstant.PATH_PROJECT_DELETE:
			int idDelete = Integer.parseInt(req.getParameter("id"));
			int result = projectService.deleteUser(idDelete);
			if (result == -1) {
				req.setAttribute("message", "Xóa user không thành công");
				req.getRequestDispatcher("URL_PROJECT_LIST").forward(req, resp);
			}
			else {
				resp.sendRedirect(req.getContextPath() + ServletConstant.PATH_PROJECT);
			}
			break;

		default:
			break;
		}
	}
}
