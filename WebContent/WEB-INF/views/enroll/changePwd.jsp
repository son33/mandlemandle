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
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/changePwd.css">
    <title>비밀번호 변경</title>
</head>
<body style="margin: 20px;">
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
            <form action="changePwd" class="form-signin" method="POST" onsubmit="return validateForm()">
                <p>${m.userName }</p>
                <input type="password" name="userPwd" id="pwd" class="form-control" placeholder="비밀번호" required
                    onkeyup="checkPassword()"><br>
                <input type="password" name="repwd" id="repwd" class="form-control" placeholder="비밀번호 재확인" required
                    onkeyup="checkPasswordMatch()"><br>
                <p class="checks" id="checks"></p>
                <button id="submit" class="btn btn-lg btn-block" type="submit" disabled>비밀번호 재설정</button>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        function checkPassword() {
            let passwordInput = $('#pwd');
            let passwordMessage = $('#checks');
            const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,20}$/;

            if (!passwordRegex.test(passwordInput.val())) {
                passwordMessage.text('비밀번호는 6~20자의 영문 소문자, 숫자만 사용 가능합니다.');
                passwordMessage.css('color', 'red');
            } else {
                passwordMessage.text('');
            }
        }

        function checkPasswordMatch() {
            let passwordInput = $('#pwd');
            let repasswordInput = $('#repwd');
            let passwordMessage = $('#checks');
            let sb = $('#submit');

            if (passwordInput.val() !== repasswordInput.val()) {
                passwordMessage.text('비밀번호가 다릅니다.');
                passwordMessage.css('color', 'red');
            } else {
            	sb.css('background-color', '#57D9FF');
                sb.prop('disabled', false);
                passwordMessage.text('');
            }
        }
    </script>
</body>
</html>