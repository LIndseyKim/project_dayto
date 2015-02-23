package com.kodb.model.service;

import java.util.List;

import com.kodb.model.dao.TimetableDao;
import com.kodb.model.vo.Timetable;

public class TimetableServiceImpl implements TimetableService{
	private TimetableDao timetableDao;

	public void setTimetableDao(TimetableDao timetableDao) {
		this.timetableDao = timetableDao;
	}

	@Override
	public void registerTimetable(Timetable timetable) {
		System.out.println("[registerTimetable]");
		timetableDao.insertTimetable(timetable);	
	}

	@Override
	public List<Timetable> getSchedule(int postId) {
		System.out.println("[getTimetable]");
		return timetableDao.selectTimetable(postId);
	}
}
