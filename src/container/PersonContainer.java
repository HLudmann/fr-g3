package container;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import jpaUtils.JPAUtil;

import personSystem.SystemUser;
import betSystem.Competitor;

public class PersonContainer {
	private static ArrayList<Competitor> CompetitorDB;
	private static ArrayList<Player> PlayerDB;
	private static ArrayList<Manager> ManagerDB;
	private ArrayList<SystemUser> logged;
	
	
	private Competitor searchCompetitorById(int id) {
		
	}
	
	/*
	 * Method to add a Competitor to the DB
	 */
	public boolean addCompetitor(String lastName, String firstName, int id) {
		EntityManager em = JPAUtil.getEntityManager();
		Competitor c = new Competitor(lastName, firstName, id);
		if (c == null) {
			return false;
		} try {
			em.persist(c);
		} catch (Exception e) {
			System.err.println("Problem when saving ");
			e.printStackTrace();
			return true;
		}
		
	}
	
	/* TODO
	 * Method to add a SystemUser to the DB
	 */
	public boolean addSystemUser(SystemUser s) {
		EntityManager em = JPAUtil.getEntityManager();
		SystemUserDB.add(s);
		if (s == null) {
			return false;
		}
		return true;
	}
	
	/*
	 * Method to delete a Competitor from the DB with the primary key id
	 */
	public boolean delCompetitor(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		Competitor c = searchCompetitorById(id);
		if (c == null) {
			return false;
		} try {
			em.remove(c);
		} catch (Exception e) {
			System.err.println("Problem when deleting an entity ");
			e.printStackTrace();
			return true;
		}
	}
	
	/* TODO
	 * Method to delete a SystemUser from the DB with the primary key nickname
	 */
	public boolean delSystemUser(String nickname) {
		return true;
	}
	
	/* TODO
	 * Method to update a Competitor found by his id and replaced by a new Competitor
	 */
	public boolean updateCompetitor(int id, Competitor c){
		
	}
	
	/* TODO
	 * Method to update a SystemUser found by his id and replaced by a new SystemUser
	 */
	public boolean updateSystemUser(int id, SystemUser su){
		
	}
}