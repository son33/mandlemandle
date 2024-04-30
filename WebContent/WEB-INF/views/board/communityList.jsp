<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>커뮤니티 메인</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%= contextPath %>/resources/css/board/communityList.css">
</head>
<body>
	<div class="container" id="container">
        <div class="content">
			<section class="notice">
				<div class="page-container">
					<div class="page-title">
						<h3>커뮤니티</h3>
					</div>
					<div class="page-content">
						<div class="page-btn">
							<div class="search-area">
								<form action="filter.co" method="get">
									<select name="condition" id="filterSelect">
										<option value="date" selected>최신순</option>
										<option value="count">조회순</option>
									</select>
								</form>
							</div>
							<div class="write-filter">
								<c:if test="${!empty loginUser && boardNo != 10}">
									<input type="button" id="writeBtn" onclick="window.location.href = '<%= contextPath %>/insert.co'" value="글쓰기">
								</c:if>
								<c:set var="communityInsertURL"	value="${contextPath}/insert.co" />
							</div>
						</div>
						<div id="board-list">
							<div class="board-container">
								<table class="board-table">
									<thead>
										<tr>
											<th scope="col" class="th-num">번호</th>
											<th scope="col" class="th-title">제목</th>
											<th scope="col" class="th-divide">구분</th>
											<th scope="col" class="th-writer">작성자</th>
											<th scope="col" class="th-count">조회수</th>
											<th scope="col" class="th-date">등록일</th>
											<th scope="col" class="th-report">비고</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
							</div>
						</div>
						<div id="pagingArea"></div>
					</div>
				</div>
			</section>
		</div>
	</div>
	<div class="modal fade" id="reportModal" tabindex="-1" role="dialog" aria-labelledby="reportModalLabel" aria-hidden="true">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="reportModalLabel">신고하기</h5>
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                    <span aria-hidden="true">&times;</span>
	                </button>
	            </div>
	            <div class="modal-body">
	                <form id="reportForm">
	                    <div class="form-group">
	                        <label for="reportContent">신고 내용:</label>
	                        <textarea class="form-control" id="reportContent" name="reportContent" rows="4" required></textarea>
	                    </div>
	                    <button type="button" class="btn btn-primary" onclick="confirmReport('${boardNo}')">신고 보내기</button>
	                </form>
	            </div>
	        </div>
	    </div>
	</div>
	<script>
		// 필터링
        function tableFilter() {
            let filterSelect = document.getElementById('filterSelect');
            let selectedOption = filterSelect.options[filterSelect.selectedIndex].value;
            $.ajax({
                type: 'GET',
                url: '<%= contextPath %>/filter.co',
                data: { condition: selectedOption, currentPage: '${currentPage}', boardNo: '${boardNo}'},
                dataType: 'json',
                success: function (data) {
                    updateTable(data);
                },
                error: function (xhr, status, error) {
                    console.error('필터 비동기 통신 실패 : ', status, error);
                }
            });
        }

        function updateTable(data) {
            let tableBody = document.querySelector('#board-list tbody');
            let boardList = data.list;
            tableBody.innerHTML = '';
            let pagingInfo = data.pi;
            for (let i = 0; i < boardList.length; i++) {
                let row = '<tr>';
                row += '<td onclick="location.href=\'detail.co?bno=' + boardList[i].boardNo + '\'"><div>' + boardList[i].boardNo + '</div></td>';
                row += '<td onclick="location.href=\'detail.co?bno=' + boardList[i].boardNo + '\'"><div>' + boardList[i].boardTitle + '</div></td>';
                row += '<td onclick="location.href=\'detail.co?bno=' + boardList[i].boardNo + '\'"><div>' + boardList[i].boardDivideName + '</div></td>';
                row += '<td onclick="location.href=\'detail.co?bno=' + boardList[i].boardNo + '\'"><div>' + boardList[i].userName + '</div></td>';
                row += '<td onclick="location.href=\'detail.co?bno=' + boardList[i].boardNo + '\'"><div>' + boardList[i].count + '</div></td>';
                row += '<td onclick="location.href=\'detail.co?bno=' + boardList[i].boardNo + '\'"><div>' + boardList[i].createDate + '</div></td>';
                row += '<td id="buttons">';
                if('${loginUser}' != "" && '${loginUser.userNo}' != boardList[i].userNo){
	                row += '<button id="reportBtn" onclick="openModal('+boardList[i].boardNo+')">신고</button>';
                };
                row += '</td>';
                row += '</tr>';
                tableBody.innerHTML += row;
            }
            updatePagination(pagingInfo);
        }
        // 페이징 처리
        function updatePagination(pagingInfo) {
		    let pagination = $('#pagingArea');
		    pagination.empty();
		
		    let ul = $('<ul class="pagination"></ul>');
		    if (pagingInfo.currentPage != 1) {
		        ul.append('<li class="page-item" onclick="location.href=\'<%= contextPath %>/community?boardNo=1&page=' + (pagingInfo.currentPage - 1) + '\'">이전</li>');
		    }
		    for (let p = pagingInfo.startPage; p <= pagingInfo.endPage; p++) {
		        if ((pagingInfo.startPage + p - 1) == pagingInfo.currentPage) {
		            ul.append('<li class="page-item"><span style="color:red;">' + (pagingInfo.startPage + p - 1) + '</span></li>');
		        } else {
		            ul.append('<li class="page-item" onclick="location.href=\'<%= contextPath %>/community?boardNo=1&page=' + p + '\'">' + p + '</li>');
		        }
		    }
		    if (pagingInfo.currentPage != pagingInfo.maxPage) {
		        ul.append('<li class="page-item" onclick="location.href=\'<%= contextPath %>/community?boardNo=1&page=' + (pagingInfo.currentPage + 1) + '\'">다음</li>');
		    }
		    pagination.html(ul);
		}

        $(document).ready(function () {
            tableFilter($("#currentPage").val());
        });

        document.getElementById('filterSelect').addEventListener('change', function () {
            tableFilter(1);
        });

        function openModal(boardNo) {
            $('#reportModal').modal('show');
            currentBoardNo = boardNo;
        }
        document.getElementById('filterSelect').addEventListener('change', function () {
            tableFilter(1);
        });
        
        $('#reportModal').on('hidden.bs.modal', function () {
            $("#reportContent").val(""); // 모달이 닫힐 때 내용을 빈칸으로 초기화
        });
		
        let currentBoardNo;
        function confirmReport() {
            const confirmReport = confirm("신고하시겠습니까?");
            if (confirmReport) {
                const reportTitle = $('#reportTitle').val();
                const reportContent = $('#reportContent').val();
                $.ajax({
                    type: 'POST',
                    url: '<%= contextPath %>/report',
                    data: {refBno: currentBoardNo, reportContent: reportContent, userNo:'${loginUser.userNo}'},
                    dataType: 'json',
                    success: function (data) {
                    	if(data > 0){
                    		alert("신고가 접수되었습니다")
                        	$('#reportModal').modal('hide');
                    		$("#reportContent").val("");
                    	} else {
                    		alert("신고가 접수되지 않았습니다. 다시 접수해주세요")
                    		$('#reportModal').modal('hide');
                    		$("#reportContent").val("");
                    	}
                    },
                    error: function (xhr, status, error) {
                        console.error('신고 비동기 통신 실패 : ', status, error);
                    }
                });
            }
        }
    </script>
</body>
</html>
