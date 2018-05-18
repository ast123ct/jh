package qna_board.action;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("*.bo")
public class FrontController extends javax.servlet.http.HttpServlet{
   
	  private static final long serialVersionUID = 1L;
	   protected void doProcess(HttpServletRequest request, HttpServletResponse response)
	                     throws ServletException, IOException{
	      
	      String RequestURI=request.getRequestURI();
	      
	      //getContextPath() : 컨텍스트 경로가 반환됩니다.
	      //ContextPath는 "/JspProject"가 반환됩니다.
	      String contextPath=request.getContextPath();
	      
	      //RequestURI에서 컨텍스트 경로 길이 값의 인덱스 위치의 문자부터
	      //마지막 위치 문자까지 추출합니다.
	      //command는 "/login.net" 반환됩니다.
	      String command=RequestURI.substring(contextPath.length());
	      
	      
	      //초기화
	      ActionForward forward=null;
	      Action action=null;
	      
	      
	      
	      if(command.equals("/List.bo")) {
	         action = new ListAction();//다형성에 의한 업캐스팅
	         try {
	            forward=action.execute(request,  response);
	         } catch(Exception e) {
	            e.printStackTrace();
	         }
	      }else if(command.equals("/Write.bo")) {
	         forward=new ActionForward();
	         forward.setRedirect(false);
	         forward.setPath("/qna_board/write.jsp");
	      } else if(command.equals("/AddAction.bo")) {
	          action = new AddAction();//다형성에 의한 업캐스팅
	          try {
	             forward=action.execute(request,  response);
	          } catch(Exception e) {
	             e.printStackTrace();
	          }
	      } else if(command.equals("/DetailAction.bo")) {
	          action = new DetailAction();//다형성에 의한 업캐스팅
	          try {
	             forward=action.execute(request,  response);
	          } catch(Exception e) {
	             e.printStackTrace();
	          }
	      } 
	      	else if(command.equals("/ReplyView.bo")) {
	          action = new ReplyView();//다형성에 의한 업캐스팅
	          try {
	             forward=action.execute(request,  response);
	          } catch(Exception e) {
	             e.printStackTrace();
	          }
	   
	      	} 
	      
	      System.out.println("");
	          
	          
	      if(forward != null) {
	         if(forward.isRedirect()) {   //리다이렉트 됩니다.
	            response.sendRedirect(forward.getPath());
	         } else {   //포워딩 됩니다.
	            RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
	            dispatcher.forward(request, response);
	         }
	         
	      }
	   }
	   
	   //doProcess메서드를 구현하여 요청이 get방식이든 post 방식이든
	   //전송되어 오는 같은 메서드에서 요청을 처리할 수 있도록 하였습니다.
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	                     throws ServletException, IOException {
	      doProcess(request,response);
	   }
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	                     throws ServletException, IOException {
	      doProcess(request, response);
	   }
	   
      }
