<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.mm.member.model.vo.*"%>
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
    <div class="container" id="container">
        <div class="content">
            <div class="portfolio">
	            <form action="<%= contextPath %>/update.po" method="post" enctype="multipart/form-data">
	            <input type="hidden" name="refPno" id="refPno" value="${empty portfolio ? 0 : portfolio.ptfNo}">
	            <input type="hidden" name="mtoNo" id="mtoNo" value="${loginUser.userNo}">
	                <div class="portfolio-top">
	                    <div class="portfolio-profile wrapper">
	                        <div class="portfolio-profile-img">
	                        	<c:if test="${not empty attachmentList[0]}">
	                                <img class="img" id="img0" src="<%= contextPath %>/resources/portfolio_upfiles/${attachmentList[0].changeName}" alt="Profile Image">
	                        	</c:if>
	                        	<c:if test="${empty attachmentList[0]}">
	                                <img class="img" id="img0" src="<%= contextPath %>/resources/image/mentor2.png" alt="Profile Image">
	                        	</c:if>
	                        </div>
	                    </div>
	                    <div class="grade wrapper">
	                        <div class="grade-value text-bottom"><span><fmt:formatNumber type="number" pattern="0.0" value="${empty portfolio ? 0 : portfolio.averageScore}"/>/5</span></div>
	                        <div class="grade-name text-bottom"><span>평점</span></div>
	                    </div>
	                    <div class="review-count wrapper">
	                        <div class="review-count-value text-bottom"><span>${empty portfolio ? 0 : portfolio.reviewCount}</span></div>
	                        <div class="review-count-name text-bottom"><span>리뷰 수</span></div>
	                    </div>
	                    <div class="agree-count wrapper">
	                        <div class="agree-count-value text-bottom"><span>${empty portfolio ? 0 : portfolio.requestCount}</span></div>
	                        <div class="agree-count-name text-bottom"><span>수락 수</span></div>
	                    </div>
                        <div class="open-check form-switch">
                           	<div class="open-check-value text-bottom">
	                           	<label class="toggle_switch">
	                           		<input class="switch" type="checkbox" id="status" name="status" value="Y"
	                           		disabled ${not empty portfolio and portfolio.status == 'Y' ? 'checked' : ''}>
	                           		<span class="slider"></span>
	                           	</label>
                           	</div>
                            <div class="open-check-name text-bottom"><span>공개/비공개</span></div>
                    	</div>
                	</div>
	                <div class="introduce-wrapper oneline">
	                    <div class="introduce oneline">
	                        <div class="header-wrapper">
	                            <div class="header">
	                            	<div class="header-title"><h3>한줄소개</h3></div>
	                            </div>
	                            <div class="info">
                         	   		<textarea class="value-online value" name="introduce" id="introduce" placeholder="내용을 입력하세요" readonly>${portfolio.introduce}</textarea>
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
									<div class="dropdown">
										<select class="form-select value-specialization" id="categoryNo" name="categoryNo" onchange="selectSubCategoryList()" disabled>
									        <c:if test="${portfolio == null}">
									        	<option value="" selected>선택하세요</option>
									        </c:if>
									        <c:forEach var="l" items="${bigCategory}">
									            <option value="${l.categoryNo}" 
									                <c:if test="${not empty portfolio and portfolio.categoryName eq l.categoryName}">
									                    selected
									                </c:if>
									        	>${l.categoryName}</option>
									        </c:forEach>
									    </select>
									</div>
									<div class="dropdown">
										<select class="form-select value-specialization" id="subCategoryNo" name="subCategoryNo" disabled>
									    </select>
			                       	</div>
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
									<div class="dropdown">
										<select class="form-select value-address" id="sidoNo" name="sidoNo" onchange="selectSigunguList()" disabled>
											<c:if test="${portfolio == null}">
									        	<option value="" selected>지역을 선택하세요</option>
									        </c:if>
									        <c:forEach var="l" items="${sido}">
									            <option value="${l.sidoNo}" 
									                <c:if test="${not empty portfolio and portfolio.sidoName eq l.sidoName}">
									                    selected
									                </c:if>
									        	>${l.sidoName}</option>
									        </c:forEach>
									    </select>
									</div>
									<div class="dropdown">
										<select class="form-select value-address" id="sigunguNo" name="sigunguNo" disabled>
									    </select>
									</div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="introduce-wrapper editer">
	                    <div class="introduce editer">
	                        <div class="header-wrapper">
	                            <div class="header"><div class="header-title"><h3>포트폴리오</h3></div></div>
	                            <div class="info">
	                            	<textarea class="value-editer value" id="ptfContent" name="ptfContent" placeholder="내용을 입력하세요" readonly>${portfolio.ptfContent}</textarea>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="photo-wrapper">
	                	<div class="header-wrapper">
							<div class="header"><div class="header-title"><h3>사진</h3>(최대 8개)</div></div>
							<div class="photo-body">
								<table class="img-table">
									<tbody>
										<tr>
										<c:forEach var="index" begin="1" end="4">
											<c:if test="${empty attachmentList[index]}">
									            <td><img class="img" id="img${index}" src="<%= contextPath %>/resources/image/add-image.png" alt="Image"></td>
											</c:if>
											<c:if test="${not empty attachmentList[index]}">
									            <td><img class="img" id="img${index}" src="<%= contextPath %>/resources/portfolio_upfiles/${attachmentList[index].changeName}" alt="Image"></td>
											</c:if>
								        </c:forEach>
										</tr>
										<tr>
										<c:forEach var="index" begin="5" end="8">
											<c:if test="${empty attachmentList[index]}">
									            <td><img class="img" id="img${index}" src="<%= contextPath %>/resources/image/add-image.png" alt="Image"></td>
											</c:if>
											<c:if test="${not empty attachmentList[index]}">
									            <td><img class="img" id="img${index}" src="<%= contextPath %>/resources/portfolio_upfiles/${attachmentList[index].changeName}" alt="Image"></td>
											</c:if>
								        </c:forEach>
										</tr>
									</tbody>
								</table>
							</div>	                	
	                	</div>
	                </div>
	                <div class="portfolio-button">
	                    <input type="button" class="btn btn-info rounded-pill px-3 update-btn" value="수정">
                        <input type="button" class="btn btn-info rounded-pill px-3 submit-btn" value="등록" disabled>
	                </div>
	                <div class="portfolio-review-wrapper">
		                <div id="review-area">
					        <table class="review-table">
					            <tbody>
					            </tbody>
					        </table>
					    </div>
	                </div>
	                <div id="file-area">
						<input type="file" id="file0" name="file0" disabled />
						<input type="file" id="file1" name="file1" disabled />
						<input type="file" id="file2" name="file2" disabled />
						<input type="file" id="file3" name="file3" disabled />
						<input type="file" id="file4" name="file4" disabled />
						<input type="file" id="file5" name="file5" disabled />
						<input type="file" id="file6" name="file6" disabled />
						<input type="file" id="file7" name="file7" disabled />
						<input type="file" id="file8" name="file8" disabled />
						<c:forEach var="i" items="${attachmentList}" varStatus="index">
						<input type="hidden" name="fileNo${index.index}" value="${i.fileNo}">
						<input type="hidden" name="fileName${index.index}" value="${i.originName}">
						<input type="hidden" name="fileChangeName${index.index}" value="${i.changeName}">
						</c:forEach>
			        </div>
	            </form>
            </div>
        </div>
	</div>
    <script>
		$(function(){
// 			페이지 로딩 시 마지막으로 실행
			selectSubCategoryList();
			selectSigunguList();
			selectReviewList();
			
// 		    수정 버튼 클릭 시, 입력 폼들을 활성화
		    $(".update-btn").click(function() {
	            $("#status").removeAttr("disabled");
	            $(".value").removeAttr("readonly");
	            $("#categoryNo").removeAttr("disabled");
	            $("#subCategoryNo").removeAttr("disabled");
	            $("#sidoNo").removeAttr("disabled");
	            $("#sigunguNo").removeAttr("disabled");
	            $("input[type=file]").removeAttr("disabled");
	            $("#introduce").addClass("textarea-border");
	            $("#ptfContent").addClass("textarea-border");
	            // 수정 버튼 비활성화, 등록 버튼 활성화
	            $(".update-btn").prop("disabled", true);
	            $(".submit-btn").prop("disabled", false);
        	});

		    // 등록 버튼 클릭 시, form을 submit
		    $(".submit-btn").click(function() {
		        $("form").submit();
		    });
		    
// 		    이미지 선택 시 파일 업로드 선택
			$("#file-area").hide();
			$("img[id^=img]").each(function(index,value){
				$(value).click(function(){$("#file"+(index)).click();});
			});
			$("input[type=file]").each(function(index,value){
				$(value).change(function(){loadImg(value,index)});
			});
		});
		
// 		이미지 불러오기
		function loadImg(file,index){
			if(file.files[0]){
				const reader = new FileReader();
				reader.readAsDataURL(file.files[0]);
				reader.onload = function(e){
				$("#img"+index).attr("src",e.target.result);
				}
			}else{
				$("#img"+index).attr("src",`<%= contextPath %>/resources/image/add-image.png`);
			}
		}
		
// 		sub카테고리 불러오기
		function selectSubCategoryList() {
		    $.ajax({
		        url: "subcategory.sc",
		        data: { categoryNo: $("#categoryNo").val() },
		        success: function (subCategoryList) {
		            let sl = $("#subCategoryNo");
		            sl.empty();
		            for (let s of subCategoryList) {
		                let option = $("<option>", {value: s.subCategoryNo});
		                if ("${portfolio.subCategoryName}" == s.subCategoryName){
		                	option.prop("selected",true);
		                }
		                option.html(s.subCategoryName);
		                sl.append(option);
		            }
		        }
		    });
		}
		
// 		시군구 불러오기
		function selectSigunguList() {
		    $.ajax({
		        url: "sigungu.sg",
		        data: { sidoNo: $("#sidoNo").val() },
		        success: function (sidoList) {
		            let sn = $("#sigunguNo");
		            sn.empty();
		            for (let s of sidoList) {
		                let option = $("<option>", {value: s.sigunguNo});
		                if ("${portfolio.sigunguName}" == s.sigunguName){
		                	option.prop("selected",true);
		                }
		                option.html(s.sigunguName);
		                sn.append(option);
		            }
		        }
		    });
		}
		
// 		review 불러오기
		function selectReviewList(){
			$.ajax({
				url : "list.rv",
				data : {refPno: $("#refPno").val()},
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
	</script>
</body>
</html>