package client.action;

import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.naming.*;

public class ClientDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;
	
	//생성자에서 JNDI 리소스를 참조하여 Connection 객체를 얻어옵니다.
	
	public ClientDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		}catch(Exception e) {
			System.out.println("DB 연결되었습니다. : " + e);
			return;
		}
	}//ClientDAO end
	
	public int isId(String user_id, String user_passwd) {
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			
			String sql = "select user_id, user_passwd from client where user_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(2).equals(user_passwd)) {
					result=1;//아이디와 비밀번호가 일치하는 경우
				}else {
					result=0;//비밀번호가 일치하지 않는 경우
				}
			}else {
				result =-1;  //아이디가 존재하지 않습니다.
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {if(rs !=null) rs.close();}catch(Exception e) {e.printStackTrace();}
			try {if(con!=null) con.close();} catch (SQLException sqle) {sqle.printStackTrace();
			}
		}
		return result;
	}//isId end
	
	public List<Client> getList(){
		List<Client> list = new ArrayList<Client>();
		try {
			con = ds.getConnection();
			String sql = "select*from client";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();		
			while(rs.next()) {
				Client c = new Client();
				c.setUser_no(rs.getInt("user_no"));
				c.setUser_id(rs.getString("user_id"));
				c.setUser_passwd(rs.getString("user_passwd"));
				c.setUser_name(rs.getString("user_name"));
				c.setUser_email(rs.getString("user_email"));
				c.setUser_type(rs.getInt("user_type"));
				list.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {if(rs !=null) rs.close();}catch(Exception e) {e.printStackTrace();}
			try {if(pstmt !=null) pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {if(con!=null) con.close();} catch (SQLException sqle) {sqle.printStackTrace();
			}
		}
		return list;
	}

	public Client client_info(String user_id) {
		Client c = new Client();
			try {
				con = ds.getConnection();
				String sql="select* from client where user_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_id);
				rs= pstmt.executeQuery();
			
				while(rs.next()) {
					c.setUser_no(rs.getInt("user_no"));
					c.setUser_id(rs.getString("user_id"));
					c.setUser_passwd(rs.getString("user_passwd"));
					c.setUser_name(rs.getString("user_name"));
					c.setUser_email(rs.getString("user_email"));
					c.setUser_type(rs.getInt("user_type"));
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {if(rs !=null) rs.close();}catch(Exception e) {e.printStackTrace();}
				try {if(pstmt !=null) pstmt.close();}catch(Exception e) {e.printStackTrace();}
				try {if(con!=null) con.close();} catch (SQLException sqle) {sqle.printStackTrace();
				}
			}
		return c;
	}

	public Client delete(String user_id) {
		Client c = new Client();
		try {
			con = ds.getConnection();
			String sql = "delete from client where user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {if(rs !=null) rs.close();}catch(Exception e) {e.printStackTrace();}
			try {if(pstmt !=null) pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {if(con!=null) con.close();} catch (SQLException sqle) {sqle.printStackTrace();
			}
		}
		return c;
	}//delete end

	public int update(Client c) {
		int result=0;
		try {
			con = ds.getConnection();
			String sql = "update client set user_passwd=?, user_name=?, "
					+ "user_email=?, user_type=? where user_id=?";
			pstmt = con.prepareStatement(sql);			
			pstmt.setString(1, c.getUser_passwd());
			pstmt.setString(2, c.getUser_name());
			pstmt.setString(3, c.getUser_email());
			pstmt.setInt(4, c.getUser_type());
			pstmt.setString(5, c.getUser_id()); 			
			result = pstmt.executeUpdate();						
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {if(pstmt !=null) pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {if(con!=null) con.close();} catch (SQLException sqle) {sqle.printStackTrace();}
		}
		return result;
	}

	public int join(Client c) {
		int result=0;
		try {
			con = ds.getConnection();
			String sql = "insert into client"
					+ "(user_no,user_id,user_passwd,user_name,user_email,user_type)"
					+ " values(client_seq.nextval,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);			
			pstmt.setString(1, c.getUser_id()); 
			pstmt.setString(2, c.getUser_passwd());
			pstmt.setString(3, c.getUser_name());
			pstmt.setString(4, c.getUser_email());
			pstmt.setInt(5, c.getUser_type());			
			result = pstmt.executeUpdate();			
			//primary key 제약조건 위반했을 경우 발생하는 에러
		}catch(java.sql.SQLIntegrityConstraintViolationException asd) {
			result = -1;
			System.out.println("클라이언트 ID 중복입니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {if(pstmt !=null) pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {if(con!=null) con.close();} catch (SQLException sqle) {sqle.printStackTrace();}
		}
		return result;
	}

	public int checkId(String user_id) {
		try {
			con = ds.getConnection();
			System.out.println("getConnection");		
			String sql = "select user_id from client where user_id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = -1; //아이디가 존재합니다.
			}else {
				result = 1;//아이디가 존재하지 않습니다.
			}
		}catch(java.sql.SQLIntegrityConstraintViolationException asd) {
			result = -1;
			System.out.println("클라이언트 ID 중복 에러입니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {if(pstmt !=null) pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {if(con!=null) con.close();} catch (SQLException sqle) {sqle.printStackTrace();}
		}
		return result;
	}
}
