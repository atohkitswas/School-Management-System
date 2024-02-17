package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.School;

public class SchoolDao 
{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
	EntityManager em = emf.createEntityManager();
	
	public void saveSchool(School s)
	{
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(s);
		et.commit();
	}
	
	public void updateSchoolById(School s,int id)
	{
		EntityTransaction et = em.getTransaction();
		School s1 = em.find(School.class, id);
		if(s1!=null) {
			et.begin();
			em.merge(s);
			et.commit();
		}
	}
	
	public void deleteSchoolById(int id)
	{
		EntityTransaction et = em.getTransaction();
		School s = em.find(School.class, id);
		et.begin();
		em.remove(s);
		et.commit();
	}
	
	public School getSchoolById(int id)
	{
		return em.find(School.class, id);
	}
	public List<School> getAllSchools()
	{
		String hql = "select s from School s";
		Query q = em.createQuery(hql);
		return q.getResultList();
	}
}
