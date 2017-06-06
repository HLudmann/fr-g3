package betSystem;

import exceptions.*;
import personSystem.Competitor;
import personSystem.Player;
import javax.persistence.*;

import betSystem.exception.ObjectNotFound;

@Entity
public class PodiumBet extends Bet {
	private static final long serialVersionUID = 1L;
	//uni-directional many-to-one association to Competitor
	@ManyToOne
	@JoinColumn(name="first")
	private Competitor first;
	//uni-directional many-to-one association to Competitor
	@ManyToOne
	@JoinColumn(name="second")
	private Competitor second;
	//uni-directional many-to-one association to Competitor
	@ManyToOne
	@JoinColumn(name="third")
	private Competitor third;
	
	/**
	 * @param amount
	 * @param player
	 * @param competition
	 * @param competitor1
	 * @param competitor2
	 * @param competitor3
	 * @throws BadParametersException
	 * @throws ObjectNotFound
	 * @throws ItemAlreadyInList
	 * @throws InvalidWallet
	 */
	public PodiumBet(long amount, Player player, Competition competition, 
					Competitor competitor1, Competitor competitor2, Competitor competitor3 )throws BadParametersException, ObjectNotFound, ItemAlreadyInList, InvalidWallet{
		super(amount, player, new String("POD"), competition);

		if (competitor1 == null) throw new BadParametersException("Wrong number of competitors");
		if (competitor2 == null) throw new BadParametersException("Wrong number of competitors");
		if (competitor3 == null) throw new BadParametersException("Wrong number of competitors");

		Competitor[] competitor = new Competitor[] {competitor1, competitor2, competitor3};
		
		for(int i=0; i<3; i++){
			if(!competition.contains(competitor[i])) 
				throw new ObjectNotFound("Competitor "+competitor[i].getFirstName()+" not in Competition "+competition.getName());
		}
		
		for(int i=0; i<2; i++){
			for(int j=i+1; j<3; j++){
				if(competitor[i]==competitor[j]) 
					throw new BadParametersException("2 times the same competitor "+competitor[i].getFirstName());
			}
		}
		
		first = competitor1;
		second = competitor2;
		third = competitor3;
		competition.addBet(this);
		
	}
	
	public PodiumBet(){
		
	}
	
	/**
	 * @return the first competitor
	 * @throws ObjectNotFound
	 */
	public Competitor getFirstCompetitor() throws ObjectNotFound{
		if(first == null) throw new ObjectNotFound("First competitor not found");
		else return first;
	}
	
	/**
	 * @return the second competitor
	 * @throws ObjectNotFound
	 */
	public Competitor getSecondCompetitor() throws ObjectNotFound{ if(second == null) throw new ObjectNotFound("Second competitor not found");
		else return second;
	}
	
	/**
	 * @return the third competitor
	 * @throws ObjectNotFound
	 */
	public Competitor getThirdCompetitor() throws ObjectNotFound{
		if(third == null) throw new ObjectNotFound("Third competitor not found");
		else return third;
	}
	
	/**
	 * @param first  
	 * 		the first competitor
	 * @throws BadParametersException
	 */
	public void setFirstCompetitor(Competitor first) throws BadParametersException{
		if(first == null) throw new BadParametersException();
		else this.first = first;
	}
	
	/**
	 * @param second
	 * 		the second competitor
	 * @throws BadParametersException
	 */
	public void setSecondCompetitor(Competitor second) throws BadParametersException{
		if(second == null) throw new BadParametersException();
		else this.second = second;
	}
	
	/**
	 * @param third
	 * 		the third competitor
	 * @throws BadParametersException
	 */
	public void setThirdCompetitor(Competitor third) throws BadParametersException{
		if(third == null) throw new BadParametersException();
		else this.third = third;
	}

}
