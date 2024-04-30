<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.mm.member.model.vo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String contextPath = request.getContextPath();
String alertMsg = (String) session.getAttribute("alertMsg");
Member loginUser = (Member) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="<%= contextPath %>/resources/css/common/common.css">
</head>
	<header class="head">
		<nav class="nav">
			<div class="navi">
				<div class="nav-logo"><a href="<%= contextPath %>" title="메인으로 이동"><img src="resources/image/mandlemandle_logo_image.png" alt="로고"></a></div>
				<div class="navList">
					<div class="searchBar">
						<form action="<%= contextPath%>/search" method="get">
							<input type="text" name="category" id="search" placeholder="주제를 검색하세요" oninput="fetchSearchList()">
							<button type="submit">검색</button>
							<div class="searchList">
								<ul class="search-depth1">
								</ul>
							</div>
						</form>
					</div>
					<div class="nav-contents">
						<div class="nav-depth1">
						<c:choose>
							<c:when test="${empty loginUser}">
								<div><a href=""></a></div>
								<div><a href=""></a></div>
								<div><a href="<%= contextPath %>/community?boardNo=1&page=1">커뮤니티</a></div>
								<div><a href="<%= contextPath %>/login.me">로그인</a></div>
							</c:when>
							<c:when test="${loginUser.memberDivideNo == 1}">
								<div></div>
								<div><a href="<%= contextPath %>/community?boardNo=1&page=1">커뮤니티</a></div>
								<div><a href="<%= contextPath %>/admin?bNo=1" target="_blank">관리자페이지</a></div>
								<div><a href="<%= contextPath %>/logout.me">로그아웃</a></div>
							</c:when>
							<c:when test="${loginUser.memberDivideNo == 2}">
								<div><a href="<%= contextPath %>/chatList">채팅</a></div>
								<div><a href="<%= contextPath %>/community?boardNo=1&page=1">커뮤니티</a></div>
								<div><a href="<%= contextPath %>/mentorMypage?boardNo=1">마이페이지</a></div>
								<div><a href="<%= contextPath %>/logout.me">로그아웃</a></div>
							</c:when>
							<c:when test="${loginUser.memberDivideNo == 3}">
								<div><a href="<%= contextPath %>/chatList">채팅</a></div>
								<div><a href="<%= contextPath %>/community?boardNo=1&page=1">커뮤니티</a></div>
								<div><a href="<%= contextPath %>/menteeMypage?boardNo=1">마이페이지</a></div>
								<div><a href="<%= contextPath %>/logout.me">로그아웃</a></div>
							</c:when>
						</c:choose>
						</div>
					</div>
				</div>
			</div>
		</nav>
		<script>
			const contextPath = "<%= contextPath %>"
			const msg = "<%= alertMsg %>";
			if(msg != "null"){
				alert(msg);
			<% session.removeAttribute("alertMsg"); %>
			}
			function fetchSearchList() {
		        $.ajax({
		            url: '<%=contextPath %>/AutoSearch',
		            method: 'GET',
		            dataType: 'json',
		            data: { search: $('#search').val() },
		            success: function (data) {
		                updateSearchList(data);
		            },
		            error: function (error) {
		                console.error('searchList 가져오기 오류:', error);
		            }
		        });
		    }
			function updateSearchList(searchList) {
				const searchListContainer = $('.searchList ul.search-depth1');
				searchListContainer.empty();
	
				$.each(searchList, function(index, item) {
					let listItem = $('<li>').text(item.categoryName + ' > ' + item.subcategoryName);
					searchListContainer.append(listItem);
				});
			}
			$(document).on('click', function(event) {
		        if (!$(event.target).closest('#search').length) {
		            $('.searchList ul.search-depth1').empty();
		        }
		    });
		</script>
	</header>
</html>