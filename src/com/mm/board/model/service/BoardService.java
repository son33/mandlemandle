package com.mm.board.model.service;

import java.util.ArrayList;

import com.mm.attachment.model.vo.Attachment;
import com.mm.board.model.vo.Board;
import com.mm.board.model.vo.BoardDivide;
import com.mm.board.model.vo.Reply;
import com.mm.common.model.vo.PageInfo;

public interface BoardService {
//	페이징
	int selectListCount(int boardDivideNo);
//	커뮤니티 메인 페이징
	ArrayList<Board> selectList(PageInfo pi, String condition, int boardDivideNo);
//	게시글 조회수 증가
	int countList(int boardNo);
//	보드 작성
	int insertBoard(Board board, Attachment attachment);
	int insertBoard(Board board);
//	게시글 상세 조회
	Board searchBoard(int boardNo);
//	게시글 댓글 작성
	int insertReply(Reply reply);
//	게시글 댓글 조회
	ArrayList<Reply> selectReply(int boardNo);
//	게시글 댓글 삭제
	int deleteReply(int replyNo);
//	게시글 구분 조회
	ArrayList<BoardDivide> selectBoardDivideList();
//	게시글 업데이트
	int updateBoard(Board b);
//	게시글 삭제
	int deleteBoard(int boardNo);
	int deleteBoardAndReply(int boardNo);
//	본인 작성 글 / 댓글 불러오기
	ArrayList<Board> getCommunityBoardList(int userNo);
	ArrayList<Reply> getCommunityReplyList(int userNo);
}