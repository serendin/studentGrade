package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Grade;

public class GradeDao extends BaseDao {

	public ArrayList<Grade> findAllGrade(int tcid) {

		ArrayList<Grade> graList = new ArrayList<Grade>();
		String sql = "exec tcid_grade ?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tcid);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Grade grade = new Grade();
				grade.setId(rst.getInt("TCSID"));
				grade.setSno(rst.getString("SID"));
				grade.setSname(rst.getString("Sname"));
				grade.setSsex(rst.getString("Ssex"));
				grade.setSclass(rst.getString("Sclass"));
				grade.setCname(rst.getString("Cname"));
				grade.setGrade(rst.getInt("grade"));
				graList.add(grade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return graList;
	}
	public ArrayList<Grade> findGrades() {

		ArrayList<Grade> graList = new ArrayList<Grade>();
		String sql = "exec grades";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Grade grade = new Grade();
				grade.setId(rst.getInt("TCSID"));
				grade.setSno(rst.getString("SID"));
				grade.setSname(rst.getString("Sname"));
				grade.setSsex(rst.getString("Ssex"));
				grade.setSclass(rst.getString("Sclass"));
				grade.setCname(rst.getString("Cname"));
				grade.setTname(rst.getString("Tname"));
				grade.setGrade(rst.getInt("grade"));
				graList.add(grade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return graList;
	}
	public void updateGrade(int id, int grade) {
		String sql = "update lsm_C_S set grade=? where TCSID=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, grade);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	public ArrayList<Grade> findAllStuGrade(String sid) {
		ArrayList<Grade> graList = new ArrayList<Grade>();
		String sql = "exec sid_grade ?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sid);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Grade grade = new Grade();
				grade.setId(rst.getInt("TCSID"));
				grade.setSno(rst.getString("SID"));
				grade.setSname(rst.getString("Sname"));
				grade.setCname(rst.getString("Cname"));
				grade.setCredit(rst.getInt("Ccredit"));
				grade.setPeriod(rst.getInt("Cperiod"));
				grade.setGrade(rst.getInt("grade"));
				if (grade.getGrade() != 0)
					graList.add(grade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return graList;
	}
	
	
}
