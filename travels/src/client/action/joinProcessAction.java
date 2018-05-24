package client.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class joinProcessAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_passwd = request.getParameter("user_passwd");
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		int user_type = Integer.parseInt(request.getParameter("user_type"));
		
		ClientDAO cd = new ClientDAO();
		Client c = new Client();
		
		c.setUser_id(user_id);
		c.setUser_passwd(user_passwd);
		c.setUser_name(user_name);
		c.setUser_email(user_email);
		c.setUser_type(user_type);
		
		
		int result = cd.join(c);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		
		out.println("<script>");
		if(result==1) {
		out.println("alert('가입이 완료되었습니다..')");
		out.println("location.href='./login.net'");
		
		}else if(result==-1){
			out.println("alert('ID가 중복되었습니다. 다시 입력하세요.')");
			//out.println("location.href='./join.net';");//새로고침
			out.println("history.back()");//비밀번호를 제외한 다른 데이터
		}
		out.println("</script>");
		out.close();
		return null;
	}

}
