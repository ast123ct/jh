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
	     
	     //이름 공백 유효성 검사
	     if($.trim($("#user_name").val()) == ""){
	          alert("이름을 입력 하세요");
	          $("#user_name").focus();
	          return false;
	      }
	     
	   //email 공백 유효성 검사
	     if($.trim($("#user_email").val()) ==""){
	      alert("E-mail을 입력하세요");
	      $("#user_email").focus();
	      return false;
	     }

	     //라디오 버튼 선택 유효성 검사
	     /*if($("#gender1")is(":checked") == false &&
	     $("#gender2").is(":checked") == false){
	        alert("남, 여 중에서 1개를 선택하세요");
	          return false;}*/
	     
	     if($('input:radio:checked').length==0){
	    	 alert("4중에서 선택하세요");
	    	 return false;
	     }
	     
	     
	   });  
	  
 });
  