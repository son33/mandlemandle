package com.mm.board.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int count;
	private Date createDate;
	private Date modifyDate;
	private String status;
	private int userNo;
	private int boardDivideNo;
//	게시글 조회
	private String userName;
	private String boardDivideName;
//	댓글 수 확인
	private int replyCount;
}
