package container;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

//import javax.persistence.EntityManager;

//import jpaUtils.JPAUtil;
import java.util.Calendar;

import betSystem.*;
import personSystem.Competitor;
import exceptions.*;

public class CompContainer {
	private ArrayList<Competition> compDB;

	
	/**
	 * Method to add a Competition to the DataBase
	 */
	public void addComp(String name, Calendar date, Competitor[] competitors) throws BadParametersException {
		throw new BadParametersException();
	}

	
	/** 
	 * Method to update a Competition in the DataBase
	 */
	public void updateComp(String name) {
		
	}
	
	
	/**
	 * Method to delete a Competition in the DataBase
	 */
	public void delComp(String name) throws BadParametersException {
		throw new BadParametersException();
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
