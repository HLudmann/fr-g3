
package betSystem;
import personSystem.Player;
import exceptions.InvalidWallet;
import personSystem.Competitor;


public class Bet {
	private static int iterator = 0;
	private int id;
	private long amount;
	private Player player;
	private Competition competition;
	protected Competitor[] competitors;
	
	public Bet(long amount, Player player, Competition competition){
		this.amount = amount;
		this.player = player;
		this.competition = competition;
		this.id = iterator;
		iterator++;
	}
	
	public int getId(){
		return id;
	}
	
	public long getAmount(){
		return amount;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public Competitor[] getCompetitor(){
		return competitors;
	}
	
	public Competition getCompetition(){
		return competition;
	}
	
	public void setAmount(long amount){
		this.amount = amount;
	}
	
	public void setCompetitors(Competitor[] competitors) {
		this.competitors = competitors;
	}
	public void creditGain() throws InvalidWallet {
		player.setWallet(this.player.getWallet() + 2*this.amount);	
	}

}
