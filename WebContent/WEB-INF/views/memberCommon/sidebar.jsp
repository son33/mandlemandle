<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</head>
<c:if test="${!empty loginUser}">
	<div class="sidebar">
	    <div class="d-flex" id="wrapper">
	        <div class="bg-light border-right sidebar-wrapper">
	            <div class="list-group list-group-flush">
	                <div class="list-group-item list-group-item-action bg-light"></div>
	                <c:if test="${loginUser.memberDivideNo == 2}">
		                <a href="mentorMypage?boardNo=1" class="list-group-item list-group-item-action bg-light">포트폴리오</a>
		                <a href="mentorMypage?boardNo=2" class="list-group-item list-group-item-action bg-light">요청 내역 조회</a>
		                <a href="mentorMypage?boardNo=3" class="list-group-item list-group-item-action bg-light">내가 쓴 글/댓글</a>
	                </c:if>
	                <c:if test="${loginUser.memberDivideNo == 3}">
		                <a href="menteeMypage?boardNo=1" class="list-group-item list-group-item-action bg-light">찜한 멘토</a>
		                <a href="menteeMypage?boardNo=2" class="list-group-item list-group-item-action bg-light">내 멘토 요청</a>
		                <a href="menteeMypage?boardNo=3" class="list-group-item list-group-item-action bg-light">내가 쓴 글/댓글</a>
	                </c:if>
	            </div>
	        </div>
	    </div>
	</div>
</c:if>
</html>