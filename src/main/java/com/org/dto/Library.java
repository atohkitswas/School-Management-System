package com.org.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Library 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int capacity;
	private int avlHours;
	@OneToOne
	private Teacher t;
	public Library(int capacity, int avlHours, Teacher t) {
		super();
		this.capacity = capacity;
		this.avlHours = avlHours;
		this.t = t;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getAvlHours() {
		return avlHours;
	}
	public void setAvlHours(int avlHours) {
		this.avlHours = avlHours;
	}
	
	public Library()
	{
		
	}

}
