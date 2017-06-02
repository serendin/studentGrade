package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.User;

public class UserDao extends BaseDao {
	public boolean insertUser(User user) {
		boolean flag = false;
		String sql = "INSERT INTO users VALUES(?,?,?,?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUseid());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getType());
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

	public boolean deleteUser(String stuid) {
		String sql = "delete from users where useid=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, stuid);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	public User findName(User user) {
		String sql = "SELECT * FROM lsm_users WHERE useid=? AND password=? AND usertype=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user.getUseid());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getType());
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					user.setName(rst.getString("name"));
				}
			}
		} catch (SQLException se) {
			return null;
		}
		return user;
	}

	public ArrayList<User> findAllUser() {
		ArrayList<User> userList = new ArrayList<User>();
		String sql = "SELECT * FROM users where userType!='π‹¿Ì‘±'";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				User user = new User();
				user.setUseid(rst.getString("useid"));
				user.setName(rst.getString("name"));
				user.setPassword(rst.getString("password"));
				user.setType(rst.getString("userType"));
				userList.add(user);
			}
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
		return userList;
	}

}
