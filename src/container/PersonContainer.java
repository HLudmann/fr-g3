package database;

import java.util.ArrayList;

import personSystem.SystemUser;
import betSystem.Competitor;

public class PersonContainer {
	ArrayList<Competitor> CompetitorDB;
	ArrayList<SystemUser> SystemUserDB;
	Boolean logged;
	
	/* 
	 * private Method to find the index of a Competitor in the DB with his id
	 */
	private int findCompetitorById (int id) {
		
	}
	
	/*
	 * private Method to find the index of a SystemUser in the DB with his nickname
	 */
	private int findSysUserByNick (String name) {
		
	}
	
	/*
	 * Method to add a Competitor to the DB
	 */
	public Boolean addCompetitor(Competitor c) {
		CompetitorDB.add(c);
		if (c == null) {
			return false;
		}
		return true;
	}
	
	/*
	 * Method to add a SystemUser to the DB
	 */
	public Boolean addSystemUser(SystemUser s) {
		SystemUserDB.add(s);
		if (s == null) {
			return false;
		}
		return true;
	}
	
	/*
	 * Method to delete a Competitor from the DB with the primary key id
	 */
	public Boolean delCompetitor(int id) {
		return true;
	}
	
	/*
	 * Method to delete a SystemUser from the DB with the primary key nickname
	 */
	public Boolean delSystemUser(String nickname) {
		return true;
	}
}