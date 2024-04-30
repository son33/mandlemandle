package com.mm.message.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Message {
	private int messageNo;
	private String messageContent;
	private Date messageDate;
	private String status;
	private int roomNo;
}
