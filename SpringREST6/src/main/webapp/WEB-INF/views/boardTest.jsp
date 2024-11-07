<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>실행 : http://localhost:8088/</h1>
    <h1>뷰 : /views/boardTest.jsp</h1>

    <h2> 게시판 CRUD - REST 방식으로 </h2>

    <h2> 게시판 글쓰기 </h2>
    <form action="">
        제목 : <input type="text" id="title" name="title"> <br>
        작성자 : <input type="text" id="writer" name="writer"> <br>
        내용 : <input type="text" id="content" name="content"> <br>

        <input type="button" id="btnCreate" value="글쓰기(Create)">
    </form>

<!-- jQuery CDN 추가 -->
<script src="https://code.jquery.com/jquery-3.7.1.js" 
integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" 
crossorigin="anonymous"></script>

<script>
$(function(){

    // 1) 글쓰기 버튼 클릭시, 글쓰기 수행(REST)
    $("#btnCreate").click(function(){
    	
        var boardData = {
                "title" : $("#title").val(),
                "writer" : $("#writer").val(),
                "content" : $("#content").val()
            } // 변수 생성시 범위 주의

        $.ajax({
            url : "${contextPath}/boards",
            type : "POST",
            data : JSON.stringify(boardData),
            contentType : "application/json",
            success : function(data) {
                $('body').append(data);
                if(data == "ADD_Success") {
                	alert(" 글쓰기 성공 ");
                	$("#title").val("");
                	$("#writer").val("");
                	$("#content").val("");
                }
            },
            error : function(e) {
            	alert(e);
            }
        });
        
    });

});//MOD

</script>
</body>
</html>