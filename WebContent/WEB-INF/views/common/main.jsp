<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.mm.board.model.vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<link rel="stylesheet" href="<%= contextPath %>/resources/css/common/main.css">
</head>
<body>
	<div class="container" id="container">
		<div class="content">
			<div class="category">
				<ul class="category-depth1">
					<li>원하는 활동을 선택해보세요</li>
					<li>
						<ul class="category-depth2">
							<c:forEach var="i" items="${mainCategoryList}" end="9">
								<li><a href="<%= contextPath %>/search?category=${i.subCategoryName}">${i.subCategoryName}</a></li>
							</c:forEach>
							<li><a href="<%= contextPath %>/category">기타</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<div class="community">
				<div class="horizontal-list">
					<div class="listbox">
						<ul><li class="community-title">궁금해요</li></ul>
							<ul><li>
								<ul class="community-box">
									<c:forEach var="i" items="${communityList1}">
										<li class="communityList">
											<a href="<%= contextPath %>/detail.co?bno=${i.boardNo}">
												<div class="community-wrapper">
													<div class="boardtitle"><p> ${i.boardTitle}</p></div>
													<div class="boardcontent"><p>${i.boardContent}</p></div>
													<div class="view-reply">
														<div class="reply">
															<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-binoculars" viewBox="0 0 16 16">
	 															<path d="M3 2.5A1.5 1.5 0 0 1 4.5 1h1A1.5 1.5 0 0 1 7 2.5V5h2V2.5A1.5 1.5 0 0 1 10.5 1h1A1.5 1.5 0 0 1 13 2.5v2.382a.5.5 0 0 0 .276.447l.895.447A1.5 1.5 0 0 1 15 7.118V14.5a1.5 1.5 0 0 1-1.5 1.5h-3A1.5 1.5 0 0 1 9 14.5v-3a.5.5 0 0 1 .146-.354l.854-.853V9.5a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v.793l.854.853A.5.5 0 0 1 7 11.5v3A1.5 1.5 0 0 1 5.5 16h-3A1.5 1.5 0 0 1 1 14.5V7.118a1.5 1.5 0 0 1 .83-1.342l.894-.447A.5.5 0 0 0 3 4.882V2.5zM4.5 2a.5.5 0 0 0-.5.5V3h2v-.5a.5.5 0 0 0-.5-.5h-1zM6 4H4v.882a1.5 1.5 0 0 1-.83 1.342l-.894.447A.5.5 0 0 0 2 7.118V13h4v-1.293l-.854-.853A.5.5 0 0 1 5 10.5v-1A1.5 1.5 0 0 1 6.5 8h3A1.5 1.5 0 0 1 11 9.5v1a.5.5 0 0 1-.146.354l-.854.853V13h4V7.118a.5.5 0 0 0-.276-.447l-.895-.447A1.5 1.5 0 0 1 12 4.882V4h-2v1.5a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5V4zm4-1h2v-.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5V3zm4 11h-4v.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5V14zm-8 0H2v.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5V14z" />
															</svg>
															<p>${i.replyCount}</p>
														</div>
														<div class="count">
															<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
												  			<path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"/>
															</svg><p>${i.count}</p>
														</div>
													</div>
												</div>
											</a>
										</li>
									</c:forEach>
								</ul>
							</li>
						</ul>
					</div>
					<div class="listbox">
						<ul><li class="community-title">함께해요</li></ul>
						<ul><li>
							<ul class="community-box">
								<c:forEach var="i" items="${communityList2}">
									<li class="communityList">
										<a href="<%= contextPath %>/detail.co?bno=${i.boardNo}">
											<div class="community-wrapper">
												<div class="boardtitle"><p> ${i.boardTitle}</p></div>
												<div class="boardcontent"><p>${i.boardContent}</p></div>
												<div class="view-reply">
													<div class="reply">
														<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-binoculars" viewBox="0 0 16 16">
															<path d="M3 2.5A1.5 1.5 0 0 1 4.5 1h1A1.5 1.5 0 0 1 7 2.5V5h2V2.5A1.5 1.5 0 0 1 10.5 1h1A1.5 1.5 0 0 1 13 2.5v2.382a.5.5 0 0 0 .276.447l.895.447A1.5 1.5 0 0 1 15 7.118V14.5a1.5 1.5 0 0 1-1.5 1.5h-3A1.5 1.5 0 0 1 9 14.5v-3a.5.5 0 0 1 .146-.354l.854-.853V9.5a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v.793l.854.853A.5.5 0 0 1 7 11.5v3A1.5 1.5 0 0 1 5.5 16h-3A1.5 1.5 0 0 1 1 14.5V7.118a1.5 1.5 0 0 1 .83-1.342l.894-.447A.5.5 0 0 0 3 4.882V2.5zM4.5 2a.5.5 0 0 0-.5.5V3h2v-.5a.5.5 0 0 0-.5-.5h-1zM6 4H4v.882a1.5 1.5 0 0 1-.83 1.342l-.894.447A.5.5 0 0 0 2 7.118V13h4v-1.293l-.854-.853A.5.5 0 0 1 5 10.5v-1A1.5 1.5 0 0 1 6.5 8h3A1.5 1.5 0 0 1 11 9.5v1a.5.5 0 0 1-.146.354l-.854.853V13h4V7.118a.5.5 0 0 0-.276-.447l-.895-.447A1.5 1.5 0 0 1 12 4.882V4h-2v1.5a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5V4zm4-1h2v-.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5V3zm4 11h-4v.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5V14zm-8 0H2v.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5V14z" />
														</svg><p>${i.replyCount}</p>
													</div>
													<div class="count">
														<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
										  					<path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"/>
														</svg><p>${i.count}</p>
													</div>
												</div>
											</div>
										</a>
									</li>
								</c:forEach>
							</ul>
						</li></ul>
					</div>
				</div>
			</div>
			<div class="recommend-wrapper">
				<div class="recommend-title">
					<p>오늘의 추천 맨토</p>
				</div>
				<div class="swiper mySwiper recommend-swiper">
					<div class="swiper-wrapper">
						<c:forEach var="i" items="${recommendList}">
							<div class="swiper-slide">
								<div class="recommend-content">
									<a href="<%= contextPath %>/portfolio?no=${i.ptfNo}">
										<div class="recommend-mentor">
											<div class="mentor-profile">
												<div class="mentor-image">
													<img
														src="<%= contextPath %>/resources/portfolio_upfiles/${i.changeName}"
														alt="">
												</div>
												<div></div>
												<div class="mentor-rating">
													<img src="resources/image/star.png" alt="별"> <span>
														<fmt:formatNumber type="number" pattern="0.0"
															value="${i.scoreAvg}" />
													</span>
												</div>
											</div>
											<div class="mentor-name">
												<span>${i.subCategoryName} ${i.userName} 맨토</span>
											</div>
											<div class="mentor-oneline">
												<span>${i.introduce}</span>
											</div>
										</div>
									</a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="liveReview">
				<div class="liveReview-title">
					<p>실시간 리뷰</p>
				</div>
				<div class="liveReview-content">
					<div class="swiper mySwiper liveReview-swiper">
						<div class="swiper-wrapper">
							<c:forEach var="i" items="${liveReviewList}" end="9">
								<div class="swiper-slide">
									<div class="review-wrapper">
										<div class="review-image">
											<img src="resources/portfolio_upfiles/${i.changeName}"
												alt="맨토사진">
											<div class="review-mentorid">
												<span>${i.subCategoryName} 맨토 ${i.mteName}</span>
											</div>
										</div>
										<div class="review-text">
											<div class="review-menteeid">
												<span>${i.mtoName} 맨티의 리뷰</span>
											</div>
											<div class="review-title">
												<span>${i.reviewTitle}</span>
											</div>
											<div class="review-content">
												<span>${i.reviewContent}</span>
											</div>
											<div class="review-score">
												<img src="resources/image/star.png" alt="별"><span>${i.score}/5</span>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
			<script>
				var swiper = new Swiper(".recommend-swiper", {
					spaceBetween : 20,
					centeredSlides : true,
					autoplay : {
						delay : 4000,
						disableOnInteraction : false,
					},
					pagination : {
						el : ".swiper-pagination",
						clickable : true,
					},
					loop : true,
					slidesPerView : 3,
					slidesPerGroup : 1,
				});

				var swiper = new Swiper(".liveReview-swiper", {
					direction : "vertical",
					spaceBetween : 30,
					centeredSlides : true,
					autoplay : {
						delay : 3000,
						disableOnInteraction : false,
					},
					pagination : {
						el : ".swiper-pagination",
						clickable : true,
					},
					loop : true,
					slidesPerView : 1,
					slidesPerGroup : 1,
				});
			</script>
		</div>
	</div>
</body>
</html>