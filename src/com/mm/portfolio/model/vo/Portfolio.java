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
public class Portfolio {
	private int ptfNo;
	private String introduce;
	private String ptfContent;
	private int sigunguNo;
	private Date createDate;
	private Date modifyDate;
	private String status;
	private int mtoNo;
	private int subCategoryNo;
	
//	메인페이지 추천맨토
	private String userName;
	private String subCategoryName;
	private String filePath;
	private int scoreAvg;
	private String changeName;
	
//	맨토 마이페이지 불러오기
	private String sidoName;
	private String sigunguName;
	private String categoryName;
	private int averageScore;
	private int reviewCount;
	private int requestCount;
}
