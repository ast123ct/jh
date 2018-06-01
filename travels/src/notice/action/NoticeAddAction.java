package notice.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.db.*;

public class NoticeAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception {
		NoticeDAO nd = new NoticeDAO();
		NoticeBean nb = new NoticeBean();
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();

		boolean result= false;
		
		nb.setAdmin_id(request.getParameter("admin_id"));
		nb.setNotice_title(request.getParameter("notice_title"));
		nb.setNotice_content(request.getParameter("notice_content"));
		
		result=nd.noticeInsert(nb);
		
		//글 등록에 실패할 경우 null을 반환 합니다.
			if(result==false) {
				System.out.println("게시판 등록 실패");
				return null;
			}
			System.out.println("게시판 등록 완료");
			
			//글 등록이 완료되면 글 목록을 단순히 보여주기만 할 것이므로 Redirect여부를 true로 설정합니다.
			forward.setRedirect(true);
			//이동할 경로를 지정합니다.
			forward.setPath("./NoticeList.no");
			return forward;
	}
}








