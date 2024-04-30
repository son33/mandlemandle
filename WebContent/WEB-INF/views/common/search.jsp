<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색결과</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<link rel="stylesheet" href="<%=contextPath %>/resources/css/common/search.css">
</head>
<body id="body-top">
	<main>
		<!-- wrapper -->
		<div class="body-wrapper">
			<jsp:include page="../common/menubar.jsp" />
			<div class="container" id="container">
				<div class="content">
					<!-- 검색 결과 -->
					<c:if test="${!empty list1 || !empty list2}">
						<div class="recommend-wrapper">
							<div class="recommend-title">
								<p>맨토 검색 결과</p>
							</div>
							<div class="swiper mySwiper search-swiper">
								<div class="swiper-wrapper">
									<c:forEach var="i" items="${list1}">
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
																		value="${i.averageScore}" />
																</span>
															</div>
														</div>
														<div class="mentor-name">
															<span>${i.subCategoryName} ${i.userName} 맨토</span>
														</div>
														<div class="mentor-oneline">
															<textarea readonly>${i.introduce}</textarea>
														</div>
													</div>
												</a>
											</div>
										</div>
									</c:forEach>
									<c:if test="${empty list1}">
										<div class="mentor-profile">
											<span> 검색 결과가 없습니다 </span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
						<!-- 비슷한 맨토 -->
						<div class="recommend-wrapper">
							<div class="recommend-title">
								<p>비슷한 분야의 맨토</p>
							</div>
							<div class="swiper mySwiper other-swiper">
								<div class="swiper-wrapper">
									<c:forEach var="i" items="${list2}">
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
																		value="${i.averageScore}" />
																</span>
															</div>
														</div>
														<div class="mentor-name">
															<span>${i.subCategoryName} ${i.userName} 맨토</span>
														</div>
														<div class="mentor-oneline">
															<textarea readonly>${i.introduce}</textarea>
														</div>
													</div>
												</a>
											</div>
										</div>
									</c:forEach>
									<c:if test="${empty list2}">
										<div class="mentor-profile">
											<span> 검색 결과가 없습니다 </span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${empty list1 && empty list2}">
						<div class="search-mentor">
							<span> 검색한 분야의 철자가 틀렸거나 해당 분야의 맨토가 없습니다 다시 검색해주세요 </span>
						</div>
					</c:if>
				</div>
			</div>
			<jsp:include page="../common/footer.jsp" />
		</div>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
	<script>
		var swiper = new Swiper(".search-swiper", {
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

		var swiper = new Swiper(".other-swiper", {
			spaceBetween : 20,
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
			slidesPerView : 3,
			slidesPerGroup : 1,
		});
	</script>
</body>
</html>