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
	      
	      //getContextPath() : ���ؽ�Ʈ ��ΰ� ��ȯ�˴ϴ�.
	      //ContextPath�� "/JspProject"�� ��ȯ�˴ϴ�.
	      String contextPath=request.getContextPath();
	      
	      //RequestURI���� ���ؽ�Ʈ ��� ���� ���� �ε��� ��ġ�� ���ں���
	      //������ ��ġ ���ڱ��� �����մϴ�.
	      //command�� "/login.net" ��ȯ�˴ϴ�.
	      String command=RequestURI.substring(contextPath.length());
	      
	      
	      //�ʱ�ȭ
	      ActionForward forward=null;
	      Action action=null;
	      
	      
	      
	      if(command.equals("/List.bo")) {
	         action = new ListAction();//�������� ���� ��ĳ����
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
	          action = new AddAction();//�������� ���� ��ĳ����
	          try {
	             forward=action.execute(request,  response);
	          } catch(Exception e) {
	             e.printStackTrace();
	          }
	      } else if(command.equals("/DetailAction.bo")) {
	          action = new DetailAction();//�������� ���� ��ĳ����
	          try {
	             forward=action.execute(request,  response);
	          } catch(Exception e) {
	             e.printStackTrace();
	          }
	      } 
	      	else if(command.equals("/ReplyView.bo")) {
	          action = new ReplyView();//�������� ���� ��ĳ����
	          try {
	             forward=action.execute(request,  response);
	          } catch(Exception e) {
	             e.printStackTrace();
	          }
	   
	      	} 
	      
	      System.out.println("");
	          
	          
	      if(forward != null) {
	         if(forward.isRedirect()) {   //�����̷�Ʈ �˴ϴ�.
	            response.sendRedirect(forward.getPath());
	         } else {   //������ �˴ϴ�.
	            RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
	            dispatcher.forward(request, response);
	         }
	         
	      }
	   }
	   
	   //doProcess�޼��带 �����Ͽ� ��û�� get����̵� post ����̵�
	   //���۵Ǿ� ���� ���� �޼��忡�� ��û�� ó���� �� �ֵ��� �Ͽ����ϴ�.
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	                     throws ServletException, IOException {
	      doProcess(request,response);
	   }
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	                     throws ServletException, IOException {
	      doProcess(request, response);
	   }
	   
      }
