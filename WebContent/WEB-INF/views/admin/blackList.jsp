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
      <h1>블랙리스트</h1>
      <div class="datatable-search" style="margin-top: 10px;">
        <input class="datatable-input" placeholder="Search..." type="search" title="Search within table">
      </div>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <!-- <h5 class="card-title">Datatables</h5>
                <p>Add lightweight datatables to your project with using the <a href="https://github.com/fiduswriter/Simple-DataTables" target="_blank">Simple DataTables</a> library. Just add <code>.datatable</code> class name to any table you wish to conver to a datatable. Check for <a href="https://fiduswriter.github.io/simple-datatables/demos/" target="_blank">more examples</a>.</p> -->

              <!-- Table with stripped rows -->
              <div class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
                <div class="datatable-top">
                  <div class="datatable-dropdown">
                   
                    <label>
                      <select class="datatable-selector">
                        <option value="5">5</option>
                        <option value="10" selected="">10</option>
                        <option value="15">15</option>
                        <option value="-1">All</option>
                      </select> entries per page
                    </label>
                  </div>
                  
                  <div class="delete-btn" >
                    <button type="button" class="btn btn-outline-danger btn-sm">회원복구</button>
                  </div>
                </div>
                <div class="datatable-container">
                    <table class="table table-hover datatable datatable-table">
                        <thead>
                          <tr>
                            <th data-sortable="true" style="width: 5%;">
                              <b>선택</b>
                            </th>
                            <th data-sortable="true" style="width: 15%;"><button class="datatable-sorter">
                                <b>이메일</b>
                              </button></th>
                            <th data-sortable="true" style="width: 50%;"><button
                                class="datatable-sorter">사유</button></th>
                            <th data-sortable="true" style="width:15%;"><button
                                  class="datatable-sorter">설정날짜</button></th>    
                            <th data-sortable="true" style="width: 10%;"><button
                                class="datatable-sorter">상세보기</button></th>
                          </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="m" items="${list}">
                          <tr data-index="0">
                            <td><input type="checkbox" name="" id=""></td>
                            <td>${m.email}</td>
                            <td>신고사유를 입력하세요 칼럼 만들기</td>
                            <td>${m.modifyDate}</td>
                            <td><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalDialogScrollable">회원정보</button></td>
                            
                          </tr>
                        </c:forEach>
    
                        </tbody>
                      </table>
                </div>
                <div class="datatable-bottom">
                  <div class="datatable-info">Showing 1 to 10 entries</div>
                  <nav class="datatable-pagination">
                    <ul class="datatable-pagination-list">
                      <li class="datatable-pagination-list-item datatable-hidden datatable-disabled"><button
                          data-page="1" class="datatable-pagination-list-item-link" aria-label="Page 1">‹</button></li>
                      <li class="datatable-pagination-list-item datatable-active"><button data-page="1"
                          class="datatable-pagination-list-item-link" aria-label="Page 1">1</button></li>
                      <li class="datatable-pagination-list-item"><button data-page="2"
                          class="datatable-pagination-list-item-link" aria-label="Page 2">2</button></li>
                      <li class="datatable-pagination-list-item"><button data-page="3"
                          class="datatable-pagination-list-item-link" aria-label="Page 3">3</button></li>
                      <li class="datatable-pagination-list-item"><button data-page="4"
                          class="datatable-pagination-list-item-link" aria-label="Page 4">4</button></li>
                      <li class="datatable-pagination-list-item"><button data-page="5"
                          class="datatable-pagination-list-item-link" aria-label="Page 5">5</button></li>
                      <li class="datatable-pagination-list-item"><button data-page="6"
                          class="datatable-pagination-list-item-link" aria-label="Page 6">6</button></li>
                      <li class="datatable-pagination-list-item"><button data-page="7"
                          class="datatable-pagination-list-item-link" aria-label="Page 7">7</button></li>
                      <li class="datatable-pagination-list-item datatable-ellipsis datatable-disabled"><button
                          class="datatable-pagination-list-item-link">…</button></li>
                      <li class="datatable-pagination-list-item"><button data-page="10"
                          class="datatable-pagination-list-item-link" aria-label="Page 10">10</button></li>
                      <li class="datatable-pagination-list-item"><button data-page="2"
                          class="datatable-pagination-list-item-link" aria-label="Page 2">›</button></li>
                    </ul>
                  </nav>
                </div>
              </div>
              <!-- End Table with stripped rows -->

            </div>
          </div>

        </div>
      </div>
    </section>
</body>
</html>