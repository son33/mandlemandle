package com.mm.board.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class Reply {
	private int replyNo;
	private String replyContent;
	private Date createDate;
	private Date modifyDate;
	private String status;
	private int userNo;
	private int boardNo;
//	게시글 댓글 조회
	private String userName;
	
	
	private String boardDivideName;
	private int boardDivideNo;
}
