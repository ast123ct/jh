package qna_board.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import qna_board.db.qna_boardBean;
import qna_board.db.qna_boardDAO;

public class AddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		qna_boardBean boarddata = new qna_boardBean();
		qna_boardDAO boarddao = new qna_boardDAO();
		
		String realFolder="";
		
		String saveFolder="qna_boardupload";
		System.out.println("여기1");
		int fileSize=5*1024*1024;
		
		ServletContext sc = request.getServletContext();
		realFolder = sc.getRealPath(saveFolder);
		System.out.println("readFolder=" + realFolder);
		boolean result=false;
		
		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(request, realFolder, fileSize, "euc-kr",
										new DefaultFileRenamePolicy());
			
	
		boarddata.setQna_title(multi.getParameter("qna_title"));
		boarddata.setQna_content(multi.getParameter("qna_content"));
		
		result=boarddao.qna_boardInsert(boarddao);
		if(result==false) {
			System.out.println("게시판 등록 실패");
			return null;
		}
		System.out.println("게시판 등록 완료");
		
    } catch(Exception e) {
    	e.printStackTrace();
    } 
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('글이 등록되었습니다.');");
		out.println("location.href='List.bo';");
		out.println("</script>");
		out.close();
		return null;
	}

}