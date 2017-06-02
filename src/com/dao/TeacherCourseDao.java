package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.TeacherCourse;

public class TeacherCourseDao extends BaseDao {

	public ArrayList<TeacherCourse> findAllTeacherCourse() {

		ArrayList<TeacherCourse> teaList = new ArrayList<TeacherCourse>();
		String sql = "SELECT * FROM lism_teacherCourse";
		Connection conn=null;
		try {
			    conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				TeacherCourse teacher=new TeacherCourse();
				teacher.setTno(rst.getString("lsm_Tno"));
				teacher.setTname(rst.getString("lsm_Tname"));
				teacher.setCno(rst.getString("lsm_Cno"));
				teacher.setCname(rst.getString("lsm_Cname"));
				teaList.add(teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return teaList;
	}
}
