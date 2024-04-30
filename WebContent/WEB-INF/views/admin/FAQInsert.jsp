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
	<jsp:include page="adminmenubar.jsp"></jsp:include>
	
        <div class="pagetitle" >
            <h1>FAQ등록</h1>
        </div><!-- End Page Title -->

        <div class="pagetitle">


        </div><!-- End Page Title -->

        <section class="section" >
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            
                           

                            <table class="table table-bordered" style="margin-top: 30px;">
                                                  
                                <tr>
                                    <td >제목</td>
                                    <td> 
                                        <span class="textBox">
                                        <input type="text" placeholder="제목을 입력해주세요" style="width: 100%;" class="int" name="title"/>
                                    </span></td>
                                </tr>
                                 
                                
                                <tr>
                                    <td>내용</td>
                                    <td ><form method="post">
                                        <textarea id="summernote" name='content'></textarea>
                                         </form>
                                    </td>   
                                </tr>
                               
                              </tbody>
                            </table>
                                    
                            <div class="text-right mt-3">
                                <button type="button" class="btn btn-primary">등록</button>
                            </div>


                        </div>
                    </div>



                </div>
            </div>
        </section>
        <script>
        $(document).ready(function() {
            //여기 아래 부분
            $('#summernote').summernote({
                  height: 300,                 // 에디터 높이
                  minHeight: null,             // 최소 높이
                  maxHeight: null,             // 최대 높이
                  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
                  lang: "ko-KR",					// 한글 설정
                  placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
                  
            });
        });
        $('.summernote').summernote({
		  toolbar: [
			    // [groupName, [list of button]]
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
    </main><!-- End #main -->
</body>
</html>