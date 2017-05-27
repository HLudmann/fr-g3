package personSystem;
import java.util.ArrayList;

import betSystem.Bet;
import exceptions.IncorrectString;
import exceptions.InvalidWallet;
import exceptions.ItemAlreadyInList;
import exceptions.ItemNotInList;


import java.util.ArrayList;

public class Player extends SystemUser {

	private long wallet;
	private ArrayList<Bet> betList;


	public Player(String firstName, String lastName, String nickname, String password) throws IncorrectString{

		super(firstName, lastName, password, nickname);

		betList = new ArrayList<Bet>();
		wallet=0;
	}

	public Player(String firstName, String lastName, String password, String nickname, long wallet) throws IncorrectString,
																																																			InvalidWallet{
		//define a custom value of wallet
		this(firstName, lastName, password, nickname);
		this.setWallet(wallet);
	}



	public void setWallet(long w) throws InvalidWallet{
		if (w<0){
			throw new InvalidWallet("wallet can't be negative");
		}
		this.wallet = w;
	}

	public long getWallet(){
		return wallet;
	}

	public ArrayList<betSystem.Bet> getBetList(){
		return betList;
	}

	public void addBet(Bet b) throws ItemAlreadyInList{

		if (!betList.contains(b)){

			betList.add(b);

		}
		else{
			throw new ItemAlreadyInList("Bet already in list");
		}
	}

	public void removeBet(Bet b) throws ItemNotInList{

		if (betList.contains(b)){

			betList.remove(b);

		}
		else{
			throw new ItemNotInList("Can't remove a not-existing bet");
		}
	}
	
}
