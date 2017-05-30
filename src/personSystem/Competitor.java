package personSystem;

import java.util.ArrayList;
import java.io.Serializable;
import javax.persistence.*;
import betSystem.Competition;

import exceptions.ItemNotInList;
import exceptions.ItemAlreadyInList;
import exceptions.IncorrectString;

@Entity
public class Competitor extends Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;

	//bi-directional many-to-many association to Competition
  	@ManyToMany
  	@JoinTable(
  		name="participate"
  		, joinColumns={
  			@JoinColumn(name="competitor")
  			}
  		, inverseJoinColumns={
  			@JoinColumn(name="competition")
  			}
  		)
	private ArrayList<betSystem.Competition> competitionList;

	public Competitor() {}

	public Competitor(String firstName, String lastName, int id) throws IncorrectString{
		super(firstName, lastName);
		this.id=id;

		competitionList = new  ArrayList<betSystem.Competition>();

	}

	public Competitor(String firstName, String lastName, int id, ArrayList<betSystem.Competition> compList) throws IncorrectString{
		this(firstName, lastName, id);
		this.competitionList = compList;
	}

	public int getId(){
		return id;
	}

	public ArrayList<Competition> getCompetitionList() {

		return this.competitionList;

	}

	public void addCompetition(Competition c) throws ItemAlreadyInList{

		if (!competitionList.contains(c)){

			this.competitionList.add(c);

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
