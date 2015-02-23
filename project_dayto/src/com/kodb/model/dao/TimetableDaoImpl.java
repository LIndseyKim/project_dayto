package com.kodb.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kodb.model.vo.Board;
import com.kodb.model.vo.Timetable;

public class TimetableDaoImpl implements TimetableDao {
	
	SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public void insertTimetable(Timetable timetable) {
		boolean flag = false;
		flag = session.insert("timetable.insertTimetable", timetable) > 0;
	}

	@Override
	public List<Timetable> selectTimetable(int postId) {
		
		return session.selectList("timetable.selectTimetable", postId);
	}
}
