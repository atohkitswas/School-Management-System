package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Principal;

public class PrincipalDao 
{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
	EntityManager em = emf.createEntityManager();
	
	
	public void savePrincipal(Principal p)
	{
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(p);
		et.commit();
		
	}
	
	public void deletePrincipal(int id)
	{
		Principal p = em.find(Principal.class, id);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(p);
		et.commit();
		
	}
	
	public void updatePrincipalById(Principal p, int id)
	{
		
		Principal p1 = em.find(Principal.class, id);
		if(p1!=null)
		{
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.merge(p);
			et.commit();
		}
		else
		{
			System.out.println("invalid id");
		}
		
	}
	
	public Principal getPrincipalById(int id)
	{
		return em.find(Principal.class, id);
	}
	
	public List<Principal> getAllPrincipals()
	{
		String hql = "select p from Principal p";
		
		Query q = em.createQuery(hql);
		return q.getResultList();	
	}

	public List<Principal> getPrincipalByName(String name)
	{
		String hql = " SELECT p from Principal p where name=?1";
		Query q = em.createQuery(hql);
		q.setParameter(1, name);
		return q.getResultList();
	}
	
}
