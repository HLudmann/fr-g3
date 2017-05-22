package src.container;

import java.util.ArrayList;
import src.betSystem.Competition;

public class CompContainer {
	private ArrayList<Competition> compDB;
	
	/*
	 * Method to find the index of the Competition c in the DataBase (private)
	 */
	private int findCompByName(String name) {
		int index = 0;
		int sizeDB = compDB.size();
		if (name.length() > 20) {
			return -1;
		}
		while (name != compDB.get(index).getName() || index <= compDB.size()) {
			index++;			
		}
		//In the case we have't find c in the DataBase
		if (index == sizeDB) {
			//if it's not the last
			if (name != compDB.get(index).getName()) {
				return index-1;
			}
		}
		return -1;
	}
	
	/*
	 * Method to find the Competition c in the DataBase (public)
	 */
	public Competition searchCompetition(String name) {
		int index = findCompByName(name);
		if (index > 0) {
			return compDB.get(index);
		}
		else {
			return null;
		}
	}
	
	/*
	 * Method to add a Competition to the DataBase
	 */
	public Boolean addComp(Competition c) {
		compDB.add(c);
		if (c == null) {
			return false;
		}
		return true;
	}
	
	/*
	 * Method to update a Competition in the DataBase
	 */
	public Boolean updateComp(String name, Competition cNew) {
		int indexC = findCompByName(name);
		Competition c = searchCompetition(name);
		
		if (c == null) {
			return false;
		}
		
		else  {
			compDB.remove(indexC);
			compDB.add(cNew);
			return true;
		}
	}
	
	/*
	 * Method to delete a Competition in the DataBase
	 */
	public Boolean delComp(String name) {
		Competition c = searchCompetition(name);
		if (c == null) {
			return false;
		}
		else {
			compDB.remove(c);
			return true;
		}
	}
}
