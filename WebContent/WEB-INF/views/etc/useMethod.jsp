<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>맨들맨들 이용방법</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/useMethod.css" />
</head>
<body class="body-top">
	<main id="app">
		<div class="body-wrapper">
			<jsp:include page="../common/menubar.jsp" />
			<div class="container" id="container">
				<div class="content">
					<header class="header">
						<h1>맨들맨들 서비스 소개</h1>
					</header>

					<section class="content-section">
						<div class="text">
							<h2>편리한 서비스 매칭</h2>
							<p>서비스를 선택하고 가장 잘 맞는 전문가에게 요청서를 작성하세요.</p>
						</div>
						<div class="image">
							<img src="logo.png" alt="서비스 이미지">
						</div>
					</section>

					<section class="content-section reverse">
						<div class="image">
							<img src="logo.png" alt="매칭 이미지">
						</div>
						<div class="text">
							<h2>전문가와의 만남</h2>
							<p>전문가와 논의하여 자세한 사항을 조율하세요.</p>
						</div>
					</section>

					<section class="content-section">
						<div class="text">
							<h2>새로운 시작</h2>
							<p>멘토와 함께 새로운 시작을 만드세요.</p>
						</div>
						<div class="image">
							<img src="logo.png" alt="새로운 시작 이미지">
						</div>
					</section>
				</div>
			</div>
			<jsp:include page="../common/footer.jsp" />
		</div>

		<script src="resources/js/introduce.js"></script>
	</main>
</body>
</html>
