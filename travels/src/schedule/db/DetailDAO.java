package schedule.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DetailDAO {
	
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs ;
	int result;
	
	public boolean addDetail(String user_id) {
		
		try {
			conn=ds.getConnection();
			String sql = "";
			
			
		}catch(Exception e) {
			System.out.println();
		}
		
		
		return false;
	}
	
	public boolean delDetail(int detail_no) {
			
		try {
			conn=ds.getConnection();
			String sql ="";
			sql = " delete from sch_detail where detail_no = ? ";
			pstmt = conn.prepareStatement(sql);
			int result = 0;
			result = pstmt.executeUpdate();
			if(result!=0)
				return true;
			
		}catch(Exception e) {
			System.out.println("delDetail error : " + e);
		}finally {
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return false;
	}
	
	
	
	
}
