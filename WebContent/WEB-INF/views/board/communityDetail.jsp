<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/board/communityDetail.css">
</head>
<body>
<main>
	<div class="body-wrapper">
		<jsp:include page="../board/sidebar.jsp"/>
		<jsp:include page="../common/menubar.jsp"/>
		<div class="container" id="container">
	        <div class="content">
				<div class="detail-wrapper">
					<div class="detail-content">
						<div class="content-top">
							<div class="title"><p>${b.boardTitle}</p></div>
							<div class="divide"><p>${b.boardDivideName}</p></div>
							<div class="userNo"><p>작성자 : ${b.userName}</p></div>
							<div class="date"><p>작성일 : ${b.createDate}</p></div>
							<div class="count"><p>조회수 : ${b.count}</p></div>
						</div>
						<div class="content-bottom">
							<div class="board-content">${b.boardContent}"</div>
						</div>
						<div class="content-button">
							<button onclick="window.location.href='<%= contextPath %>/community?boardNo=1&page=1'">목록</button>
							<c:if test="${loginUser != null && loginUser.userNo eq b.userNo}">
								<button onclick="window.location.href = '<%= contextPath %>/update.co?boardNo=${b.boardNo}'">수정</button>
								<button onclick="confirmDelete('<%= contextPath %>/delete.co?boardNo=${b.boardNo}')">삭제</button>
							</c:if>
						</div>
					</div>
					<div id="reply-area">
						<table id="reply-table">
							<thead>
								<c:if test="${not empty loginUser}">
									<tr><th>댓글작성</th></tr>
									<tr><th><textarea rows="3" cols="50" style="resize: none" id="replyContent"></textarea></th></tr>
									<tr><th><button id="reply-btn" onclick="insertReply()">댓글등록</button></th></tr>
								</c:if>
							</thead>
							<tbody class="reply-body">
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</main>
<script>
function insertReply() {
    $.ajax({
        url: "insert.re",
        data: {
            content: $("#replyContent").val(),
            boardNo: '${b.boardNo}'
        },
        success: function (result) {
            console.log(result);
            if (result > 0) {
                $('#replyContent').val("");
            }
            selectReplyList();
        },
        error: function () {
            console.log("비동기 통신 실패");
        }
    });
}

function selectReplyList() {
    $.ajax({
        url: "list.re",
        data: { boardNo: '${b.boardNo}'},
		success : function(list){
			let tbody = $("#reply-table tbody");
          	tbody.empty();
            for (let r of list) {
            	let replyWrapper = $("<tr>");
            	replyWrapper.append($("<div>", { class: "reply-userName" }).html("<span>" + r.userName + "</span>"));
            	replyWrapper.append($("<div>", { class: "reply-content" }).html("<span>" + r.replyContent + "</span>"));
            	replyWrapper.append($("<div>", { class: "reply-createDate" }).html("<span>" + r.createDate + "</span>"));
            	if (${loginUser.userNo} == r.userNo) {
            		let deleteButton = $("<button>", { class: "deleteButton"}).html("삭제");
            	    deleteButton.click(function() {
            	    	confirmReplyDelete(r.replyNo);
            	    });
            	    replyWrapper.append(deleteButton);
                }
                tbody.append(replyWrapper);
            }
   		}
	})
};

function confirmReplyDelete(replyNo) {
    if (confirm("정말 삭제하시겠습니까?")) {
        deleteReply(replyNo);
    } else {
        console.log("삭제가 취소되었습니다.");
    }
}

function deleteReply(replyNo){
	$.ajax({
		url: "delete.re",
		data: {replyNo : replyNo},
		success : function(result){
			if (result > 0) {
                $('#replyContent').val("");
            }
            selectReplyList();
        },
        error: function () {
            console.log("비동기 통신 실패");
		}
	})
}
function confirmDelete(deleteUrl) {
    var result = confirm("삭제하시겠습니까?");
    if (result) {
        window.location.href = deleteUrl;
    }
}
selectReplyList();
</script>
</body>
</html>