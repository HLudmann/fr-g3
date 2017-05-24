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

   /** 
	 * private Method to find the index of a Competitor in the DB with his id
	 */
	private int findCompetitorById (int id) {
		
	}
	
	/**
	 * private Method to find the index of a SystemUser in the DB with his nickname
	 */
	private int findSysUserByNick (String name) {
		
	}
	
	/**
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
	
	/** TODO
	 * Method to add a SystemUser to the DB
	 */
	public boolean addSystemUser(SystemUser s) {
		EntityManager em = JPAUtil.getEntityManager();

	
	/**
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
	
	/** TODO
	 * Method to delete a SystemUser from the DB with the primary key nickname
	 */
	public boolean delSystemUser(String nickname) {
		return true;
	}
	
	/** TODO
	 * Method to update a Competitor found by his id and replaced by a new Competitor
	 */
	public boolean updateCompetitor(int id, Competitor c){
		
	}
	
	/** TODO
	 * Method to update a SystemUser found by his id and replaced by a new SystemUser
	 */
	public boolean updateSystemUser(int id, SystemUser su){
		
	}
}