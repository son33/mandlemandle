<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="pagetitle">
		<h1>Frequently Asked Questions</h1>
		<h5 class="card-title">자주 묻는 질문</h5>

	</div>
	<!-- End Page Title -->

	<section class="section faq">
		
		<!-- F.A.Q Group 1 -->
		<div class="card">
			<div class="card-body">
			
				<input type="hidden" id="currentPage" name="currentPage" value="${currentPage}">
				
				
			
				<div class="d-flex justify-content-end align-items-center mb-3"
					style="margin-top: 20px;">
					
					<!-- 버튼 그룹 -->
					<div class="button-group">
					
						<div class="button-group">
								<button type="button" class="btn btn-primary btn-dark"
									data-bs-toggle="modal" data-bs-target="#ExtralargeModal">글쓰기</button>
							</div>
					
					</div>
					
				</div>


				<div class="accordion accordion-flush" id="faq-group-1">
					<c:forEach var="b" items="${list}" varStatus="loop">
						<div class="accordion-item">
							<h1 class="accordion-header">
								 <div class="btn-group me-2">
                   						 <button type="button" class="btn btn-danger btn-sm" onclick="deleteNotice(${b.boardNo})">삭제</button>
                				</div>
								<button class="accordion-button collapsed"
									data-bs-target="#faqsOne-${loop.index}" type="button"
									data-bs-toggle="collapse">${b.boardTitle}</button>
							</h1>
							<div id="faqsOne-${loop.index}"
								class="accordion-collapse collapse"
								data-bs-parent="#faq-group-1">
								<div class="accordion-body">${b.boardContent}</div>
							</div>
					
						
						</div>
					</c:forEach>
				</div>
		
				
				<script>
						
				function performSearch(currentPage) {
				
			        let url = "FAQList";
			        let data = {currentPage};
			        loadLayout(url , data);
			    }
					// 삭제하기
									function deleteNotice(boardNo) {
									    					    
									    const deleteCheck= confirm("정말로 이 게시글을 삭제하시겠습니까?");
								        if (!deleteCheck) {
								            return; 
								        }
									   
									    $.ajax({
									        url: "deleteNotice",
									        data: { boardNo: boardNo },
									        dataType: "json",
									        success: function (result) {
									            if (result > 0) {
									                console.log("review deleted successfully");
									                 alert("게시글 삭제에 성공했습니다.");
									                
									            } else {
									                alert("게시글 삭제에 실패했습니다.");
									                
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
		</div>
		
			<div class="modal fade" id="ExtralargeModal" tabindex="-1">
									<div class="modal-dialog modal-xl">
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
																	<form id="FAQForm" enctype="multipart/form-data">
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
												        let formData = new FormData($('#FAQForm')[0]);
												        formData.append('boardTitle', $('#boardTitleInput').val());
												        formData.append('boardContent', $('#summernote').summernote('code'));
												
												        $.ajax({
												            type: 'POST',
												            url: 'adminFAQInsert',
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
												                $('#ExtralargeModal').modal('hide');
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
								</div>
								<script>
								    function resetForm() {
								       
								        $('#FAQForm')[0].reset(); // 폼 리셋
								        $('#summernote').summernote('code', ''); // 에디터 내용 비우기
								        $('#selectedFileName').html(''); 
								    }
							</script>
		
	</section>
	
</body>
</html>