package personSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.persistence.*;
import betSystem.Bet;
import exceptions.IncorrectString;
import exceptions.InvalidWallet;
import exceptions.ItemAlreadyInList;
import exceptions.ItemNotInList;
import jpaUtil.JPAUtil;
import utils.*;

@NamedNativeQuery(
        name="findAllBetsWithNickname",
        query="SELECT * FROM bet b WHERE b.player LIKE :custName"
)
@Entity 
public class Player extends SystemUser {

	
	private static final long serialVersionUID = 1L;
	private long wallet;
	
	@Transient
	private ArrayList<Bet> betList = new ArrayList<Bet>();

	public Player() {	
	}

	public Player(String firstName, String lastName, String nickname) throws IncorrectString {
		super(firstName, lastName, new Date(), new String("PLR"), RandPass.getPass(10), nickname);

		this.wallet=0;
	}

	public Player(String firstName, String lastName, Date bornDate, String nickname, String password) throws IncorrectString {

		super(firstName, lastName, bornDate, new String("PLR"), password, nickname);

		this.wallet=0;
	}

	public Player(String firstName, String lastName, Date bornDate, String password, String nickname, long wallet) throws IncorrectString,
																																																			InvalidWallet{
		//define a custom value of wallet
		this(firstName, lastName, bornDate, password, nickname);
		this.setWallet(wallet);
	}

	
	@PostLoad
	public void initBetList(){
		EntityManager em = JPAUtil.getEntityManager();
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

	public long getBettedWallet() {
		long res = 0;
		for (Bet b : this.betList) {
			res += b.getAmount();
		}
		return res;
	}

	public ArrayList<Bet> getBetList() {
		return this.betList;
	}

	public void addBet(Bet b) throws ItemAlreadyInList, InvalidWallet {

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
