package com.student.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Grade;
import com.model.User;
import com.dao.GradeDao;

@WebServlet("/findGradeStuServlet")
public class findGradeStuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		ArrayList<Grade> grades=new ArrayList<Grade>();
		GradeDao gradao=new GradeDao();
		grades=gradao.findAllStuGrade(user.getUseid());
		request.getSession().setAttribute("grades", grades);
		response.sendRedirect("SdisplayGrade.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
