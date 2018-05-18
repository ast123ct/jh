package qna_board.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import qna_board.db.qna_boardBean;
import qna_board.db.qna_boardDAO;

public class ReplyView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");
		qna_boardDAO boarddao = new qna_boardDAO();
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		qna_boardBean boarddata = boarddao.getDetail(num);
		
		if(boarddata==null) {
			System.out.println("답장 페이지 이동 실패");
			return null;
		}
		System.out.println("답장 페이지 이동 성공");
		
		forward.setPath("/qna_board/reply.jsp");
		forward.setRedirect(false);
		request.setAttribute("boarddata", boarddata);
		return forward;
	}

}
