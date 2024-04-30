<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맨티 마이페이지</title>
</head>
<body id="body-top">
	<main>
        <div class="body-wrapper">
        <jsp:include page="../common/menubar.jsp"/>
        <jsp:include page="../memberCommon/sidebar.jsp"/>
			<c:choose>
			    <c:when test="${boardNo == 1}">
				    <jsp:include page="checkMentor.jsp"/>
			    </c:when>
			    <c:when test="${boardNo == 2}">
			    	<jsp:include page="../../views/memberCommon/requestList.jsp"/>
			    </c:when>
			    <c:when test="${boardNo == 3}">
			    	<jsp:include page="../memberCommon/writeCommunity.jsp"/>
			    </c:when>
			</c:choose>
			<jsp:include page="../common/footer.jsp"/>
		</div>
	</main>
</body>
</html>