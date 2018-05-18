package qna_board.db;

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



public class qna_boardDAO {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
public 	qna_boardDAO(){
	try {
		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	} catch(Exception e) {
		System.out.println("DB ���� ���� : " + e);
		return;
	}
}
public int getListCount() {
    int x=0;
    try {
       conn=ds.getConnection();
       pstmt=conn.prepareStatement("select count(*) from qna_board");
       rs=pstmt.executeQuery();
       
       if(rs.next()) {
          x=rs.getInt(1);
       }
    }catch(Exception ex) {
       System.out.println("getListCount(); ���� : "+ex);
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
public List<qna_boardBean> getQnAList(int page, int limit) {
	//page : ������
	//limit : ������ �� ����� ��
	//BOARD_RE_REF desc, BOARD_RE_SEQ asc�� ���� ������ ����
	//�������� �´� rnum�� ������ŭ �������� �������Դϴ�.
	String qna_list_sql= "select * from "
		+	"(select rownum rnum, qna_no, qna_title,"
		+	" qna_content, qna_date, user_no  from"
		+		"(select * from qna_board)) "
		+	"where rnum>=? and rnum<=? ";

	
	List<qna_boardBean> list = new ArrayList<qna_boardBean>();
					//�� �������� 10���� ����� ��� 	  	  1������     2������	  3������
	int startrow=(page-1)* limit + 1; //�б� ������ row ��ȣ(1		11		21
	int endrow = startrow + limit -1; //���� ������ row ��ȣ(10		20		30
	
	
	try {
		conn=ds.getConnection();
		pstmt= conn.prepareStatement(qna_list_sql);
		pstmt.setInt(1,  startrow);
		pstmt.setInt(2,  endrow);
		rs=pstmt.executeQuery();

		
		//������ �����͸� VO��ü�� ����ϴ�.
		while(rs.next()) {
			qna_boardBean board = new qna_boardBean();
			board.setQna_no(rs.getInt("qna_no"));
			board.setQna_title(rs.getString("qna_title"));
			board.setQna_content(rs.getString("qna_content"));
			board.setQna_date(rs.getDate("qna_date"));
			board.setUser_no(rs.getInt("user_no"));
			
			list.add(board);
		}
		return list;	//���� ���� ��ü�� ������ ����Ʈ�� ȣ���� ������ ������
	} catch(Exception e) {
		System.out.println("getBoardList() ����:" + e);
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




public qna_boardBean getDetail(int num) {
	qna_boardBean boarddata = new qna_boardBean();
	try {
		conn=ds.getConnection();
		String sql= "select * from qna_board where QnA_no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			boarddata.setQna_no(rs.getInt("qna_no"));
			boarddata.setQna_title(rs.getString("qna_title"));
			boarddata.setQna_content(rs.getString("qna_content"));
			boarddata.setQna_date(rs.getDate("qna_date"));
			boarddata.setUser_no(rs.getInt("user_no"));
		
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
	String sql = "select USER_PASS from client where USER_NO = ?";
	

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
	
	
	String sql2= "delete from qna_board "
			+	"where QNA_NO = ?";
	
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



public void update(qna_boardBean boarddata) {
	
	String sql2= "update qna_board "
			+	"set QNA_TITLE = ?, QNA_CONTENT = ? "
			+	"where QNA_NO= ?";
	
	try {
		conn=ds.getConnection();
		
		pstmt = conn.prepareStatement(sql2);
		
		pstmt.setInt(1, boarddata.getQna_no());
		pstmt.setString(2, boarddata.getQna_title());
		pstmt.setString(3, boarddata.getQna_content());
		pstmt.setDate(4, (Date) boarddata.getQna_date());
		pstmt.setInt(5, boarddata.getUser_no());
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
public boolean qna_boardInsert(qna_boardDAO boarddao) {
	int no=0;
	int result=0;
	boolean y=false;
	
	try {
		conn=ds.getConnection();
		
		//board ���̺��� board_num �ʵ��� �ִ밪�� ���ؿͼ� ����
		//����� �� �� ��ȣ�� ���������� �����ϱ� �����Դϴ�.
		String max_sql = "select max(QNA_NO) from qna_board";
		pstmt= conn.prepareStatement(max_sql);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			no = rs.getInt(1)+1;
		} else {
			no=1;//ó�� �����͸� ����ϴ� ����Դϴ�.
		}
		
		pstmt.close();
		String sql="insert into qna_board values(?,?,?,sysdate,?)";
		pstmt= conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.setString(2, boarddao.getQna_title());
		pstmt.setString(3, boarddao.getQna_content());
		pstmt.setInt(4, boarddao.getUser_no());
		
		result=pstmt.executeUpdate();
		
		
		
		if(result==0)
			return false;
		return true;
	} catch(Exception e) {
		System.out.println("getListCount() ����:" + e);
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
private String getQna_title() {
	// TODO Auto-generated method stub
	return null;
}
private int getUser_no() {
	// TODO Auto-generated method stub
	return 0;
}
private String getQna_content() {
	// TODO Auto-generated method stub
	return null;
}


















	
}
