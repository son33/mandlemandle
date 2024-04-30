<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/memberCommon/mentorRequestPage.css">
</head>
<body>
    <div id="myModal${param.rn}" class="modal">
		<div class="modal-content-wrapper">
			<span class="close">&times;</span>
			<div class="mentorRequest-wrapper">
				<div class="mentorRequest">
				    <h2>맨토요청</h2>
				</div>
				<div class="mentorRequest-details-wrapper">
					<form action="request.in" method="post">
					    <div class="mentorRequest-details">
					    	<c:if test="${user == '맨티' && empty param.rc}">
						        <textarea id="mentorRequestTextarea" name="requestContent" placeholder="한번 보낸 요청은 수정할 수 없습니다. 신중히 작성해주세요."></textarea>
					    	</c:if>
					    	<c:if test="${user == '맨토' || !empty param.rc}">
						        <textarea id="mentorRequestTextarea" name="requestContent" disabled>${param.rc}</textarea>
					    	</c:if>
					    </div>
					    <c:if test="${user == '맨티' && empty param.rc}">
							<input type="hidden" name="mtiNo" value="${loginUser.userNo}">
						    <input type="hidden" name="mtoNo" value="${param.mn}">
						    <input type="hidden" name="refPno" value="${param.pn}">
						    <input id="mentorRequest-button btn btn-info" type="submit" value="맨토 요청">
					    </c:if>
					    <c:if test="${user == '맨토' && param.rs == 'W'}">
						    <input type="hidden" name="mtoNo" value="${param.mn}">
						    <input type="hidden" name="requestNo${param.rn}" value="${param.rn}">
						    <input id="request-accept-button btn btn-info" type="button" value="수락" onclick="acceptRequest(${param.rn})">
						    <input id="request-refuse-button btn btn-warning" type="button" value="거절" onclick="refuseRequest(${param.rn})">
					    </c:if>
					</form>
			    </div>
			</div>
		</div>
	</div>
</body>
</html>