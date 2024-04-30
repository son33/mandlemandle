<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	String alertMsg = (String) session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인</title>
<link rel="stylesheet" href="<%= contextPath %>/resources/css/enroll/login.css">
</head>
<body>
	<div class="container" id="container">
		<!-- 계정 생성 폼 -->
		<div class="form-container sign-up-container">
			<form action="<%= contextPath %>/insert.me" id="signupForm" method="post">
				<h1>계정 생성</h1>
				<div class="toggle-container">
					<input type="radio" id="mentor" name="memberDivideNo" value="2">
					<label for="mentor">멘토</label>
					<input type="radio" id="mentee"	name="memberDivideNo" value="3" checked>
					<label for="mentee">멘티</label>
				</div>
				<input type="text" placeholder="이름" name="userName" required />
				<div class="input-container">
					<input type="email" placeholder="이메일" name="email" id="email" class="email-input" required />
					<button type="button" onclick="verifyEmail()" id="checkEmail" class="email-verify-button">이메일 중복확인</button>
				</div>
					<input type="password" placeholder="비밀번호 (6~20자 영문자+숫자로 작성)" id="userPwd"
						name="userPwd" minlength="6" maxlength="20" pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]+$" required />
					<input type="password" placeholder="비밀번호 확인" name="confirm_password" required />
				<div style="display: flex; gap: 8px; width: 100%;">
					<input type="date" id="birth" placeholder="생년월일" name="birth" required />
					<select name="gender" style="height: 70%; margin: auto; background-color: #eee; border: 0;">
						<option value="">성별</option>
						<option value="M">남성</option>
						<option value="F">여성</option>
					</select>
				</div>
				<input type="tel" placeholder="휴대폰 번호 (-를 포함하여 입력하세요.)" name="phone"
					pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" maxlength="13" required />
				<div class="addressapi">
					<div class="zipcode-container">
						<input type="text" id="sample6_postcode" placeholder="우편번호" name="zipCode" required readonly>
						<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
					</div>
					<div class="address-container">
						<input type="text" id="sample6_address" name="address1" placeholder="주소" required readonly>
					</div>
					<div class="details-container">
						<input type="text" id="sample6_detailAddress" name="address3" placeholder="상세주소">
						<input type="text" id="sample6_extraAddress" name="address2" placeholder="참고항목" readonly>
					</div>
				</div>
				<button class="submitButton" id="submitButton" onclick="submitSignUpForm()" disabled>회원가입</button>
			</form>
		</div>
		<div class="form-container sign-in-container">
			<form action="<%= contextPath %>/login.me" method="post">
				<h1>로그인</h1>
				<input type="email" name="email" placeholder="이메일" required />
				<input type="password" name="userPwd" placeholder="비밀번호 (6~20자 영문자+숫자로 작성)" minlength="6"
					maxlength="20" pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]+$" required />
					<a href="<%= contextPath %>/findPwd">비밀번호를 잊으셨나요?</a>
				<button type="submit">로그인</button>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<img src="resources/image/mandlemandle_logo_full.png" alt="Login Image" class="login-image" />
					<h1>로그인</h1>
					<p>서비스를 이용하기 위해서 로그인 해주세요.</p>
					<button class="ghost" id="signIn">로그인</button>
				</div>
				<div class="overlay-panel overlay-right">
					<img src="resources/image/mandlemandle_logo_full.png" alt="Login Image" class="login-image" />
					<h1>환영합니다!</h1>
					<p>맨들맨들에 오신 것을 환영합니다.</p>
					<button class="ghost" id="signUp">회원가입</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		const contextPath = "<%=contextPath%>"
		const msg = "<%=alertMsg%>";
		if(msg != "null"){
			alert(msg);
		<%session.removeAttribute("alertMsg");%>
		}
		
		const signUpButton = document.getElementById('signUp');
		const signInButton = document.getElementById('signIn');
		const container = document.getElementById('container');
		
		signUpButton.addEventListener('click', () => {
		  container.classList.add("right-panel-active");
		});
		signInButton.addEventListener('click', () => {
		  container.classList.remove("right-panel-active");
		});
		
// 		회원가입 폼 제출
	    function submitSignUpForm() {
	        document.getElementsByName('email')[0].removeAttribute('disabled');
	        const form = document.getElementById('signupForm');
	        const password = form.userPwd.value;
	        const confirm_password = form.confirm_password.value;
	        if (password !== confirm_password) {
	            alert("비밀번호가 일치하지 않습니다.");
	            return false;
	        }
	        form.submit();
	    }
		const passwordInput = document.getElementById('userPwd');
		const passwordMessage = document.getElementById('passwordMessage');
		// 비밀번호 조건에 맞는지 확인하는 함수
		function validatePassword() {
	  		const password = passwordInput.value;
			const passwordPattern = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]+$/;
			const isPasswordValid = passwordPattern.test(password);
			// 메시지 표시
			passwordMessage.textContent = isPasswordValid ? '' : '비밀번호는 영문자와 숫자의 조합이어야 합니다.';
		}
		// 비밀번호 입력 시 조건 확인
		passwordInput.addEventListener('blur', validatePassword);
	    
// 		이메일 유효성 검시
	 	function verifyEmail() {
        	const email = document.getElementsByName('email')[0].value;
        	const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
            if (!emailPattern.test(email)) {
                alert("올바른 이메일 주소를 입력하세요.");
                return;
            }
            
//          이메일 중복 검사
	        const xhr = new XMLHttpRequest();
	        xhr.open('GET', '<%= request.getContextPath() %>/verifyEmail?email=' + email, true);
	        xhr.onreadystatechange = function () {
	            if (xhr.readyState == 4 && xhr.status == 200) {
	                let response = xhr.responseText;
	                const submitButton = document.getElementById('submitButton');
	                const email = document.getElementById('email');
	                const checkEmail = document.getElementById('checkEmail');

	                if (response === "true") {
	                    alert("사용 가능한 이메일 주소입니다.");
	                    submitButton.style.backgroundColor = '#57D9FF';
	                    submitButton.disabled = false;
	                    email.disabled = true;
	                    checkEmail.style.backgroundColor = '#ccc';
	                    checkEmail.disabled = true;
	                } else {
	                    alert("이미 사용 중인 이메일 주소입니다.");
	                }
	            }
	        };
	        xhr.send();
	    }
	    
// 		생년월일 유효성 검사
		const currentDate = new Date();
		const birthInput = document.getElementById('birth');
		
		function checkBirthday() {
		    const birthValue = birthInput.value;
		    if (!birthValue) {
		        alert('생년월일을 선택하세요.');
		        return;
		    }
		    const birthDate = new Date(birthValue);
		    if (birthDate > currentDate) {
		        alert('올바른 생년월일을 입력하세요.');
		        birthInput.value = '';
		    }
		}
		birthInput.addEventListener('change', checkBirthday);
	    
// 	 	주소 확인
		function sample6_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                let addr = '';
	                let extraAddr = '';
	
	                if (data.userSelectedType === 'R') {
	                    addr = data.roadAddress;
	                } else {
	                    addr = data.jibunAddress;
	                }
	
	                if(data.userSelectedType === 'R'){
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    document.getElementById("sample6_extraAddress").value = extraAddr;
	                } else {
	                    document.getElementById("sample6_extraAddress").value = '';
	                }
	                document.getElementById('sample6_postcode').value = data.zonecode;
	                document.getElementById("sample6_address").value = addr;
	                document.getElementById("sample6_detailAddress").focus();
	            }
	        }).open();
	    }
	</script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>
</html>