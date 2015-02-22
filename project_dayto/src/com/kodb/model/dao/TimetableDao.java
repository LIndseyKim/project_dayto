package com.kodb.model.dao;

import java.util.List;

import com.kodb.model.vo.Timetable;

public interface TimetableDao {
	public abstract void insertTimetable(Timetable timetable);
	
	public abstract List<Timetable> selectTimetable(int postId);
}
