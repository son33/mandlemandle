<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= contextPath %>/resources/css/mentorMyPage/portfolio.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
	<main>
        <div class="body-wrapper">
        <jsp:include page="../common/menubar.jsp"/>
		    <div class="container" id="container">
		        <div class="content">
		            <div class="portfolio">
			            <div class="portfolio-top">
		                    <div class="portfolio-profile wrapper">
		                        <div class="portfolio-profile-img">
		                                <img class="img" id="img0" src="<%= contextPath %>/resources/portfolio_upfiles/${attachmentList[0].changeName}" alt="Profile Image">
		                        </div>
		                    </div>
		                    <div class="grade wrapper">
		                        <div class="grade-value text-bottom"><span><fmt:formatNumber type="number" pattern="0.0" value="${empty portfolio.averageScore ? 0 : portfolio.averageScore}"/>/5</span></div>
		                        <div class="grade-name text-bottom"><span>평점</span></div>
		                    </div>
		                    <div class="review-count wrapper">
		                        <div class="review-count-value text-bottom"><span>${empty portfolio.requestCount ? 0 : portfolio.reviewCount}</span></div>
		                        <div class="review-count-name text-bottom"><span>리뷰 수</span></div>
		                    </div>
		                    <div class="agree-count wrapper">
		                        <div class="agree-count-value text-bottom"><span>${empty portfolio.requestCount ? 0 : portfolio.requestCount}</span></div>
		                        <div class="agree-count-name text-bottom"><span>수락 수</span></div>
		                    </div>
	                        <div class="open-check form-switch">
	                    	</div>
	                	</div>
		                <div class="introduce-wrapper oneline">
		                    <div class="introduce oneline">
		                        <div class="header-wrapper">
		                            <div class="header">
		                            	<div class="header-title"><h3>한줄소개</h3></div>
		                            </div>
		                            <div class="info">
	                         	   		<div>${portfolio.introduce}</div>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		                <div class="introduce-wrapper specialization">
		                    <div class="introduce specialization">
		                        <div class="header-wrapper">
		                            <div class="header">
		                                <div class="header-title"><h3>전문분야</h3></div>
		                            </div>
		                            <div class="info">
										<div class="dropdown">${portfolio.categoryName}</div>
										<div class="dropdown">${portfolio.subCategoryName}</div>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		                <div class="introduce-wrapper address">
		                    <div class="introduce address">
		                        <div class="header-wrapper">
		                            <div class="header">
		                                <div class="header-title"><h3>활동지역</h3></div>
		                            </div>
		                            <div class="info">
										<div class="dropdown">${portfolio.sidoName}</div>
										<div class="dropdown">${portfolio.sigunguName}</div>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		                <div class="introduce-wrapper editer">
		                    <div class="introduce editer">
		                        <div class="header-wrapper">
		                            <div class="header"><div class="header-title"><h3>포트폴리오</h3></div></div>
		                            <div class="info">${portfolio.ptfContent}</div>
		                        </div>
		                    </div>
		                </div>
		                <div class="photo-wrapper">
		                	<div class="header-wrapper">
								<div class="header"><div class="header-title"><h3>사진</h3>(최대 8개)</div></div>
								<div class="photo-body">
									<table class="img-table">
										<tbody>
											<c:if test="${!empty attachmentList[1]}">
												<tr>
												<c:forEach var="index" begin="1" end="4">
													<c:if test="${not empty attachmentList[index]}">
											            <td><img class="img" id="img${index}" src="<%= contextPath %>/resources/portfolio_upfiles/${attachmentList[index].changeName}" alt="Image"></td>
													</c:if>
										        </c:forEach>
												</tr>
												<tr>
												<c:forEach var="index" begin="5" end="8">
													<c:if test="${not empty attachmentList[index]}">
											            <td><img class="img" id="img${index}" src="<%= contextPath %>/resources/portfolio_upfiles/${attachmentList[index].changeName}" alt="Image"></td>
													</c:if>
										        </c:forEach>
												</tr>
											</c:if>
										</tbody>
									</table>
								</div>	                	
		                	</div>
		                </div>
		                <div class="portfolio-button">
		                	<c:if test="${loginUser.memberDivideNo == 3}">
		                		<c:if test="${empty mentorRequest || mentorRequest.requestStatus == 'N'}">
							    	<button id="requestButton" class="btn btn-info rounded-pill px-3">요청</button>
		                		</c:if>
							    <c:if test="${empty jjim}">
							    	<input type="button" class="btn btn-info rounded-pill px-3 jjim" value="찜하기">
							    </c:if>
							    <c:if test="${!empty jjim}">
			                        <input type="button" class="btn btn-warning rounded-pill px-3 jjim" value="찜하기">
							    </c:if>
							</c:if>
		                </div>
		                <div class="portfolio-review-wrapper">
			                <div id="review-area">
						        <table class="review-table">
						            <thead class="reviewInput">
						            	<c:if test="${!empty loginUser && mentorRequest.requestStatus == 'Y' && empty review}">
							                <tr>
							                    <th>리뷰 작성</th>
							                    <td><textarea id="reviewTitle" cols="50" rows="1" style="resize:none" placeholder="제목을 입력하세요"></textarea></td>
							                    <td><textarea id="reviewContent" cols="50" rows="3" style="resize:none" placeholder="지나친 비방, 욕설은 삼가해주세요"></textarea></td>
							                    <td class="score-box">
							                    	<div>
									                    <input type="hidden" name="userNo" id="userNo" value="${loginUser.userNo}">
											   			<input type="button" id="review-btn" class="btn btn-info rounded-pill px-3" value="등록">
												        <span>별점</span>
												        <input type="radio" name="score" id="rate1" value="5"><label for="rate1">⭐</label>
												        <input type="radio" name="score" id="rate2" value="4"><label for="rate2">⭐</label>
												        <input type="radio" name="score" id="rate3" value="3"><label for="rate3">⭐</label>
												        <input type="radio" name="score" id="rate4" value="2"><label for="rate4">⭐</label>
												        <input type="radio" name="score" id="rate5" value="1"><label for="rate5">⭐</label>
											   		</div>
											    </td>
							                </tr>
										</c:if>
						            </thead>
						            <tbody>
						            </tbody>
						        </table>
						    </div>
		                </div>
		            </div>
		        </div>
		    </div>
			<jsp:include page="mentorRequestPage.jsp">
				<jsp:param name="mn" value="${portfolio.mtoNo}" />
				<jsp:param name="pn" value="${portfolio.ptfNo}" />
			</jsp:include>
			<jsp:include page="../common/footer.jsp"/>
		</div>
	<script>
	// 찜버튼
	$(function(){
	    $(".jjim").click(function(){
	        console.log("찜하기 버튼 클릭됨");
	        var jjimButton = $(this);

	        if (jjimButton.hasClass("btn-info")) {
	            jjimButton.removeClass("btn-info");
	            jjimButton.addClass("btn-warning");
	            console.log("check 클래스 추가. jjim.in 요청 전송");
	            jjimRequest("jjim.in");
	        } else {
	            jjimButton.removeClass("btn-warning");
	            jjimButton.addClass("btn-info");
	            console.log("check 클래스 제거. jjim.de 요청 전송");
	            jjimRequest("jjim.de");
	        }
	    });

	    function jjimRequest(action) {
	        $.ajax({
	            url: action,
	            data: {
	                mtoNo: '${portfolio.mtoNo}',
	                mtiNo: '${loginUser.userNo}'
	            },
	            success: function(result) {
                }
            })
        };
	});

	// 요청
	$(function(){
	    $(".request").click(function(){
	        var refPno = '${portfolio.ptfNo}';
	        var mtiNo = '${loginUser.userNo}';
	        var mtoNo = '${portfolio.mtoNo}';
	        var url = "request.in?mtiNo=" + mtiNo + "&mtoNo=" + mtoNo + "&refPno=" + refPno;
	        window.location.href = url;
	    });
	});
	
	// review 불러오기
	function selectReviewList(){
		$.ajax({
			url : "list.rv",
			data : {refPno: '${portfolio.ptfNo}'},
			success : function(list){
				 let tbody = $("#review-area tbody");
	          	tbody.empty();  // 기존 데이터를 지우고 다시 렌더링
	            for (let r of list) {
	            	let reviewWrapper = $("<div>", { class: "review-wrapper" });
	            	
	                let reviewText = $("<div>", { class: "review-text" });
	                reviewText.append($("<div>", { class: "id" }).html("<span>작성자 : " + r.mtoName + " 맨티</span>"));
	                reviewText.append($("<div>", { class: "review-title" }).html("<span> 제목 : " + r.reviewTitle + "</span>"));
	                reviewText.append($("<div>", { class: "review-content" }).html("<span>내용 : " + r.reviewContent + "</span>"));
	                reviewText.append($("<div>", { class: "review-score" }).html("<span>별점 : " + r.score + "/5</span>"));
	                
	                let updateButton = $("<div>", { class: "updateButton" });

	                reviewWrapper.append(reviewText);
	                reviewWrapper.append(updateButton);
	
	                let row = $("<tr>").append(reviewWrapper);
	                tbody.append(row);
	            }
       		}
		})
	}
	
	// 댓글 등록 기능
	$(function(){
	    $("#review-btn").click(function(){
	        $.ajax({
	            url : "insert.rv",
	            data : {reviewTitle : $("#reviewTitle").val(),
	            		reviewContent : $("#reviewContent").val(),
	            		refPno : '${no}',
	                   	userNo : $("#userNo").val(),
	                   	score : $("input[name='score']:checked").val()
	           		},
	            type : 'post',
	            success : function(result){
	                if(result > 0){
	                    $(".reviewInput").val("");
	                selectReviewList();
	                }
	            },
	            error : function(){
	                console.log('비동기 통신 실패')
	            }
	        })
	        selectReviewList();
	    })
	})
	selectReviewList();
	
	const modal = document.getElementById('myModal');
	const btn = document.getElementById('requestButton');
	const span = document.getElementsByClassName('close')[0];
	btn.onclick = function() {
		modal.style.display = 'block';
	};
	span.onclick = function() {
		modal.style.display = 'none';
	};
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = 'none';
		}
	};
	</script>
</main>
</body>
</html>