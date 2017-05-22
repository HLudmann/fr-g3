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

   /** TODO
	 * private Method to find the index of a Competitor in the DB with his id
	 */
	private int findCompetitorById (int id) {
		
	}
	
	/** TODO
	 * private Method to find the index of a Player in the DB with his nickname
	 */
	private int findPlayerByNick (String name) {
		
	}
	
	/** TODO
	 * private Method to find the index of a Player in the DB with his nickname
	 */
	private int findManagerByNick (String name) {
		
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
			return false;
		}
		return true;
		
	}
	
	/** 
	 * Method to add a Player to the DB
	 */
	public boolean addPlayer(String firstName, String lastname, String password, String nickname) {
		EntityManager em = JPAUtil.getEntityManager();
		Player p = new Player(String firstName, String lastname, String password, String nickname);
		p.setWallet(0);
		if (p == null) {
			return false;
		} try {
			em.persist(p);
		} catch (Exception e) {
			System.err.println("Problem when saving ");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/** 
	 * Method to add a Manager to the DB
	 */
	public boolean addManager(String firstName, String lastname, String password, String nickname) {
		EntityManager em = JPAUtil.getEntityManager();
		Manager m = new Manager(String firstName, String lastname, String password, String nickname);
		if (m == null) {
			return false;
		} try {
			em.persist(m);
		} catch (Exception e) {
			System.err.println("Problem when saving ");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
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
			return false;
		}
		return true;
	}
	
	/** TODO
	 * Method to delete a Player from the DB with the primary key nickname
	 */
	public boolean delPlayer(String nickname) {
		return true;
	}
	
	/** TODO
	 * Method to delete a Manager from the DB with the primary key nickname
	 */
	public boolean delManager(String nickname) {
		return true;
	}
	
	/** TODO
	 * Method to update a Competitor found by his id and replaced by a new Competitor
	 */
	public boolean updateCompetitor(int id){
		return true;
	}
	
	/** TODO
	 * Method to update a Player found by his id and replaced by a new SystemUser
	 */
	public boolean updatePlayer(String nickname){
		return true;
	}
	
	/** TODO
	 * Method to update a Manager found by his id and replaced by a new SystemUser
	 */
	public boolean updateManagerint(String nickname){
		return true;
	}
}