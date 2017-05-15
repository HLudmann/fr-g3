package database;

import java.util.List;
import betSystem.Competition;

public class CompContainer {
	List<Competition> compDB;
	/*
	 * Method to find the Competition c in the DataBase 
	 */
	private int findComp(Competition c) {
		int index = 0;
		int sizeDB = compDB.size();
		while (c != compDB.get(index) || index <= compDB.size()) {
			index++;			
		}
		//In the case we have't find c in the DataBase (it could possibly be the last element
		if (index == sizeDB) {
			//if it's not the last
			if (c != compDB.get(index)) {
				return -1;
			}
		}
		return index-1;
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
	public Boolean updateComp(Competition c, Competition cNew) {
		int indexC = findComp(c);
		if (c == null || indexC == -1) {
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
	public Boolean delComp(Competition c) {
		int indexC = findComp(c);
		if (c == null || indexC == -1) {
			return false;
		}
		else {
			compDB.remove(indexC);
			return true;
		}
	}
}
