
package betSystem;
import exceptions.BadParametersException;
import exceptions.InvalidWallet;
import personSystem.Player;



public class Bet {
	private static int iterator = 0;
	private int id;
	private long amount;
	private Player player;
	private Competition competition;
	
	
	public Bet(long amount, Player player, Competition competition) throws BadParametersException, InvalidWallet{
		this.player = player;
		setAmount(amount);
		player.setWallet(player.getWallet()-amount);
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
	
	public Competition getCompetition(){
		return competition;
	}
	
	public void setAmount(long amount) throws BadParametersException, InvalidWallet{
		if (amount <= 0) throw new BadParametersException("Negative Amount");
		else {
			player.setWallet(player.getWallet()+this.amount);
			player.setWallet(player.getWallet()-this.amount);
			this.amount = amount;
		}
	}
	
	public void creditGain() throws InvalidWallet{
		player.setWallet(player.getWallet() + 2*amount);
	}

}
