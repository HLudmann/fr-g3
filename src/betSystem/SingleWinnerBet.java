
package betSystem;

import exceptions.*;
import personSystem.Competitor;
import personSystem.Player;
import javax.persistence.*;

import betSystem.exception.*;

@Entity
public class SingleWinnerBet extends Bet {

	//uni-directional many-to-one association to Competitor
	@ManyToOne
	@JoinColumn(name="first")
	private Competitor first;
	private static final long serialVersionUID = 1L;
	/**
	 * @param amount
	 * @param player
	 * @param competition
	 * @param competitor
	 * @throws ObjectNotFound
	 * @throws BadParametersException
	 * @throws ItemAlreadyInList
	 * @throws InvalidWallet
	 */
	public SingleWinnerBet(long amount, Player player, Competition competition, Competitor competitor) throws ObjectNotFound, BadParametersException, ItemAlreadyInList, InvalidWallet{
		super(amount, player, new String("SGL"), competition);
		
		if(!competition.contains(competitor)) throw new ObjectNotFound("Competitor "+competitor.getFirstName()+" not in Competition "+competition.getName());
		
		first = competitor;
		
		competition.addBet(this);
		player.addBet(this);
	}
	
	public SingleWinnerBet(){
		
	}
	
	/**
	 * @return the competitor
	 * @throws ObjectNotFound
	 */
	public Competitor getFirstCompetitor() throws ObjectNotFound{
		if(first == null) throw new ObjectNotFound("First competitor not found");
		else return first;
	}
	
	/**
	 * @param first
	 * 		the competitor
	 * @throws BadParametersException
	 */
	public void setFirstCompetitor(Competitor first) throws BadParametersException{
		if(first == null) throw new BadParametersException();
		else this.first = first;
	}

}
