package qna_board.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna_board.db.qna_boardBean;
import qna_board.db.qna_boardDAO;

public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		qna_boardDAO qna_boarddao = new qna_boardDAO();
		List<qna_boardBean> qna_boardlist = new ArrayList<qna_boardBean>();
		ActionForward forward = new ActionForward();
		
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("넘어온 페이지 =" + page);
		
		int listcount=qna_boarddao.getListCount();
		
		qna_boardlist = qna_boarddao.getQnAList(page,limit);
		
		int maxpage = (listcount+limit-1)/limit;
		System.out.println("총 페이지수 = " + maxpage);
		
		
		int startpage = ((page-1) / 10) * 10 + 1;
		System.out.println("현재 페이지에 보여줄 시작 페이지 수" + startpage);
		
		int endpage = startpage + 10 -1;
		System.out.println("현재 페이지에 보여줄 마지막 페이지 수" +  endpage);
		
		if(endpage>maxpage) {
			endpage = maxpage;
		}
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		
		request.setAttribute("startpage", startpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("qna_boardlist", qna_boardlist);
		
		forward.setRedirect(false);
		forward.setPath("./qna_board/list.jsp");
		
		System.out.println(listcount);
		
		
		return forward;
	}

}
