package container;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import jpaUtils.JPAUtil;
import java.util.Calendar;

import betSystem.Competition;c/container/CompContainer.java

public class CompContainer {
	private ArrayList<Competition> compDB;
	
	/** TODO
	 * Method to find the index of the Competition c in the DataBase (private)
	 */
	private int findCompByName(String name) {
		int index = 0;
		int sizeDB = compDB.size();
		if (name.length() > 20) {
			return -1;
		}
		while (name != compDB.get(index).getName() || index <= compDB.size()) {
			index++;			
		}
		//In the case we have't find c in the DataBase
		if (index == sizeDB) {
			//if it's not the last
			if (name != compDB.get(index).getName()) {
				return index-1;
			}
		}
		return -1;
	}
	
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
	 * Method to update a Competition in the DataBase
	 */
	public boolean updateComp(String name) {
		EntityManager em = JPAUtil.getEntityManager();
		Competition c = searchCompByName(name);		
		if (c == null) {
			return false;
		} try  {
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
		Competition c = searchCompetition(name);
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

	
	/** TODO
	 * Method to find the Competition c in the DataBase (public)
	 */
	public Competition[] searchCompetition(String name) {
		int index = findCompByName(name);
		if (index > 0) {
			return compDB.get(index);
		}
		else {
			return null;
		}
	}
}