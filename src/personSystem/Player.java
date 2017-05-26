package personSystem;
import java.util.ArrayList;

import betSystem.Bet;
import exceptions.IncorrectString;
import exceptions.InvalidWallet;


public class Player extends SystemUser {
	private long wallet;
	private ArrayList<Bet> betList;


	public Player(String firstName, String lastName, String password, String nickname) throws IncorrectString{

		super(firstName, lastName, password, nickname);

		betList = new ArrayList<Bet>();
		wallet=0;
	}

	public Player(String firstName, String lastName, String password, String nickname, long wallet) throws IncorrectString{
		//define a custom value of wallet
		this(firstName, lastName, password, nickname);
		this.setWallet(wallet);
	}



	public void setWallet(int w) throws InvalidWallet{
		if (w<0){
			throw new InvalidWallet("wallet can't be negative");
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
