package com.manage.control;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.model.Teacher;
import com.dao.TeacherDao;


@WebServlet("/updateTeacherInfoServlet.do")
public class updateTeacherInfoServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Teacher tea=new Teacher((String)request.getParameter("tno"),(String)request.getParameter("name"),
				(String)request.getParameter("sex"),(String)request.getParameter("birth"),(String)request.getParameter("phone"));
		TeacherDao teadao=new TeacherDao();
		teadao.updateTeacher(tea);
		ArrayList<Teacher> teachers=teadao.findAllTeacher();
		if (teachers!= null) {
			request.getSession().setAttribute("teachers", teachers);
			response.sendRedirect("displayAllTeacher.jsp");
		} else {
			response.sendRedirect("noMessage.jsp");
		}
	}

}
