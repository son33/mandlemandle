package com.mm.request.model.vo;

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
public class Request {
	private int requestNo;
	private Date requestDate;
	private String requestContent;
	private String status;
	private String requestStatus;
	private int mtiNo;
	private int mtoNo;
//	요청 불러오기
	private String userName;
}
