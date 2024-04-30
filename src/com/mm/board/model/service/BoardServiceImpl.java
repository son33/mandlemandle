package com.mm.board.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mm.attachment.model.vo.Attachment;
import com.mm.board.model.dao.BoardDao;
import com.mm.board.model.vo.Board;
import com.mm.board.model.vo.BoardDivide;
import com.mm.board.model.vo.Reply;
import com.mm.common.model.vo.PageInfo;
import com.mm.common.template.Template;

public class BoardServiceImpl implements BoardService {
	BoardDao boardDao = new BoardDao();
//	커뮤니티 메인 보드 페이징
	@Override
	public int selectListCount(int boardDivideNo) {
		SqlSession session = Template.getSqlSession();
		int selectListCount = boardDao.selectListCount(session, boardDivideNo);
		session.close();
		return selectListCount;
	}
//	커뮤니티 메인 보드 리스트
	@Override
	public ArrayList<Board> selectList(PageInfo pi, String condition, int BoardDivideNo) {
		SqlSession session = Template.getSqlSession();
		ArrayList<Board> selectList = boardDao.selectList(session, pi, condition, BoardDivideNo);
		session.close();
		return selectList;
	}
//	게시글 조회수 증가
	@Override
	public int countList(int boardNo) {
		SqlSession session = Template.getSqlSession();
		int result = boardDao.countList(session, boardNo);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
//	커뮤니티 보드 작성
	@Override
	public int insertBoard(Board board, Attachment attachment) {
		SqlSession session = Template.getSqlSession();
		int result1 = boardDao.insertBoard(session, board);
		int result2 = 1;
		if (attachment != null) {
			result2 = new BoardDao().insertAttachment(session, attachment);
		}
		if (result1 > 0 && result2 > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result1 * result2;
	}
	@Override
	public int insertBoard(Board board) {
		SqlSession session = Template.getSqlSession();
		int result = boardDao.insertBoard(session, board);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
//	커뮤니티 게시글 조회
	@Override
	public Board searchBoard(int boardNo) {
		SqlSession session = Template.getSqlSession();
		Board b = boardDao.searchBoard(session, boardNo);
		session.close();
		return b;
	}
//	커뮤니티 댓글 작성
	public int insertReply(Reply reply) {
		SqlSession session = Template.getSqlSession();
		int result = boardDao.insertReply(session, reply);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
//	커뮤니티 댓글 조회
	@Override
	public ArrayList<Reply> selectReply(int boardNo) {
		SqlSession session = Template.getSqlSession();
		ArrayList<Reply> list = boardDao.selectReply(session, boardNo);
		session.close();
		return list;
	}
//	커뮤니티 댓글 삭제
	@Override
	public int deleteReply(int replyNo) {
		SqlSession session = Template.getSqlSession();
		int result = boardDao.deleteReply(session, replyNo);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
//	게시글 구분 조회
	@Override
	public ArrayList<BoardDivide> selectBoardDivideList() {
		SqlSession session = Template.getSqlSession();
		ArrayList<BoardDivide> list = boardDao.selectBoardDivideList(session);
		session.close();
		return list;
	}
//	게시글 업데이트
	@Override
	public int updateBoard(Board b) {
		SqlSession session = Template.getSqlSession();
		int result = boardDao.updateBoard(session, b);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
//	게시글 삭제
	@Override
	public int deleteBoard(int boardNo) {
		SqlSession session = Template.getSqlSession();
		int result = boardDao.deleteBoard(session, boardNo);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
	@Override
	public int deleteBoardAndReply(int boardNo) {
		SqlSession session = Template.getSqlSession();
		int result1 = boardDao.deleteBoard(session, boardNo);
		int result2 = boardDao.deleteReplyList(session, boardNo);
		int result = result1 * result2;
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
//	본인 작성 글 불러오기
	@Override
	public ArrayList<Board> getCommunityBoardList(int userNo) {
		SqlSession session = Template.getSqlSession();
		ArrayList<Board> boardList = boardDao.selectBoardList(session, userNo);
		session.close();
		return boardList;
	}
	@Override
	public ArrayList<Reply> getCommunityReplyList(int userNo) {
		SqlSession session = Template.getSqlSession();
		ArrayList<Reply> replyList = boardDao.selectReplyList(session, userNo);
		session.close();
		return replyList;
	}
}