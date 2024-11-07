<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<!-- jQuery CDN 추가 -->
<script src="https://code.jquery.com/jquery-3.7.1.js" 
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" 
	crossorigin="anonymous"></script>
	
<script type="text/javascript">
	$(function() {
		// 버튼을 클릭했을 때, 비동기 방식으로 RestController 호출
		// 결과를 받아와서 div에 정보 출력
		
		
		$("#btnSend").on("click",function(){
			/*
			$.ajax({
				url : "${contextPath}/rest2/test1",
				success : function(data){
					alert(" RESTController 다녀옴");
					alert(data);
					$("#result").append(data);
				}
			});
			*/
			
			var boardData = {
				"bno" : 1000,
				"title" : "제목",
				"content" : "내용",
				"writer" : "ITWILLBS"
			};
			
			$.ajax({
				url : "${contextPath}/rest2/test2",
				type : "POST",
				data : JSON.stringify(boardData),
				// data : JSON.stringify(boardData),
				//		=> 데이터 형태를 JSON데이터 구조로 변경(String)
				// contentType : 전달하는 데이터의 타입 설정
				// 		default => application/x-www-from-urlencoded; charset=UTF-8
				contentType : "application/json",
				success : function() {
					alert(" RESTController 다녀옴 ");
				},
				error : function() {
					alert(" 실 패 ");
				}
			});
			console.log(boardData);
			console.log(JSON.stringify(boardData));
			console.log(typeof boardData); // Object
			console.log(typeof JSON.stringify(boardData)); // String
			
		});
		
		
	});

</script>

<input type="button" id="btnSend" value="회원정보 처리">

<hr>
<h2>결과</h2>
<div id="result"></div>



</body>
</html>
