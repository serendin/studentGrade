package com.manage.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Teacher;
import com.dao.TeacherDao;


@WebServlet("/updateTeacherServlet.do")
public class updateTeacherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String tno=(String)request.getParameter("tno");
		TeacherDao teadao=new TeacherDao();
		Teacher teacher=teadao.findByID(tno);
		if (teacher!= null) {
			request.getSession().setAttribute("updateTeacher", teacher);
			response.sendRedirect("updateTeacher.jsp");
		} else {
			response.sendRedirect("noMessage.jsp");
		}
	}
}
