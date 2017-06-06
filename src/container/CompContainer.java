package container;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.*;
import jpaUtil.JPAUtil;

import betSystem.*;
import personSystem.Competitor;
import exceptions.*;

@MappedSuperclass
@NamedNativeQuery(
		name="selectEverythingFromCompetition",
		query="SELECT * FROM competition c")

/**
 * @author Hsb511 
 *
 */
public class CompContainer {
	private ArrayList<Competition> compDB = new ArrayList<Competition>();

	public CompContainer() {
		EntityManager em = JPAUtil.getEntityManager();
		
		List<?> competitions = em.createNamedQuery("selectEverythingFromCompetition").getResultList();
		for (Object competition : competitions) {
			Competition comp = (Competition)competition;
			this.compDB.add(comp);				
		}
	}

	
	/**
	 * Method to add a Competition to the DataBase
	 * @param name						String which is the primary key
	 * @param date						java.util.Date
	 * @param competitors				array of Competitor
	 * @throws BadParametersException
	 */
	public void addComp(String name, Date date, Competitor[] competitors) throws BadParametersException {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			Competition c = new Competition(name, date, competitors);
			em.persist(c);
			this.compDB.add(c);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}

	
	/**
	 * Method to update a Competition in the DataBase /!\ you can't update the primary key name
	 * @param name						String which is the primary key
	 * @param date						java.util.Date
	 * @throws BadParametersException
	 */
	public void updateComp(String name, Date date) throws BadParametersException {
		EntityManager em = JPAUtil.getEntityManager();
		ArrayList<Competition> searchRes = findCompetitionByName(name);	
		if (searchRes.size() != 1) {
			throw new BadParametersException();
		} 
		try  {
			Competition c = searchRes.get(0);
			this.compDB.remove(c);
			c.setDate(date);
			em.merge(c);
			this.compDB.add(c);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}
	
	
	/**
	 * @param name		String which is the primary key
	 * @throws BadParametersException
	 */
	public void delComp(String name) throws BadParametersException {
		EntityManager em = JPAUtil.getEntityManager();
		ArrayList<Competition> searchRes = findCompetitionByName(name);	
		if (searchRes.size() != 1) {
			throw new BadParametersException();
		} 
		try {
			Competition c = searchRes.get(0);
			em.remove(c);
			this.compDB.remove(c);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}

	
	/**
	 * Method to find Competitions by their name
	 * @param name 		String which is the primary key of the table Competition
	 * @return 			ArrayList of Competitions
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

	
	/**
	 * Method to find Competitions by their Date
	 * @param date 		the date of the Competition of type Date			
	 * @return 			ArrayList of Competitions
	 */
	public ArrayList<Competition> findCompetitionByDate(Date date) {
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

	/**
	 * Method to get the Competitions which are not finished
	 * @return ArrayList of Competitions
	 */
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

	/**
	 * Method to get all the Competitions
	 * @return ArrayList of Competitions
	 */
	public ArrayList<Competition> getCompetitions() {
		return this.compDB;
	}
}