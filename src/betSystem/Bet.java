package betSystem;
import personSystem.Player;

public class Bet {
	private static int iterator = 0;
	private int id;
	private long amount;
	private Player player;
	
	public Bet(long amount, Player player){
		this.amount = amount;
		this.player = player;
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
	
	public void setAmount(long amount){
		this.amount = amount;
	}	
	
	public void creditGain(){
		player.setWallet(player.getWallet() + 2*amount);
	}

}
