package com.manage.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;
import com.model.Teacher;
import com.model.Course;
import com.dao.TeacherDao;
import com.dao.CourseDao;
import com.dao.StudentDao;


@WebServlet("/findTeacherServlet")
public class findTeacherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherDao teadao=new TeacherDao();
		ArrayList<Teacher> teachers=teadao.findAllTeacher();
		if (teachers!= null) {
			request.getSession().setAttribute("teachers", teachers);
			response.sendRedirect("displayAllTeacher.jsp");
		} else {
			response.sendRedirect("noMessage.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
