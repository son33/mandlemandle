package com.mm.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.mm.attachment.model.vo.Attachment;
import com.mm.board.model.vo.Board;
import com.mm.board.model.vo.Reply;
import com.mm.common.model.vo.PageInfo;
import com.mm.member.model.vo.Member;
import com.mm.portfolio.model.vo.Review;
import com.mm.report.model.vo.Report;

public interface adminBoardService {

//--멘토리스트
	ArrayList<Member> selectSearchList(HashMap<String, String> map, PageInfo pi);

	int selectSearchCount(HashMap<String, String> map);
//멘티리스트
	int selectSearchCount2(HashMap<String, String> map);

	ArrayList<Member> selectSearchList2(HashMap<String, String> map, PageInfo pi);
//공지리스트
	int selectNoticeSearchCount3(HashMap<String, String> map);

	int selectNoticeCount();

	ArrayList<Board> selectNoticeSearchList3(HashMap<String, String> map, PageInfo pi);

	ArrayList<Board> selectNotice(PageInfo pi);

	Board selectNoticeDetail(int boardNo);

	int deleteNotice(int boardNo);
//공지 등록
	int noticeInsert(Board b, Attachment at);

	Attachment selectNoticeFile(int boardNo);

	int updateNotice(Board b, Attachment at);
//FAQ
	ArrayList<Board> selectFAQList();

	int selectcommunitySearchCount3(HashMap<String, String> map);

	int selectCommunityCount();

	ArrayList<Board> selectCommunitySearchList3(HashMap<String, String> map, PageInfo pi);

	ArrayList<Board> selectCommunity(PageInfo pi);

	Board selectCommunityDetail(int boardNo);

	Attachment selectCommunityFile(int boardNo);

	int selectreviewSearchCount3(HashMap<String, String> map);

	int selectReviewCount();

	ArrayList<Review> selectReviewSearchList3(HashMap<String, String> map, PageInfo pi);

	ArrayList<Review> selectReview(PageInfo pi);

	Review selectReviewDetail(int reviewNo);

	Attachment selectReviewFile(int reviewNo);

	int deleteReview(int reviewNo);

	int selectreplySearchCount3(HashMap<String, String> map);

	int selectReplyCount();

	ArrayList<Reply> selectreplySearchList3(HashMap<String, String> map, PageInfo pi);

	ArrayList<Reply> selectReply(PageInfo pi);

	int deleteReply(int replyNo);

	int FAQInsert(Board b, Attachment at);

	int selectReplyBoardSearchCount3(HashMap<String, String> map);

	int selectReplyBoardCount();

	ArrayList<Report> selectReplyBoardSearchList3(HashMap<String, String> map, PageInfo pi);

	ArrayList<Report> selectReplyBoard(PageInfo pi);

	Board selectReportBoardDetail(int refBno);

	Attachment selectReportBoardFile(int refBno);

	int deleteReportCommunity(int reportNo);

	int deleteReportList(int reportNo);

	int deleteBoardReport(int refBno);

	int selectReportReviewSearchCount3(HashMap<String, String> map);

	int selectReportReviewCount();

	ArrayList<Report> selectReportReviewSearchList3(HashMap<String, String> map, PageInfo pi);

	ArrayList<Report> selectReportReviewBoard(PageInfo pi);

	Review selectReportReviewDetail(int refBno);

	Attachment selectReportReviewFile(int refBno);

	int deleteReviewReport(int refBno);

	int selectReportReplySearchCount3(HashMap<String, String> map);

	int selectReportReplyCount();

	ArrayList<Report> selectReportReplySearchList3(HashMap<String, String> map, PageInfo pi);

	ArrayList<Report> selectReportReplyBoard(PageInfo pi);

	Reply selectReportReplyDetail(int replyNo);

	int deleteReplyReport(int replyNo);
}