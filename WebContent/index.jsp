<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main page</title>
</head>
<body id="body-top">
	<main>
	<!-- wrapper -->
        <div class="body-wrapper">
        <jsp:include page="WEB-INF/views/common/menubar.jsp"/>
        <jsp:include page="WEB-INF/views/common/main.jsp"/>
        <jsp:include page="WEB-INF/views/common/footer.jsp"/>
		</div>
	</main>
</body>
</html>