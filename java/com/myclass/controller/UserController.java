package com.myclass.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.dto.RoleDto;
import com.myclass.dto.UserDto;
import com.myclass.service.RoleService;
import com.myclass.service.UserService;
import com.myclass.util.ServletConstant;
import com.myclass.util.UserConstant;

@WebServlet (urlPatterns = {"/user" , "/user/add" , "/user/edit" , "/user/delete"})
public class UserController extends HttpServlet {
	

	private RoleService		roleService;
	private UserService		userService;
	public UserController() {
		roleService = new RoleService();
		userService = new UserService();
	}
	
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getServletPath();
		switch (action) {
		case ServletConstant.PATH_USER:
			req.setAttribute("userList", userService.getAllUser());
			req.getRequestDispatcher(UserConstant.URL_USER_LIST).forward(req, resp);
			
			
			break;
		case ServletConstant.PATH_USER_ADD:
			List<RoleDto> roleDtos = roleService.getAll();
			req.setAttribute("roles", roleDtos);
			req.getRequestDispatcher(UserConstant.URL_USER_ADD).forward(req, resp);
			
			break;
		case ServletConstant.PATH_USER_DELETE:
			int idDelete = Integer.parseInt(req.getParameter("id"));
			int result = userService.deleteUser(idDelete);
			if (result == -1) {
				req.setAttribute("message", "Xóa user không thành công");
				req.getRequestDispatcher("URL_USER_LIST").forward(req, resp);
			}
			else {
				resp.sendRedirect(req.getContextPath() + ServletConstant.PATH_USER);
			}
			break;
		case ServletConstant.PATH_USER_EDIT:
			int idEdit = Integer.parseInt(req.getParameter("id"));
			
			req.setAttribute("user" , userService.getById(idEdit));
			req.setAttribute("role" , roleService.getAll());
			req.getRequestDispatcher(UserConstant.URL_USER_EDIT).forward(req, resp);
			
			break;


		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		switch (action) {
		case ServletConstant.PATH_USER_ADD:
			UserDto userDto = extractUserFromRequest(req);
			int result = userService.saveUser(userDto);
			
			if (result == -1) {
				req.setAttribute("message", "Thêm user không thành công");
				req.getRequestDispatcher(UserConstant.URL_USER_ADD).forward(req, resp);
			}
			else {
				resp.sendRedirect(req.getContextPath() + ServletConstant.PATH_USER);
			}
			
			
			
			
			break;
		case ServletConstant.PATH_USER_EDIT:
			UserDto userEditDto = extractUserFromRequest(req);
			int idEditDto = (Integer.parseInt(req.getParameter("id")));
			userEditDto.setId(idEditDto);
			int resultEdit = userService.updateUser(userEditDto);
			if(resultEdit == -1) {
				req.setAttribute("message", "Edit user thất bại");
				req.getRequestDispatcher(UserConstant.URL_USER_EDIT).forward(req, resp);
			}
			else {
				resp.sendRedirect(req.getContextPath() + ServletConstant.PATH_USER);
			}
			break;

		default:
			break;
		}
	}

	private UserDto extractUserFromRequest(HttpServletRequest req) {
		// TODO Auto-generated method stub
		UserDto userDto = new UserDto();
		
		userDto.setEmail(req.getParameter("email"));
		userDto.setPassword(req.getParameter("password"));
		userDto.setFullname(req.getParameter("fullname"));
		userDto.setAddress(req.getParameter("address"));
		userDto.setRoleId(Integer.parseInt(req.getParameter("roleId")));
		
		return userDto;
	}
	

}
