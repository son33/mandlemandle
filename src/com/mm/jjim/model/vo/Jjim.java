package com.mm.jjim.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Data
public class Jjim {
	private int mtoNo;
	private int mtiNo;
//	맨토 찜목록 불러오기
	private String userName;
	private int ptfNo;
	private String introduce;
}
