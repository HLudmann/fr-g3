
package personSystem;
import java.util.ArrayList;

import betSystem.Bet;
import exceptions.IncorrectString;
import exceptions.InvalidWallet;
import exceptions.ItemAlreadyInList;
import exceptions.ItemNotInList;


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

	public void addBet(betSystem.Bet b){
		if(!betList.contains(b)) {
			betList.add(b);
			b.getCompetition().addBet(b);
			this.wallet -= b.getAmount();
		}
	}
	
}
