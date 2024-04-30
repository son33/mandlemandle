<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="pagetitle">
		<h1>커뮤니티신고내역</h1>
		<div class="me-2 " style="width: 130px; margin-top: 10px;"
			id="adminsearch">
			<form action="reviewList" method="get">
				<input type="hidden" name="currentPage" value="${currentPage}">
				<select class="form-select" onchange="changeDropdown(this)"
					name="condition">
					<option id="content" value="content">신고사유</option>
					<option id="name" value="name">신고자</option>
				</select> <input placeholder="Search..." type="search" name="keyword"
					value="${keyword }">
				<button id="searchbtn" type="button">검색</button>
			</form>
		</div>
	</div>
	<section class="section">
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">커뮤니티신고내역</h5>
						<!-- Table with stripped rows -->
						<div
							class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
							<div class="datatable-top"></div>
							<div class="datatable-container">
								<table class="table table-hover datatable datatable-table">
									<thead>
										<tr>
											<th data-sortable="true" style="width: 10%;"><button
													class="datatable-sorter">
													<b>신고번호</b>
												</button></th>
											<th data-sortable="true"5><button
													class="datatable-sorter">신고사유</button></th>
											<th data-sortable="true" style="width: 10%;"><button
													class="datatable-sorter">신고자</button></th>
											<th data-sortable="true" style="width: 15%;"><button
													class="datatable-sorter">신고날짜</button></th>
											<th data-sortable="true" style="width: 10%;"><button
													class="datatable-sorter">상세보기</button></th>
											<th data-sortable="true" style="width: 10%;"><button
													class="datatable-sorter">확인</button></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="r" items="${list}">
											<tr>
												<td>${r.reportNo}</td>
												<td>${r.reportContent}</td>
												<td>${r.userName}</td>
												<td>${r.reportDate}</td>
												<td><button type="button"
														class="btn btn-primary boardReportDetailButton"
														data-bs-toggle="modal" data-bs-target="#ExtralargeModal"
														data-boardno="${r.refBno}" data-reportno="${r.reportNo}">글상세</button></td>
												<td><button type="button"
														class="btn btn-primary reportdelete"
														data-boardno="${r.reportNo}"
														onclick="confirmation(${r.reportNo})">확인</button></td>
											</tr>
										</c:forEach>
										<c:if test="${empty list}">
											<tr>
												<td colspan="6" align="center">조회된 결과가 없습니다.</td>
											</tr>
										</c:if>
									</tbody>
								</table>
								<div class="listbtn">
									<button type="button" class="btn btn-primary btn-sm"
										onclick=" firstPage()">목록</button>
								</div>
							</div>
						</div>
						<div aria-label="Page navigation example" id="adminpaging"
							class="d-flex justify-content-center">
							<ul class="pagination">
								<c:if test="${pi.currentPage ne 1 }">
									<li class="page-item"><a class="page-link"
										href="javascript:performSearch('${pi.currentPage-1}')"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:if>
								<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
									<li class="page-item"><a class="page-link"
										href="javascript:performSearch('${p}')">${p}</a></li>
								</c:forEach>
								<c:if test="${pi.currentPage ne pi.maxPage }">
									<li class="page-item"><a class="page-link"
										href="javascript:performSearch('${pi.currentPage+1}')"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</c:if>
							</ul>
						</div>
						<div class="modal fade" id="ExtralargeModal" tabindex="-1">
							<div class="modal-dialog modal-xl">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title">상세보기</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
										<section class="section">
											<div class="row">
												<div class="col-lg-12">
													<div class="card">
														<div class="card-body">
															<div
																class="d-flex justify-content-end align-items-center mb-3"
																style="margin-top: 20px;">
																<!-- 버튼 그룹 -->
																<div class="button-group">
																	<button type="button" id="deleteBtn"
																		class="btn btn-outline-danger btn-sm">삭제</button>
																</div>
															</div>
															<div class="table-responsive scrollable-table">
																<table class="table table-bordered"
																	style="margin-top: 30px;">
																	<tr>
																		<td>제목</td>
																		<td id="NoticeBoardTitle" colspan="3"></td>
																	</tr>
																	<tr>
																		<td>게시글번호</td>
																		<td id="NoticeBoardNo"></td>
																		<td>작성자</td>
																		<td id="UserName"></td>
																	</tr>
																	<tr>
																		<td>구분이름</td>
																		<td id="DivideName"></td>
																		<td>조회수</td>
																		<td id="Count"></td>
																	</tr>
																	<tr>
																		<td>첨부파일</td>
																		<td id="NoticeBoardAttachment"></td>
																	</tr>
																	<tr>
																		<td>내용</td>
																		<td id="NoticeBoardContent" colspan="3"></td>
																	</tr>
																</table>
															</div>
														</div>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-bs-dismiss="modal" id="closeBtn">Close</button>
													</div>
												</div>
											</div>
										</section>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</section>
	<script>
	function firstPage() {
	   const keyword = $("#adminsearch [name=keyword]").val().trim();
	   let url = "reportBoardList";
	   let data = {currentPage:1};
	   loadLayout(url , data);
	}
	$(function() {
	    const condition = '${condition}';
	
	    if (condition) {
	        $("#adminsearch select[name='condition']").val(condition);
	    }
	});
								
	//검색기능 
	$(function () {
	    $("#adminsearch [name=keyword]").keydown(function (e) {
	        if (e.key === "Enter") {
	            e.preventDefault();
	            const keyword = $(this).val().trim();
	            
	            if (keyword === "") {
	                alert("검색어를 입력하세요.");
	            } 
	            let url = "reportBoardList";
	            let data = {keyword, currentPage : 1, condition : $("#adminsearch select").val()};
	            loadLayout(url , data);
	        }
	    });
	    $("#searchbtn").click(function () {
	        performSearch(1);
	    });
	});
	
	function performSearch(currentPage) {
	       const keyword = $("#adminsearch [name=keyword]").val().trim();
	       const condition = $("#adminsearch select[name='condition']").val();
	       let url = "reportBoardList";
	       let data = {keyword, currentPage, condition};
	       loadLayout(url , data);
	   }
	
	$(function () {
	    $(".boardReportDetailButton").click(function () {
	    
	        const clickedBoardNo = $(this).data("boardno");
	        const clickedReportNo = $(this).data("reportno");
			            console.log("Clicked reportNo:", clickedBoardNo);
	
	        viewNoticeDetail(clickedBoardNo , clickedReportNo);
	    });
	});
	
	function viewNoticeDetail(clickedBoardNo, clickedReportNo) {
	    $.ajax({
	        url: "adminReportBoardDetail?refBno=" + clickedBoardNo,
	        dataType: "json",
	        success: function (result) {
	            if (result && result.board) {
	            	console.log(result)
	                const board = result.board;
	                const attachment = result.attachment;
	
	                $("#NoticeBoardNo").text(board.boardNo);						                
	                $("#NoticeBoardTitle").text(board.boardTitle);
	                $("#NoticeBoardContent").html(board.boardContent);
	                $("#UserName").text(board.userName);
	                $("#Count").text(board.count);
	                $("#DivideName").text(board.boardDivideName);
	
	                // 첨부파일 관련 코드 추가 attachment.filePath $(attachment.changeName)  $(attachment.originName)
	                if (attachment) {
	                    const attachmentLink = "<a href='"+ attachment.filePath+"/" +attachment.changeName+"' download='"+attachment.originName+"'>"+attachment.originName+"</a>"; 
	                    const fileNo = attachment.fileNo;
	                  
	                    $("#NoticeBoardAttachment").html(attachmentLink);
	                    $("#NoticeFileNo").html(fileNo);
	                    
	                   
	                    const originName= attachment.originName;
	                    console.log("File No: ", fileNo);
	                    console.log("originName:",originName)
	                 
	                } else {
	                    $("#NoticeBoardAttachment").text("첨부파일이 없습니다.");
	                }
					//onclick="deleteBoardReport('${r.refBno}','${r.reportNo}')"
			
	
	                document.querySelector("#deleteBtn").onclick = function () {
	                	 const deleteCheck = confirm("정말로 삭제 하시겠습니까?");
		                    
		                    if (deleteCheck) {
		                        deleteBoardReport(board.boardNo, clickedReportNo);
		                        $("#ExtralargeModal").modal('hide');
		                    }
		                };
					
	                $("#ExtralargeModal").modal('show');
	            } else {
	                alert('유효한 데이터가 포함되어 있지 않습니다.');
	            }
	        },
	        error: function () {
	            alert('데이터를 가져오는 중 오류가 발생했습니다.');
	        }
	    });
	}
	// 목록 확인하기
	function confirmation(reportNo) {
	   									    
	    const confirmCheck= confirm("정말로 확인하셨습니까?");
	       if (!confirmCheck) {
	           return; 
	       }
	   
	    $.ajax({
	        url: "deleteReportConfirm",
	        data: { reportNo: reportNo },
	        dataType: "json",
	        success: function (result) {
	            if (result > 0) {
	                console.log("review deleted successfully");
	               
	                alert("확인에 성공했습니다.");
	                
	            } else {
	                alert("확인에 실패했습니다.");
	                
	            }
	            performSearch(1);
	            
	        },
	        error: function () {
	            alert('데이터를 삭제하는 중 오류가 발생했습니다.');
	        }
	    });
	}
	
	function deleteBoardReport(refBno, reportNo ) {
	    $.ajax({
	        url: "deleteBoardReport",
	        data: { reportNo ,refBno  },
	        dataType: "json",
	        success: function (result) {
	        	if (result.result1 > 0 && result.result2 > 0) {
	                console.log("review deleted successfully");
	                alert("삭제에 성공했습니다.");
	            } else {
	                alert("삭제에 실패했습니다.");
	            }
	            performSearch(1);
	            $("#ExtralargeModal").modal('hide'); 
	            
	        },
	        error: function () {
	            alert('데이터를 삭제하는 중 오류가 발생했습니다.');
	        }
	    });
	}
	</script>
</body>
</html>