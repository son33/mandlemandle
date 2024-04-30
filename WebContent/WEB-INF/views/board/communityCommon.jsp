<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<title>Document</title>
</head>
<body>
	<main>
		<div class="body-wrapper">
        <jsp:include page="../common/menubar.jsp"/>
        <jsp:include page="sidebar.jsp"/>
	    <jsp:include page="communityList.jsp"/>
        <jsp:include page="../common/footer.jsp"/>
		</div>
	</main>
</body>
</html>