package com.myclass.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.dto.ProjectDto;
import com.myclass.dto.TaskDto;
import com.myclass.service.TaskService;
import com.myclass.util.ServletConstant;
import com.myclass.util.TaskConstant;

@WebServlet(urlPatterns = {"/task" , "/task/add" , "/task/edit" + "/task/delete"})
public class TaskController extends HttpServlet{
	
	private TaskService taskService;
	
	public TaskController() {
		taskService = new TaskService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch (action) {
		case ServletConstant.PATH_TASK:
			List<TaskDto> taskList = taskService.getAll();
			
			req.setAttribute("taskList",taskList);
			req.getRequestDispatcher(TaskConstant.URL_TASK_LIST).forward(req, resp);
			break;
		case ServletConstant.PATH_TASK_DELETE:
			int idDel = Integer.parseInt(req.getParameter("id"));
			int result = taskService.delete(idDel);
			if (result == -1) {
				req.setAttribute("message", "Xóa task thất bại");
				req.getRequestDispatcher(TaskConstant.URL_TASK_LIST).forward(req, resp);
			}
			resp.sendRedirect(req.getContextPath() + ServletConstant.PATH_TASK);
			break;
		case ServletConstant.PATH_TASK_ADD:
			req.getRequestDispatcher(TaskConstant.URL_TASK_ADD).forward(req, resp);
			break;
		case ServletConstant.PATH_TASK_EDIT:
			
			break;

		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch (action) {
		case ServletConstant.PATH_TASK_ADD:
			TaskDto dto = extractTaskFromRequest(req);
			int result = taskService.add(dto);
			if (result == -1) {
				req.setAttribute("message", "Thêm task thất bại");
				req.getRequestDispatcher(TaskConstant.URL_TASK_ADD).forward(req, resp);
			}
			resp.sendRedirect(req.getContextPath() + ServletConstant.PATH_TASK);
			break;
		case ServletConstant.PATH_TASK_EDIT:
			
			break;
		default:
			break;
		}
	}
	
	private TaskDto extractTaskFromRequest(HttpServletRequest req) {
		// TODO Auto-generated method stub
		TaskDto taskDto = new TaskDto();
		taskDto.setName(req.getParameter("name"));
		taskDto.setDescription(req.getParameter("description"));
		taskDto.setStartDate(req.getParameter("startDate"));
		taskDto.setEndDate(req.getParameter("endDate"));
		taskDto.setCreateUserId(Integer.parseInt(req.getParameter("createUserId")));
		taskDto.setStatusId(Integer.parseInt(req.getParameter("statusId")));
		taskDto.setProjectId(Integer.parseInt(req.getParameter("projectId")));
		taskDto.setUserId(Integer.parseInt(req.getParameter("userId")));
		taskDto.setCategoryId(Integer.parseInt(req.getParameter("categoryId")));
		
		return taskDto;
	}
}
