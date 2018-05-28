package com.latoris.consume.beans;

import java.sql.Timestamp;

public class VOBean {
	private String name;
	private Timestamp startTime;
	private Timestamp endTime;
	private int count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
