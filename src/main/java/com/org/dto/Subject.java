package com.org.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String subName;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable
	private List<Student> s;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Teacher t;

	public Subject(String subName) {
		super();
		this.subName = subName;

	}

	public Subject() {

	}

	public int getId() {
		return id;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public List<Student> getS() {
		return s;
	}

	public void setS(List<Student> s) {
		this.s = s;
	}

	public Teacher getT() {
		return t;
	}

	public void setT(Teacher t) {
		this.t = t;
	}

}
