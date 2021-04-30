package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * VO 클래스와 DTO클래스
 * 일반적인 개념은 거의 같다
 * 
 * DB와 연동을 할때는 약간의 차이가 있다
 * 		VO : CRUD모두에서 사용하는 데이터
 * 		DTO : 읽기전용 데이터를 담는 용도
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookDTO {

	private String bk_isbn;
	private String bk_title;
	private String cp_title;
	private String cp_ceo;
	private String au_name;
	private String au_tel;
	private String bk_date;
	private Integer bk_price;
	private Integer bk_pages;
}
