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


@WebServlet("/updateMessageStuServlet")
public class updateMessageStuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		Student stu=new Student(user.getUseid(),(String)request.getParameter("name"),
				(String)request.getParameter("sex"),(String)request.getParameter("birth")
				,(String)request.getParameter("class"),(String)request.getParameter("phone"));
        StudentDao studao=new StudentDao();
        studao.updateStudent(stu);
		request.getSession().setAttribute("student",stu);
		response.sendRedirect("studentOp.jsp");
	}
}
