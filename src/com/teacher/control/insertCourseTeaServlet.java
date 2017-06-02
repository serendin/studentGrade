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

@WebServlet("/insertCourseTeaServlet.do")
public class insertCourseTeaServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		String[] cnos = request.getParameterValues("cnos");
		CourseDao coudao = new CourseDao();
		for (String tmp : cnos)
			coudao.insertTeaCourse(tmp, user.getUseid());
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
