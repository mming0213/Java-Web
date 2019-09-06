<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 정보창</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	function fn_process(p_command){
		var params = $("#frm").serialize(); 
		var _id = $("#t_id").val();
		//command 설정
		$("#command").val(p_command);
		var idCopy = $("#t_id").val();
		var _command = $("#command").val();
		var input01 = $("#input01").val();
		var input02 = $("#input02").val();
		var input03 = $("#input03").val();
		var input04 = $("#input04").val();
		var input05 = $("#input05").val();
		var input06 = $("#input06").val();
		var input07 = $("#input07").val();
		var input08 = $("#input08").val();
		
		//추가 시 값 초기화 후 종료
		if(p_command == 'add'){
			$('#frm')[0].reset();
			return;
		}
		
		//조회 시 validation
		if(p_command == "search" && _id == ''){
			alert("ID를 입력하세요.");
			return;
		}
		
		//저장 시 validation
		var v_id = $("#id").val();
	    if(p_command == 'save' && v_id == ''){
	       alert("조회나 추가 후 저장을 선택해 주세요");
	       return;
	    }    
		
		$.ajax({
			type: "post",
			async: false,
			url: "http://localhost:8090/Day190828/cust",
			//data: params,
			//dataType: "text",
			data: { id: _id, command: _command, input01: input01, input02: input02, input03: input03, input04: input04, input05: input05, input06: input06, input07: input07, input08: input08, idCopy: idCopy },
			success: function(data, textStatus){
				var jsonInfo = JSON.parse(data); //dataType을 json으로 설정 시 변환해 주지 않아도 자동변환됌.
		        //var jsonInfo = data;
				
				if(p_command == "search"){
					if(jsonInfo.error.error_yn == 'Y'){
						alert(jsonInfo.error.error_text);
						return;
					}
				   $('#idCopy').val(jsonInfo.member.id);  
				   $('#input01').val(jsonInfo.member.id);     
		           $('#input02').val(jsonInfo.member.name);    
		           $('#input03').val(jsonInfo.member.address);    
		           $('#input04').val(jsonInfo.member.state);    
		           $('#input05').val(jsonInfo.member.zip);    
		           $('#input06').val(jsonInfo.member.country);    
		           $('#input07').val(jsonInfo.member.contact);    
		           $('#input08').val(jsonInfo.member.email);  	
				}else if(p_command == "save"){

					alert("저장되었습니다.");
				}
				
		           
				   // if(data == 'usable'){
				//		$('#message').text("고객이 존재하지 않습니다.");
				//		$('#btn_duplicate').prop("disabled", true);
				//	}else{
				//		$('#message').text("고객이 존재합니다.");
				//	}
			
			},
		    error:function(request,textStatus,error){
	          alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	        },
			complete:function(data,textStatus){
				//alert("작업을 완료했습니다.")
			}	
		
		
		});
	}
</script>
</head>
<body>
  <form name="frm" id="frm">
	고객번호<input type="text" name="t_id" id="t_id" />
	<input type="hidden" name="command" id="command" /> 
	<input type="button" id="btn_list" value="조회" onClick="fn_process('search')" /> 
	<input type="button" id="btn_add" value="추가" onClick="fn_process('add')" /> 	
	<input type="button" id="btn_save" value="저장" onClick="fn_process('save')" />
	<input type="button" id="btn_save" value="삭제" onClick="fn_process('del')" />	
	
	<table border=1 width=300 >
	<tr>
	  <td bgcolor="FFFF66">고객번호</td>
	  <td><input type="text" id="input01"></td>
	  <input type="hidden" name="idCopy" id="idCopy">
	</tr>
	<tr>
	  <td bgcolor="FFFF66">고객이름</td>
	  <td><input type="text" id="input02"></td>
	</tr>
	<tr>
	  <td bgcolor="FFFF66">고객주소</td>
	  <td><input type="text" id="input03"></td>
	</tr>	
	<tr>
	  <td bgcolor="FFFF66">고객주</td>
	  <td><input type="text" id="input04"></td>
	</tr>	
	<tr>
	  <td bgcolor="FFFF66">고객우편번호</td>
	  <td><input type="text" id="input05"></td>
	</tr>	
	<tr>
	  <td bgcolor="FFFF66">고객국가</td>
	  <td><input type="text" id="input06"></td>
	</tr>	
	<tr>
	  <td bgcolor="FFFF66">고객담당자</td>
	  <td><input type="text" id="input07"></td>
	</tr>	
	<tr>
	  <td bgcolor="FFFF66">고객메일주소</td>
	  <td><input type="text" id="input08"></td>
	</tr>	
	</table>
  </form>
</body>
</html>