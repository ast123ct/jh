package schedule.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import schedule.db.DetailDAO;
import schedule.db.ScheduleDAO;

public class SchDetailAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ScheduleDAO sch_DAO = new ScheduleDAO();
		DetailDAO det_DAO =new DetailDAO();
		HttpSession session = request.getSession();
		boolean result = false;
		String id= (String) session.getAttribute("id");
		
		//장바구니에 담을때 여해지나 축제정보 bean 통해서 담아서 옮기기
		
		
		
		
		
		
		return null;
	}

}
