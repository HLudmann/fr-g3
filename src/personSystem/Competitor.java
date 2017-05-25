package personSystem;
import java.util.ArrayList;

import betSystem.Competition;

import exceptions.CompetitionNotInList;
import exceptions.CompetitionAlreadyInList;
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

	public void addCompetition(Competition c) throws CompetitionAlreadyInList{

		if (!competitionList.contains(c)){

			competitionList.add(c);

		}
		else{
			throw new CompetitionAlreadyInList();
		}
	}

	public void removeCompetition(Competition c) throws CompetitionNotInList{

		if (competitionList.contains(c)){

			competitionList.remove(c);

		}
		else{
			throw new CompetitionNotInList();
		}
	}



}
