package com.callor.todo.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.callor.todo.config.DBContract;
import com.callor.todo.config.DBInfo;
import com.callor.todo.service.TodoService;

public class TodoServiceImplV2 implements TodoService {

	protected Connection dbConn;
	
	public TodoServiceImplV2() {
		
		dbConn = DBContract.getDBConnection();
	}
	
	@Override
	public List<Map<String, Object>> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_todolist ";
		sql += " ORDER BY td_edate, td_sdate, td_stime";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet rSet = pStr.executeQuery();
			
			List<Map<String,Object>> tdList = new ArrayList<>();
			
			while(rSet.next()) {
				
				Map<String,Object> tdVO = new HashMap<>();
				tdVO.put(DBInfo.td_seq, rSet.getObject(DBInfo.td_seq));
				tdVO.put(DBInfo.td_sdate, rSet.getObject(DBInfo.td_sdate));
				tdVO.put(DBInfo.td_stime, rSet.getObject(DBInfo.td_stime));
				tdVO.put(DBInfo.td_doit, rSet.getObject(DBInfo.td_doit));
				tdVO.put(DBInfo.td_edate, rSet.getObject(DBInfo.td_edate));
				tdVO.put(DBInfo.td_etime, rSet.getObject(DBInfo.td_etime));
				tdList.add(tdVO);
			}
			rSet.close();
			pStr.close();
			return tdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Object> findById(Long td_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> findBySDate(String td_sdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> findByDoit(String td_doit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(Map<String, Object> tdVO) {
		// TODO TodoList 등록하기
		
		// 현재 날짜정보 가져오기
		Date date = new Date(System.currentTimeMillis());
		
		// 날짜정보를 문자열화 하기 위한 보조 클래스
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
		
		String curDate = sd.format(date);
		String curTime = st.format(date);
		
		// tdVO에 2개의 칼럼을 생성하고
		// 데이터 추가
		tdVO.put(DBInfo.td_sdate, curDate);
		tdVO.put(DBInfo.td_stime, curTime);
		
		String sql = " INSERT INTO tbl_todolist ( ";
		sql += "td_sdate,";
		sql += "td_stime,";
		sql += "td_doit) ";
		sql += "VALUES( ?, ?, ? )";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setObject(1, tdVO.get(DBInfo.td_sdate));
			pStr.setObject(2, tdVO.get(DBInfo.td_stime));
			pStr.setObject(3, tdVO.get(DBInfo.td_doit));
			Integer result = pStr.executeUpdate();
			
			pStr.close();
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer update(Map<String, Object> tdVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Long td_seq) {
		// TODO Auto-generated method stub
		return null;
	}

}
