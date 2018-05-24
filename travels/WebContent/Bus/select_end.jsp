<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="org.json.simple.*" %>
<%
	request.setCharacterEncoding("utf-8");
	String area=(String)session.getAttribute("area");
	String start= request.getParameter("bus_start");
	
	session.setAttribute("start", start);
	
	System.out.println("end1 "+ area);
	System.out.println("end2 "+ start);
	
  	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
	
		String sql ="select bus_end from bus_list where bus_area=? and bus_start=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, area);
				pstmt.setString(2, start);
				rs=pstmt.executeQuery();

		//JSON 형태로 데이터를 만듭니다.
		JSONArray array = new JSONArray();
		while(rs.next()){
			JSONObject object = new JSONObject();
			object.put("bus_end", rs.getString(1));
			array.add(object);
		}
		
		//page가 안바뀐 상태에서 한번 요청하면 갱신이 안되고 캐쉬에 남아있는 데이터를 계속 쓰게 됩니다.
		//ajax처리시 캐쉬에 저장하지 않겠다고 세팅해야 합니다.
		response.setHeader("cache-control","no-cache,no-store");
		System.out.println(array);
		out.print(array);
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if(pstmt!=null)try{pstmt.close();}catch(Exception ex){}
		if(rs!=null)try{rs.close();}catch(Exception ex){}
		if(conn!=null)try{conn.close();}catch(Exception ex){}
	}
	
%>



