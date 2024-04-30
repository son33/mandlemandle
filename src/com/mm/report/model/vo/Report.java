package com.mm.report.model.vo;

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
public class Report {
	private int reportNo;
	private String reportContent;
	private Date reportDate;
	private int userNo;
	private int refUserNo;
	private int refReplyNo;
	private int refBno;
	private String status;
	
	private String userName;
}
