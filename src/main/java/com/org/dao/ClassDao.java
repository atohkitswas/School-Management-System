package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.ClassRoom;
import com.org.dto.Student;

public class ClassDao 
{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
	EntityManager em = emf.createEntityManager();
	
	public void saveClassRoom(ClassRoom c)
	{
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(c);
		et.commit();
		
	}
	
	public void deleteClassRoom(int id)
	{
		EntityTransaction et = em.getTransaction();
		
		ClassRoom c = em.find(ClassRoom.class, id);
		et.begin();
		em.remove(c);
		et.commit();
		
	}
	
	public void updateClassRoomById(ClassRoom c, int id)
	{
		EntityTransaction et = em.getTransaction();
		
		ClassRoom c1 = em.find(ClassRoom.class, id);
		if(c1!=null)
		{
			et.begin();
			em.merge(c);
			et.commit();
		}else {
			System.out.println("INVALID ID");
		}
		
	}
	public ClassRoom getClassRoomById(int id)
	{
		return em.find(ClassRoom.class, id);
	}
	public List<ClassRoom> getAllStudents()
	{
		
		String hql = "select s from ClassRoom s";
		
		Query q = em.createQuery(hql);
		
		List<ClassRoom> list = q.getResultList();
		return list;
	}
	

}
