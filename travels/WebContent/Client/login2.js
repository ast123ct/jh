$(document).ready(function(){

	   //회원가입 버튼 클릭했을 경우
	   $("form").submit(function (){     
		   //id 공백 유효성 검사
	       if($.trim($("#user_id").val()) == ""){
	          alert("ID를 입력 하세요");
	          $("#user_id").focus();
	          return false;
	      }
	     
	     //비밀번호 공백 유효성 검사
	     if($.trim($("#user_passwd").val()) == ""){
	      alert("비밀번호를 입력 하세요");
	      $("#user_passwd").focus();
	      return false;
	     }
	     
	    
	   });  
	  
 });
  