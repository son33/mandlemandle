<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main page</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/common/category.css">
</head>
<body id="body-top">
	<main>
	<!-- wrapper -->
		<div class="body-wrapper">
		<jsp:include page="../common/menubar.jsp"/>
			<div class="container" id="container">
				<div class="content">
					<!-- category -->
		            <div class="category">
		                <ul class="category-depth1">
					        <c:if test="${empty list}">
					            조회 오류 다시 실행해주세요
					        </c:if>
					        <c:forEach var="c" items="${nameList}" varStatus="status">
							    <li>${c}</li>
							    <li>
							        <ul class="category-depth2">
							            <c:set var="count" value="0"/>
							            <c:forEach var="l" items="${list}">
							                <c:if test="${c eq l.categoryName}">
							                    <c:if test="${count % 5 == 0}">
							                        </ul>
							                        <ul class="category-depth2">
							                    </c:if>
							                    <li><a href="<%= request.getContextPath()%>/search?category=${l.subCategoryName}">${l.subCategoryName}</a></li>
							                    <c:set var="count" value="${count + 1}" />
							                </c:if>
							            </c:forEach>
							        </ul>
							    </li>
							</c:forEach>

					        <li>앞으로 추가될 다양한 분야를 기다려주세요</li>
					    </ul>
		            </div>
				</div>
			</div>
			<jsp:include page="../common/footer.jsp"/>
		</div>
	</main>
</body>
</html>