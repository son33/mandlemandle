<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mm.member.model.vo.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<main id="main" class="main">
	 <jsp:include page="adminmenubar.jsp"></jsp:include>
	 <div id="layout-container">
		 <c:choose>
		 	<c:when test="${bNo == 1 and dNo == 1 }">
		 		<jsp:include page="adminmentoList.jsp"></jsp:include>	 
		 	</c:when>
		 	<c:when test="${bNo == 1 and dNo == 2 }">
		 		<jsp:include page="adminmentiList.jsp"></jsp:include>	 
		 	</c:when>
		 	<c:when test="${bNo == 1 and dNo == 3 }">
		 		<jsp:include page="adminReportBoardList.jsp"></jsp:include>	 
		 	</c:when>
			<c:when test="${bNo == 1 and dNo == 4 }">
		 		<jsp:include page="blackList.jsp"></jsp:include>	 
		 	</c:when>
		 	<c:when test="${bNo == 2 and dNo == 1 }">
		 		<jsp:include page="adminNoticeList.jsp"></jsp:include>	 
		 	</c:when>
		 	<c:when test="${bNo == 2 and dNo == 2 }">
		 		<jsp:include page="FAQList.jsp"></jsp:include>	 
			</c:when>
		 	<c:when test="${bNo == 3 and dNo == 1 }">
		 		<jsp:include page="adminNoticeList.jsp"></jsp:include>	 
		 	</c:when>
		 	<c:when test="${bNo == 3 and dNo == 2 }">
		 		<jsp:include page="adminReviewList.jsp"></jsp:include>	 
		 	</c:when>
		 	<c:when test="${bNo == 3 and dNo == 3 }">
		 		<jsp:include page="adminReplyList.jsp"></jsp:include>	 
		 	</c:when>
		 	<c:otherwise>
		 		<jsp:include page="dashboard.jsp"></jsp:include>
		 	</c:otherwise>
		 </c:choose>
	 </div>
</main>
</body>
</html>