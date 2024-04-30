package com.mm.category.model.vo;

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
public class SubCategory {
	private int subCategoryNo;
	private String subCategoryName;
	private int refCategoryNo;
	
	private String categoryName;
}
