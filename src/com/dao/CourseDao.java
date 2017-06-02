package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Course;

public class CourseDao extends BaseDao {

	public boolean insertCourse(Course course) {
		boolean flag = false;
		String sql = "INSERT INTO lsm_course " + "VALUES(?,?,?,?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, course.getCno());
			pstmt.setString(2, course.getName());
			pstmt.setInt(3, course.getCredit());
			pstmt.setInt(4, course.getPeriod());
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

	public boolean deleteCourse(String couid) {
		String sql = "delete from lsm_course where CID=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, couid);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	public void updateCourse(Course course) {
		deleteCourse(course.getCno());
		insertCourse(course);
	}

	public Course findByID(String cid) {
		String sql = "SELECT * FROM lsm_course WHERE CID=?";
		Course course = new Course();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, cid);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					course.setCno(rst.getString("CID"));
					course.setName(rst.getString("Cname"));
					course.setCredit(rst.getInt("Ccredit"));
					course.setPeriod(rst.getInt("Cperiod"));
				}
				rst.close();
			}
			conn.close();
		} catch (SQLException se) {
			return null;
		}
		return course;
	}

	public ArrayList<Course> findAllCourse() {

		ArrayList<Course> couList = new ArrayList<Course>();
		String sql = "SELECT * FROM lsm_course";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Course course = new Course();
				course.setCno(rst.getString("CID"));
				course.setName(rst.getString("Cname"));
				course.setCredit(rst.getInt("Ccredit"));
				course.setPeriod(rst.getInt("Cperiod"));
				couList.add(course);
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
		return couList;
	}

	public ArrayList<Course> findTeaCourse(String tid) {
		ArrayList<String> cid = new ArrayList<String>();
		String sql = "SELECT CID FROM lsm_C_T WHERE TID=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, tid);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				cid.add(rst.getString("CID"));
			}
            rst.close();
			conn.close();
		} catch (SQLException se) {
			return null;
		}
		ArrayList<Course> couList = new ArrayList<Course>();
		for (String tmp : cid) {
			couList.add(findByID(tmp));
		}
		return couList;
	}
	
	public boolean deleteTeaCourse(String cid,String tid) {
		String sql = "delete from lsm_C_T where CID=? and TID=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, cid);
			pstmt.setString(2, tid);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
	
	public boolean insertTeaCourse(String cid,String tid) {
		boolean flag = false;
		String sql = "INSERT INTO lsm_C_T " + "VALUES(?,?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tid);
			pstmt.setString(2, cid);
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
}
