/*package commu_board.action;

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
      
      
      
      if(command.equals("/BoardList.bo")) {
         action = new BoardListAction();//�������� ���� ��ĳ����
         try {
            forward=action.execute(request,  response);
         } catch(Exception e) {
            e.printStackTrace();
         }
      }else if(command.equals("/BoardWrite.bo")) {
         forward=new ActionForward();
         forward.setRedirect(false);
         forward.setPath("/1_board/qna_board_write.jsp");
      } else if(command.equals("/BoardAddAction.bo")) {
          action = new BoardAddAction();//�������� ���� ��ĳ����
          try {
             forward=action.execute(request,  response);
          } catch(Exception e) {
             e.printStackTrace();
          }
      } else if(command.equals("/BoardDetailAction.bo")) {
          action = new BoardDetailAction();//�������� ���� ��ĳ����
          try {
             forward=action.execute(request,  response);
          } catch(Exception e) {
             e.printStackTrace();
          }
      } else if(command.equals("/BoardDelete.bo")) {
             forward= new ActionForward();
             forward.setRedirect(false);
             forward.setPath("/1_board/qna_board_delete.jsp");
      } else if(command.equals("/BoardDeleteAction.bo")) {
          action = new BoardDeleteAction();//�������� ���� ��ĳ����
          try {
             forward=action.execute(request,  response);
          } catch(Exception e) {
             e.printStackTrace();
          }
      } else if(command.equals("/BoardModifyView.bo")) {
          action = new Board_update();//�������� ���� ��ĳ����
          try {
             forward=action.execute(request,  response);
          } catch(Exception e) {
             e.printStackTrace();
          }
      } else if(command.equals("/BoardUpdateAction.bo")) {
          action = new BoardUpdateAction();//�������� ���� ��ĳ����
          try {
             forward=action.execute(request,  response);
          } catch(Exception e) {
             e.printStackTrace();
          }
      } else if(command.equals("/BoardReplyView.bo")) {
          action = new BoardReplyView();//�������� ���� ��ĳ����
          try {
             forward=action.execute(request,  response);
          } catch(Exception e) {
             e.printStackTrace();
          }
      } else if(command.equals("/BoardReplyAction.bo")) {
          action = new BoardReplyAction();//�������� ���� ��ĳ����
          try {
             forward=action.execute(request,  response);
          } catch(Exception e) {
             e.printStackTrace();
          }
      } else if(command.equals("/BoardFileDown.bo")) {
          action = new BoardFileDownAction();//�������� ���� ��ĳ����
          try {
             forward=action.execute(request,  response);
          } catch(Exception e) {
             e.printStackTrace();
          }
      } 
      
          
          
          
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
      
   }*/