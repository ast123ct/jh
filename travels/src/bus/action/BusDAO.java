package bus.action;

import java.sql.*;
import java.util.*;
import javax.sql.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.naming.*;
	
public class BusDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;
	
	public BusDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		}catch(Exception e) {
			System.out.println("DB 연결되었습니다. : " + e);
			return;
		}
	}

	public List<BusBean> getInfo(String bus_area) {
		BusBean bb = new BusBean();
		List<BusBean> list = new ArrayList<BusBean>();
		System.out.println(1+ bus_area);
		
		try {
			con = ds.getConnection();
			System.out.println("getConnection");			
			String sql = "select*from bus_list where bus_area=? order by bus_no";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bus_area);
			rs = pstmt.executeQuery();
			while(rs.next()) {			
				bb.setBus_area(rs.getString("bus_area"));
				bb.setBus_no(rs.getInt("bus_no"));
				bb.setBus_linename(rs.getString("bus_linename"));
				bb.setBus_start(rs.getString("bus_start"));
				bb.setBus_end(rs.getString("bus_end"));
				bb.setBus_traveltime(rs.getString("bus_traveltime"));
				bb.setBus_cost_ad(rs.getInt("bus_cost_ad"));
				bb.setBus_cost_st(rs.getInt("bus_cost_st"));
				bb.setBus_cost_ch(rs.getInt("bus_cost_ch"));
				list.add(bb);
			}			
		} catch (SQLException e) {
			System.out.println("getInfo 에러 : " + e);
		}
		finally {
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(con!=null)try {con.close();}catch(SQLException e) {}
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
		}
		return list;
	}//info end
	
	public boolean BusInsert(BusBean bb) {
		int result=0;
		try {
			con=ds.getConnection();		
			String sql = "insert into bus_list"
				+ " values(?, bus_no_seq.nextval,?,?,?,?,?,?,?)";
					
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bb.getBus_area());
			pstmt.setString(2, bb.getBus_linename());
			pstmt.setString(3, bb.getBus_start());
			pstmt.setString(4, bb.getBus_end());
			pstmt.setString(5, bb.getBus_traveltime());
			pstmt.setInt(6, bb.getBus_cost_ad());
			pstmt.setInt(7, bb.getBus_cost_st());
			pstmt.setInt(8, bb.getBus_cost_ch());
			pstmt.executeQuery();
			pstmt.close();
			
			String sql2 = "create sequece bus_?_seq "
				+ "increment by 1 "
				+ "start with 1";
			pstmt = con.prepareStatement(sql2);
			pstmt.executeQuery();
			pstmt.close();
						
			String sql3 ="insert into bus_?_schedule "
				+ "values(?,bus_?_seq.nextval,?,?)";
			pstmt = con.prepareStatement(sql3);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
			pstmt.setInt(1, bb.getBus_no());
			pstmt.setInt(2, bb.getBus_no());
			pstmt.setString(3, bb.getBus_departure());
			pstmt.setString(4,bb.getBus_arrival());
			}					
			result = pstmt.executeUpdate();						
			if(result==0) {return false;}
			return true;
			
		}catch(Exception ex) {
			System.out.println("Insert() 에러 :  " + ex);
		}
		finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(con!=null)try {con.close();}catch(SQLException e) {}
		}		
		return false;
	}//insert end
	
	public boolean BusModify(BusBean bb) {
		String sql = "update bus_list set "
				+ "bus_area=?, bus_linename=?, bus_start=?, bus_end=?, "
				+ "bus_traveltime=?, bus_cost_ad=?, bus_cost_st=?, bus_cost_ch=? "
				+ "where bus_no=?";
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);		
			pstmt.setString(1, bb.getBus_area());
			pstmt.setString(2, bb.getBus_linename());
			pstmt.setString(3, bb.getBus_start());
			pstmt.setString(4, bb.getBus_end());
			pstmt.setString(5, bb.getBus_traveltime());
			pstmt.setInt(6, bb.getBus_cost_ad());
			pstmt.setInt(7, bb.getBus_cost_st());
			pstmt.setInt(8, bb.getBus_cost_ch());
			pstmt.setInt(9, bb.getBus_no());
			result =pstmt.executeUpdate();
			pstmt.close();
			
			String sql2="update bus_?_schedule set "
					+ "bus_departure =?, bus_arrival=? "
					+ "where bus_no=? and bus_seq=?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, bb.getBus_area());
			pstmt.setString(2, bb.getBus_departure());
			pstmt.setString(3, bb.getBus_arrival());
			pstmt.setInt(4, bb.getBus_no());
			pstmt.setInt(5, bb.getBus_seq());
			result = pstmt.executeUpdate();
		
		}catch(Exception ex) {
			System.out.println("modify() 에러 :  " + ex);
		}
		finally {
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(con!=null)try {con.close();}catch(SQLException e) {}
		}
		if(result == 1) {
			return true;
		}else {
			return false;
		}
	}//modify end
	
	public boolean Busdelete(BusBean bb) {
		String sql = "delete from bus_?_schedule"
				+ " where bus_no=?";
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bb.getBus_area());
			pstmt.setInt(2, bb.getBus_no());
			result =pstmt.executeUpdate();
			pstmt.close();
			
			String sql2= "delete from bus_list where bus_no=?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, bb.getBus_no());
			result =pstmt.executeUpdate();
					
		}catch(Exception ex) {
			System.out.println("delete() 에러 :  " + ex);
		}
		finally {
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(con!=null)try {con.close();}catch(SQLException e) {}
		}	
		if(result == 1) {
			return true;
		}else {
			return false;
		}
	}//delete end	

	public JSONArray select_start(String area) {
		JSONArray array = new JSONArray();
		try{
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		
			String sql ="select distinct bus_start from bus_list where bus_area=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, area);
					rs=pstmt.executeQuery();

			//JSON 형태로 데이터를 만듭니다.		
			while(rs.next()){
				JSONObject object = new JSONObject();
				object.put("bus_start", rs.getString(1));
				array.add(object);
			}			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(pstmt!=null)try{pstmt.close();}catch(Exception ex){}
			if(rs!=null)try{rs.close();}catch(Exception ex){}
			if(con!=null)try{con.close();}catch(Exception ex){}
		}
		
		return array;
	}

	
	
}
