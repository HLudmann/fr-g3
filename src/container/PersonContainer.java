package container;

import java.util.ArrayList;
//import java.util.List;
import java.util.Iterator;
import java.util.Date;

//import javax.persistence.*;

//import jpaUtil.JPAUtil;
import personSystem.*;
import exceptions.*;

//@MappedSuperclass
//@NamedNativeQueries({
//	@NamedNativeQuery(
//		name="selectEverythingFromCompetitor",
//		query="SELECT * FROM competitor c",
//		resultClass = Competitor.class),
//	@NamedNativeQuery(
//		name="selectEverythingFromSystemUser",
//		query="SELECT * FROM system_user s")
//})

/**
 * @author Hsb511
 *
 */
public class PersonContainer {
	private static ArrayList<Competitor> competitorDB = new ArrayList<Competitor>();
	private static ArrayList<Player> playerDB = new ArrayList<Player>();
	private static ArrayList<Manager> managerDB = new ArrayList<Manager>();
	private static ArrayList<Player> loggedPlayers = new ArrayList<Player>();
	private static ArrayList<Manager> loggedManagers = new ArrayList<Manager>();


	public PersonContainer() {
//		EntityManager em = JPAUtil.getEntityManager();
//
//		Query q1 = em.createNamedQuery("selectEverythingFromSystemUser");
//		List<?> systemUsers = q1.getResultList();
//		for (Object sysus : systemUsers) {
//			if (sysus instanceof Player) {
//				Player p = (Player)sysus;
//				playerDB.add(p);
//			} else if (sysus instanceof Manager) {
//				Manager m = (Manager)sysus;
//				managerDB.add(m);
//			}
//		}
//		Query q2 = em.createNamedQuery("selectEverythingFromCompetitor");
//		List<?> competitors = q2.getResultList();
//		for (Object competitor : competitors) {
//			Competitor c = (Competitor)competitor;
//			competitorDB.add(c);				
//		}
		
	}
	 
	public ArrayList<Competitor> getCompetitors() {
		return competitorDB;
	}
	
	public ArrayList<Manager> getManagerDB() {
		return managerDB;
	}
	
	public ArrayList<Player> getPlayerDB() {
		return playerDB;
	}

	public void logIn(Player plr) {
		loggedPlayers.add(plr);
	}
	
	public void logIn(Manager mng) {
		loggedManagers.add(mng);
	}

	public void logOut(Player plr) {
		loggedPlayers.remove(plr);
	}

	public void logOut(Manager mng) {
		loggedManagers.remove(mng);
	}
	
	/**
	 * Method to add a Competitor (Team) to the DB
	 * @param lastName					String 
	 * @param firstName					String
	 * @param id						int which corresponds to the primary key
	 * @throws BadParametersException	
	 */
	public void addCompetitor(String name) throws BadParametersException {
//		EntityManager em = JPAUtil.getEntityManager();
		try {
			Competitor c = new Competitor(name);
//			em.merge(c);
			competitorDB.add(c);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}

	/**
	 * Method to add a Competitor (Person) to the DB
	 * @param lastName					String 
	 * @param firstName					String
	 * @param id						int which corresponds to the primary key
	 * @throws BadParametersException	
	 */
	public void addCompetitor(String lastName, String firstName, String bornDate) throws BadParametersException {
//		EntityManager em = JPAUtil.getEntityManager();
		try {
			Date d = new Date();
			Competitor c = new Competitor(lastName, firstName, d);
//			em.merge(c);
			competitorDB.add(c);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}
	
	/**
	 * Method to add a Player to the DB
	 * @param firstName					String
	 * @param lastname					String
	 * @param password					String
	 * @param nickname					String which is the primary key
	 * @throws BadParametersException
	 */
	public void addPlayer(String firstName, String lastname, String bornDate, String password, String nickname) throws BadParametersException {
//		EntityManager em = JPAUtil.getEntityManager();
		try {
			Date d = new Date();
			Player p = new Player(firstName, lastname, d, password, nickname);
			playerDB.add(p);			
//			em.persist(p);
		} catch (IncorrectString e) {
			throw new BadParametersException("Incorrect string");	
		}
	}

	/**
	 * Method to add a Manager to the DB
	 * @param firstName				String
	 * @param lastname				String
	 * @param password				String
	 * @param nickname				String which is the primary key
	 * @throws BadParametersException
	 */
	public void addManager(String firstName, String lastname, String password, String nickname) throws BadParametersException {
//		EntityManager em = JPAUtil.getEntityManager();
		try {
			Manager m = new Manager(firstName, lastname, nickname, password);
//			em.persist(m);
			managerDB.add(m);
		} catch (IncorrectString e) {
			throw new BadParametersException("Incorrect string");
		}
	}

	/**
	 * Method to delete a Competitor from the DB with the primary key id
	 * @param id					int which is the primary key for the table Competitor
	 * @throws BadParametersException
	 */
	public void delCompetitor(int id) throws BadParametersException {
//		EntityManager em = JPAUtil.getEntityManager();
		ArrayList<Competitor> searchRes = findCompetitorById(id);
		if (searchRes.size() != 1) {
			throw new BadParametersException("Competitor not found");
		}
		try {
			Competitor c = searchRes.get(0);
//			em.r=emove(c);
			competitorDB.remove(c);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}
	
	/**
	 * Method to delete a Player from the DB with the primary key nickname
	 * @param nickname				String which is the primary key for the table Player
	 * @throws BadParametersException
	 */
	public void delPlayer(String nickname) throws BadParametersException {
//		EntityManager em = JPAUtil.getEntityManager();
		try {
			Player p = findPlayer(nickname);
//			em.remove(p);
			playerDB.remove(p);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}
		

	/**
	 * Method to find a Manager in the List
	 * @param nickname			String : the primary key
	 * @return					Manager
	 * @throws Exception
	 */
	public Manager findManager(String nickname) throws BadParametersException {
		Manager res = null;
		Boolean notFound = true;
		Iterator<Manager> it = managerDB.iterator();
		while (it.hasNext() && notFound) {
			Manager m = it.next();
			if (m.getNickname() == nickname) {
				res = m;
				notFound = false;
			}
		}
		if (res == null) {
			throw new BadParametersException();
		}
		return res;
	}

	/**
	 * Method to find a Player in the List
	 * @param nickname			String : the primary key
	 * @return					Player
	 * @throws Exception
	 */
	public Player findPlayer(String nickname) throws BadParametersException {
		Player res = null;
		Boolean notFound = true;
		Iterator<Player> it = playerDB.iterator();
		while (it.hasNext() && notFound) {
			Player m = it.next();
			if (m.getNickname() == nickname) {
				res = m;
				notFound = false;
			}
		}
		if (res == null) {
			throw new BadParametersException();
		}
		return res;
	}

	/**
	 * Method to find players with a part of their nickname
	 * @param nickname			String : the primary key
	 * @return					ArratyList of Players
	 * @throws Exception
	 */
	public ArrayList<Player> findPlayers(String nickname) throws BadParametersException {
		ArrayList<Player> res = new ArrayList<Player>();
		Iterator<Player> it = playerDB.iterator();
		while (it.hasNext()) {
			Player m = it.next();
			if (m.getNickname().contains(nickname)) {
				res.add(m);
			}
		}
		if (res.size() == 0) {
			throw new BadParametersException("No player found");
		}
		return res;
	}

	/**
	 * Method to find Competitors with a part of their name
	 * @param name				String 
	 * @return					ArrayList of Competitor
	 * @throws BadParametersException
	 */
	public ArrayList<Competitor> findCompetitorByName(String name) throws BadParametersException {
		ArrayList<Competitor> res = new ArrayList<Competitor>();
		Iterator<Competitor> it = competitorDB.iterator();
		while (it.hasNext()) {
			personSystem.Competitor c = it.next();
			if (c.getFirstName().contains(name) || c.getLastName().contains(name)) {
				res.add(c);
			}
		}
		if (res.size() == 0) {
			throw new BadParametersException("Competitor not found");
		}
		return res;
	}

	/**
	 * Method to find competitors with their id
	 * @param id				int : the primary key 
	 * @return					ArrayList of Competitor
	 * @throws BadParametersException
	 */
	public ArrayList<Competitor> findCompetitorById(int id) throws BadParametersException {
		ArrayList<Competitor> res = new ArrayList<Competitor>();
		Iterator<Competitor> it = competitorDB.iterator();
		while (it.hasNext()) {
			personSystem.Competitor c = it.next();
			if (String.valueOf(c.getId()).contains(String.valueOf(id))) {
				res.add(c);
			}
		}
		if (res.size() == 0) {
			throw new BadParametersException("Competitor not found");
		}
		return res;
	}
}