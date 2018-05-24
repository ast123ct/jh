/*
 DAO(Data Access Object)클래스
 - 데이터 베이스와 연동하여 레코드의 추가,수정, 삭제 작업이 이루어지는 클래스입니다.
 - 어떤 Action클래스가 호출되더라도 그에 해당하는 데이터 베이스 연동처리는 DAO 클래스에서 이루어지게 됩니다.
 */

package travel.db;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;

public class travelDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;

	public travelDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}//생성자 end
	
	public int insertTravel(travel t) {
		int result=0;
		
		try {
			con=ds.getConnection();
			String seq = "select travel_seq.nextval from dual ";
			pstmt=con.prepareStatement(seq);
			rs=pstmt.executeQuery();
			int num=0;
			if(rs.next()) {
				num=rs.getInt(1);
			}
			
			pstmt.close();
			
			
			String travel_insert ="insert into travel_information(travel_no,travel_name,travel_content,travel_address,travel_type,travel_tema)" 
								+"values(?,?,?,?,?,?) ";
			pstmt=con.prepareStatement(travel_insert);
			pstmt.setInt(1, num);
			pstmt.setString(2, t.getTravel_name());
			pstmt.setString(3,t.getTravel_content());
			pstmt.setString(4,t.getTravel_address());
			pstmt.setInt(5, t.getTravel_type());
			pstmt.setInt(6, t.getTravel_tema());
			result=pstmt.executeUpdate();
	
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
		return result;
	}//insertTravel end
	
	
	
	
	public int insertTravel_img(travel_image t) {
		int result=0;
		try {
			con=ds.getConnection();
			
			
			String travel_img_seq = "select travel_image_seq.nextval from dual ";
			pstmt=con.prepareStatement(travel_img_seq);
			rs = pstmt.executeQuery();
			
			int seq_num =0;
			if(rs.next()) {
				seq_num=rs.getInt(1);
			}
			
			pstmt.close();
			
			String travel_img_insert = "insert into travel_image(travel_img_no,travel_img_name,travel_img_type,travel_no)"
									+"values(?,?,?,?) ";
			pstmt=con.prepareStatement(travel_img_insert);
			pstmt.setInt(1, seq_num);
			pstmt.setString(2, t.getTravel_img_name());
			pstmt.setInt(3, t.getTravel_img_type());
			pstmt.setInt(4, t.getTravel_no());
			
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("여행지 이미지 등록 에러:"+e.getMessage());
		}finally {
			
			try {
				
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
		return result;
		
	}//insertTravel_img end
	
	
	
	public List<travel> getTravelList(){
		List<travel> list = new ArrayList<travel>();
		try {
			con=ds.getConnection();
			
			String sql="select * from travel_information ";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				travel temp = new travel();
				temp.setTravel_no(rs.getInt("travel_no"));
				temp.setTravel_address(rs.getString("travel_address"));
				temp.setTravel_content(rs.getString("travel_content"));
				temp.setTravel_name(rs.getString("travel_name"));
				temp.setTravel_tema(rs.getInt("travel_tema"));
				temp.setTravel_type(rs.getInt("travel_type"));
				list.add(temp);
			}
		}catch(Exception e) {
			System.out.println("여행지 리스트 추가 에러"+e.getMessage());
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
		
		return list;
	}//getTraveList end
	
	
	public travel getTravel_info(int no) {
		travel t = new travel();
		try {
			con=ds.getConnection();
			
			String sql="select * from travel_information where travel_no =? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				t.setTravel_no(rs.getInt("travel_no"));
				t.setTravel_address(rs.getString("travel_address"));
				t.setTravel_content(rs.getString("travel_content"));
				t.setTravel_name(rs.getString("travel_name"));
				t.setTravel_tema(rs.getInt("travel_tema"));
				t.setTravel_type(rs.getInt("travel_type"));
			}
		}catch(Exception e) {
			System.out.println("여행지 상세정보 에러" + e.getMessage());
		}finally {
			try {
				
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
		return t;
	}//getTravel_info end
	
	
	public int travel_modify(travel t) {
		int result=0;
		try {
			con=ds.getConnection();
			
			String sql="update from travel_information set travel_name=? ,travel_address=? , travel_content = ? ,travel_tema =? ,travel_type = ?"
					+" where travel_no =? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, t.getTravel_name());
			pstmt.setString(2, t.getTravel_address());
			pstmt.setString(3, t.getTravel_content());
			pstmt.setInt(4, t.getTravel_tema());
			pstmt.setInt(5, t.getTravel_type());
			pstmt.setInt(6, t.getTravel_no());
			
			result =pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("여행 수정 에러" +e.getMessage());
		}finally {
			try {
				
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
		return result;
	}//travel_modify end
	
	public int travel_delete(int no) {
		int result=0;
		try {
			con=ds.getConnection();
			String sql = "delete from travel_information where travel_no =? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("여행지 삭제 에러"+e.getMessage());
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
		return result;
	}//travel_delete end
	
	
	public int travel_img_modify(travel_image t) {
		int result =0;
		try {
			con=ds.getConnection();
			String sql = "update from travel_image set travel_img_name =?, travel_img_type=? travel_no=?  where  travel_img_no =? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, t.getTravel_img_name());
			pstmt.setInt(2, t.getTravel_img_type());
			pstmt.setInt(3, t.getTravel_no());
			pstmt.setInt(4, t.getTravel_img_no());
			
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("여행지 이미지 수정 에러 "+e.getMessage());
		}finally {
			try {
				
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
		return result;
	}//travel_img_modify end
	
	
}//class end


