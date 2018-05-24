package bus.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BusListView implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();	
		String bus_area = request.getParameter("area");
		BusDAO bd = new BusDAO();
		List<BusBean> list = bd.getInfo(bus_area);
		 
		forward.setPath("/Bus/BusList.jsp");	
		forward.setRedirect(false);	
		request.setAttribute("bb", list);	
		
		return forward;
	}

}
