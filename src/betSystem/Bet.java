
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
	
	
	/**
	 * @param amount
	 * @param player
	 * @param competition
	 * @throws BadParametersException
	 * @throws InvalidWallet
	 */
	public Bet(long amount, Player player, Competition competition) throws BadParametersException, InvalidWallet{
		this.player = player;
		setAmount(amount);
		player.setWallet(player.getWallet()-amount);
		this.competition = competition;
		this.id = iterator;
		iterator++;
	}
	
	/**
	 * @return id
	 */
	public int getId(){
		return id;
	}
	
	/**
	 * @return amount
	 */
	public long getAmount(){
		return amount;
	}
	
	/**
	 * @return player
	 */
	public Player getPlayer(){
		return player;
	}
	
	/**
	 * @return competition
	 */
	public Competition getCompetition(){
		return competition;
	}
	
	/**
	 * @param amount
	 * @throws BadParametersException
	 * @throws InvalidWallet
	 */
	public void setAmount(long amount) throws BadParametersException, InvalidWallet{
		if (amount <= 0) throw new BadParametersException("Negative Amount");
		else {
			player.setWallet(player.getWallet()+this.amount);
			player.setWallet(player.getWallet()-this.amount);
			this.amount = amount;
		}
	}
	
	/**
	 * @throws InvalidWallet
	 */
	public void creditGain() throws InvalidWallet{
		player.setWallet(player.getWallet() + 2*amount);
	}

}
