package com.manage.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CourseDao;
import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.model.Course;
import com.model.Student;
import com.model.Teacher;

@WebServlet("/deleteStudentServlet.do")
public class deleteStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String sno=(String)request.getParameter("sno");
		StudentDao studao=new StudentDao();
		studao.deleteStudent(sno);
		ArrayList<Student> students=studao.findAllStudent();
		if (students!= null) {
			request.getSession().setAttribute("students", students);
			response.sendRedirect("displayAllStudent.jsp");
		} else {
			response.sendRedirect("noMessage.jsp");
		}
	}
}
