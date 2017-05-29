package betSystem;

import java.util.ArrayList;
import java.util.Calendar;
import personSystem.Competitor;
import betSystem.exception.*;
import exceptions.*;
import exceptions.BadParametersException;

public class Competition {
	private String name;
	private Calendar date;
	private ArrayList<Bet> betList = new ArrayList<Bet>();
	private ArrayList<Competitor> competitorList = new ArrayList<Competitor>();
	
	public Competition(String name, Calendar date, Competitor[] competitors) throws BadParametersException{
		this.name = name;
		
		if(competitors.length < 2) throw new BadParametersException("Wrong number of Competitors");
		
		for(int i=0; i<competitors.length-1; i++){
			for(int j=i+1; j<competitors.length; j++){
				if(competitors[i]==competitors[j]) 
					throw new BadParametersException("2 times the same competitor "+competitors[i].getFirstName());
			}
		}
		
		for(int i=0; i<competitors.length;i++){
			competitorList.add(competitors[i]);
		}
		
		this.date = date;
		this.date.set(Calendar.MILLISECOND, 0);
		this.date.set(Calendar.SECOND, 0);
		this.date.set(Calendar.MINUTE, 0);
		this.date.set(Calendar.HOUR_OF_DAY, 0);
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
	
	public void removeBet(Bet b){
		betList.remove(b);
	}
	
	
	public void addCompetitor(Competitor c){
		if(!competitorList.contains(c)) competitorList.add(c);
	}
	
	public void removeCompetitor(Competitor c) throws MultiplicityException{
		if(competitorList.size() == 2) throw new MultiplicityException("Competitor must have at least 2 competitors");
		competitorList.remove(c);
	}
	
	public boolean contains(Competitor competitor){
		return competitorList.contains(competitor);
	}
	
	
	public boolean hasBegun() {
		Calendar currentTime = Calendar.getInstance();
		return (currentTime.after(date));
	}
	
	public void results(Competitor[] winners) throws BadParametersException{
		if(competitorList.size() <= 2){
			if (winners.length != 1) {throw new BadParametersException("Single winner only");}
			for (int i=0; i<betList.size();i++) {
				Bet b = betList.get(i);
				if (b instanceof SingleWinnerBet) {
					if (winners[0] == b.getCompetitor()[0])	{
						try {
							b.creditGain();
						} catch (InvalidWallet e) {
							throw new BadParametersException("Issues when crediting wallets");
						}
					}
				}
			}
		}
		else{
			if(winners.length != 3) throw new BadParametersException("3 winners only");
			for(int i=0; i<betList.size();i++){
				Bet b = betList.get(i);
				if (winners[0] == b.getCompetitor()[0] && winners[1] == b.getCompetitor()[1] 
													   && winners[2] == b.getCompetitor()[2])
					try {
							b.creditGain();
						} catch (InvalidWallet e) {
							throw new BadParametersException("Issues when crediting wallets");
						}				
			}
			for(int i=0; i<betList.size();i++){
				Bet b = betList.get(i);
				if (b instanceof SingleWinnerBet){
					if (winners[0] == b.getCompetitor()[0])	{
						try {
							b.creditGain();
						} catch (InvalidWallet e) {
							throw new BadParametersException("Issues when crediting wallets");
						}
					}
				}
			}
			
		}
	}

	

}
