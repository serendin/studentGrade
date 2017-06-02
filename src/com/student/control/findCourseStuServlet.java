package com.student.control;

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

@WebServlet("/findCourseStuServlet")
public class findCourseStuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		CTmessageDao ctdao = new CTmessageDao();
		ArrayList<CTmessage> learnedCourses = new ArrayList<CTmessage>();
		learnedCourses = ctdao.findStuCourse(user.getUseid());
		ArrayList<CTmessage> unlearnedCourses = new ArrayList<CTmessage>();
		unlearnedCourses = ctdao.findAllCourse();
		for (int i = 0, j = 0; i < unlearnedCourses.size() && j < learnedCourses.size();)
			if (unlearnedCourses.get(i).getId()==learnedCourses.get(j).getId()) {
				unlearnedCourses.remove(i);
				j++;
			}
			else i++;
		request.getSession().setAttribute("learnedCourses",learnedCourses);
		request.getSession().setAttribute("unlearnedCourses", unlearnedCourses);
		response.sendRedirect("SselectCourse.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
