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
	String start=(String)session.getAttribute("start");
	String end=(String)session.getAttribute("end");
	int no = Integer.parseInt(request.getParameter("bus_no"));
	
	System.out.println("search1 "+ area);
	System.out.println("search2 "+ start);
	System.out.println("search3 "+ end);
	System.out.println("search4 " + no );
	
	
  	Connection conn = null;
	//PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();

		String sql ="select * from bus_list natural join bus_" +area+"_schedule where bus_no=" + no;
		//String sql = "select*from bus_list natural join bus_Seoul_schedule where bus_no=18";
		System.out.println(sql);
		stmt=conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		
		//JSON 형태로 데이터를 만듭니다.
	 	JSONArray array = new JSONArray();
			while(rs.next()){
			JSONObject object = new JSONObject();
			object.put("bus_no", rs.getInt(1));		
			object.put("bus_area", rs.getString(2));
			object.put("bus_linename", rs.getString(3));
			object.put("bus_start", rs.getString(4));
			object.put("bus_end", rs.getString(5));
			object.put("bus_traveltime", rs.getString(6));
			object.put("bus_cost_ad", rs.getInt(7));
			object.put("bus_cost_st", rs.getInt(8));
			object.put("bus_cost_ch", rs.getInt(9));
			object.put("bus_seq", rs.getInt(10));
			object.put("bus_departure", rs.getString(11));
			object.put("bus_arrival", rs.getString(12));
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
		if(stmt!=null)try{stmt.close();}catch(Exception ex){}
		if(rs!=null)try{rs.close();}catch(Exception ex){}
		if(conn!=null)try{conn.close();}catch(Exception ex){}
	}
	
%>
