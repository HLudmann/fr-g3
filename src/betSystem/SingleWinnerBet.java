
package betSystem;
import personSystem.Competitor;
import personSystem.Player;


public class SingleWinnerBet extends Bet {
	
	public SingleWinnerBet(long amount, Player player, Competition competition, Competitor competitor){
		super(amount, player, competition);
		super.competitors = new Competitor[1]; 
		super.competitors[0] = competitor;
	}
	

}
