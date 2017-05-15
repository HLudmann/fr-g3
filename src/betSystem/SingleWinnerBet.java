package betSystem;
import personSystem.Competitor;
import personSystem.Player;

public class SingleWinnerBet extends Bet {
	private Competitor competitor;
	
	public SingleWinnerBet(long amount, Player player, Competitor competitor){
		super(amount, player);
		this.competitor = competitor;
	}
	
	public Competitor getCompetitor(){
		return competitor;
	}
}
