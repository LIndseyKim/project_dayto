package com.kodb.model.service;

import java.util.List;

import com.kodb.model.vo.Timetable;

public interface TimetableService {
	public abstract void registerTimetable(Timetable schedule);
	
	public abstract List<Timetable> getSchedule(int postId);
}
