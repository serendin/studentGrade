package com.manage.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.UserDao;
import com.model.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		User u = new User((String) request.getParameter("useid"), (String) request.getParameter("password"), null,
				(String) request.getParameter("userType"));
		UserDao userdao = new UserDao();
		User user = userdao.findName(u);
		if (user.getName() != null) {
			request.getSession().setAttribute("user", user);
			request.setAttribute("message", "");
			if (u.getType().equals("manager")) {
				response.sendRedirect("manageOp.jsp");
			} else if (u.getType().equals("teacher")) {
				RequestDispatcher rd = request.getRequestDispatcher("/findMessageTeaServlet");
				rd.forward(request, response);
			}else if(u.getType().equals("student")){
				RequestDispatcher rd = request.getRequestDispatcher("/findMessageStuServlet");
				rd.forward(request, response);
			}else if(u.getType().equals("notchoose")){
				request.setAttribute("message", "用户类型未选择");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} else {
			request.setAttribute("message", "用户名或密码错误");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
        
	}

}
