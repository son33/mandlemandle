<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/chatList.css">
</head>
<body id="body-top">
	<main>
	<!-- wrapper -->
        <div class="body-wrapper">
        	<jsp:include page="../common/menubar.jsp"/>
			<div class="mentorRequest-wrapper">
				<div class="mentorRequest">
					<h2>채팅</h2>
				</div>

				<div class="mentorRequestList">
					<div class="mentorRequestItem">
						<div class="mentorInfo">
							<p>1. xx 멘토님</p>
							<span class="mentorStatus online"></span>
						</div>
						<button class="reportButton" onclick="reportMentor(1)">신고하기</button>
					</div>
					<div class="mentorRequestItem">
						<div class="mentorInfo">
							<p>2. xx 멘토님</p>
							<span class="mentorStatus offline"></span>
						</div>
						<button class="reportButton" onclick="reportMentor(2)">신고하기</button>
					</div>
					<div class="mentorRequestItem">
						<div class="mentorInfo">
							<p>3. xx 멘토님</p>
							<span class="mentorStatus online"></span>
						</div>
						<button class="reportButton" onclick="reportMentor(3)">신고하기</button>
					</div>
				</div>
			</div>

			<script>
		        function reportMentor(mentorId) {
		            const reason = prompt('신고 사유를 입력하세요:');
		            if (reason !== null) {
		                alert(`신고가 접수되었습니다. 신고 사유: ${reason}`);
		            }
		        }
		    </script>
			<jsp:include page="../common/footer.jsp"/>
		</div>
	</main>
</body>
</html>