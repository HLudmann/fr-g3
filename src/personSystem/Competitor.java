package personSystem;
import java.util.ArrayList;

import betSystem.Competition;

import exceptions.ItemNotInList;
import exceptions.ItemAlreadyInList;
import exceptions.IncorrectString;

/**
 * Competitor class extends a person and add a unique id. It also have a list
 * of competitions.
 */
public class Competitor extends Person{

	private int id; //the unique id of competitor

	private ArrayList<betSystem.Competition> competitionList; //competitions of
																														//the competitor
	/**
	 * Create an instance of Competitor with an empty competition list
	 * @param firstName the firstName of the competitor
	 * @param lastName the lastName of the competitor
	 * @param id the id of the competitor

	 */

	public Competitor(String firstName, String lastName, int id) throws IncorrectString{
		super(firstName, lastName);
		this.id=id;

		competitionList = new  ArrayList<betSystem.Competition>(); //init with an empty arrayList

	}

	/**
	 * Create an instance of a competitor and init the competitionList with the given list
	 * @param firstName the firstName of the competitor
	 * @param lastName the lastName of the competitor
	 * @param id the id of the competitor
	 * @param compList the competition list
	 */

	//if we need to add competitions by default
	public Competitor(String firstName, String lastName, int id, ArrayList<betSystem.Competition> compList) throws IncorrectString{
		this(firstName, lastName, id);
		competitionList = compList;
	}

	public int getId(){
		return id;
	}

	public ArrayList<Competition> getCompetitionList() {

		return competitionList;

	}

	/**
	 * Add a competition if possible. This will add the competition onky if it is not
	 * already in the list.
	 * @param c the competition to add
	 */
	public void addCompetition(Competition c) throws ItemAlreadyInList{

		if (!competitionList.contains(c)){

			competitionList.add(c);

		}
		else{ //can't add a competition if already in list
			throw new ItemAlreadyInList();
		}
	}

	/**
	 * Remove the competition if is in list. 
	 * @param c the competition to remove
	 */
	public void removeCompetition(Competition c) throws ItemNotInList{

		if (competitionList.contains(c)){

			competitionList.remove(c);

		}
		else{ //can't remove comp if not in list
			throw new ItemNotInList();
		}
	}

}
