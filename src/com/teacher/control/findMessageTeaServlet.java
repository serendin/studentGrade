package com.teacher.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Teacher;
import com.model.User;
import com.dao.TeacherDao;

@SuppressWarnings("serial")
@WebServlet("/findMessageTeaServlet")
public class findMessageTeaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		Teacher teacher=new Teacher();
		TeacherDao teadao=new TeacherDao();
		teacher=teadao.findByID(user.getUseid());
		request.getSession().setAttribute("teacher", teacher);
		response.sendRedirect("teacherOp.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
