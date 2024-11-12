<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <hr>


        <h2>게시판 목록(list)</h2>

        <input type="button" value="게시판 조회" id="btnRead">

        <div id="divRead"></div>
        <hr>


        <h2>게시판 특정 글 조회(READ)</h2>
        <!-- bno = 1 인 게시판 글의 정보를 조회 -->
        <input type="button" value="글조회" id="btnReadBno">

        <div id="divReadBno"></div>
        <hr>


        <h2> 게시판 글 수정하기 </h2>
        <form action="">
            제목 : <input type="text" id="utitle" name="title"> <br>
            작성자 : <input type="text" id="uwriter" name="writer"> <br>
            내용 : <input type="text" id="ucontent" name="content"> <br>

            <input type="button" id="btnUpdate" value="수정하기(Update)">
        </form>
        <hr>

        <h2> 게시판 글 삭제하기 </h2>
        <input type="button" id="btnDelete" value="삭제하기(Delete)">
        <hr>

        
        <!-- jQuery CDN 추가 -->
        <script src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

        <script>
            $(function () {

                // 1) 글쓰기 버튼 클릭시, 글쓰기 수행(REST)
                $("#btnCreate").click(function () {

                    var boardData = {
                        "title": $("#title").val(),
                        "writer": $("#writer").val(),
                        "content": $("#content").val()
                    } // 변수 생성시 범위 주의

                    $.ajax({
                        url: "${contextPath}/boards",
                        type: "POST",
                        data: JSON.stringify(boardData),
                        contentType: "application/json",
                        success: function (data) {
                            $('body').append(data);
                            if (data == "ADD_Success") {
                                alert(" 글쓰기 성공 ");
                                $("#title").val("");
                                $("#writer").val("");
                                $("#content").val("");
                            }
                        },
                        error: function (e) {
                            alert(e);
                        }
                    });
                });


                // 전체글 조회
                $('#btnRead').click(function () {
                    // alert("리스트");
                    // 정보를 REST 방식 호출
                    // 글조회 : /boards/all GET방식(ALL)
                    // => 결과를 divRead에 저장

                    $.ajax({
                        url: "/boards/all",
                        type: "GET",
                        success: function (data) {
                            alert("성공!");
                            // alert(data);
                            // console.log(data);
                            $(data).each(function (idx, item) {
                                $("#divRead").append(function () {
                                    return "<a>" + item.bno + " // " + item.title + "</a><br>"
                                });
                            });
                        },
                        error: function (e) {
                        }
                    });
                });


                // 특정글 조회
                $("#btnReadBno").click(function () {

                    $.ajax({
                        url: "/boards/1",
                        // url: "/boards/"+bno,
                        type: "GET",
                        success: function (data) {
                            // console.log(data);
                            $("#divReadBno").append(
                                "<h3>" +
                                data.bno
                                + "," +
                                data.title
                                + "," +
                                data.writer
                                + "," +
                                data.content
                                + "," +
                                data.regdate
                                + "</h3>"
                            );
                        },
                    });
                });


                // 글 수정하기
                $("#btnUpdate").click(function () {
                    var updateData = {
                        "bno": 1,
                        "title": $("#utitle").val(),
                        "writer": $("#uwriter").val(),
                        "content": $("#ucontent").val()
                    };

                    $.ajax({
                        url: "/boards/1",
                        type: "PUT",
                        contentType: "application/json",
                        data: JSON.stringify(updateData),
                        success: function (data) {
                            alert(data);
                        },
                    });
                });


                // 글 삭제하기
                $("#btnDelete").click(function () {
                    $.ajax({
                        url: "boards/1",
                        type: "DELETE",
                        success: function (data) {
                            alert(data);
                        },
                        error: function (e) {
                            alert(e);
                        },
                    });
                });



            });//DOM

        </script>
    </body>

    </html>