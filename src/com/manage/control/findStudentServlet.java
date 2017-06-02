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


@WebServlet("/findStudentServlet")
public class findStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao studao = new StudentDao();
		ArrayList<Student> students=studao.findAllStudent();
		if (students!= null) {
			request.getSession().setAttribute("students", students);
			response.sendRedirect("displayAllStudent.jsp");
		} else {
			response.sendRedirect("noMessage.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
