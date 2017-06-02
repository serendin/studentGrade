package com.manage.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.CTmessage;
import com.model.User;
import com.dao.CTmessageDao;

@WebServlet("/findTeachServlet")
public class findTeachServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		CTmessageDao ctdao = new CTmessageDao();
		ArrayList<CTmessage> Courses = new ArrayList<CTmessage>();
		Courses = ctdao.findAllCourse();
		request.getSession().setAttribute("TeacherCourses",Courses);
		
		response.sendRedirect("MTeacherCourse.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
