package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Teacher;

public class TeacherDao 
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
	EntityManager em = emf.createEntityManager();
	public void saveTeacher(Teacher t)
	{	
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(t);
		et.commit();
	}
	
	public void deleteTeacher(int id)
	{
		EntityTransaction et = em.getTransaction();
		et.begin();
		Teacher t = em.find(Teacher.class, id);
		em.remove(t);
		et.commit();
	}
	
	public void updateTeacherById(Teacher t,int id)
	{
		EntityTransaction et = em.getTransaction();
		et.begin();
		Teacher t1 = em.find(Teacher.class, t);
		if(t1!=null)
		{
			em.merge(t);
		}
	}
	public Teacher getTeacherById(int id)
	{
		return em.find(Teacher.class, id);
	}
	
	public List<Teacher> getAllTeacher()
	{
		String hql = "select t from Teacher t";
		Query q = em.createQuery(hql);
		
		List<Teacher> list = q.getResultList();
		return list;
	}
	public List<Teacher> getTeacherByName(String name)
	{
		String hql = "select t from Teacher t where name=?1";
		Query q = em.createQuery(hql);
		q.setParameter(1, name);
		List<Teacher> list = q.getResultList();
		return list;	
	}
	
	public List<Teacher> getTeacherBySub(String sub)
	{
		String hql = "select t from Teacher t where sub=?1";
		Query q = em.createQuery(hql);
		q.setParameter(1, sub);
		return q.getResultList();		
	}

}
