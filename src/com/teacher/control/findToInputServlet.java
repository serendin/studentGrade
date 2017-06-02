package com.teacher.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Course;
import com.model.User;
import com.dao.CourseDao;

@WebServlet("/findToInputServlet")
public class findToInputServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		CourseDao coudao = new CourseDao();
		ArrayList<Course> choosedCourses = new ArrayList<Course>();
		choosedCourses = coudao.findTeaCourse(user.getUseid());
		request.getSession().setAttribute("choosedCourses", choosedCourses);
		response.sendRedirect("TinputGrade.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
