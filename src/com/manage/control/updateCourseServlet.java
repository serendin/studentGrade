package com.manage.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Course;
import com.dao.CourseDao;


@WebServlet("/updateCourseServlet.do")
public class updateCourseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String cno=(String)request.getParameter("cno");
		CourseDao coudao=new CourseDao();
		Course course=coudao.findByID(cno);
		if (course!= null) {
			request.getSession().setAttribute("updateCourse", course);
			response.sendRedirect("updateCourse.jsp");
		} else {
			response.sendRedirect("noMessage.jsp");
		}
	}
}
