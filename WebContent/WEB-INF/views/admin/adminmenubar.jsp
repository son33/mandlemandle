<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String contextPath = request.getContextPath();
String alertMsg = (String) session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>맨들맨들</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="<%=contextPath %>/resources/admin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=contextPath %>/resources/admin/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="<%=contextPath %>/resources/admin/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="<%=contextPath %>/resources/admin/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="<%=contextPath %>/resources/admin/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="<%=contextPath %>/resources/admin/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="<%=contextPath %>/resources/admin/vendor/simple-datatables/style.css" rel="stylesheet">

  <script src="<%=contextPath %>/resources/admin/vendor/apexcharts/apexcharts.min.js"></script>
  <script src="<%=contextPath %>/resources/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="<%=contextPath %>/resources/admin/vendor/chart.js/chart.umd.js"></script>
  <script src="<%=contextPath %>/resources/admin/vendor/echarts/echarts.min.js"></script>
  <script src="<%=contextPath %>/resources/admin/vendor/quill/quill.min.js"></script>
  <script src="<%=contextPath %>/resources/admin/vendor/simple-datatables/simple-datatables.js"></script>
  <script src="<%=contextPath %>/resources/admin/vendor/tinymce/tinymce.min.js"></script>
  <script src="<%=contextPath %>/resources/admin/vendor/php-email-form/validate.js"></script>
<!--   <link rel="stylesheet" href="/MyBatisProject/resources/commonWriter.css"> -->
<!--   <link rel="stylesheet" href="/MyBatisProject/resources/boardWriter.css"> -->
  <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
  <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

  <!-- Template Main CSS File -->
  <link href="<%=contextPath %>/resources/admin/css/style.css" rel="stylesheet">
  
  <!-- include summernote css/js-->
  <script src="<%=contextPath %>/resources/admin/js/summernote/summernote-lite.js"></script>
  <script src="<%=contextPath %>/resources/admin/js/summernote/lang/summernote-ko-KR.js"></script>
  <link rel="stylesheet" href="<%=contextPath %>/resources/admin/css/summernote/summernote-lite.css">
</head>
<body>
	<script>
		const msg = "<%= alertMsg %>";
		if(msg != "null"){
			alert(msg);
		<% session.removeAttribute("alertMsg"); %>
		}
	</script>
	<header id="header" class="header fixed-top d-flex align-items-center">
		<div class="d-flex align-items-center justify-content-between">
			<a href="<%=contextPath%>/admin?bNo=1" class="logo d-flex align-items-center">
				<img src="<%=contextPath%>/resources/admin//img/mandlemandle_logo_image.png" alt="">
				<span class="d-none d-lg-block">맨들맨들</span>
			</a>
			<i class="bi bi-list toggle-sidebar-btn"></i>
		</div>
		<aside id="sidebar" class="sidebar">
			<ul class="sidebar-nav" id="sidebar-nav">
				<li class="nav-item">
					<a class="nav-link " href="<%=contextPath %>/admin?bNo=1"> <i class="bi bi-grid"></i><span>Dashboard</span></a>
				</li>
				<li class="nav-item">
					<a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
						<i class="bi bi-menu-button-wide"></i><span>회원관리</span>
						<i class="bi bi-chevron-down ms-auto"></i>
					</a>
					<ul id="components-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
						<li data-url="mentoList">
							<a><i class="bi bi-circle"></i><span>멘토리스트</span></a>
						</li>
						<li data-url="mentiList">
							<a><i class="bi bi-circle"></i><span>멘티리스트</span></a>
						</li>
					</ul>
				</li>
				<li class="nav-item">
					<a class="nav-link collapsed" data-bs-target="#charts-nav" data-bs-toggle="collapse" href="#">
						<i class="bi bi-bar-chart"></i><span>신고내역</span>
						<i class="bi bi-chevron-down ms-auto"></i>
					</a>
					<ul id="charts-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
						<li data-url="reportBoardList">
							<a><i class="bi bi-circle"></i><span>커뮤니티</span></a>
						</li>
						<li data-url="reportReviewList">
							<a><i class="bi bi-circle"></i><span>리뷰</span></a>
						</li>
						<li data-url="reportReplyList">
							<a><i class="bi bi-circle"></i><span>댓글</span></a>
						</li>
					</ul>
				</li>
				<li class="nav-item">
					<a class="nav-link collapsed" data-bs-target="#forms-nav" data-bs-toggle="collapse" href="#">
						<i class="bi bi-journal-text"></i><span>고객센터</span>
						<i class="bi bi-chevron-down ms-auto"></i>
					</a>
					<ul id="forms-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
						<li data-url="noticeList">
							<a><i class="bi bi-circle"></i><span>공지사항</span></a>
						</li>
						<li data-url="FAQList">
							<a><i class="bi bi-circle"></i><span>FAQ</span></a>
						</li>
					</ul>
				</li>
				<li class="nav-item">
					<a class="nav-link collapsed" data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
						<i class="bi bi-layout-text-window-reverse"></i><span>게시글 관리</span>
						<i class="bi bi-chevron-down ms-auto"></i>
					</a>
					<ul id="tables-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
						<li data-url="communityList">
							<a><i class="bi bi-circle"></i><span>커뮤니티</span></a>
						</li>
						<li data-url="reviewList">
							<a><i class="bi bi-circle"></i><span>리뷰</span></a>
						</li>
						<li data-url="replyList">
							<a><i class="bi bi-circle"></i><span>댓글</span></a>
						</li>
					</ul>
				</li>
			</ul>
		</aside>
	</header>
	<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>
	<script src="<%=contextPath %>/resources/admin/js/main.js"></script>
	<script>
	const contextPath = "<%=contextPath %>";
	$(function(){
		$("#components-nav li").click(function(e){
		    let url = $(this).data("url");
		    let data = {currentPage : 1};
		    $("#layout-container").load(url, data, function(layout){
		      console.log("로딩완료");
		    })
		})
	}) 
	$(function(){
		$("#forms-nav li").click(function(e){
		    let url = $(this).data("url");
		    let data = {currentPage : 1};
		    $("#layout-container").load(url, data, function(layout){
		      console.log("로딩완료");
		    })
		})
	}) 
	 $(function(){
	  $("#tables-nav li").click(function(e){
	      let url = $(this).data("url");
	      let data = {currentPage : 1};
	      $("#layout-container").load(url, data, function(layout){
	        console.log("로딩완료");
	      })
	  })
	}) 
	$(function(){
	  $("#charts-nav li").click(function(e){
	      let url = $(this).data("url");
	      let data = {currentPage : 1};
	      $("#layout-container").load(url, data, function(layout){
	        console.log("로딩완료");
	      })
	  })
	}) 
	//공용함수  
	function loadLayout(url,data){
		$("#layout-container").load(url, data, function(layout){
			console.log("로딩완료");
		})
	} 
	</script>
</body>
</html>