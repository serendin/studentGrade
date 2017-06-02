package com.teacher.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Course;
import com.model.Grade;
import com.model.User;
import com.dao.CourseDao;
import com.dao.GradeDao;

@WebServlet("/insertGradeServlet.do")
public class insertGradeServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<Grade> grades=new ArrayList<Grade>();
		grades=(ArrayList<Grade>)request.getSession().getAttribute("grades");
		int tcid=Integer.parseInt(request.getSession().getAttribute("tcid").toString());
		GradeDao gradao=new GradeDao();
		for(Grade g:grades){
			int ggrade=0;
			String id=Integer.toString(g.getId());
	        ggrade=Integer.parseInt(request.getParameter(id));
	        if(ggrade!=0)
	        	gradao.updateGrade(g.getId(),ggrade);
		}
		grades=gradao.findAllGrade(tcid);
		request.getSession().setAttribute("grades", grades);
		response.sendRedirect("TinputGrade.jsp");
	}

}
