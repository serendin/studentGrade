package com.student.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CTmessageDao;
import com.dao.CourseDao;
import com.model.CTmessage;
import com.model.Course;
import com.model.User;

@WebServlet("/deleteCourseStuServlet.do")
public class deleteCourseStuServlet extends HttpServlet {

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
		int tcid = Integer.parseInt(request.getParameter("tcid"));
		CTmessageDao ctdao=new CTmessageDao();
		ctdao.deleteStuCourse(tcid, user.getUseid());
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
}
