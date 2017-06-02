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


@WebServlet("/updateMessageTeaServlet")
public class updateMessageTeaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		Teacher tea=new Teacher(user.getUseid(),(String)request.getParameter("name"),
				(String)request.getParameter("sex"),(String)request.getParameter("birth"),(String)request.getParameter("phone"));
		TeacherDao teadao=new TeacherDao();
		teadao.updateTeacher(tea);
		request.getSession().setAttribute("teacher",tea);
		response.sendRedirect("teacherOp.jsp");
	}
}
