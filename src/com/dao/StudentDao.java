package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Student;

public class StudentDao extends BaseDao {
	public boolean insertStudent(Student student) {
		boolean flag = false;
		String sql = "INSERT INTO lsm_student " + "VALUES(?,?,?,?,?,?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getSno());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getSex());
			pstmt.setString(4, student.getSclass());
			pstmt.setString(5, student.getPhone());
			pstmt.setString(6, student.getBirth());
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

	public boolean deleteStudent(String stuid) {
		String sql = "delete from lsm_student where SID=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, stuid);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	public void updateStudent(Student student) {
		String sql = "update lsm_student set Sname=?,Ssex=?,Sbirth=?,Sphone=?,Sclass=? where SID=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getSex());
			pstmt.setString(3, student.getBirth());
			pstmt.setString(4, student.getPhone());
			pstmt.setString(5, student.getSclass());
			pstmt.setString(6, student.getSno());
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public Student findByID(String sid) {
		String sql = "SELECT * FROM lsm_student WHERE SID=?";
		Student student = new Student();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, sid);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					student.setSno(rst.getString("SID"));
					student.setName(rst.getString("Sname"));
					student.setSex(rst.getString("Ssex"));
					student.setBirth(rst.getString("Sbirth"));
					student.setPhone(rst.getString("Sphone"));
					student.setSclass(rst.getString("Sclass"));
				}
				rst.close();
			}
			conn.close();
		} catch (SQLException se) {
			return null;
		}
		return student;
	}

	public ArrayList<Student> findAllStudent() {

		ArrayList<Student> stuList = new ArrayList<Student>();
		String sql = "SELECT * FROM lsm_student";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Student student = new Student();
				student.setSno(rst.getString("SID"));
				student.setName(rst.getString("Sname"));
				student.setSex(rst.getString("Ssex"));
				student.setSclass(rst.getString("Sclass"));
				student.setPhone(rst.getString("Sphone"));
				student.setBirth(rst.getString("Sbirth"));
				stuList.add(student);
			}
			rst.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return stuList;
	}
}
