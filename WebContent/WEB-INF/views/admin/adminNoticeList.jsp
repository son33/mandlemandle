<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="pagetitle">
		<h1>공지사항</h1>

		<div class="me-2 " style="width: 130px; margin-top: 10px;"
			id="adminsearch">
			<form action="noticeList" method="get">
				<input type="hidden" name="currentPage" value="${currentPage}">
				<select class="form-select" onchange="changeDropdown(this)"
					name="condition">
					<option id="title" value="title">글제목</option>
				</select> <input placeholder="Search..." type="search" name="keyword"
					value="${keyword }">
				<!-- <button id="searchbtn" type="button">검색</button> -->
			</form>
		</div>
	</div>
	<!-- End Page Title -->
	

	<section class="section">
		<div class="row">
			<div class="col-lg-12">

				<div class="card">
					<div class="card-body">
						<div class="d-flex justify-content-end align-items-center mb-3"
							style="margin-top: 20px;">
							<!-- 버튼 그룹 -->
							<div class="button-group">
								<button type="button" class="btn btn-primary btn-dark"
									data-bs-toggle="modal" data-bs-target="#fullscreenModal">글쓰기</button>
							</div>
						</div>
						<div
							class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
							<div class="datatable-top"></div>
							<div class="datatable-container">
								<table class="table table-hover datatable datatable-table">
									<thead>
										<tr>

											<th data-sortable="true" style="width: 10%;"><button
													class="datatable-sorter">
													<b>공지번호</b>
												</button></th>
											<th data-sortable="true" style="width: 40%;"><button
													class="datatable-sorter">공지제목</button></th>
											<th data-sortable="true" style="width: 15%;"><button
													class="datatable-sorter">작성날짜</button></th>
											<th data-sortable="true" style="width: 15%;"><button
													class="datatable-sorter">작성자</button></th>
											<th data-sortable="true" style="width: 10%;"><button
													class="datatable-sorter">상세보기</button></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="b" items="${list}">
											<tr>
												<td>${b.boardNo}</td>
												<td>${b.boardTitle}</td>
												<td>${b.createDate}</td>
												<td>${b.userName}</td>
												<td>
													<button type="button"
														class="btn btn-primary noticeDetailButton"
														data-bs-toggle="modal"
														data-bs-target="#modalDialogScrollable"
														data-boardno="${b.boardNo}">상세보기</button>
												</td>
											</tr>
										</c:forEach>
										<c:if test="${empty list}">
											<tr>
												<td colspan="5" align="center">조회된 결과가 없습니다.</td>
											</tr>
										</c:if>
									</tbody>
								</table>
								<div class="listbtn">
									<button type="button" class="btn btn-primary btn-sm"
										onclick=" firstPage()">목록</button>
								</div>
								<script>
							
						      	function firstPage() {
							        const keyword = $("#adminsearch [name=keyword]").val().trim();
							        let url = "noticeList";
							        let data = {currentPage:1};
							        loadLayout(url , data);
							    }
									
										//검색기능 
								$(function () {
								    $("#adminsearch [name=keyword]").keydown(function (e) {
								        if (e.key === "Enter") {
								            e.preventDefault();
								            const keyword = $(this).val().trim();
								            
								            if (keyword === "") {
								                alert("검색어를 입력하세요.");
								                
								            } 
								            let url = "noticeList";
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
							        let url = "noticeList";
							        let data = {keyword, currentPage, condition: $("#adminsearch select").val()};
							        loadLayout(url , data);
							    }
								
								
							
								$(function () {
								    $(".noticeDetailButton").click(function () {
								    
								        const clickedBoardNo = $(this).data("boardno");
		    				            console.log("Clicked boardNo:", clickedBoardNo);
		
								        viewNoticeDetail(clickedBoardNo);
								    });
								});
		
								
								function viewNoticeDetail(clickedBoardNo) {
								    
								    console.log("Viewing notice detail for boardNo:", clickedBoardNo);
		
								    $.ajax({
								        url: "adminNoticeDetail?boardNo=" + clickedBoardNo,
								        dataType: "json",
								        success: function (result) {
								            if (result && result.board) {
								                const board = result.board;
								                const attachment = result.attachment;

								                $("#NoticeBoardNo").text(board.boardNo);
								                $("#NoticeBoardTitle").text(board.boardTitle);
								                $("#NoticeBoardContent").html(board.boardContent);
								              
								             

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

								                $("#modalDialogScrollable").modal('show');
								            } else {
								                alert('유효한 데이터가 포함되어 있지 않습니다.');
								            }
								        },
								        error: function () {
								            alert('데이터를 가져오는 중 오류가 발생했습니다.');
								        }
								    });
								}
							</script>

								<div aria-label="Page navigation example" id="adminpaging"
									class="d-flex justify-content-center">
									<ul class="pagination">
										<c:if test="${pi.currentPage ne 1 }">
											<li class="page-item"><a class="page-link"
												href="javascript:performSearch('${pi.currentPage-1}')"
												aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a></li>
										</c:if>
										<c:forEach var="p" begin="${pi.startPage }"
											end="${pi.endPage }">
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
								<div class="modal fade" id="fullscreenModal" tabindex="-1">
									<div class="modal-dialog modal-fullscreen">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title">공지작성</h5>
												<button type="button" class="btn-close"
													data-bs-dismiss="modal" aria-label="Close"></button>
											</div>
											<div class="modal-body">

												<section class="section">
													<div class="row">
														<div class="col-lg-12">
															<div class="card">
																<div class="card-body">
																	<form id="noticeForm" enctype="multipart/form-data">
																		<input type="hidden" name="userNo" value="1">
																		<table class="table table-bordered"
																			style="margin-top: 30px;">
																			<tr>
																				<td>제목</td>
																				<td><input type="text" placeholder="제목을 입력해주세요"
																					id="boardTitleInput" style="width: 100%"
																					name="boardTitle" /></td>
																			</tr>
																			<tr>
																				<td>내용</td>
																				<td><textarea id="summernote"
																						name="boardContent"></textarea></td>
																			</tr>
																			<tr>
																				<td>파일</td>
																				<td><input type="file" name="upfile"
																					id="fileInput" style="display: none" multiple>
																					<button type="button" class="btn btn-secondary"
																						name="" id="fileInfut"
																						onclick="$('#fileInput').click();">파일 선택</button>
																					<p id="selectedFileName"></p></td>
																			</tr>
																		</table>

																	</form>
																</div>
															</div>
														</div>
													</div>
												</section>

												<script>
												    $(document).ready(function() {
												     
												
												        // 이미지 업로드 콜백 함수
												        $('#summernote').summernote({
												            height: 600,
												            minHeight: null,
												            maxHeight: null,
												            focus: false,
												            lang: "ko-KR",
												            placeholder: '최대 2048자까지 쓸 수 있습니다',
												            callbacks: {
												                onImageUpload: function(files) {
												                    uploadFile(files[0]);
												                }
												            }
												        });
												
												        // 파일 선택 시 파일명 표시
												        $('#fileInput').on('change', function() {
												            let selectedFiles = $(this)[0].files;
												            let selectedFileNames = '';
												
												            for (var i = 0; i < selectedFiles.length; i++) {
												                selectedFileNames += selectedFiles[i].name + '<br>';
												            }
												
												            $('#selectedFileName').html(selectedFileNames);
												        });
												    });
												
												    // 이미지 업로드 함수
												    function uploadFile(file) {
												        let formData = new FormData();
												        formData.append('file', file);
												
												        $.ajax({
												            type: 'POST',
												            url: 'adminNoticeInsert',
												            data: formData,
												            processData: false,
												            contentType: false,
												            success: function(response) {
												                console.log(response);
												            },
												            error: function(error) {
												                console.log(error);
												            }
												        });
												    }
												
												    // 공지 작성 저장 함수
												    function insertNotice() {
												        let formData = new FormData($('#noticeForm')[0]);
												        formData.append('boardTitle', $('#boardTitleInput').val());
												        formData.append('boardContent', $('#summernote').summernote('code'));
												
												        $.ajax({
												            type: 'POST',
												            url: 'adminNoticeInsert',
												            data: formData,
												            contentType: false,
												            processData: false,
												            success: function(response) {
												                console.log(response);
												                alert('게시글 작성 성공');
												                
												                $('#boardTitleInput').val('');
												                $('#summernote').summernote('code', '');
												                $('#fileInput').val('');
												                $('#selectedFileName').html('');
																
												                performSearch(1);
												                $('#fullscreenModal').modal('hide');
												            },
												            error: function(error) {
												                console.log(error);
												            }
												        });
												    }
												
												    $(document).ready(function() {
												        // 여기 아래 부분
												        // 에디터 설정
												        $('#summernote').summernote({
												            height: 600,
												            minHeight: null,
												            maxHeight: null,
												            focus: false,
												            lang: "ko-KR",
												            placeholder: '최대 2048자까지 쓸 수 있습니다'
												        });
												    });
												
												    // 에디터 설정
												    $('.summernote').summernote({
												        toolbar: [
												            ['fontname', ['fontname']],
												            ['fontsize', ['fontsize']],
												            ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
												            ['color', ['forecolor','color']],
												            ['table', ['table']],
												            ['para', ['ul', 'ol', 'paragraph']],
												            ['height', ['height']],
												            ['insert',['picture','link','video']],
												            ['view', ['fullscreen', 'help']]
												        ],
												        fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
												        fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
												    });
												</script>

											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-primary"
													onclick="insertNotice()">저장 후 닫기</button>
												<button type="button" class="btn btn-secondary"
													data-bs-dismiss="modal" onclick="resetForm()">Close</button>
											</div>
										</div>
									</div>
									<script>
								    function resetForm() {
								       
								        $('#noticeForm')[0].reset(); // 폼 리셋
								        $('#summernote').summernote('code', ''); // 에디터 내용 비우기
								        $('#selectedFileName').html(''); 
								    }
									</script>
								</div>

							</div>
						</div>

					</div>


				





					<div class="modal fade" id="modalDialogScrollable" tabindex="-1">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title">공지상세</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
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

																<button type="button"
																	class="btn btn-outline-primary btn-sm"
																	onclick="modify()">수정</button>
																<button type="button"
																	class="btn btn-outline-danger btn-sm"
																	onclick="deleteNotice()">삭제</button>
															</div>
														</div>
														<div class="table-responsive scrollable-table">
															<table class="table table-bordered"
																style="margin-top: 30px;">

																<tr>
																	<td>공지번호</td>
																	<td id="NoticeBoardNo"></td>
																	<td>제목</td>
																	<td id="NoticeBoardTitle"></td>
																</tr>

																<tr>
																	<td>첨부파일</td>
																	<td id="NoticeBoardAttachment" ></td>
																	<td>파일번호</td>
																	<td id="NoticeFileNo"></td>
																																
																</tr>
																</tr>
																<tr>
																	<td>내용</td>
																	<td id="NoticeBoardContent" colspan="3"></td>
																</tr>
															</table>
														</div>

													</div>
												</div>



											</div>
										</div>
									</section>
									
<!-- ===================================================================================================================== -->
	<script>
	function modify() {
    // 선택된 공지의 데이터 가져오기
    const noticeNo = $("#NoticeBoardNo").text();
    const noticeTitle = $("#NoticeBoardTitle").text();
    const noticeAttachment = $("#NoticeBoardAttachment").text();
    const noticeContent = $("#NoticeBoardContent").text();
    const noticeFileNo = $("#NoticeFileNo").text();
    
   

    // 데이터 출력
    console.log("Notice No: ", noticeNo);
    console.log("Notice Title: ", noticeTitle);
    console.log("Notice Attachment: ", noticeAttachment);
    console.log("Notice Content: ", noticeContent);
    console.log("Notice fileNo: ", noticeFileNo);
    

    // ExtralargeModal에 데이터 표시
    $("#updateNoticeNo").val(noticeNo);
    $("#updateTitleInput").val(noticeTitle);
    $("#originFileName").html(noticeAttachment);
    $("#originFileNo").val(noticeFileNo);
    $("#summernoteModal").summernote('code', noticeContent);
    $("#updateFileName").html(noticeAttachment);

  
    
    $('#ExtralargeModal').modal('show');
    
}
	</script>
		<div class="modal fade" id="ExtralargeModal" tabindex="-1">
                <div class="modal-dialog modal-xl">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h5 class="modal-title">Extra Large Modal</h5>
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                       <div class="pagetitle" >
            <h1>공지 작성</h1>
        </div><!-- End Page Title -->

        <div class="pagetitle">


        </div><!-- End Page Title -->

       	<section class="section">
													<div class="row">
														<div class="col-lg-12">
															<div class="card">
																<div class="card-body">
																	<form id="updateForm" enctype="multipart/form-data">
																		<input type="hidden" name="userNo" value="1">
																		<input type="hidden" name=updateNoticeNo id="updateNoticeNo">
																		
																		
																		<table class="table table-bordered"
																			style="margin-top: 30px;">
																			<tr>
																				<td>제목</td>
																				<td><input type="text" placeholder="제목을 입력해주세요"
																					id="updateTitleInput" style="width: 100%"
																					name="updateTitle" /></td>
																			</tr>
																			<tr>
																				<td>내용</td>
																				<td><textarea id="summernoteModal"
																						name="updateContent"></textarea></td>
																			</tr>
																			<tr>
																				<input type="hidden" name="originFileNo" id="originFileNo">
																				<input type="hidden" name="originFileName" id="originFileName">
																				
																				
																				<td>파일</td>
																				<td><input type="file" name="reupfile"
																					id="updatefileInput" style="display: none" multiple>
																					<button type="button" class="btn btn-secondary"
																						name="" id="updatefileInputButton"
																						onclick="$('#updatefileInput').click();">파일 선택</button>
																					<p id="updateFileName"></p></td>
																			</tr>
																		</table>

																	</form>
																</div>
															</div>
														</div>
													</div>
												</section>
        <script>
        $(document).ready(function() {
            //여기 아래 부분
            $('#summernoteModal').summernote({
                  height: 300,                 // 에디터 높이
                  minHeight: null,             // 최소 높이
                  maxHeight: null,             // 최대 높이
                  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
                  lang: "ko-KR",					// 한글 설정
                  placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
                  
            });
            $('#updatefileInput').on('change', function() {
                let selectedFileNames = '';
                let selectedFiles = $(this)[0].files;

                for (let i = 0; i < selectedFiles.length; i++) {
                  selectedFileNames += selectedFiles[i].name + '<br>';
                }

                $('#updateFileName').html(selectedFileNames);
              });
        });
       
        </script>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-primary" onclick="updateNotice()">수정하기</button>
                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    
                    </div>
                  </div>
                </div>
              </div>
              
              <script>
              function updateNotice(){
            	 
            	    let updateNoticeNo = $("#updateNoticeNo").val(); 
            	    const updateNoticeTitle = $("#updateTitleInput").val(); 
            	    const updateNoticeContent = $("#summernoteModal").summernote('code');
            	   
            	    let fileNo = $("#originFileNo").val();

            	    // fileNo가 undefined인 경우 0으로 초기화
            	    if (fileNo === undefined) {
            	        fileNo = 0;
            	    }
            	
            	  let formData = new FormData($('#updateForm')[0]);
            	  formData.append('boardNo', updateNoticeNo); 
                  formData.append('boardTitle', updateNoticeTitle);
                  formData.append('boardContent', updateNoticeContent);
                  formData.append('fileNo', fileNo);
            	    
				        $.ajax({
				            type: 'POST',
				            url: 'adminNoticeUpdate',
				            data: formData,
				            contentType: false,
				            processData: false,
				            success: function(response) {
				                console.log(response);
				                alert('게시글 수정 성공');
				                $('#updateNoticeNo').val(''); 
				                $('#updateTitleInput').val('');
				                $('#summernoteModal').summernote('code', '');
				                $('#updatefileInput').val('');
				                $('#updateFileName').html('');
				                performSearch(1);
				                $('#ExtralargeModal').modal('hide')	
				                $('#modalDialogScrollable').modal('hide');
				             
				            },
				            error: function(error) {
				                console.log(error);
				            }
				        });
				 
            	  
              }
              
              
              </script>
			<!-- ===================================================================================================================== -->
									<script>
									// 삭제하기
									function deleteNotice() {
									    const boardNo = $("#NoticeBoardNo").text();
									    
									    const deleteCheck= confirm("정말로 이 공지사항을 삭제하시겠습니까?");
								        if (!deleteCheck) {
								            return; 
								        }
									   
									    $.ajax({
									        url: "deleteNotice",
									        data: { boardNo: boardNo },
									        dataType: "json",
									        success: function (result) {
									            if (result > 0) {
									                console.log("Notice deleted successfully");
									                $("#modalDialogScrollable").modal('hide');
									                alert("공지사항 삭제에 성공했습니다.");
									                
									            } else {
									                alert("공지사항 삭제에 실패했습니다.");
									                
									            }
									            performSearch(1);
									            
									        },
									        error: function () {
									            alert('데이터를 삭제하는 중 오류가 발생했습니다.');
									        }
									    });
									}
									
									</script>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
					</div>
					</div>
					</div>
	</section>

</body>
</html>