package personSystem;
import betSystem.Competition;

public class Competitor extends Person{
	
	private int id;
	
	private ArrayList<betSystem.Competition> competitionList;
	
	public Competitor(String firstName, String lastName, int id){
		this.firstName = firstName;
		this.lastName = lastName;
		this.id=id;
		competitionList = new  ArrayList();
		
	}
	
	public int getId(){
		return id;
	}
	
	public Competition[] getCompetitionList() {
		
		return competitionList;
				
	}
	
	public void addCompetition(Competition c) {
		
		if (!competitionList.contains(c)){
			
			competitionList.add(c);
			
		}
	}
	
	public void removeCompetition(Competition c){
		
		if (competitionList.contains(c)){
			
			competitionList.remove(c);
			
		}
	}

}
