package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.CTmessage;

public class CTmessageDao extends BaseDao {


	public ArrayList<CTmessage> findAllCourse() {

		ArrayList<CTmessage> ctList = new ArrayList<CTmessage>();
		String sql = "exec student_selectlist";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				CTmessage ct=new CTmessage();
				ct.setId(rst.getInt("TCID"));
				ct.setCno(rst.getString("CID"));
				ct.setName(rst.getString("Cname"));
				ct.setCredit(rst.getInt("Ccredit"));
				ct.setPeriod(rst.getInt("Cperiod"));
				ct.setTname(rst.getString("Tname"));
				ctList.add(ct);
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
		return ctList;
	}

	public ArrayList<CTmessage> findStuCourse(String sid) {
		ArrayList<CTmessage> ctList=new ArrayList<CTmessage>();
		String sql = "exec sid_selectlist ?";
		try (Connection conn = dataSource.getConnection(); CallableStatement pstmt = conn.prepareCall(sql)) {
			pstmt.setString(1, sid);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				CTmessage ct=new CTmessage();
				ct.setId(rst.getInt("TCID"));
				ct.setCno(rst.getString("CID"));
				ct.setName(rst.getString("Cname"));
				ct.setCredit(rst.getInt("Ccredit"));
				ct.setPeriod(rst.getInt("Cperiod"));
				ct.setTname(rst.getString("Tname"));
				ctList.add(ct);
			}
            rst.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return ctList;
	}
	
	public boolean deleteStuCourse(int tcid,String sid) {
		String sql = "delete from lsm_C_S where TCID=? and SID=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, tcid);
			pstmt.setString(2, sid);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
	
	public boolean insertStuCourse(int tcid,String sid) {
		boolean flag = false;
		String sql = "INSERT INTO lsm_C_S " + "VALUES(?,?,null)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tcid);
			pstmt.setString(2, sid);
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
	
	public int findTcid(String tid,String cid){
		int tcid=0;
		String sql = "SELECT TCID FROM lsm_C_T WHERE TID=? AND CID=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, tid);
			pstmt.setString(2, cid);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					tcid=rst.getInt("TCID");
				}
			}
		} catch (SQLException se) {
			return 0;
		}
		return tcid;
	}
}
