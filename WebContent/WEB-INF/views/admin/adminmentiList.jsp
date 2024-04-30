<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="pagetitle" >
		<h1>멘티회원리스트</h1>
		<div class="me-2 " style="width: 130px; margin-top: 10px;" id="adminsearch">
			<form action="mentiList" method="get" >
				<input  type="hidden" name="currentPage" value="${currentPage}" >
				 <select class="form-select" onchange="changeDropdown(this)" name="condition">
					<option id="title" value="email">이메일</option>
					<option id="content" value="name">이름</option>
				</select>
				<input  placeholder="Search..."	type="search" name="keyword" value="${keyword }">
				<button id="searchbtn" type="button">검색</button>
			</form>
		</div>
	</div>
	<section class="section">
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<div class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
							<div class="datatable-top d-flex justify-content-end">
								<div class="delete-btn">
									<button type="button" class="btn btn-outline-danger btn-sm"><a id="delbtn">삭제</a></button>
								</div>
							</div>
							<div class="datatable-container">
								<table class="table table-hover datatable datatable-table">
									<thead>
										<tr>
											<th data-sortable="true" style="width: 5%;"><b>선택</b></th>
											<th data-sortable="true" style="width: 10%;"><button class="datatable-sorter"><b>회원번호</b></button></th>
											<th data-sortable="true" style="width: 25%;"><b>이메일</b></th>
											<th data-sortable="true" style="width: 10%;">이름</th>
											<th data-sortable="true" style="width: 5%;">성별</th>
											<th data-sortable="true" style="width: 20%;">전화번호</th>
											<th data-sortable="true" style="width: 10%;">회원등급</th>
											<th data-sortable="true" class="red" style="width: 20%;">가입날짜</th>
										</tr>
									</thead>
									<tbody id="searchResults">
										<c:forEach var="m" items="${list}">
											<tr>
												<td><input type="checkbox" name="memcheck" value="${m.userNo}" ></td>
												<td>${m.userNo}</td>
												<td>${m.email }</td>
												<td>${m.userName}</td>
												<td>${m.gender}</td>
												<td>${m.phone}</td>
												<td>${m.gradeNo}</td>
												<td>${m.enrollDate}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div aria-label="Page navigation example" id="adminpaging" class="d-flex justify-content-center">
									<ul class="pagination" >
									 <c:if test = "${pi.currentPage ne 1 }">
										<li class="page-item">
										<a class="page-link"
											href="javascript:performSearch('${pi.currentPage-1}')"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a>
										</li>
								 	</c:if>
								    <c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
								  		<li class="page-item"><a class="page-link" href="javascript:performSearch('${p}')">${p}</a></li>
								    </c:forEach>
									<c:if test="${pi.currentPage ne pi.maxPage }">
										<li class="page-item"><a class="page-link" href="javascript:performSearch('${pi.currentPage+1}')"
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										</a></li>
									</c:if>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script>
	$(function() {
	    const condition = '${condition}';
	    if (condition) {
	        $("#adminsearch select[name='condition']").val(condition);
	    }
	});
			
	$(function () {
	    $("#adminsearch [name=keyword]").keydown(function (e) {
	        if (e.key === "Enter") {
	            e.preventDefault();
	            const keyword = $(this).val().trim();
	            if (keyword === "") {
	                alert("검색어를 입력하세요.");
	            } 
	            let url = "mentiList";
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
		let url = "mentiList";
		let data = {keyword, currentPage, condition};
		loadLayout(url , data);
	}
	
	$(function () {
	    $("#delbtn").click(function () {
	   		const currentPage = 1;
	   	 	const checked = $("input:checkbox[name=memcheck]:checked");
	   	 	const checkValue = $("input:checkbox[name=memcheck]").val();
			
	        if (checked.length > 0) {
	        	const confirmation = confirm("선택한 항목을 삭제하시겠습니까?");
	        	
	        	 if (confirmation){
	        	$.ajax({
	        	 url : "admindelete.me",
	          	 data : {check : checkValue, currentPage},			         
				 success :function(result){
					 alert("삭제에 성공했습니다.")
					 performSearch(currentPage);
				 }
	            }) 
	        	}else{
	        		alert("삭제가 취소 되었습니다.");
	        	}
	        } else {
	            alert("삭제할 항목을 선택해주세요.");
	        }
	    });
	});
	</script>
</body>
</html>