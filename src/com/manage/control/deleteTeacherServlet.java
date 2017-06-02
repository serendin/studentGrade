package com.manage.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CourseDao;
import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.model.Course;
import com.model.Student;
import com.model.Teacher;

@WebServlet("/deleteTeacherServlet.do")
public class deleteTeacherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String tno=(String)request.getParameter("tno");
		TeacherDao teadao=new TeacherDao();
		teadao.deleteTeacher(tno);
		ArrayList<Teacher> teachers=teadao.findAllTeacher();
		if (teachers!= null) {
			request.getSession().setAttribute("teachers", teachers);
			response.sendRedirect("displayAllTeacher.jsp");
		} else {
			response.sendRedirect("noMessage.jsp");
		}
	}
}
