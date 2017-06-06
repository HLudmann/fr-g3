package personSystem;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
	private Set<betSystem.Competition> competitionList;
  	
  	@Temporal(TemporalType.DATE)
  	private Date bornDate;

	public Competitor() {}

	public Competitor(String name) throws IncorrectString {
		super(name, name);
		this.id = ids++;
		this.bornDate = new Date();
	}

	public Competitor(String firstName, String lastName, Date bornDate) throws IncorrectString {
		super(firstName, lastName);
		this.id = ids++;
		this.bornDate = new Date();

		this.competitionList = new  HashSet<betSystem.Competition>();

	}

	public int getId(){
		return id;
	}

	public Set<Competition> getCompetitionList() {

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
