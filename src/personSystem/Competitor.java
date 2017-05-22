package personSystem;
import java.util.ArrayList;

import betSystem.Competition;

public class Competitor extends Person{
	
	private int id;
	
	private ArrayList<betSystem.Competition> competitionList;
	
	public Competitor(String firstName, String lastName, int id){
		this.firstName = firstName;
		this.lastName = lastName;
		this.id=id;
		competitionList = new  ArrayList<betSystem.Competition>();
		
	}
	
	public int getId(){
		return id;
	}
	
	public ArrayList<Competition> getCompetitionList() {
		
		return competitionList;
				
	}
	
	public void addCompetition(Competition c) throws Exception{
		
		if (!competitionList.contains(c)){
			
			competitionList.add(c);
			
		}
		else{
			throw new Exception("competition already in list");
		}
	}
	
	public void removeCompetition(Competition c) throws Exception{
		
		if (competitionList.contains(c)){
			
			competitionList.remove(c);
			
		}
		else{
			throw new Exception("competition wasnt in list");
		}
	}

}
