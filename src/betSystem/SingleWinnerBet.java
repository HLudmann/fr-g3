
package betSystem;

import betSystem.exception.ObjectNotFound;
import personSystem.Competitor;
import personSystem.Player;


public class SingleWinnerBet extends Bet {
	
	public SingleWinnerBet(long amount, Player player, Competition competition, Competitor competitor) throws ObjectNotFound, ItemAlreadyInList {
		super(amount, player, competition);
		
		if(!competition.contains(competitor)) throw new ObjectNotFound("Competitor "+competitor.getFirstName()+" not in Competition "+competition.getName());
		
		super.competitors = new Competitor[1]; 
		super.competitors[0] = competitor;
		
		competition.addBet(this);
		player.addBet(this);
	}
	

}
