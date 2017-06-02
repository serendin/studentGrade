package com.manage.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;
import com.dao.StudentDao;


@WebServlet("/updateStudentServlet.do")
public class updateStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String sno=(String)request.getParameter("sno");
		StudentDao studao=new StudentDao();
		Student student=studao.findByID(sno);
		if (student!= null) {
			request.getSession().setAttribute("updateStudent", student);
			response.sendRedirect("updateStudent.jsp");
		} else {
			response.sendRedirect("noMessage.jsp");
		}
	}
}
