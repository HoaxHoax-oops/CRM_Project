package com.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.util.ControllerUrl;
import com.myclass.util.JspPath;

@WebServlet(name = "loginController", urlPatterns = {ControllerUrl.URL_LOGIN,
													ControllerUrl.URL_LOGOUT})
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		switch (action) {
		case ControllerUrl.URL_LOGIN:
			req.getRequestDispatcher(JspPath.JSP_LOGIN).forward(req, resp);
			break;

		default:
			break;
		}
	}
}
