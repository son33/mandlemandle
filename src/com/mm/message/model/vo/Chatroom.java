package com.mm.message.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Chatroom {
	private int roomNo;
	private Date roomDate;
	private String status;
	private int mtiNo;
	private int mtoNo;
}
