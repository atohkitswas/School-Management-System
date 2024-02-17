package com.org.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.org.util.Address;

@Entity
public class School 
{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Address a;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Principal principal;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ClassRoom> rooms;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Teacher> teachers;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Library library;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Student> students;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getA() {
		return a;
	}
	public void setA(Address a) {
		this.a = a;
	}
	public Principal getPrincipal() {
		return principal;
	}
	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}
	public List<ClassRoom> getRooms() {
		return rooms;
	}
	public void setRooms(List<ClassRoom> rooms) {
		this.rooms = rooms;
	}
	public Library getLibrary() {
		return library;
	}
	public void setLibrary(Library library) {
		this.library = library;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
}
