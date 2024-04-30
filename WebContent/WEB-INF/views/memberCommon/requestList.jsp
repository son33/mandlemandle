<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main page</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/memberCommon/mentorRequestList.css">
</head>
<body id="body-top">
	<div class="container" id="container">
		<div class="content">
	        <div class="mentorRequest-details-wrapper">
				<div class="mentorRequestList-wrapper">
					<div class="mentorRequestList">
						<h2>내 맨토 요청</h2>
					</div>
					<div class="mentorRequestList">
						<c:forEach var="rl" items="${requestList}">
							<div class="mentorRequestListItem" id="requestButton" onclick="requestModal(${rl.requestNo})">
								<c:if test="${user == '맨토'}">
									<p>${rl.requestDate} ${rl.userName} ${user}님의 요청</p>
								</c:if>
								<c:if test="${user == '맨티'}">
									<p>${rl.requestDate} ${rl.userName} 맨토님에게 요청</p>
								</c:if>
								<c:if test="${rl.requestStatus == 'Y'}">
									<span class="status statusConfirmed">수락</span>
								</c:if>
								<c:if test="${rl.requestStatus == 'W'}">
									<span class="status statusPending">확인중</span>
								</c:if>
								<c:if test="${rl.requestStatus == 'N'}">
									<span class="status statusRejected">거절</span>
								</c:if>
							</div>
							<jsp:include page="mentorRequestPage.jsp">
								 <jsp:param name="rn" value="${rl.requestNo}" />
								 <jsp:param name="mn" value="${portfolio.mtoNo}" />
								 <jsp:param name="pn" value="${portfolio.ptfNo}" />
								 <jsp:param name="rc" value="${rl.requestContent}" />
								 <jsp:param name="rs" value="${rl.requestStatus}" />
							</jsp:include>
						</c:forEach>
					</div>
				</div>
	        </div>
	    </div>
	</div>
	<script>
	function requestModal(requestNo){
		const modal = document.getElementById('myModal'+requestNo);
		const span = document.getElementsByClassName('close')[0];
		
		modal.style.display = 'block';
		span.onclick = function() {
			modal.style.display = 'none';
		};
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = 'none';
			}
		};
	}
    function refuseRequest(requestNo){
        const url = "request.rf?&requestNo=" + requestNo;
        window.location.href = url;
	};
    function acceptRequest(requestNo){
    	const url = "request.ac?&requestNo=" + requestNo;
        window.location.href = url;
	};
    </script>
</body>
</html>