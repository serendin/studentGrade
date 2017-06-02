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


@WebServlet("/updateStudentInfoServlet.do")
public class updateStudentInfoServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Student stu=new Student((String)request.getParameter("sno"),(String)request.getParameter("name"),
				(String)request.getParameter("sex"),(String)request.getParameter("birth")
				,(String)request.getParameter("class"),(String)request.getParameter("phone"));
		StudentDao studao=new StudentDao();
		studao.updateStudent(stu);
		ArrayList<Student> students=studao.findAllStudent();
		if (students!= null) {
			request.getSession().setAttribute("students", students);
			response.sendRedirect("displayAllStudent.jsp");
		} else {
			response.sendRedirect("noMessage.jsp");
		}
	}

}
