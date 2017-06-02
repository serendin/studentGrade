package com.manage.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.AvgGrade;
import com.model.Grade;
import com.dao.AvgGradeDao;
import com.dao.GradeDao;


@WebServlet("/findAvgGradeServlet")
public class findAvgGradeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AvgGradeDao avgdao=new AvgGradeDao();
		ArrayList<AvgGrade> avgGrades=avgdao.findAllAvgGrade();
		GradeDao gradao=new GradeDao();
		ArrayList<Grade> grades=new ArrayList<Grade>();
		grades=gradao.findGrades();
		if (avgGrades!= null) {
			request.getSession().setAttribute("avgGrades", avgGrades);
			request.getSession().setAttribute("grades",grades);
			response.sendRedirect("MGrade.jsp");
		} else {
			response.sendRedirect("noMessage.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
