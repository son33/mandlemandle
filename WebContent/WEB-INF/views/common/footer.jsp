<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mm.member.model.vo.Member"%>
<!DOCTYPE html>
<html lang="ko">
     <!-- footer -->
     <footer>
        <div class="footArea">
            <div class="info">
                <ul class="infoList">
                    <li>
                        <ul class="l2">
                            <li>맨들맨들은 통신판매중개자로서 통신판매의 당사자가 아니며 개별 판매자가 제공하는 서비스에 대한 이행, 계약사항 등과 관련한 의무와 책임은 거래당사자에게 있습니다.</li>
                            <li>상호명:(주)맨들맨들 · 대표 : 오정연 · 개인정보책임관리자 : 오정연 · 주소: 서울특별시 강남구 테헤란로14길 6 남도빌딩</li>
                            <li>사업자등록번호:***-**-***** · 통신판매업신고증:제 ****-서울강남-***** 호 · 직업정보제공사업 신고번호:서울청 제 ****-**호</li>
                            <li>고객센터:****-**** · 이메일 : kiteflying@mandlemandle.com</li>
                            <li>Copyright ©mandlemandle All Rights Reserved.</li>
                        </ul>
                    </li>
                    <li>
                        <ul class="l1">
                            <li><a href="<%= request.getContextPath() %>/introduce">맨들맨들 소개</a></li>
                            <li><a href="<%= request.getContextPath() %>/community?divide=60">이용방법</a></li>
                            <li><a href="<%= request.getContextPath() %>/community?divide=60">고객센터</a></li>
                            <li><a href="<%= request.getContextPath() %>/community?boardNo=1">커뮤니티</a></li>
                            <li><a href="<%= request.getContextPath() %>/community?divide=10">공지사항</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </footer>
</html>