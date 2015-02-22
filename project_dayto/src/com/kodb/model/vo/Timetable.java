package com.kodb.model.vo;

public class Timetable {
	private int	   timeTableId;
	private int	   postId;
	private String placeName;
	private String startTime;
	private String endTime;
	
	public Timetable() {
		super();
	}
	
	public Timetable(String placeName, String startTime, String endTime) {
		this.placeName = placeName;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public Timetable(int postId, String placeName, String startTime,
			String endTime) {
		this.postId = postId;
		this.placeName = placeName;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getTimeTableId() {
		return timeTableId;
	}

	public void setTimeTableId(int timeTableId) {
		this.timeTableId = timeTableId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Schedule [timeTableId=" + timeTableId + ", postId=" + postId
				+ ", placeName=" + placeName + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
}
