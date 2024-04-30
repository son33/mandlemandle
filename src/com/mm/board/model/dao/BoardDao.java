package com.mm.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mm.attachment.model.vo.Attachment;
import com.mm.board.model.vo.Board;
import com.mm.board.model.vo.BoardDivide;
import com.mm.board.model.vo.Reply;
import com.mm.common.model.vo.PageInfo;

public class BoardDao {
	
	public int selectListCount(SqlSession session, int boardDivideNo) {
		return session.selectOne("boardMapper.selectListCount",boardDivideNo);
	}
	
	public int countList(SqlSession session, int boardNo) {
		int result = session.update("boardMapper.countList",boardNo);
		return result;
	}
	
	public ArrayList<Board> selectList(SqlSession session, PageInfo pi, String condition, int boardDivideNo) {
		int limit = pi.getBoardLimit();
	    int offset = (pi.getCurrentPage()-1) * limit;
	    RowBounds rowBounds = new RowBounds(offset, limit);
	    
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("condition", condition);
		paramMap.put("boardDivideNo", boardDivideNo);

		return new ArrayList<>(session.selectList("boardMapper.selectList", paramMap, rowBounds));
	}
	
	public int insertBoard(SqlSession session, Board board) {
		return session.insert("boardMapper.insertBoard",board);
	}
	
	public Board searchBoard(SqlSession session, int boardNo) {
		return session.selectOne("boardMapper.searchBoard", boardNo);
	}
	
	public int insertReply(SqlSession session, Reply reply) {
		return session.insert("boardMapper.insertReply",reply);
	}
	
	public ArrayList<Reply> selectReply(SqlSession session, int boardNo) {
		return new ArrayList<Reply> (session.selectList("boardMapper.selectReply", boardNo));
	}
	
	public int deleteReply(SqlSession session, int replyNo) {
		return session.update("boardMapper.deleteReply",replyNo);
	}
	
	public ArrayList<BoardDivide> selectBoardDivideList(SqlSession session) {
		return new ArrayList<BoardDivide> (session.selectList("boardMapper.selectBoardDivideList"));
	}
	
	public int updateBoard(SqlSession session, Board b) {
		return session.update("boardMapper.updateBoard", b);
	}
	
	public int deleteBoard(SqlSession session, int boardNo) {
		return session.update("boardMapper.deleteBoard", boardNo);
	}
	public int deleteReplyList(SqlSession session, int boardNo) {
		return session.update("boardMapper.deleteReplyList",boardNo);
	}
	
	public ArrayList<Board> selectBoardList(SqlSession session, int userNo) {
		return new ArrayList<Board> (session.selectList("boardMapper.selectBoardList",userNo));
	}

	public ArrayList<Reply> selectReplyList(SqlSession session, int userNo) {
		return new ArrayList<Reply> (session.selectList("boardMapper.selectReplyList",userNo));
	}

	public int insertAttachment(SqlSession session, Attachment attachment) {
		return 1;
	}
}
