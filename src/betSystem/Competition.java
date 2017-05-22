package src.betSystem;

import java.util.ArrayList;
import java.util.Calendar;
import personSystem.Competitor;

public class Competition {
	private String name;
	private Calendar date;
	private ArrayList<Bet> betList = new ArrayList<Bet>();
	private ArrayList<Competitor> competitorList = new ArrayList<Competitor>();
	
	public Competition(String name, Calendar date){
		this.name = name;
		this.date = date;
	}
	
	public String getName(){
		return name;
	}
	
	public Calendar getDate(){
		return date;
	}
	
	public ArrayList<Bet> getBetList(){
		return betList;
	}
	
	public ArrayList<Competitor> getCompetitorList(){
		return competitorList;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDate(Calendar date){
		this.date = date;
	}
	
	public void addBet(Bet b){
		if(!betList.contains(b)) betList.add(b);
	}
	
	public boolean hasBegun() {
		Calendar currentTime = Calendar.getInstance();
		return (currentTime.after(date));
	}
	
	public void results(Competitor[] winners){
		if(winners.length >= 1){
			for(int i=0; i<betList.size();i++){
				Bet b = betList.get(i);
				if (b instanceof SingleWinnerBet){
					if (winners[0] == b.getCompetitor()[0])	b.creditGain();
				}
			}
			if(winners.length >= 3){
				for(int i=0; i<betList.size();i++){
					Bet b = betList.get(i);
					if (winners[0] == b.getCompetitor()[0] && winners[1] == b.getCompetitor()[1] 
														   && winners[2] == b.getCompetitor()[2])
						b.creditGain();				
				}
			}
			
		}
	}

	

}
