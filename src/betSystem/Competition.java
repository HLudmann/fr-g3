package betSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import betSystem.exception.MultiplicityException;
import betSystem.exception.ObjectNotFound;
import personSystem.Competitor;
import exceptions.*;

@Entity
@NamedQuery(
        name="findAllBetsWithCompName",
        query="SELECT b FROM Bet b WHERE b.competition LIKE :compName "
)
public class Competition {
	@Id
	private String name;
	@Temporal(TemporalType.DATE)
	private Date date ;
	@Transient
	private ArrayList<Bet> betList = new ArrayList<Bet>();
	
	//bi-directional many-to-many association to Competitor
	@ManyToMany(mappedBy="competitionList")
	private ArrayList<Competitor> competitorList;
	
	@PersistenceContext
	public EntityManager em;
		
	
	
	
	/**
	 * @param name
	 * @param date
	 * @param competitors
	 * @throws BadParametersException
	 */
	@SuppressWarnings("deprecation")
	public Competition(String name, Date date, Competitor[] competitors) throws BadParametersException{
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
		this.date.setSeconds(1);
		this.date.setMinutes(0);
		this.date.setHours(0);
	}
	
	public Competition(){	
	}
	
	@PostLoad
	public void initBetList(){
		final List<?> bets =em.createNamedQuery("findAllBetsWithCompName")
							.setParameter("compName",this.name)
							.getResultList();
		for(Object bet : bets){
			Bet b = (Bet) bet;
			this.betList.add(b);
			
		}
	}
	
	/**
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @return date
	 */
	public Date getDate(){
		return date;
	}
	
	/**
	 * @return betList
	 */
	public ArrayList<Bet> getBetList(){
		return betList;
	}
	
	/**
	 * @return competitorList
	 */
	public ArrayList<Competitor> getCompetitorList(){
		return competitorList;
	}
	
	/**
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * @param date
	 */
	public void setDate(Date date){
		this.date = date;
	}
	
	/**
	 * @param bet
	 * @throws ItemAlreadyInList
	 */
	public void addBet(Bet b) throws ItemAlreadyInList{
		if(!betList.contains(b)) betList.add(b);
		else throw new ItemAlreadyInList();
	}
	
	/**
	 * @param bet
	 */
	public void removeBet(Bet b){
		betList.remove(b);
	}
	
	
	/**
	 * @param competitor
	 * @throws ItemAlreadyInList
	 */
	public void addCompetitor(Competitor c) throws ItemAlreadyInList{
		if(!competitorList.contains(c)) competitorList.add(c);
		else throw new ItemAlreadyInList();
	}
	
	/**
	 * @param competitor
	 * @throws MultiplicityException
	 */
	public void removeCompetitor(Competitor c) throws MultiplicityException{
		if(competitorList.size() == 2) throw new MultiplicityException("Competitor must have at least 2 competitors");
		competitorList.remove(c);
	}
	
	/**
	 * @param competitor
	 * @return if the competitor is in the list of competitors or not
	 */
	public boolean contains(Competitor competitor){
		return competitorList.contains(competitor);
	}
	
	
	/**
	 * @return if the competition has begun or not
	 */
	public boolean hasBegun() {
		Date currentTime = new Date();
		return (currentTime.after(date));
	}
	
	/**
	 * @param winners
	 * @throws BadParametersException
	 * @throws InvalidWallet
	 * @throws ObjectNotFound
	 */
	public void results(Competitor[] winners) throws BadParametersException, InvalidWallet, ObjectNotFound{
		if(competitorList.size() <= 2){
			if(winners.length != 1) throw new BadParametersException("Single winner only");
			for(int i=0; i<betList.size();i++){
				Bet bet = betList.get(i);
				if (bet instanceof SingleWinnerBet){
					SingleWinnerBet b = (SingleWinnerBet) bet;
					if (winners[0] == b.getFirstCompetitor())	b.creditGain();
				}
			}
		}
		else{
			if(winners.length != 3) throw new BadParametersException("3 winners only");
			for(int i=0; i<betList.size();i++){
				Bet bet = betList.get(i);
				if(bet instanceof PodiumBet){
					PodiumBet b = (PodiumBet) bet;
					if (winners[0] == b.getFirstCompetitor() && winners[1] == b.getSecondCompetitor() 
													   && winners[2] == b.getThirdCompetitor())
						b.creditGain();
				}
			}
			for(int i=0; i<betList.size();i++){
				Bet bet = betList.get(i);
				if (bet instanceof SingleWinnerBet){
					SingleWinnerBet b = (SingleWinnerBet) bet;
					if (winners[0] == b.getFirstCompetitor())	b.creditGain();
				}
			}
			
		}
	}

	

}
