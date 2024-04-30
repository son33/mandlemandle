package com.mm.admin.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mm.attachment.model.vo.Attachment;
import com.mm.board.model.vo.Board;
import com.mm.board.model.vo.Reply;
import com.mm.common.model.vo.PageInfo;
import com.mm.member.model.vo.Member;
import com.mm.portfolio.model.vo.Review;
import com.mm.report.model.vo.Report;


public class adminBoardDao {

	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("adminMapper.selectSearchCount",map);
	}

	public ArrayList<Member> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Member> (sqlSession.selectList("adminMapper.selectSearchList",map,rowBounds));
	}

	public int selectSearchCount2(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("adminMapper.selectSearchCount2",map);
	}

	public ArrayList<Member> selectSearchList2(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Member> (sqlSession.selectList("adminMapper.selectSearchList2",map,rowBounds));
	}
	//공지리스트
	public int selectNoticeSearchCount3(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("adminMapper.selectNoticeSearchCount3",map);
	}

	public int selectNoticeCount(SqlSession sqlSession) {
		return sqlSession.selectOne("adminMapper.selectNoticeCount");
	}

	public ArrayList<Board> selectNoticeSearchList3(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Board> (sqlSession.selectList("adminMapper.selectNoticeSearchList3",map,rowBounds));
	}

	public ArrayList<Board> selectNotice(SqlSession sqlSession, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Board> (sqlSession.selectList("adminMapper.selectNotice",null,rowBounds));
		
	}

	public Board selectNoticeDetail(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("adminMapper.selectNoticeDetail",boardNo);
	}

	public int deleteNotice(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("adminMapper.deleteNotice",boardNo);
	}

	public int noticeInsert(SqlSession sqlSession, Board b) {
		return sqlSession.insert("adminMapper.noticeInsert",b);
	}

	public int AttachmentNoticeInsert(SqlSession sqlSession, Attachment at) {
		return sqlSession.insert("adminMapper.AttachmentNoticeInsert",at);
	}

	public Attachment selectNoticeFile(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("adminMapper.selectNoticeFile",boardNo);
	}

	public int updateNotice(SqlSession sqlSession, Board b) {
		return sqlSession.update("adminMapper.updateNotice",b);
	}

	public int updateAttachment(SqlSession sqlSession, Attachment at) {
		return sqlSession.update("adminMapper.updateAttachment",at);
	}

	public int insertNewAttachment(SqlSession sqlSession, Attachment at) {
		return sqlSession.insert("adminMapper.insertNewAttachment",at);
	}
//FAQList
	public ArrayList<Board> selectFAQList(SqlSession sqlSession) {
		return new ArrayList<Board> (sqlSession.selectList("adminMapper.selectFAQList"));
	}
//커뮤니티 리스트
	public int selectcommunitySearchCount3(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("adminMapper.selectcommunitySearchCount3",map);
	}

	public int selectCommunityCount(SqlSession sqlSession) {
		return sqlSession.selectOne("adminMapper.selectCommunityCount");
	}

	public ArrayList<Board> selectCommunitySearchList3(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Board> (sqlSession.selectList("adminMapper.selectCommunitySearchList3",map,rowBounds));
	}

	public ArrayList<Board> selectCommunity(SqlSession sqlSession, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Board> (sqlSession.selectList("adminMapper.selectCommunity",null,rowBounds));
	}
//커뮤니티 상세보기
	public Board selectCommunityDetail(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("adminMapper.selectCommunityDetail",boardNo);
	}

	public Attachment selectCommunityFile(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("adminMapper.selectCommunityFile",boardNo);
	}
//리뷰 리스트
	public int selectreviewSearchCount3(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("adminMapper.selectreviewSearchCount3",map);
	}

	public int selectReviewCount(SqlSession sqlSession) {
		return sqlSession.selectOne("adminMapper.selectReviewCount");
	}

	public ArrayList<Review> selectReviewSearchList3(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Review> (sqlSession.selectList("adminMapper.selectReviewSearchList3",map,rowBounds));
	}

	public ArrayList<Review> selectReview(SqlSession sqlSession, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Review> (sqlSession.selectList("adminMapper.selectReview",null,rowBounds));
	}
	//리뷰 상세
	public Review selectReviewDetail(SqlSession sqlSession, int reviewNo) {
		return sqlSession.selectOne("adminMapper.selectReviewDetail",reviewNo);
	}

	public Attachment selectReviewFile(SqlSession sqlSession, int reviewNo) {
		return sqlSession.selectOne("adminMapper.selectReviewFile",reviewNo);
	}
    //리뷰 삭제
	public int deleteReview(SqlSession sqlSession, int reviewNo) {
		return sqlSession.update("adminMapper.deleteReview",reviewNo);
	}
    //댓글 리스트
	public int selectreplySearchCount3(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("adminMapper.selectreplySearchCount3",map);
	}

	public int selectReplyCount(SqlSession sqlSession) {
		return sqlSession.selectOne("adminMapper.selectReplyCount");
	}

	public ArrayList<Reply> selectreplySearchList3(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Reply> (sqlSession.selectList("adminMapper.selectreplySearchList3",map,rowBounds));
	}

	public ArrayList<Reply> selectReply(SqlSession sqlSession, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Reply> (sqlSession.selectList("adminMapper.selectReply",null,rowBounds));
	}
//댓글 삭제
	public int deleteReply(SqlSession sqlSession, int replyNo) {
		return sqlSession.update("adminMapper.deleteReply",replyNo);
	}
//FAQ등록
	
	public int FAQInsert(SqlSession sqlSession, Board b) {
		return sqlSession.insert("adminMapper.FAQInsert",b);
	}

	public int AttachmentFAQInsert(SqlSession sqlSession, Attachment at) {
		return sqlSession.insert("adminMapper.AttachmentFAQInsert",at);
	}
    //신고내역
	//커뮤니티신고리스트
	public int selectReplyBoardSearchCount3(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("adminMapper.selectReplyBoardSearchCount3",map);
	}

	public int selectReplyBoardCount(SqlSession sqlSession) {
		return sqlSession.selectOne("adminMapper.selectReplyBoardCount");
	}

	public ArrayList<Report> selectReplyBoardSearchList3(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Report> (sqlSession.selectList("adminMapper.selectReplyBoardSearchList3",map,rowBounds));
	}

	public ArrayList<Report> selectReplyBoard(SqlSession sqlSession, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Report> (sqlSession.selectList("adminMapper.selectReplyBoard",null,rowBounds));
	}
//신고내역 커뮤상세
	public Board selectReportBoardDetail(SqlSession sqlSession, int refBno) {
		return sqlSession.selectOne("adminMapper.selectReportBoardDetail",refBno);
	}

	public Attachment selectReportBoardFile(SqlSession sqlSession, int refBno) {
		return sqlSession.selectOne("adminMapper.selectReportBoardFile",refBno);
	}
//신고내역 커뮤니티 확인 목록지우기
	public int deleteReportCommunity(SqlSession sqlSession, int reportNo) {
		return sqlSession.update("adminMapper.deleteReportCommunity",reportNo);
	}
	//신고내역 게시글 목록 둘다 지우기
	public int deleteReportList(SqlSession sqlSession, int reportNo) {
		return sqlSession.update("adminMapper.deleteReportList",reportNo);
	}

	public int deleteBoardReport(SqlSession sqlSession, int refBno) {
		return sqlSession.update("adminMapper.deleteBoardReport",refBno);
	}
	//리뷰 신고내역 리스트

	public int selectReportReviewSearchCount3(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("adminMapper.selectReportReviewSearchCount3",map);
	}

	public int selectReportReviewCount(SqlSession sqlSession) {
		return sqlSession.selectOne("adminMapper.selectReportReviewCount");
	}

	public ArrayList<Report> selectReportReviewSearchList3(SqlSession sqlSession, HashMap<String, String> map,
			PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Report> (sqlSession.selectList("adminMapper.selectReportReviewSearchList3",map,rowBounds));
	}

	public ArrayList<Report> selectReportReviewBoard(SqlSession sqlSession, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Report>(sqlSession.selectList("adminMapper.selectReportReviewBoard",null,rowBounds));
	}
//리뷰신고상세보기
	public Review selectReportReviewDetail(SqlSession sqlSession, int refBno) {
		return sqlSession.selectOne("adminMapper.selectReportReviewDetail",refBno);
	}

	public Attachment selectReportReviewFile(SqlSession sqlSession, int refBno) {
		return sqlSession.selectOne("adminMapper.selectReportReviewFile",refBno);
	}
   //리뷰신고상세삭제
	public int deleteReviewReport(SqlSession sqlSession, int refBno) {
		return sqlSession.update("adminMapper.deleteReviewReport",refBno);
	}
	//댓글 신고 리스트

	public int selectReportReplySearchCount3(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("adminMapper.selectReportReplySearchCount3",map);
	}

	public int selectReportReplyCount(SqlSession sqlSession) {
		return sqlSession.selectOne("adminMapper.selectReportReplyCount");
	}

	public ArrayList<Report> selectReportReplySearchList3(SqlSession sqlSession, HashMap<String, String> map,
			PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Report> (sqlSession.selectList("adminMapper.selectReportReplySearchList3",map,rowBounds));
	}

	public ArrayList<Report> selectReportReplyBoard(SqlSession sqlSession, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Report> (sqlSession.selectList("adminMapper.selectReportReplyBoard",null,rowBounds));
	}
//신고댓글상세보기
	public Reply selectReportReplyDetail(SqlSession sqlSession, int replyNo) {
	return sqlSession.selectOne("adminMapper.selectReportReplyDetail",replyNo);
	}

	public int deleteReplyReport(SqlSession sqlSession, int replyNo) {
		return sqlSession.update("adminMapper.deleteReplyReport",replyNo);
	}
}