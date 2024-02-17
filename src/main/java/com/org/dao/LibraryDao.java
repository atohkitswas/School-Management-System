package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Library;

public class LibraryDao 
{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
	EntityManager em = emf.createEntityManager();
	
	public void saveLibrary(Library l )
	{
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(l);
		et.commit();
	}

	public void deleteLibrary(int id)
	{
		EntityTransaction et = em.getTransaction();	
		Library l = em.find(Library.class, id);
		et.begin();
		em.remove(l);
		et.commit();
	}
	
	public void updateLibraryById(Library l, int id)
	{
		EntityTransaction et = em.getTransaction();
		Library l1 = em.find(Library.class, id);
		if(l1!=null)
		{
			et.begin();
			em.merge(l);
			et.commit();
		}else {
			System.out.println("INVALID ID");
		}
	}
	
	public List<Library> getAllLibrary()
	{
		String hql = "select l from Library l";
		Query q = em.createQuery(hql);
		return q.getResultList();
	}
	
}
