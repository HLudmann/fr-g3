
package betSystem;
import exceptions.BadParametersException;
import exceptions.InvalidWallet;
import personSystem.Player;

import java.io.Serializable;

import javax.persistence.*;


@Entity @Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING , length=3)
public abstract class Bet implements Serializable{
	private static final long serialVersionUID = 1L;
	private static int iterator = 0;
	@Id
	private int id;
	private long amount;
	@SuppressWarnings("unused")
	private String type;
	@JoinColumn(name="player") 
	private Player player;
	// Unidirectional many-to-one association to Competition
	@ManyToOne
	@JoinColumn(name="competition")
	private Competition competition;
	
	public Bet() {
	}
	
	/**
	 * @param amount
	 * @param player
	 * @param competition
	 * @throws BadParametersException
	 * @throws InvalidWallet
	 */
	public Bet(long amount, Player player, String type, Competition competition) throws BadParametersException, InvalidWallet{
		this.player = player;
		this.type = type;
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
