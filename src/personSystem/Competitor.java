package personSystem;
import java.util.ArrayList;

import betSystem.Competition;

import exceptions.ItemNotInList;
import exceptions.ItemAlreadyInList;
import exceptions.IncorrectString;

public class Competitor extends Person{

	private int id;

	private ArrayList<betSystem.Competition> competitionList;

	public Competitor(String firstName, String lastName, int id) throws IncorrectString{
		super(firstName, lastName);
		this.id=id;

		competitionList = new  ArrayList<betSystem.Competition>();

	}

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

	public void addCompetition(Competition c) throws ItemAlreadyInList{

		if (!competitionList.contains(c)){

			competitionList.add(c);

		}
		else{
			throw new ItemAlreadyInList();
		}
	}

	public void removeCompetition(Competition c) throws ItemNotInList{

		if (competitionList.contains(c)){

			competitionList.remove(c);

		}
		else{
			throw new ItemNotInList();
		}
	}

}
