package com.org.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClassRoom 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY  )
	private int roomId;
	private int capacity;
	private String Class;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getclass() {
		return Class;
	}
	public void setClass(String class1) {
		Class = class1;
	}
	public ClassRoom(int capacity, String class1) {
		super();
		this.capacity = capacity;
		Class = class1;
	}
	
	public ClassRoom()
	{
		
	}
	

}
