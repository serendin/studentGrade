package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.AvgGrade;

public class AvgGradeDao extends BaseDao {

	public ArrayList<AvgGrade> findAllAvgGrade() {

		ArrayList<AvgGrade> graList = new ArrayList<AvgGrade>();
		String sql = "exec averages";
		Connection conn=null;
		try {
			    conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				AvgGrade avgGrade=new AvgGrade();
				avgGrade.setCno(rst.getString("CID"));
				avgGrade.setCname(rst.getString("Cname"));
				avgGrade.setTname(rst.getString("Tname"));
				avgGrade.setGrade(rst.getInt("average"));
				graList.add(avgGrade);
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
		return graList;
	}
}
