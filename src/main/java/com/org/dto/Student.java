package com.org.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int marks;
	private String gender;
	@ManyToMany(mappedBy = "s")
	private List<Subject> subjects;
	private String address;

	public int getId() {
		return id;
	}

	public List<Subject> getSubject() {
		return subjects;
	}

	public void setSubject(List<Subject> subject) {
		this.subjects = subject;
	}

	public Student(String name, int marks, String gender, String ads) {
		super();
		this.name = name;
		this.marks = marks;
		this.gender = gender;
		this.address = ads;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAds() {
		return address;
	}

	public void setAds(String ads) {
		this.address = ads;
	}

	public Student() {
		super();
	}

}
