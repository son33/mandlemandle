<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="<%= contextPath %>/resources/summernote/summernote-lite.js"></script>
	<script src="<%= contextPath %>/resources/summernote/lang/summernote-ko-KR.js"></script>
	<link rel="stylesheet" href="<%= contextPath %>/resources/summernote/summernote-lite.css">
	<link rel="stylesheet" href="<%= contextPath %>/resources/css/board/communityInsert.css">
</head>
<body>
	<div class="body-wrapper">
		<jsp:include page="../common/menubar.jsp"></jsp:include>
		<jsp:include page="../board/sidebar.jsp"></jsp:include>
		<div class="container" id="container">
			<div class="content">
				<div class="outer">
					<div class="formArea">
						<form action="<%= contextPath %>/${status}.co" id="myForm"
							method="post" enctype="multipart/form-data">
							<div class="info">
								<div>
									<input type="text" name="boardTitle" placeholder="제목" required id="input1" value="${b.boardTitle}">
									<div class="filterArea">
										<select name="boardDivideNo" id="boardDivideNo">
										<c:forEach var="l" items="${list}">
<%-- 											<option value="${l.boardDivideNo}"<c:if test="${l.boardDivideNo ==  b.boardDivideNo}">selected</c:if>>${l.boardDivideName}</option> --%>
										</c:forEach>
											<option value="40">궁금해요</option>
											<option value="50">함께해요</option>
										</select>
									</div>
									<div>
										<textarea class="summernote" name="boardContent">${b.boardContent}</textarea>
									</div>
									<div>
										<c:if test="${status == 'insert'}">
											<button type="submit" id="enrollBtn-insert">등록</button>
										</c:if>
										<c:if test="${status == 'update'}">
											<input type="hidden" name="boardNo" value="${b.boardNo}">
											<button type="submit" id="enrollBtn-insert">수정</button>
										</c:if>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp"/>
	</div>
	<script>
	$('.summernote').summernote({
		  height: 450,
		  lang: "ko-KR",
		  callbacks:{
			  onImageUpload : function(files){
				  uploadSummernoteImageFile(files[0],this);
			  }
		  }
		});
	function uploadSummernoteImageFile(file, editor){
		data = new FormData();
		data.append("file",file);
		$.ajax({
			data:data,
		type:"POST",
		url:"/uploadSummernoteImageFile",
		dataType:"JSON",
		contentType:false, 
		processData:false, 
		success:function(data){ 
		    $(editor).summernote("insertImage",data.url); 
		    $("#thumbnailPath").append("<option value="+data.url+">"+data.originName+"</option>"); 
		}
		});
	}

    // 이미지 업로드 함수 ajax 활용
    function uploadSummernoteImageFile(file, el, caption) {
        data = new FormData()
        data.append('file', file)
        $.ajax({
            data: data,
            type: 'POST',
            url: 'uploadSummernoteImageFile',
            contentType: false,
            enctype: 'multipart/form-data',
            processData: false,
            success: function (data) {
                $(el).summernote(
                    'editor.insertImage',
                    data.url,
                    function ($image) {
                        $image.attr('alt', caption) // 캡션 정보를 이미지의 alt 속성에 설정
                    }
                )
            },
        })
    }

	document.getElementById('enrollBtn-insert').addEventListener('click', function(){
	    document.getElementById('myForm').submit();
	    window.location.href = '<%= contextPath %>/community?boardNo=1';
	});
	</script>
</body>
</html>
