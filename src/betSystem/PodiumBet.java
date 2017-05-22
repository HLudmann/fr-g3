package betSystem;

import personSystem.Competitor;
import personSystem.Player;

public class PodiumBet extends Bet{

	public PodiumBet(long amount, Player player, Competition competition, Competitor[] competitor){
		super(amount, player, competition);
		if (competitor.length != 3) System.out.println("Error de competitor chez podiumBet");
		super.competitors = new Competitor[3];
		for (int i=0; i<3; i++){
			super.competitors[i] = competitor[i];
		}
		
	}
	
}
