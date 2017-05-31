package betSystem;

import personSystem.Competitor;
import personSystem.Player;
import betSystem.exception.*;
import exceptions.*;

public class PodiumBet extends Bet {

	public PodiumBet(long amount, Player player, Competition competition, Competitor[] competitor) throws BadParametersException, ObjectNotFound{
		super(amount, player, competition);
		if (competitor.length != 3) throw new BadParametersException("Wrong number of competitors");
		
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
		
		super.competitors = new Competitor[3];
		for (int i=0; i<3; i++){
			super.competitors[i] = competitor[i];
		}
		
		competition.addBet(this);
		
	}
	
}
