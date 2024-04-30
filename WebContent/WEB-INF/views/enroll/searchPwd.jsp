<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.mm.member.model.vo.*"%>
<%
String alertMsg = (String) session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/searchPwd.css">
    <title>비밀번호 찾기</title>
</head>
<body>
	<script>
		const contextPath = "<%= request.getContextPath() %>"
		const msg = "<%= alertMsg %>";
		if(msg != "null"){
			alert(msg);
		<% session.removeAttribute("alertMsg"); %>
		}
	</script>
    <div class="card">
        <div class="card-title">
            <img src="resources/image/mandlemandle_logo_full.png" alt="Logo">
        </div>
        <div class="card-body">
            <form action="findPwd" class="form-signin" method="POST">
                <input type="text" name="userName" id="name" class="form-control" placeholder="이름" required
                    onfocusout="checkInput('name', '이름을 입력하세요.')"><br>
                <input type="email" name="email" id="email" class="form-control" placeholder="이메일" required
                    onfocusout="checkInput('email', '이메일을 입력하세요.')"><br>
                <p class="checks" id="checks"></p>
                <button id="btn-Yes" class="btn btn-lg btn-block" type="submit">비밀번호 찾기</button>
                <!-- db에 저장된 이름과 이메일이 일치할때 비밀번호 찾기 버튼을 클릭하면 비밀번호 변경 페이지로 이동 -->
            </form>
        </div>
    </div>
    <script type="text/javascript">
        function checkInput(inputId, message) {
            var input = $('#' + inputId);
            var checksMessage = $('#checks');
            if (input.val() == "") {
                checksMessage.text(message);
                checksMessage.css('color', 'red');
            } else {
                checksMessage.text('');
            }
        }
    </script>
</body>
</html>