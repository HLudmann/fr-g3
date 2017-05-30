package container;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import jpaUtils.JPAUtil;
import java.util.Calendar;

import betSystem.Competition;c/container/CompContainer.java

public class CompContainer {
	private ArrayList<Competition> compDB;
	
	/**
	 * Method to add a Competition to the DataBase
	 */
	public boolean addComp(String name, Calendar date) {
		EntityManager em = JPAUtil.getEntityManager();
		Competition c = new Competition(name, date);
		if (c == null) {
			return false;
		} try {
			em.persist(c);
		} catch (Exception e) {
			System.err.println("Problem when saving ");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/** 
	 * Method to update a Competition in the DataBase /!\ you can't update the primary key name
	 */
	public boolean updateComp(String name, Calendar date) {
		EntityManager em = JPAUtil.getEntityManager();
		Competition c = searchCompByName(name);	
		if (c == null) {
			return false;
		} try  {
			c.setDate(date);
			return em.merge(c);
		} catch (Exception e) {
			System.err.println("Problem when updating ");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Method to delete a Competition in the DataBase
	 */
	public boolean delComp(String name) {
		EntityManager em = JPAUtil.getEntityManager();
		Competition c = searchCompByName(name);
		if (c == null) {
			return false;
		} try {
			em.remove(c);
		} catch (Exception e) {
			System.err.println("Problem when deleting an entity ");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	/**
	 * Methods to search a Competition in the Database
	 */
	public Competition searchCompByName(String name) {
		EntityManager em = JPAUtil.getEntityManager();
		if (name == null)
			return null;

		
		return (Competition) em.find(Competition.class, name);
	}
	
}