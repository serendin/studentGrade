package com.manage.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.model.Course;
import com.dao.CourseDao;


@WebServlet("/findCourseServlet")
public class findCourseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CourseDao coudao=new CourseDao();
		ArrayList<Course> courses=coudao.findAllCourse();
		if (courses!= null) {
			request.getSession().setAttribute("courses", courses);
			response.sendRedirect("displayAllCourse.jsp");
		} else {
			response.sendRedirect("noMessage.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
