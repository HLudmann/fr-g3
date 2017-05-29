package container;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.persistence.EntityManager;
import jpaUtil.JPAUtil;

import betSystem.*;
import personSystem.Competitor;
import exceptions.*;

public class CompContainer {
	private ArrayList<Competition> compDB;

	public CompContainer() {
		EntityManager em = JPAUtil.getEntityManager();
	}

	
	/**
	 * Method to add a Competition to the DataBase
	 */
	public void addComp(String name, Calendar date, Competitor[] competitors) throws BadParametersException {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			Competition c = new Competition(name, date, competitors);
			em.persist(c);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}

	
	/** 
	 * Method to update a Competition in the DataBase /!\ you can't update the primary key name
	 */
	public void updateComp(String name, Calendar date) throws BadParametersException {
		EntityManager em = JPAUtil.getEntityManager();
		ArrayList<Competition> searchRes = findCompetitionByName(name);	
		if (searchRes.size() != 1) {
			throw new BadParametersException();
		} 
		try  {
			Competition c = searchRes.get(0);
			c.setDate(date);
			em.merge(c);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}
	
	
	public void delComp(String name) throws BadParametersException {
		EntityManager em = JPAUtil.getEntityManager();
		ArrayList<Competition> searchRes = findCompetitionByName(name);	
		if (searchRes.size() != 1) {
			throw new BadParametersException();
		} 
		try {
			Competition c = searchRes.get(0);
			em.remove(c);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}

	
	/** TODO
	 * Method to find the Competition c in the DataBase (public)
	 */
	public ArrayList<Competition> findCompetitionByName(String name) {
		ArrayList<Competition> res = new ArrayList<Competition>();
		Iterator<Competition> it = this.compDB.iterator();
		while (it.hasNext()) {
			Competition c = it.next();
			if (c.getName().contains(name)) {
				res.add(c);
			}
		}
		return res;
	}

	public ArrayList<Competition> findCompetitionByDate(Calendar date) {
		ArrayList<Competition> res = new ArrayList<Competition>();
		Iterator<Competition> it = this.compDB.iterator();
		while (it.hasNext()) {
			Competition c = it.next();
			if (c.getDate() == date) {
				res.add(c);
			}
		}
		return res;
	}

	public ArrayList<Competition> getCompetitionsNotEnded() {
		ArrayList<Competition> res = new ArrayList<Competition>();
		Iterator<Competition> it = this.compDB.iterator();
		while (it.hasNext()) {
			Competition c = it.next();
			if (!c.hasBegun()) {
				res.add(c);
			}
		}
		return res;
	}

	public ArrayList<Competition> getCompetitions() {
		return this.compDB;
	}
}
