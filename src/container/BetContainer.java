package container;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import javax.persistence.EntityManager;

import jpaUtil.JPAUtil;

import betSystem.*;
import personSystem.*;
import exceptions.*;

@Entity
@NamedQuery(
		name="selectEverythingBet",
		query="SELECT b FROM Bet b")
public class BetContainer {
	private ArrayList<Bet> betDB;
	
	public BetContainer (Player plr) {
		this.betDB = plr.getBetList();
	}

	public BetContainer (Manager mng) {
		this.betDB = new ArrayList<?>();
		List<?> bets = em.createNamedQuery("selectEverythingFromBet").getResultList();
		for (Object b : bets) {
			if (b instanceof PodiumBet) {
				PodiumBet bet = (PodiumBet)b;
				this.betDB.add(bet);
			} else if (b instanceof SingleWinnerBet) {
				SingleWinnerBet bet = (SingleWinnerBet)b;
				this.betDB.add(bet);
			}
			
		}
	}
	
	
	public ArrayList<Bet> getBets() {
		return this.betDB;
	}
	
	/**
	 * Method to add a PodiumBet in the DB
	 * @param amount					long 
	 * @param player					Player
	 * @param competition				Competition
	 * @param competitor1				the first Competitor
	 * @param competitor2				the second Competitor
	 * @param competitor3				the third Competitor
	 * @throws BadParametersException
	 */
	public void addPodiumBet(long amount, Player player, Competition competition, Competitor competitors1, Competitor competitor2, Competitor competitor3) throws BadParametersException {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			PodiumBet pb = new PodiumBet(amount, player, competition, competitor1; competitor2; competitor3);
			em.persist(pb);
			this.betDB.add(pb);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}

	/**
	 * Method to add a SingleWinnerBet in the DB
	 * @param amount					long
	 * @param player					Player
	 * @param competition				Competition
	 * @param competitor				Competitor
	 * @throws BadParametersException
	 */
	public void addSingleWinnerBet(long amount, Player player, Competition competition, Competitor competitor) throws BadParametersException {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			SingleWinnerBet swb = new SingleWinnerBet(amount, player, competition, competitor);
			em.persist(swb);
			this.betDB.add(swb);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}
	
	/**
	 * Method to update a PodiumBet found by the pk id 
	 * @param id						int : the primary key of the Bet table
	 * @param amount					long 
	 * @param player					Player
	 * @param competition				Competition
	 * @param competitor1				the first Competitor
	 * @param competitor2				the second Competitor
	 * @param competitor3				the third Competitor
	 * @throws BadParametersException
	 */
	public void updatePodiumBet(int id, long amount, Player player, Competition competition, Competitor competitors1, Competitor competitor2, Competitor competitor3) throws BadParametersException {
		EntityManager em = JPAUtil.getEntityManager();
		PodiumBet pb = findPodiumBetById(id);
		try  {
			this.betDB.remove(pb);
			pb.setAmount(amount);
			pb.setFirstCompetitor(competitor1);
			pb.setSecondCompetitor(competitor2);
			pb.setThirdCompetitor(competitor3);
			em.merge(pb);
			this.betDB.add(pb);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}
	
	/**
	 * Method to update a SingleWinnerBet found by the pk id 
	 * @param id						int : the primary key of the Bet table
	 * @param amount					long
	 * @param player					Player
	 * @param competition				Competition
	 * @param competitor				Competitor
	 * @throws BadParametersException
	 */
	public void updateSingleWinnerBet(int id, long amount, Player player, Competition competition, Competitor competitor) 
	  throws BadParametersException {
		EntityManager em = JPAUtil.getEntityManager();
		SingleWinnerBet swb = findSingleWinnerBetById(id);
		try  {
			this.betDB.remove(swb);
			swb.setAmount(amount);
			swb.setFirstCompetitor(competitor);
			em.merge(swb);
			this.betDB.add(swb);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}
	
	/**
	 * Method to delete a PodiumBet from the DB found by the pk id
	 * @param id						int : the primary key of the Bet table
	 * @throws BadParametersException
	 */
	public void delPodiumBet(int id) throws BadParametersException {
		EntityManager em = JPAUtil.getEntityManager();
		PodiumBet pb = findPodiumBetById(id);
		try  {
			em.remove(pb);
			this.betDB.remove(pb);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}
	
	/**
	 * Method to delete a SingleWinnerBet from the DB found by the pk id
	 * @param id						int : the primary key of the Bet table
	 * @throws BadParametersException
	 */
	public void delSingleWinnerBet(int id) throws BadParametersException {
		EntityManager em = JPAUtil.getEntityManager();
		SingleWinnerBet swb = findSingleWinnerBetById(id);
		try  {
			em.remove(swb);
			this.betDB.remove(swb);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}

	/**
	 * Method to find all the PodiumBets in the ArrayList
	 * @return	an ArrayList of PodiumBet
	 */
	public ArrayList<PodiumBet> getPodiumBets() {
		Iterator<Bet> it = this.betDB.iterator();
		ArrayList<PodiumBet> res = new ArrayList<PodiumBet>();

		while (it.hasNext()) {
			Bet b = it.next();
			if (b instanceof PodiumBet) {
				res.add(b);
			}
		}
		return res;
	}

	/**
	 * Method to find all the SingleWinnerBets in the ArrayList
	 * @return	an ArrayList of SingleWinnerBet
	 */
	public ArrayList<SingleWinnerBet> getSingleWinnerBets() {
		Iterator<Bet> it = this.betDB.iterator();
		ArrayList<SingleWinnerBet> res = new ArrayList<SingleWinnerBet>();

		while (it.hasNext()) {
			Bet b = it.next();
			if (b instanceof SingleWinnerBet) {
				res.add(b);
			}
		}
		return res;
	}

	/**
	 * Method to find a PodiumBet by his id
	 * @param id						int : the primary key of the Bet table		
	 * @return							the PodiumBet corresponding
	 * @throws BadParametersException
	 */
	public PodiumBet findPodiumBetById(int id) throws BadParametersException {
		Iterator<PodiumBet> it = getPodiumBets().iterator();
		boolean notFound = true;
		PodiumBet res = null;
		while (it.hasNext() && notFound) {
			PodiumBet b = it.next();
			if (b.getId() == id) {
				notFound = !notFound;
				res = b;
			}
		}
		if (res == null) {
			throw new BadParametersException();
		}
		return res;
	}

	/**
	 * Method to find a SingleWinnerBet by his id 
	 * @param id						int : the primary key of the Bet table
	 * @return							the SingleWinnerBet corresponding
	 * @throws BadParametersException
	 */
	public SingleWinnerBet findSingleWinnerBetById(int id) throws BadParametersException {
		Iterator<SingleWinnerBet> it = getSingleWinnerBets().iterator();
		boolean notFound = true;
		SingleWinnerBet res = null;
		while (it.hasNext() && notFound) {
			SingleWinnerBet b = it.next();
			if (b.getId() == id) {
				notFound = !notFound;
				res = b;
			}
		}
		if (res == null) {
			throw new BadParametersException();
		}
		return res;
	}
}