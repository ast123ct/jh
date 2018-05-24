package schedule.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.*;

public class ScheduleDAO {
		
		DataSource ds ;
		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;
		
		public ScheduleDAO() {
			try {
				Context init = new InitialContext();
				ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			}catch(Exception e) {
				System.out.println("DB 연결 실패 : " + e);
				return;
			}
			
		}
		

		public boolean addSchedule (ScheduleBean sch_bean,String user_id) {
			try {
				
				conn=ds.getConnection();
				String sql = "";
				sql ="select user_no from client where user_id = ? ";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,user_id );
				rs=pstmt.executeQuery();
				rs.next();
				int user_no = rs.getInt(1); //rs.getInt("user_no");
				//user_no 가져오기
				rs.close();
				pstmt.close();
				
				sql="	insert into Schedule(sch_no, user_no, start_date, end_date, sch_title, sch_content)"
								  + " values(일전번호 시퀀스 ,  ? , to date(' ? '),to date(' ? ') , ? , ? )" ;
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, user_no);
				pstmt.setString(2,sch_bean.getStart_date());
				pstmt.setString(3, sch_bean.getEnd_date());
				pstmt.setString(4, sch_bean.getSch_title());
				pstmt.setString(5, sch_bean.getSch_content());
				//가져온 user_no와 입력받은 자료들로 일정 db에 입력하기
				
				int n = pstmt.executeUpdate();
				if(n==0)
					return false;
			}catch(Exception e) {
				System.out.println("addSchedule() error : " + e);
			}finally {
				if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
				if(conn!=null)try {conn.close();}catch(SQLException e) {}
			}
			
			
			return true;
		}//addSchedule end
		
		public boolean delSchedule(int sch_no) {
			try {
				conn=ds.getConnection();
				String sql = "";
				int result = 0;
				sql = "delete from schedule where sch_no = ? ";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, sch_no);
				result = pstmt.executeUpdate();
				
				
				if(result==0)
					return false;
				
			}catch(Exception e) {
				System.out.println("delSchedule error : " + e);
			}finally{
				if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
				if(conn!=null)try {conn.close();}catch(SQLException e) {}
			}
			return true;
		}

		

		
		
		public List<ScheduleBean> viewSchedule(int sch_no){
			List<ScheduleBean> list = new ArrayList<ScheduleBean>();
			
			return list;
		}
		
		
		public List<ScheduleBean> viewDetail(int detail_no){
			List<ScheduleBean> list = new ArrayList<ScheduleBean>();
			
			return list;
		}
		
		public List<ScheduleBean> updateSchedule(int sch_no){
			List<ScheduleBean> list = new ArrayList<ScheduleBean>();
			
			return list;
		}
		
		public List<ScheduleBean> updateDetail(int sch_no){
			List<ScheduleBean> list = new ArrayList<ScheduleBean>();
			
			return list;
		}
		
		public void makeChat() {
			
		}
		
		public void makeCalendar() {
			
		}
		
		
		public void writeShare() {
			
		}
		
}

