package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Teacher;

public class TeacherDao extends BaseDao {

	public boolean insertTeacher(Teacher teacher) {
		boolean flag = false;
		String sql = "INSERT INTO lsm_teacher " + "VALUES(?,?,?,?,?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher.getTno());
			pstmt.setString(2, teacher.getName());
			pstmt.setString(3, teacher.getSex());
			pstmt.setString(4, teacher.getPhone());
			pstmt.setString(5, teacher.getBirth());
			int num = pstmt.executeUpdate();
			if (num > 0) {
				flag = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	public boolean deleteTeacher(String teaid) {
		String sql = "delete from lsm_teacher where TID=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teaid);
			pstmt.executeUpdate();
			conn.close();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	public void updateTeacher(Teacher teacher) {
		String sql = "update lsm_teacher set Tname=?,Tsex=?,Tbirth=?,Tphone=? where TID=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teacher.getName());
			pstmt.setString(2, teacher.getSex());
			pstmt.setString(3, teacher.getBirth());
			pstmt.setString(4, teacher.getPhone());
			pstmt.setString(5, teacher.getTno());
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public Teacher findByID(String tid) {
		String sql = "SELECT * FROM lsm_teacher WHERE TID=?";
		Teacher teacher=new Teacher();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, tid);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					teacher.setTno(rst.getString("TID"));
					teacher.setName(rst.getString("Tname"));
					teacher.setSex(rst.getString("Tsex"));
					teacher.setPhone(rst.getString("Tphone"));
					teacher.setBirth(rst.getString("Tbirth"));
				}
				rst.close();
			}
			conn.close();
		} catch (SQLException se) {
			return null;
		}
		return teacher;
	}
	
	public ArrayList<Teacher> findAllTeacher() {

		ArrayList<Teacher> teaList = new ArrayList<Teacher>();
		String sql = "SELECT * FROM lsm_teacher";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Teacher teacher = new Teacher();
				teacher.setTno(rst.getString("TID"));
				teacher.setName(rst.getString("Tname"));
				teacher.setSex(rst.getString("Tsex"));
				teacher.setPhone(rst.getString("Tphone"));
				teacher.setBirth(rst.getString("Tbirth"));
				teaList.add(teacher);
			}
			rst.close();
			pstmt.close();
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
		return teaList;
	}
}
