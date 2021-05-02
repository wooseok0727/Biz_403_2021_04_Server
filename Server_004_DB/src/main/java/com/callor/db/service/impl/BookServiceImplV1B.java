package com.callor.db.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.db.model.BookVO;
import com.callor.db.service.BookService;

public class BookServiceImplV1B implements BookService {

	protected Connection dbConn;

	public BookServiceImplV1B() {

		this.dbConnection();
	}

	private void dbConnection() {

		String dbDriver = "oracle.jdbc.OracleDriver";

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "bookuser";
		String password = "bookuser";

		try {

			Class.forName(dbDriver);

			dbConn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			System.out.println("클래스 못찾음");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}

	@Override
	public void insert(BookVO bookVO) {
	}

	@Override
	public List<BookVO> selectAll() {

		PreparedStatement pStr = null;
		String sql = "SELECT * FROM tbl_books";

		try {
			pStr = dbConn.prepareStatement(sql);

			ResultSet result = pStr.executeQuery();
			
			List<BookVO> bookList = new ArrayList<BookVO>();

			while( result.next() ) {

				BookVO bookVO = new BookVO();
				bookVO.setBk_isbn(result.getString("bk_isbn"));
				bookVO.setBk_title(result.getString("bk_title"));
				
				bookVO.setBk_ccode(result.getString("bk_ccode"));
				bookVO.setBk_acode(result.getString("bk_acode"));
				bookVO.setBk_date(result.getString("bk_date"));
				bookVO.setBk_price(result.getInt("bk_price"));
				bookVO.setBk_pages(result.getInt("bk_pages"));
				
				bookList.add(bookVO);				
				System.out.println(bookVO.toString());
			} // end while()
			result.close();
			pStr.close();
			return bookList;
			
		} catch (SQLException e) {
			System.out.println("오라클 연결 오류");
		}
		return null;
	}

	@Override
	public BookVO findById(String bk_isbn) {
		
		PreparedStatement pStr = null;
		String sql = "SELECT * FROM view_도서정보 WHERE ISBN = '" + bk_isbn + "'";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet result = pStr.executeQuery();
			result.next();
			
			BookVO bookVO = new BookVO();
			bookVO.setBk_title(result.getString("도서명"));
			bookVO.setBk_isbn(result.getString("ISBN"));
			bookVO.setBk_ccode(result.getString("출판사명"));
			bookVO.setBk_acode(result.getString("저자명"));
			bookVO.setBk_date(result.getString("출판일"));
			bookVO.setBk_price(result.getInt("가격"));
			
			result.close();
			pStr.close();
			return bookVO;
		} catch (SQLException e) {
			System.out.println("오라클 연결 오류");
		}
		return null;
	}

	@Override
	public List<BookVO> findByTitle(String bk_title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByCompany(String bk_comp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BookVO bookVO) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void delete(String bk_isbn) {

		String sql = "DELETE FROM tbl_books WHERE bk_isbn = '" + bk_isbn + "'";
	}
}
