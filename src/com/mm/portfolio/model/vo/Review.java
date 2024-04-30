package com.mm.portfolio.model.vo;

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
public class Review {
	private int reviewNo;
	private String reviewTitle;
	private String reviewContent;
	private Date createDate;
	private Date modifyDate;
	private String status;
	private int refPno;
	private int userNo;
	private int score;
	private String userName;
	private String boardDivideName;
	private int count;
	
//	메인페이지 실시간 리뷰
	private String mtoName;
	private String mteName;
	private String subCategoryName;
	private String changeName;
}
