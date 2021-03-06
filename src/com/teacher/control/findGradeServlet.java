package com.teacher.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Grade;
import com.model.User;
import com.dao.CTmessageDao;
import com.dao.GradeDao;

@SuppressWarnings("serial")
@WebServlet("/findGradeServlet")
public class findGradeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		String cno=(String)request.getParameter("cno");
		CTmessageDao ctdao=new CTmessageDao();
		int tcid=ctdao.findTcid(user.getUseid(), cno);
		ArrayList<Grade> grades=new ArrayList<Grade>();
		GradeDao gradao=new GradeDao();
		grades=gradao.findAllGrade(tcid);
		request.getSession().setAttribute("tcid", tcid);
		request.getSession().setAttribute("grades", grades);
		response.sendRedirect("TinputGrade.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
