package commu_board.action;

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
      
      
      
      if(command.equals("/BoardList.bo")) {
         action = new BoardListAction();//다형성에 의한 업캐스팅
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
          action = new BoardAddAction();//다형성에 의한 업캐스팅
          try {
             forward=action.execute(request,  response);
          } catch(Exception e) {
             e.printStackTrace();
          }
      } else if(command.equals("/BoardDetailAction.bo")) {
          action = new BoardDetailAction();//다형성에 의한 업캐스팅
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
          action = new BoardDeleteAction();//다형성에 의한 업캐스팅
          try {
             forward=action.execute(request,  response);
          } catch(Exception e) {
             e.printStackTrace();
          }
      } else if(command.equals("/BoardModifyView.bo")) {
          action = new Board_update();//다형성에 의한 업캐스팅
          try {
             forward=action.execute(request,  response);
          } catch(Exception e) {
             e.printStackTrace();
          }
      } else if(command.equals("/BoardUpdateAction.bo")) {
          action = new BoardUpdateAction();//다형성에 의한 업캐스팅
          try {
             forward=action.execute(request,  response);
          } catch(Exception e) {
             e.printStackTrace();
          }
      } else if(command.equals("/BoardReplyView.bo")) {
          action = new BoardReplyView();//다형성에 의한 업캐스팅
          try {
             forward=action.execute(request,  response);
          } catch(Exception e) {
             e.printStackTrace();
          }
      } else if(command.equals("/BoardReplyAction.bo")) {
          action = new BoardReplyAction();//다형성에 의한 업캐스팅
          try {
             forward=action.execute(request,  response);
          } catch(Exception e) {
             e.printStackTrace();
          }
      } else if(command.equals("/BoardFileDown.bo")) {
          action = new BoardFileDownAction();//다형성에 의한 업캐스팅
          try {
             forward=action.execute(request,  response);
          } catch(Exception e) {
             e.printStackTrace();
          }
      } 
      
          
          
          
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