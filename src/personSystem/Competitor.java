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
	private static int ids = 0;

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

	public Competitor(String name) throws IncorrectString {
		super(name, name);
		this.id = ids++;
	}

	public Competitor(String firstName, String lastName) throws IncorrectString {
		super(firstName, lastName);
		this.id = ids++;

		this.competitionList = new  ArrayList<betSystem.Competition>();

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
