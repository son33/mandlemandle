package com.mm.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.mm.admin.model.dao.adminBoardDao;
import com.mm.attachment.model.vo.Attachment;
import com.mm.board.model.vo.Board;
import com.mm.board.model.vo.Reply;
import com.mm.common.model.vo.PageInfo;
import com.mm.common.template.Template;
import com.mm.member.model.vo.Member;
import com.mm.portfolio.model.vo.Review;
import com.mm.report.model.vo.Report;

public class adminBoardServiceImpl implements adminBoardService {
	private adminBoardDao boardDao = new adminBoardDao();
	
//	<!--멘토 -->
	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int searchCount = boardDao.selectSearchCount(sqlSession,map);
		sqlSession.close();
		return searchCount;
	}
	@Override
	public ArrayList<Member> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Member> list = boardDao.selectSearchList(sqlSession,map,pi);
		sqlSession.close();
		return list;
	}
//<---멘티-->
	@Override
	public int selectSearchCount2(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int searchCount = boardDao.selectSearchCount2(sqlSession,map);
		sqlSession.close();
		return searchCount;
	}
	@Override
	public ArrayList<Member> selectSearchList2(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Member> list = boardDao.selectSearchList2(sqlSession,map,pi);
		sqlSession.close();
		return list;
	}
//공지리스트
	@Override
	public int selectNoticeSearchCount3(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int searchCount = boardDao.selectNoticeSearchCount3(sqlSession,map);
		sqlSession.close();
		return searchCount;
	}
	@Override
	public int selectNoticeCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = boardDao.selectNoticeCount(sqlSession);
		sqlSession.close();
		return listCount;
	}
	@Override
	public ArrayList<Board> selectNoticeSearchList3(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = boardDao.selectNoticeSearchList3(sqlSession,map,pi);
		sqlSession.close();
		return list;
	}
	@Override
	public ArrayList<Board> selectNotice(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = boardDao.selectNotice(sqlSession,pi);
		sqlSession.close();
		return list;
	}
	@Override
	public Board selectNoticeDetail(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		Board b = boardDao.selectNoticeDetail(sqlSession,boardNo);
		sqlSession.close();
		return b;
		
	}
	@Override
	public Attachment selectNoticeFile(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		Attachment at = boardDao.selectNoticeFile(sqlSession,boardNo);
		sqlSession.close();
		return at;
	}
	//공지 삭제
	@Override
	public int deleteNotice(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = boardDao.deleteNotice(sqlSession,boardNo);
		if(result > 0) sqlSession.commit();
		else sqlSession.rollback();
		sqlSession.close();
		return result;
	}
	//공지 작성
	@Override
	public int noticeInsert(Board b, Attachment at) {
		SqlSession sqlSession = Template.getSqlSession();
		int result1 = boardDao.noticeInsert(sqlSession,b);
		int result2 = 1;
		if(at !=null) {
			result2 = boardDao.AttachmentNoticeInsert(sqlSession,at);
		}
		if(result1 > 0 && result2 > 0) sqlSession.commit();
		else sqlSession.rollback();
		sqlSession.close();
		return result1 * result2;
	}
	//공지수정
	@Override
	public int updateNotice(Board b, Attachment at) {
		SqlSession sqlSession = Template.getSqlSession();
		int result1 = boardDao.updateNotice(sqlSession,b);
		int result2 = 1;
		if(at!=null) {
			if(at.getFileNo()!= 0) {
				result2=boardDao.updateAttachment(sqlSession,at);
			}else {
				result2 = boardDao.insertNewAttachment(sqlSession,at);
			}
		}
		if(result1 > 0 && result2 > 0) sqlSession.commit();
		else sqlSession.rollback(); 
		sqlSession.close();
		return result1 * result2;
	}
	//FAQ 리스트
	@Override
	public ArrayList<Board> selectFAQList() {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = boardDao.selectFAQList(sqlSession);
		sqlSession.close();
		return list;
	}
	//커뮤니티 리스트
	@Override
	public int selectcommunitySearchCount3(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int searchCount = boardDao.selectcommunitySearchCount3(sqlSession,map);
		sqlSession.close();
		return searchCount;
	}
	@Override
	public int selectCommunityCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = boardDao.selectCommunityCount(sqlSession);
		sqlSession.close();
		return listCount;
	}
	@Override
	public ArrayList<Board> selectCommunitySearchList3(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = boardDao.selectCommunitySearchList3(sqlSession,map,pi);
		sqlSession.close();
		return list;
	}
	@Override
	public ArrayList<Board> selectCommunity(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = boardDao.selectCommunity(sqlSession,pi);
		sqlSession.close();
		return list;
	}
	//커뮤니티 상세
	@Override
	public Board selectCommunityDetail(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		Board b = boardDao.selectCommunityDetail(sqlSession,boardNo);
		sqlSession.close();
		return b;
	}
	@Override
	public Attachment selectCommunityFile(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		Attachment at = boardDao.selectCommunityFile(sqlSession,boardNo);
		sqlSession.close();
		return at;
	}
	//리뷰 리스트
	@Override
	public int selectreviewSearchCount3(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int searchCount = boardDao.selectreviewSearchCount3(sqlSession,map);
		sqlSession.close();
		return searchCount;
	}
	@Override
	public int selectReviewCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = boardDao.selectReviewCount(sqlSession);
		sqlSession.close();
		return listCount;
	}
	@Override
	public ArrayList<Review> selectReviewSearchList3(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Review> list = boardDao.selectReviewSearchList3(sqlSession,map,pi);
		sqlSession.close();
		return list;
	}
	@Override
	public ArrayList<Review> selectReview(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Review> list = boardDao.selectReview(sqlSession,pi);
		sqlSession.close();
		return list;
	}
	//리뷰 상세
	@Override
	public Review selectReviewDetail(int reviewNo) {
		SqlSession sqlSession = Template.getSqlSession();
		Review r = boardDao.selectReviewDetail(sqlSession,reviewNo);
		sqlSession.close();
		return r;
	}
	@Override
	public Attachment selectReviewFile(int reviewNo) {
		SqlSession sqlSession = Template.getSqlSession();
		Attachment at = boardDao.selectReviewFile(sqlSession,reviewNo);
		sqlSession.close();
		return at;
	}
	//리뷰 삭제
	@Override
	public int deleteReview(int reviewNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = boardDao.deleteReview(sqlSession,reviewNo);
		if(result > 0) sqlSession.commit();
		else sqlSession.rollback();
		sqlSession.close();
		return result;
	}
	//댓글 리스트
	@Override
	public int selectreplySearchCount3(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int searchCount = boardDao.selectreplySearchCount3(sqlSession,map);
		sqlSession.close();
		return searchCount;
	}
	@Override
	public int selectReplyCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = boardDao.selectReplyCount(sqlSession);
		sqlSession.close();
		return listCount;
	}
	@Override
	public ArrayList<Reply> selectreplySearchList3(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Reply> list = boardDao.selectreplySearchList3(sqlSession,map,pi);
		sqlSession.close();
		return list;
	}
	@Override
	public ArrayList<Reply> selectReply(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Reply> list = boardDao.selectReply(sqlSession,pi);
		sqlSession.close();
		return list;
	}
	//댓글 참조상세
	//CommunityDetail로 넘김
	//댓글 삭제
	@Override
	public int deleteReply(int replyNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = boardDao.deleteReply(sqlSession,replyNo);
		if(result > 0) sqlSession.commit();
		else sqlSession.rollback();
		sqlSession.close();
		return result;
	}
	//FAQ 등록
	@Override
	public int FAQInsert(Board b, Attachment at) {
		SqlSession sqlSession = Template.getSqlSession();
		int result1 = boardDao.FAQInsert(sqlSession,b);
		int result2 = 1;
		if(at !=null) {
			result2 = boardDao.AttachmentFAQInsert(sqlSession,at);
		}
		if(result1>0 && result2>0) sqlSession.commit();
		else sqlSession.rollback();
		sqlSession.close();
		return result1*result2;	
	}
	//신고내역
	//커뮤신고내역리스트
	@Override
	public int selectReplyBoardSearchCount3(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int searchCount = boardDao.selectReplyBoardSearchCount3(sqlSession,map);
		sqlSession.close();
		return searchCount;
	}
	@Override
	public int selectReplyBoardCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = boardDao.selectReplyBoardCount(sqlSession);
		sqlSession.close();
		return listCount;
	}
	@Override
	public ArrayList<Report> selectReplyBoardSearchList3(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Report> list = boardDao.selectReplyBoardSearchList3(sqlSession,map,pi);
		sqlSession.close();
		return list;
	}
	@Override
	public ArrayList<Report> selectReplyBoard(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Report> list = boardDao.selectReplyBoard(sqlSession,pi);
		sqlSession.close();
		return list;
	}
	//커뮤니티신고내역상세
	@Override
	public Board selectReportBoardDetail(int refBno) {
		SqlSession sqlSession = Template.getSqlSession();
		Board b = boardDao.selectReportBoardDetail(sqlSession,refBno);
		sqlSession.close();
		return b;
	}
	@Override
	public Attachment selectReportBoardFile(int refBno) {
		SqlSession sqlSession = Template.getSqlSession();
		Attachment at = boardDao.selectReportBoardFile(sqlSession,refBno);
		sqlSession.close();
		return at;
	}
	//신고 확인해서 목록지우기 공통
	@Override
	public int deleteReportCommunity(int reportNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = boardDao.deleteReportCommunity(sqlSession,reportNo);
		if(result > 0) sqlSession.commit();
		else sqlSession.rollback();
		sqlSession.close();
		return result;
	}
	//신고 커뮤상세삭제
	@Override
	public int deleteReportList(int reportNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result1 = boardDao.deleteReportList(sqlSession,reportNo);
		if(result1 > 0) sqlSession.commit();
		else sqlSession.rollback();
		sqlSession.close();
		return result1;
	}
	@Override
	public int deleteBoardReport(int refBno) {
		SqlSession sqlSession = Template.getSqlSession();
		int result2 = boardDao.deleteBoardReport(sqlSession,refBno);
		if(result2 > 0) sqlSession.commit();
		else sqlSession.rollback();
		sqlSession.close();
		return result2;
	}
	//리뷰신고리스트
	@Override
	public int selectReportReviewSearchCount3(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int searchCount = boardDao.selectReportReviewSearchCount3(sqlSession,map);
		sqlSession.close();
		return searchCount;
	}
	@Override
	public int selectReportReviewCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = boardDao.selectReportReviewCount(sqlSession);
		sqlSession.close();
		return listCount;
	}
	@Override
	public ArrayList<Report> selectReportReviewSearchList3(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Report> list = boardDao.selectReportReviewSearchList3(sqlSession,map,pi);
		sqlSession.close();
		return list;
	}
	@Override
	public ArrayList<Report> selectReportReviewBoard(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Report> list = boardDao.selectReportReviewBoard(sqlSession,pi);
		sqlSession.close();
		return list;
	}
	//리뷰신고상세보기
	@Override
	public Review selectReportReviewDetail(int refBno) {
		SqlSession sqlSession = Template.getSqlSession();
		Review b = boardDao.selectReportReviewDetail(sqlSession,refBno);
		sqlSession.close();
		return b;
	}
	@Override
	public Attachment selectReportReviewFile(int refBno) {
		SqlSession sqlSession = Template.getSqlSession();
		Attachment at = boardDao.selectReportReviewFile(sqlSession,refBno);
		sqlSession.close();
		return at;
	}
	//신고 리뷰 상세삭제
	@Override
	public int deleteReviewReport(int refBno) {
		SqlSession sqlSession = Template.getSqlSession();
		int result2 = boardDao.deleteReviewReport(sqlSession,refBno);
		if(result2 > 0) sqlSession.commit();
		else sqlSession.rollback();
		sqlSession.close();
		return result2;
	}
	//댓글 신고내역리스트
	@Override
	public int selectReportReplySearchCount3(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int searchCount = boardDao.selectReportReplySearchCount3(sqlSession,map);
		sqlSession.close();
		return searchCount;
	}
	@Override
	public int selectReportReplyCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = boardDao.selectReportReplyCount(sqlSession);
		sqlSession.close();
		return listCount;
	}
	@Override
	public ArrayList<Report> selectReportReplySearchList3(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Report> list = boardDao.selectReportReplySearchList3(sqlSession,map,pi);
		sqlSession.close();
		return list;
	}
	@Override
	public ArrayList<Report> selectReportReplyBoard(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Report> list = boardDao.selectReportReplyBoard(sqlSession,pi);
		sqlSession.close();
		return list;
	}
	//댓글 신고 상세
	@Override
	public Reply selectReportReplyDetail(int replyNo) {
		SqlSession sqlSession = Template.getSqlSession();
		Reply b = boardDao.selectReportReplyDetail(sqlSession,replyNo);
		sqlSession.close();
		return b;
	}
	//신고된댓글삭제
	@Override
	public int deleteReplyReport(int replyNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result2 = boardDao.deleteReplyReport(sqlSession,replyNo);
		if(result2 > 0) sqlSession.commit();
		else sqlSession.rollback();
		sqlSession.close();
		return result2;
	}
}