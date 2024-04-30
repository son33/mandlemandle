<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main page</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/menteeMyPage/checkMentor.css">
</head>
<body id="body-top">
	<main>
		<div class="container" id="container">
	        <div class="content">
				<div class="mentorRequest-wrapper">
					<div class="favoriteMentor"><h2>찜한 멘토</h2>	</div>
					<div class="multi-accordion">
						<c:forEach var="jjim" items="${jjimList}">
							<details>
								<summary>${jjim.userName} 멘토님<a href="portfolio?no=${jjim.ptfNo}">자세히</a></summary>
								<p>${jjim.introduce}</p>
							</details>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>