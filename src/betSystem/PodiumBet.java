package betSystem;

import exceptions.*;
import personSystem.Competitor;
import personSystem.Player;


public class PodiumBet extends Bet {

	private Competitor first;
	private Competitor second;
	private Competitor third;
	
	public PodiumBet(long amount, Player player, Competition competition, 
					Competitor competitor1, Competitor competitor2, Competitor competitor3 )throws BadParametersException, ObjectNotFound, ItemAlreadyInList, InvalidWallet{
		super(amount, player, competition);

		if (competitor1 == null) throw new BadParametersException("Wrong number of competitors");
		if (competitor2 == null) throw new BadParametersException("Wrong number of competitors");
		if (competitor3 == null) throw new BadParametersException("Wrong number of competitors");

		Competitor[] competitor = new Competitor[] {competitor1, competitor2, competitor3};
		
		for(int i=0; i<3; i++){
			if(!competition.contains(competitor[i])) 
				throw new ObjectNotFound("Competitor "+competitor[i].getFirstName()+" not in Competition "+competition.getName());
		}
		
		for(int i=0; i<2; i++){
			for(int j=i+1; j<3; j++){
				if(competitor[i]==competitor[j]) 
					throw new BadParametersException("2 times the same competitor "+competitor[i].getFirstName());
			}
		}
		
		first = competitor1;
		second = competitor2;
		third = competitor3;
		competition.addBet(this);
		
	}
	
	public Competitor getFirstCompetitor() throws ObjectNotFound{
		if(first == null) throw new ObjectNotFound("First competitor not found");
		else return first;
	}
	
	public Competitor getSecondCompetitor() throws ObjectNotFound{
		if(second == null) throw new ObjectNotFound("Second competitor not found");
		else return second;
	}
	
	public Competitor getThirdCompetitor() throws ObjectNotFound{
		if(third == null) throw new ObjectNotFound("Third competitor not found");
		else return third;
	}
	
	public void setFirstCompetitor(Competitor first) throws BadParametersException{
		if(first == null) throw new BadParametersException();
		else this.first = first;
	}
	
	public void setSecondCompetitor(Competitor second) throws BadParametersException{
		if(second == null) throw new BadParametersException();
		else this.second = second;
	}
	
	public void setThirdCompetitor(Competitor third) throws BadParametersException{
		if(third == null) throw new BadParametersException();
		else this.third = third;
	}

}
