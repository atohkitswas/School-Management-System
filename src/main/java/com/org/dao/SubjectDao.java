package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Student;
import com.org.dto.Subject;

public class SubjectDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
	EntityManager em = emf.createEntityManager();

	public void saveSubject(Subject s) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(s);
		et.commit();

	}

	public void deleteSubById(int id) {
		EntityTransaction et = em.getTransaction();
		Subject s = em.find(Subject.class, id);

		et.begin();
		em.remove(s);
		et.commit();

	}

	public void updateSubById(Subject s, int id) {
		EntityTransaction et = em.getTransaction();

		Subject s1 = em.find(Subject.class, id);
		if (s1 != null) {
			et.begin();
			em.merge(s);
			et.commit();
		} else {
			System.out.println("CAN'T UPDATE THE SUBJECT CAUSE OF INVALID ID");
		}
	}
	
	public Subject getSubjectById(int id)
	{
		return em.find(Subject.class, id);
	}
	public List<Subject> getAllSubjects()
	{
		
		String hql = "select s from Subject s";
		
		Query q = em.createQuery(hql);
		
		List<Subject> list = q.getResultList();
		return list;
	}
	

}
