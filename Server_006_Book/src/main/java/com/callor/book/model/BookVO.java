package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
// 도서정보 INSERT, UPDATE를 위한 클래스
public class BookVO {

	private String bk_isbn;			//	char		(13 byte)
	private String bk_title;		//	nvarchar2	(125 char)
	private String bk_ccode;		//	char		(5 byte)
	private String bk_acode;		//	char		(5 byte)
	private String bk_date;			//	varchar2	(10 byte)
	private Integer bk_price = 0;	//	number
	private Integer bk_pages = 0;	//	number
}
