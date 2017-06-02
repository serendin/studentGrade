package com.student.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.model.Student;
import com.model.User;
import com.dao.StudentDao;

@SuppressWarnings("serial")
@WebServlet("/findMessageStuServlet")
public class findMessageStuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		Student student=new Student();
		StudentDao studao=new StudentDao();
	    student=studao.findByID(user.getUseid());
		request.getSession().setAttribute("student", student);
		response.sendRedirect("studentOp.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
