package notice_board.db;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class NoticeDAO {

	DataSource ds;  
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public NoticeDAO(){
	try {
		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	} catch(Exception e) {
		System.out.println("DB 연결 실패 : " + e);
		return;
	}
}
	
	//글의 갯수 구하기
	public int getListCount() {
	      int x=0;
	      try {
	         conn=ds.getConnection();
	         pstmt=conn.prepareStatement("select count(*) from notice_board");
	         rs=pstmt.executeQuery();
	         
	         if(rs.next()) {
	            x=rs.getInt(1);
	         }
	      }catch(Exception ex) {
	         System.out.println("getListCount(); 에러 : "+ex);
	      }finally {
	         if(pstmt != null)
	               try{
	                  pstmt.close();
	               }catch(SQLException ex){
	                  ex.printStackTrace();
	               }
	            if(conn != null)
	               try{
	                  conn.close();
	               }catch(SQLException ex){ex.printStackTrace();}
	      }
	      return x;
	   }
	
	
	public List<NoticeBean> getBoardList(int page, int limit, String notice_list_sql) {
		//page : 페이지
		//limit : 페이지 당 목록의 수
		//BOARD_RE_REF desc, BOARD_RE_SEQ asc에 의해 정렬한 것을
		//조건절에 맞는 rnum의 범위만큼 가져오는 쿼리문입니다.
		String notice_list_sql1= "select * from "
				+	"(select rownum rnum, notice_no notice_title,"
				+	" notice_content, notice_date, admin_no from"
				+		"(select * from notice_board)) "
				+	"where rnum>=? and rnum<=?";

		
		List<NoticeBean> list = new ArrayList<NoticeBean>();
						//한 페이지당 10개씩 목록인 경우 	  	  1페이지     2페이지	  3페이지
		int startrow=(page-1)* limit + 1; //읽기 시작할 row 번호(1		11		21
		int endrow = startrow + limit -1; //읽을 마지막 row 번호(10		20		30
		
		
		try {
			conn=ds.getConnection();
			pstmt= conn.prepareStatement(notice_list_sql1);
			pstmt.setInt(1,  startrow);
			pstmt.setInt(2,  endrow);
			rs=pstmt.executeQuery();

			
			//가져온 데이터를 VO객체에 담습니다.
			while(rs.next()) {
				NoticeBean notice = new NoticeBean();
				notice.setNotice_no(rs.getInt("notice_no"));
				notice.setNotice_title(rs.getString("notice_title"));
				notice.setNotice_content(rs.getString("notice_content"));
				notice.setNotice_date(rs.getDate("notice_date"));
				notice.setAdmin_no(rs.getInt("admin_no"));
				
				list.add(notice);
			}
			return list;	//값을 담은 객체를 저장한 리스트를 호출한 곳으로 가져감
		} catch(Exception e) {
			System.out.println("getNoticeList() 에러:" + e);
		} finally{
		 	if(rs!=null)
		 		try{
		 			rs.close(); 
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	if(pstmt!=null)
		 		try{
		 			pstmt.close(); 
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	if(conn!=null)
		 		try{
		 			conn.close();
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	}
		return null;
	}
	
	
	public boolean noticeInsert(NoticeBean Notice) {
		int num=0;
		int result=0;
		boolean y=false;
		System.out.println("notice.getnotice_FILE() = " + Notice.getnotice_FILE());
		try {
			conn=ds.getConnection();
			
			//board 테이블의 board_num 필드의 최대값을 구해와서 글을
			//등록할 때 글 번호를 순차적으로 지정하기 위함입니다.
			String max_sql = "select max(notice_no) from notice_board";
			pstmt= conn.prepareStatement(max_sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1)+1;
			} else {
				num=1;//처음 데이터를 등록하는 경우입니다.
			}
			
			pstmt.close();
			String sql="insert into notice values(?,?,?,sysdate,?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, Notice.getNotice_no());
			pstmt.setString(2, Notice.getNotice_title());
			pstmt.setString(3, Notice.getNotice_content());
			pstmt.setDate(4, (Date) Notice.getNotice_date());
			pstmt.setInt(5, Notice.getAdmin_no());
			
			result=pstmt.executeUpdate();
			
			
			
			if(result==0)
				return false;
			return true;
		} catch(Exception e) {
			System.out.println("getListCount() 에러:" + e);
		} finally{
		 	if(rs!=null)
		 		try{
		 			rs.close(); 
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	if(pstmt!=null)
		 		try{
		 			pstmt.close(); 
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	if(conn!=null)
		 		try{
		 			conn.close();
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	}
		return false;
	}
	
	
	public NoticeBean getDetail(int num) {
		NoticeBean boarddata = new NoticeBean();
		try {
			conn=ds.getConnection();
			String sql= "select * from notice_board where NOTICE_NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boarddata.setNotice_no(rs.getInt("notice_no"));
				boarddata.setNotice_title(rs.getString("notice_title"));
				boarddata.setNotice_content(rs.getString("notice_content"));
				boarddata.setNotice_date(rs.getDate("notice_date"));
				boarddata.setAdmin_no(rs.getInt("admin_no"));
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
		 	if(rs!=null)
		 		try{
		 			rs.close(); 
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	if(pstmt!=null)
		 		try{
		 			pstmt.close(); 
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	if(conn!=null)
		 		try{
		 			conn.close();
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	}
		return boarddata;
	}
	public String deleteCheck(int num) {
		String BOARD_PASS ="";
		String sql = "select ADMIN_PASS from notic_board where ADMIN_NO = ?";
		

		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				BOARD_PASS = rs.getString(1);
			} else {
				BOARD_PASS = null;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
		 	if(rs!=null)
		 		try{
		 			rs.close(); 
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	if(pstmt!=null)
		 		try{
		 			pstmt.close(); 
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	if(conn!=null)
		 		try{
		 			conn.close();
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	}
		return BOARD_PASS;
	}
	
	public void delete(int num) {
		
		
		String sql2= "delete from notice_board "
				+	"where notice_no = ?";
		
		try {
			conn=ds.getConnection();
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
		 	if(rs!=null)
		 		try{
		 			rs.close(); 
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	if(pstmt!=null)
		 		try{
		 			pstmt.close(); 
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	if(conn!=null)
		 		try{
		 			conn.close();
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	}
	}

	
	public void update(NoticeBean boarddata) {
		
		String sql2= "update notice_board "
				+	"set NOTICE_TITLE = ?, NOTICE_CONTENT = ? "
				+	"where NOTICE_NO = ?";
		
		try {
			conn=ds.getConnection();
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, boarddata.getNotice_no());
			pstmt.setString(2, boarddata.getNotice_title());
			pstmt.setString(3, boarddata.getNotice_content());
			pstmt.setDate(4, (Date) boarddata.getNotice_date());
			pstmt.setInt(5, boarddata.getAdmin_no());
		
			
			pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
		 	if(rs!=null)
		 		try{
		 			rs.close(); 
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	if(pstmt!=null)
		 		try{
		 			pstmt.close(); 
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	if(conn!=null)
		 		try{
		 			conn.close();
		 		} catch(SQLException ex){ex.printStackTrace();}
		 	}
	}
	
	
	}
	
	
	
	s
	
	
	
	
	
	
	
	
	
	
	
	
	
	

