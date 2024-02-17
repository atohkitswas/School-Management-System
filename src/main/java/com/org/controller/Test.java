package com.org.controller;

import java.util.ArrayList;

import java.util.List;

import com.org.dao.ClassDao;
import com.org.dao.LibraryDao;
import com.org.dao.PrincipalDao;
import com.org.dao.SchoolDao;
import com.org.dao.StudentDao;
import com.org.dao.SubjectDao;
import com.org.dao.TeacherDao;
import com.org.dto.ClassRoom;
import com.org.dto.Library;
import com.org.dto.Principal;
import com.org.dto.School;
import com.org.dto.Student;
import com.org.dto.Subject;
import com.org.dto.Teacher;
import com.org.util.Address;

public class Test {

	public static void main(String[] args) {

		PrincipalDao pdao = new PrincipalDao();
		TeacherDao tdao = new TeacherDao();
		StudentDao sdao = new StudentDao();
		SubjectDao subDao = new SubjectDao();
		LibraryDao ldao = new LibraryDao();
		ClassDao cdao = new ClassDao();
		SchoolDao schlDao = new SchoolDao();

		
		
	

		Teacher t1 = new Teacher("surya", 1, 10000, "male");
		Teacher t2 = new Teacher("prakash", 1, 23000, "male");
		Teacher t3 = new Teacher("surya prakash", 1,32000, "male");
		Teacher t4 = new Teacher("sourya", 1, 20000, "male");
		Teacher t5 = new Teacher("suresh", 5, 20000, "male");
		
		Subject sub1 = new Subject("physics");
		Subject sub2 = new Subject("maths");
		Subject sub3 = new Subject("chemistry");
		Subject sub4 = new Subject("history");
		Subject sub5 = new Subject("library incharge");
		
		Library l = new Library(200, 7, t5);
		
		t1.setSub(sub1);
		t2.setSub(sub2);
		t3.setSub(sub3);
		t4.setSub(sub4);
		t5.setSub(sub5);
		
		sub1.setT(t1);
		sub2.setT(t2);
		sub3.setT(t3);
		sub4.setT(t4);
		
		
		Student s1 = new Student("ramu", 67, "male", "5-18,abc,banglore,513432");
		Student s2 = new Student("ragu", 37, "male", "5-189,abc,banglore,55432");
		Student s3 = new Student("ramesh",97, "male", "5-45,abc,banglore,543432");
		Student s4 = new Student("raghava",87, "male", "5-23,abc,banglore,512432");
		
		List<Student> students1 = new ArrayList<Student>();
		List<Student> students2 = new ArrayList<Student>();
		students1.add(s1);
		students1.add(s2);
		students2.add(s3);
		students2.add(s4);
		
		
		sub1.setS(students1);
		sub2.setS(students1);
		sub3.setS(students2);
		sub4.setS(students2);
		
		List<Subject> subjects1 = new ArrayList<Subject>();
		List<Subject> subjects2 = new ArrayList<Subject>();
		subjects1.add(sub1);
		subjects1.add(sub2);
		subjects2.add(sub3);
		subjects2.add(sub4);
		
		s1.setSubject(subjects1);
		s2.setSubject(subjects1);
		s3.setSubject(subjects2);
		s4.setSubject(subjects2);
		
		
		ClassRoom clsr1= new ClassRoom(100, "I");
		ClassRoom clsr2= new ClassRoom(100, "II");
		ClassRoom clsr3= new ClassRoom(100, "III");
		ClassRoom clsr4= new ClassRoom(100, "IV");
		ClassRoom clsr5= new ClassRoom(100, "V");
		
		List<ClassRoom> classRooms = new ArrayList<ClassRoom>();
		classRooms.add(clsr5);
		classRooms.add(clsr4);
		classRooms.add(clsr3);
		classRooms.add(clsr2);
		classRooms.add(clsr1);
		
		List<Teacher> teachers = new ArrayList<Teacher>();
		teachers.add(t1);
		teachers.add(t2);
		teachers.add(t3);
		teachers.add(t4);
		teachers.add(t5);
		
		List<Student> students = new ArrayList<Student>();
		students.addAll(students1);
		students.addAll(students2);
		
		Principal p = new Principal("suresh", 10, 50000, "male", teachers);
		
		Address a = new Address(534231, "Banglore", "marathahalli", "5-18");
		
		School schl = new School();
		schl.setName("PVR");
		schl.setA(a);
		schl.setLibrary(l);
		schl.setPrincipal(p);
		schl.setRooms(classRooms);
		schl.setTeachers(teachers);
		schl.setStudents(students1);
		
		schlDao.saveSchool(schl);
		


	}
}
