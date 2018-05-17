package schedule.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import schedule.db.DetailDAO;

public class SchDetailDelAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		DetailDAO det_DAO = new DetailDAO();
		
		int detail_no = Integer.parseInt(request.getParameter("detail_no"));
		boolean result = false;
		
		result = det_DAO.delDetail(detail_no);
		 
		forward.setPath("");
		forward.setRedirect(false);
			
		
		
		
		
		return null;
	}

}
