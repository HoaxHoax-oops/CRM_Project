package com.myclass.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.dto.RoleDto;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;
import com.myclass.util.RoleConstant;
import com.myclass.util.ServletConstant;

@WebServlet(urlPatterns = {"/role","/role/add","/role/edit", "/role/delete"})
public class RoleController extends HttpServlet{
	private RoleRepository roleRepository;
	private RoleService roleService;
	public RoleController() {
		roleRepository = new RoleRepository();
		roleService = new RoleService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String action = req.getServletPath();
		switch (action) {
		case ServletConstant.PATH_ROLE:
			
			List<RoleDto> roleList = roleService.getAll();
			
			req.setAttribute("listRole", roleList);
			req.getRequestDispatcher(RoleConstant.URL_ROLE_LIST).forward(req, resp);
			break;
		case ServletConstant.PATH_ROLE_ADD:
			
			req.getRequestDispatcher(RoleConstant.URL_ROLE_ADD).forward(req, resp);
			break;
		case ServletConstant.PATH_ROLE_EDIT: 
			int idEdit = Integer.parseInt(req.getParameter("id"));
			RoleDto dto = roleService.finById(idEdit);
			
			req.setAttribute("role", dto);
			req.getRequestDispatcher(RoleConstant.URL_ROLE_EDIT).forward(req, resp);
			
			break;
		case ServletConstant.PATH_ROLE_DELETE:
			int idRemove = Integer.parseInt(req.getParameter("id"));
			int result = roleService.deleteRole(idRemove);
			if (result == -1) {
				req.setAttribute("message", "Delete role fail");
				req.getRequestDispatcher(RoleConstant.URL_ROLE_LIST).forward(req, resp);
			}
			else {
				resp.sendRedirect(req.getContextPath() + ServletConstant.PATH_ROLE);
			}
			
			break;

		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String action = req.getServletPath();
		
		String name = req.getParameter("name");
		String desc = req.getParameter("desc");
		
		RoleDto roleDto = new RoleDto(name , desc);
		switch (action) {
		case ServletConstant.PATH_ROLE_ADD:
			int result =  roleService.insert(roleDto);
			if (result == -1) {
				req.setAttribute("message", "Thêm thất bại");
				req.getRequestDispatcher(RoleConstant.URL_ROLE_ADD).forward(req, resp);
			}
			else {
				resp.sendRedirect (req.getContextPath() + ServletConstant.PATH_ROLE);
			}
			break;
		case ServletConstant.PATH_ROLE_EDIT:
			int id = Integer.parseInt(req.getParameter("id"));
			roleDto.setId(id);
			if (roleService.editRole(roleDto) == -1) {
				req.setAttribute("message", "Cập nhật thất bại");
				req.getRequestDispatcher(RoleConstant.URL_ROLE_EDIT).forward(req, resp);
			}
			else {
				resp.sendRedirect(req.getContextPath() + ServletConstant.PATH_ROLE);
			}
			break;

		default:
			break;
		}
		
	}
	
	

}
