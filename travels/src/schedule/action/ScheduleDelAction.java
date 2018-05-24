package schedule.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import schedule.db.*;

public class ScheduleDelAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ScheduleDAO sch_DAO =  new ScheduleDAO();
		
		ScheduleBean sch_bean = new ScheduleBean();
		DetailBean det_bean = new DetailBean();
		
		int sch_no = Integer.parseInt(request.getParameter("sch_no"));
		boolean result = false;
		
		result = sch_DAO.delSchedule(sch_no);
		
		forward.setRedirect(false);
		forward.setPath("");
		
		return forward;
	}

}
