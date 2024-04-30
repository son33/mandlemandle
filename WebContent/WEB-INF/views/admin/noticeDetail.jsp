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

  
        <div class="pagetitle" >
            <h1>공지상세</h1>
           

        </div><!-- End Page Title -->

        <div class="pagetitle">


        </div><!-- End Page Title -->

        <section class="section" >
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            
                           <div class="d-flex justify-content-end align-items-center mb-3" style="margin-top: 20px;">
                  <!-- 버튼 그룹 -->
                  <div class="button-group">
                  
                    <button type="button" class="btn btn-outline-primary btn-sm">수정</button>
                    <button type="button" class="btn btn-outline-danger btn-sm">삭제</button>
                  </div>
                </div>

                            <table class="table table-bordered" style="margin-top: 30px;">
                                                  
                                <tr>
                                    <td >제목</td>
                                    <td> 
                                        <span class="textBox">
                                        <span>${b.boardTitle}</span>
                                    </span></td>
                                </tr>
                               <tr class="attach">
                                    <td class="topic">첨부파일</td>
                                    <td><input type="file"></td>
                                </tr>
                        
                                
                                <tr>
                                    <td>내용</td>
                                    <td ><form method="post">
                                        <p>${b.boardContent}</p>
                                         </form>
                                    </td>   
                                </tr>
                               
                              </tbody>
                            </table>
                           

                        </div>
                    </div>



                </div>
            </div>
        </section>
        
   
</body>
</html>