package com.teacher.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CourseDao;
import com.model.Course;
import com.model.User;

@WebServlet("/deleteCourseTeaServlet.do")
public class deleteCourseTeaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		String cno = (String) request.getParameter("cno");
		CourseDao coudao = new CourseDao();
		coudao.deleteTeaCourse(cno, user.getUseid());
		ArrayList<Course> choosedCourses = new ArrayList<Course>();
		choosedCourses = coudao.findTeaCourse(user.getUseid());
		ArrayList<Course> unchoosedCourses = new ArrayList<Course>();
		unchoosedCourses = coudao.findAllCourse();
		for (int i = 0, j = 0; i < unchoosedCourses.size() && j < choosedCourses.size();)
			if (unchoosedCourses.get(i).getCno().equals(choosedCourses.get(j).getCno())) {
				j++;
				unchoosedCourses.remove(i);
			}
			else i++;
		request.getSession().setAttribute("choosedCourses", choosedCourses);
		request.getSession().setAttribute("unchoosedCourses", unchoosedCourses);
		response.sendRedirect("TselectCourse.jsp");
	}
}
