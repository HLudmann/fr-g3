package personSystem;

import java.util.ArrayList;

public class Player extends SystemUser {
	private long wallet = 0;

	private ArrayList<betSystem.Bet> betList = new ArrayList<betSystem.Bet>();

	public Player(String firstName, String lastname, String password, String nickname){
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.nickname = nickname;
	}	

	public void setWallet(long w){
		this.wallet = w;
	}

	public long getWallet(){
		return wallet;
	}

	public void addBet(betSystem.Bet b){
		if(!betList.contains(b)) {
			betList.add(b);
			b.getCompetition().addBet(b);
			this.wallet -= b.getAmount();
		}
	}
	
}
