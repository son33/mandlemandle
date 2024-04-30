package com.mm.member.model.vo;

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
public class Member {
	private int userNo;
	private String email;
	private String userPwd;
	private String userName;
	private String birth;
	private String gender;
	private String phone;
	private int zipcode;
	private String address1;
	private String address2;
	private String address3;
	private Date enrollDate;
	private Date modifyDate;
	private Date connectDate;
	private String status;
	private int memberDivideNo;
	private int GradeNo;
	private String blackStatus;
}
