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
	
	/**
	 * Method to delete a Player from the DB with the primary key nickname
	 */
	public boolean delPlayer(String nickname) {
		EntityManager em = JPAUtil.getEntityManager();
		Player p = searchPlayerByNickname(nickname);
		if (p == null) {
			return false;
		} try {
			em.remove(p);
		} catch (Exception e) {
			System.err.println("Problem when deleting an entity ");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Method to delete a Manager from the DB with the primary key nickname
	 */
	public boolean delManager(String nickname) {
		EntityManager em = JPAUtil.getEntityManager();
		Manager m = searchManagerByNickname(nickname);
		if (m == null) {
			return false;
		} try {
			em.remove(p);
		} catch (Exception e) {
			System.err.println("Problem when deleting an entity ");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Method to update a Competitor found by his id and replaced by a new Competitor
	 */
	public boolean updateCompetitor(String lastName, String firstName, int id){
		EntityManager em = JPAUtil.getEntityManager();
		Competitor c = searchCompetitorById(id);	
		c.setLastName(lastName);
		c.setFirstName(firstName);
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
	 * Method to update a Player in the Database
	 */
	public boolean updatePlayer(String firstName, String lastname, String password, String nickname, long wallet){
		EntityManager em = JPAUtil.getEntityManager();
		Player p = searchPlayerByNickname(nickname);
		if (p == null) {
			return false;
		} try  {
			p.set(firstName);
			p.set(lastName);
			p.set(password);
			p.set(wallet);
			return em.merge(p);
		} catch (Exception e) {
			System.err.println("Problem when updating ");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Method to update a Manager in the Database
	 */
	public boolean updateManager(String nickname){
		EntityManager em = JPAUtil.getEntityManager();
		Manager m = searchManagerByNickname(nickname);
		if (m == null) {
			return false;
		} try  {
			m.set(firstName);
			m.set(lastName);
			m.set(password);
			return em.merge(,);
		} catch (Exception e) {
			System.err.println("Problem when updating ");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/** 
	 * Method to search a Competitor in the Database by his id
	 */
	public Competitor searchCompetitorById(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		if (id == null)
			return null;
	
		return (Competitor) em.find(Competitor.class, id);
	}
	
	/** Working ?
	 * Method to search a Player in the Database by his nickname
	 */
	public Player searchPlayerByNickname(String nickname) {
		EntityManager em = JPAUtil.getEntityManager();
		if (nickname == null)
			return null;
		Player p = em.find(Player.class, nickname); //good instantiation ?
		if (wallet == null)
			return null;
		return (p)
	}
	
	/** Working ?
	 * Method to search a Manager in the Database by his nickname
	 */
	public Manager searchManagerByNickname(String nickname) {
		EntityManager em = JPAUtil.getEntityManager();
		if (nickname == null)
			return null;
		Manager m = em.find(Manager.class, nickname); //good instantiation ?
		if (wallet != null)
			return null;
		return (m)
	}
} 