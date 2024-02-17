package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Student;

public class StudentDao 
{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
	EntityManager em = emf.createEntityManager();
	
	public void saveStudent(Student s)
	{
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(s);
		et.commit();
		
	}
	
	public void deleteStudent(int id)
	{
		EntityTransaction et = em.getTransaction();
		
		Student s = em.find(Student.class, id);
		et.begin();
		em.remove(s);
		et.commit();
		
	}
	
	public void updateStudentById(Student s, int id)
	{
		EntityTransaction et = em.getTransaction();
		
		Student s1 = em.find(Student.class, id);
		if(s1!=null)
		{
			et.begin();
			em.merge(s);
			et.commit();
		}else {
			System.out.println("INVALID ID");
		}
		
	}
	public Student getStudentById(int id)
	{
		return em.find(Student.class, id);
	}
	public List<Student> getAllStudents()
	{
		
		String hql = "select s from Student s";
		
		Query q = em.createQuery(hql);
		
		List<Student> list = q.getResultList();
		return list;
	}
	public List<Student> getStudentByName(String name)
	{
		
		String hql = "select s from Student s where name=?1";
		
		Query q = em.createQuery(hql);
		q.setParameter(1, name);
		List<Student> list = q.getResultList();
		return list;
	}

}
