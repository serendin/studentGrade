package com.manage.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Course;
import com.model.Student;
import com.model.Teacher;
import com.dao.CourseDao;
import com.dao.StudentDao;
import com.dao.TeacherDao;


@WebServlet("/insertCourseServlet.do")
public class insertCourseServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Course cou=new Course((String)request.getParameter("cno"),(String)request.getParameter("name"),
				Integer.parseInt(request.getParameter("credit").toString()),Integer.parseInt(request.getParameter("period").toString()));

		CourseDao coudao=new CourseDao();
		coudao.insertCourse(cou);
		ArrayList<Course> courses=coudao.findAllCourse();
		if (courses!= null) {
			request.getSession().setAttribute("courses", courses);
			response.sendRedirect("displayAllCourse.jsp");
		} else {
			response.sendRedirect("noMessage.jsp");
		}
	}

}
