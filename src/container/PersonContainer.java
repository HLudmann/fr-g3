package container;

import java.util.ArrayList;
import java.util.Iterator;

import personSystem.*;
import exceptions.*;

public class PersonContainer {
	private ArrayList<Competitor> competitorDB = new ArrayList<Competitor>();
	private ArrayList<Player> playerDB = new ArrayList<Player>();
	private ArrayList<Manager> managerDB = new ArrayList<Manager>();
	private ArrayList<Player> loggedPlayers = new ArrayList<Player>();
	private ArrayList<Manager> loggedManagers = new ArrayList<Manager>();


	public ArrayList<Competitor> getCompetitors() {
		return competitorDB;
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
	 * Method to add a Competitor to the DB
	 */
	public void addCompetitor(String lastName, String firstName, int id) throws BadParametersException {
		try {
			Competitor c = new Competitor(lastName, firstName, id);
			this.competitorDB.add(c);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}
	
	/** 
	 * Method to add a Player to the DB
	 */
	public void addPlayer(String firstName, String lastname, String password, String nickname) throws BadParametersException {
		try {
			Player p = new Player(firstName, lastname, password, nickname);
			this.playerDB.add(p);
		} catch (Exception e) {
			throw new BadParametersException();	
		}
	}

	/** 
	 * Method to add a Manager to the DB
	 */
	public void addManager(String firstName, String lastname, String password, String nickname) throws BadParametersException {
		try {
			Manager m = new Manager(firstName, lastname, password, nickname);
			this.managerDB.add(m);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}

	/**
	 * Method to delete a Competitor from the DB with the primary key id
	 */
	public void delCompetitor(int id) throws BadParametersException {
		ArrayList<Competitor> searchRes = findCompetitorById(id);
		if (searchRes.size() != 1) {
			throw new BadParametersException("Competitor not found");
		}
		try {
			Competitor c = searchRes.get(0);
			this.competitorDB.remove(c);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}
	
	/**
	 * Method to delete a SystemUser from the DB with the primary key nickname
	 */
	public void delPlayer(String nickname) throws BadParametersException {
		try {
			Player p = findPlayer(nickname);
			this.playerDB.remove(p);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}
	
	

	public Manager findManager(String nickname) throws Exception {
		Manager res = null;
		Boolean notFound = true;
		Iterator<Manager> it = this.managerDB.iterator();
		while (it.hasNext() && notFound) {
			Manager m = it.next();
			if (m.getNickname() == nickname) {
				res = m;
				notFound = false;
			}
		}
		if (res == null) {
			throw new Exception();
		}
		return res;
	}

	public Player findPlayer(String nickname) throws Exception {
		Player res = null;
		Boolean notFound = true;
		Iterator<Player> it = this.playerDB.iterator();
		while (it.hasNext() && notFound) {
			Player m = it.next();
			if (m.getNickname() == nickname) {
				res = m;
				notFound = false;
			}
		}
		if (res == null) {
			throw new Exception();
		}
		return res;
	}

	public ArrayList<Player> findPlayers(String nickname) throws Exception {
		ArrayList<Player> res = new ArrayList<Player>();
		Iterator<Player> it = this.playerDB.iterator();
		while (it.hasNext()) {
			Player m = it.next();
			if (m.getNickname().contains(nickname)) {
				res.add(m);
			}
		}
		if (res.size() == 0) {
			throw new Exception("No player found");
		}
		return res;
	}

	public ArrayList<Competitor> findCompetitorByName(String name) throws BadParametersException {
		ArrayList<Competitor> res = new ArrayList<Competitor>();
		Iterator<Competitor> it = this.competitorDB.iterator();
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

	public ArrayList<Competitor> findCompetitorById(int id) throws BadParametersException {
		ArrayList<Competitor> res = new ArrayList<Competitor>();
		Iterator<Competitor> it = this.competitorDB.iterator();
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