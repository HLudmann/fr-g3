package personSystem;
import java.util.ArrayList;

import betSystem.Bet;

public class Player extends SystemUser {
	private int wallet=0;

	private ArrayList<Bet> betList;

	public Player(String firstName, String lastName, String password, String nickname){
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.nickname = nickname;
		betList = new ArrayList<Bet>();
	}	

	public void setWallet(int w) throws Exception{
		if (w<0){
			throw new Exception("wallet cannot be negative");
		}
		this.wallet = w;
	}

	public int getWallet(){
		return wallet;
	}
	
	ArrayList<betSystem.Bet> getBetList(){
		return betList;
	}
	
	public void addBet(Bet b) {
		
		if (!betList.contains(b)){
			
			betList.add(b);
			
		}
	}
	
	public void removeBet(Bet b){
		
		if (betList.contains(b)){
			
			betList.remove(b);
			
		}
	}

}
