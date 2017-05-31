package personSystem;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import betSystem.Bet;
import exceptions.IncorrectString;
import exceptions.InvalidWallet;
import exceptions.ItemAlreadyInList;
import exceptions.ItemNotInList;

@NamedQuery(
        name="findAllBetsWithNickname",
        query="SELECT b FROM Bet b WHERE b.player LIKE :custName"
)
@Entity 
public class Player extends SystemUser {

	@PersistenceContext
	public EntityManager em;
	
	private static final long serialVersionUID = 1L;
	private long wallet;
	
	@Transient
	private ArrayList<Bet> betList;

	public Player() {	
	}

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

	
	@PostLoad
	public void initBetList(){
		final List<?> bets = em.createNamedQuery("findAllBetsWithNickname")
								.setParameter("custName",this.getNickname())
								.getResultList();
		for(Object bet : bets){
			Bet b = (Bet) bet;
			this.betList.add(b);
		}
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

	public void addBet(Bet b) throws ItemAlreadyInList, InvalidWallet {

		if (!betList.contains(b)){

			setWallet(getWallet()-b.getAmount());
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
