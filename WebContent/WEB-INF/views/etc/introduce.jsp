<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>맨들맨들 소개페이지</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/introduce.css" />
</head>
<body class="body-top">
	<main id="app">
		<div class="body-wrapper">
			<jsp:include page="../common/menubar.jsp" />
			<div class="container" id="container">
				<div class="content">
					<section class="section-intro">
						<header id="header">
							<h1 class="txt-invisible">Portfolio</h1>
							<nav>
								<ul class="nav-list">
									<li><a href="#about" class="list-link">About</a></li>
									<li><a href="#project" class="list-link">Project</a></li>
									<li><a href="#contact" class="list-link">Contact</a></li>
								</ul>
							</nav>
							<div class="bar-bg">
								<span class="bar-ing"></span>
							</div>
						</header>

						<div class="cont-intro">
							<a name="info"></a>
							<img src="resources/image/mandlemandle_logo_image.png" alt="로고 이미지" />
							<div>
								<p class="txt-title"></p>
								<a href="#about" class="btn-more">More</a>
							</div>
						</div>
					</section>

					<section class="section-about">
						<a name="about"></a>
						<h2>About.</h2>
						<div class="cont-about">
							<div class="slide-container">
								<div class="slide-album">
									<div class="slide-images">
										<img src="resources/image/img-mentor-1.jpg" alt="photo" /> <img
											src="resources/image/img-mentor-2.jpg" alt="photo" /> <img
											src="resources/image/img-mentor-3.jpg" alt="photo" />
									</div>
									<button class="btn-next">▶</button>
									<button class="btn-prev">◀</button>
								</div>
							</div>
							<div class="info-about">
								<div class="txt-about">
									<li>맨들맨들은 여러분들이 도움을 필요로 하는 일을 도와줄 멘토를 무료로 빠르게 찾아드려요.</li>
									<li>필요한 사람을 찾는 일에 시간과 에너지를 낭비하지 마세요. 최대 48시간 안에 여러분이 찾는
										사항에 딱! 맞는 멘토를 찾아드립니다.</li>
									<li>새로운 멘티를 만나세요. 가입 직후 내 조건에 맞는 요청서를 무료로 받아보고 만나고 싶은 멘티에게
										연락하시면 됩니다.</li>
									<li>조건에 딱! 맞는 멘토를 찾으시나요? 딱! 맞는 멘티을 찾으시나요? 맨들맨들이 도와드리겠습니다.</li>
								</div>
							</div>
						</div>
					</section>

					<section class="section-project">
						<a name="project"></a>
						<h2>Project.</h2>
						<article class="box-project">
							<img class="img-project" src="resources/image/mentor1.png"
								alt="첫번째 멘토 이미지" />
							<div class="txt-project">
								<h3>첫번째 멘토</h3>
								<dl>
									<dt>분야</dt>
									<dd>스포츠</dd>
									<dt>매칭된 멘티 수</dt>
									<dd>50명</dd>
									<dt>후기</dt>
									<dd>"프리랜서를 처음 했을 때는 많이 불안했어요. SNS에 계속 올리는 게 너무 힘들었거든요.
										그러다보니까 맨들맨들을 찾게 된 것 같아요."</dd>
								</dl>
							</div>
						</article>

						<article class="box-project">
							<img class="img-project" src="resources/image/mentor2.png"
								alt="두번째 멘토 이미지" />
							<div class="txt-project">
								<h3>두번째 멘토</h3>
								<dl>
									<dt>분야</dt>
									<dd>스포츠</dd>
									<dt>매칭된 멘티 수</dt>
									<dd>50명</dd>
									<dt>후기</dt>
									<dd>"맨들맨들을 발견하고 바로 등록을 하게 된 계기는 일단은 광고비가 들지 않고 맨들맨들에서 꾸준히
										필요로 하는 고객들을 매칭시켜줘서 정말 편하고 좋아요."</dd>
								</dl>
							</div>
						</article>
					</section>
				</div>
			</div>
			<jsp:include page="../common/footer.jsp" />
		</div>
		<script src="index.js"></script>
		<script>
			// 타이핑 효과
			const $txt = document.querySelector(".txt-title");
			const content = "안녕하세요 :)\n맨들맨들 입니다.";
			let contentIndex = 0;

			let typing = function() {
				$txt.innerHTML += content[contentIndex];
				contentIndex++;
				if (content[contentIndex] === "\n") {
					$txt.innerHTML += "<br />";
					contentIndex++;
				}
				if (contentIndex > content.length) {
					$txt.textContent = "";
					contentIndex = 0;
				}
			};
			setInterval(typing, 200);

			// 이미지 슬라이드
			let imgIndex = 0;
			let position = 0;
			const IMG_WIDTH = 438;
			const $btnPrev = document.querySelector(".btn-prev");
			const $btnNext = document.querySelector(".btn-next");
			const $slideImgs = document.querySelector(".slide-images");

			let prev = function() {
				if (imgIndex > 0) {
					$btnNext.removeAttribute("disabled");
					position += IMG_WIDTH;
					$slideImgs.style.transform = `translateX(${position}px)`;
					imgIndex = imgIndex - 1;
				}
				if (imgIndex == 0) {
					$btnPrev.setAttribute("disabled", "true");
				}
			};

			let next = function() {
				if (imgIndex < 3) {
					$btnPrev.removeAttribute("disabled");
					position -= IMG_WIDTH;
					$slideImgs.style.transform = `translateX(${position}px)`;
					$slideImgs.style.transition = "transform .5s ease-out";
					imgIndex = imgIndex + 1;
				}
				if (imgIndex == 2) {
					$btnNext.setAttribute("disabled", "true");
				}
			};

			let init = function() {
				$btnPrev.setAttribute("disabled", "true");
				$btnPrev.addEventListener("click", prev);
				$btnNext.addEventListener("click", next);
			};

			init();
		</script>
	</main>
</body>
</html>