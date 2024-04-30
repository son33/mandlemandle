<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main page</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/memberCommon/writeCommunity.css">
</head>
<body id="body-top">
	<main>
		<div class="container" id="container">
	        <div class="content">
				<div class="mentorRequest-wrapper">
					<div id="mainBody">
						<div id="tabButtons">
							<div class="tabButton"
								onclick="toggleContent('userPost', 'userComment')">내가 작성한 글</div>
							<div class="tabButton"
								onclick="toggleContent('userComment', 'userPost')">내가 작성한 댓글</div>
						</div>
						<div id="userContent">
							<div id="userPost">
							<c:forEach var="board" items="${boardList}">
								<div class="post" onclick="goToBoard(${board.boardNo})">${board.boardTitle}</div>
							</c:forEach>
							</div>
							<div id="userComment">
								<c:forEach var="reply" items="${replyList}">
									<div class="comment" onclick="goToBoard(${reply.boardNo})">${reply.replyContent}</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<script>
		function toggleContent(showId, hideId) {
			document.getElementById(showId).style.display = 'block';
			document.getElementById(hideId).style.display = 'none';
		}
		function goToBoard(boardNo) {
			window.location.href = '<%=request.getContextPath()%>/detail.co?bno=' + boardNo;
		}
	</script>
</body>
</html>