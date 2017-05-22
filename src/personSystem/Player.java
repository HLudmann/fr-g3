package personSystem;
import java.util.ArrayList;

import betSystem.Bet;

public class Player extends SystemUser {
	private long wallet;
	private ArrayList<Bet> betList;


	public Player(String firstName, String lastName, String password, String nickname){

		super(firstName, lastName, password, nickname);

		betList = new ArrayList<Bet>();
		wallet=0;
	}

	public Player(String firstName, String lastName, String password, String nickname, long wallet){
		//define a custom value of wallet
		this(firstName, lastName, password, nickname);
		this.wallet=wallet;
	}



	public void setWallet(int w) throws Exception{
		if (w<0){
			throw new Exception("wallet cannot be negative");
		}
		this.wallet = w;
	}

	public long getWallet(){
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
