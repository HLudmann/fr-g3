package container;

import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.*;

import jpaUtil.JPAUtil;

import betSystem.*;
import personSystem.*;
import exceptions.*;

//@MappedSuperclass
//@NamedNativeQuery(
//		name="selectEverythingFromBet",
//		query="SELECT * FROM bet b")

public class BetContainer {
	private ArrayList<Bet> betDB = new ArrayList<Bet>();
	
	public BetContainer() {}
	
	public BetContainer (Player plr) {
		this.betDB = plr.getBetList();
	}

	public BetContainer (Manager mng) {
//		EntityManager em = JPAUtil.getEntityManager();
//		
//		List<?> bets = em.createNamedQuery("selectEverythingFromBet").getResultList();
//		for (Object bet : bets) {
//			Bet b = (Bet) bet;
//			this.betDB.add(b);				
//		}
		PersonContainer pc = new PersonContainer();
		for (Player p : pc.getPlayerDB()) {
			this.betDB.addAll(p.getBetList());
		}
	}
	
	public ArrayList<Bet> getBets() {
		return this.betDB;
	}
	
	/**
	 * Method to add a PodiumBet in the DB
	 * @param amount
	 * @param player
	 * @param competition
	 * @param competitors
	 * @throws BadParametersException
	 */
	public void addPodiumBet(long amount, Player player, Competition competition, Competitor competitor1, Competitor competitor2, Competitor competitor3) throws BadParametersException {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			PodiumBet pb = new PodiumBet(amount, player, competition, competitor1, competitor2, competitor3);
			em.persist(pb);
			this.betDB.add(pb);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}

	/**
	 * Method to add a SingleWinnerBet in the DB
	 * @param amount
	 * @param player
	 * @param competition
	 * @param competitor
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
	 * @param id
	 * @param amount
	 * @param player
	 * @param competition
	 * @param competitors
	 * @throws BadParametersException
	 */
	public void updatePodiumBet(int id, long amount, Player player, Competition competition, Competitor[] competitors) 
	 throws BadParametersException {
		EntityManager em = JPAUtil.getEntityManager();
		PodiumBet pb = findPodiumBetById(id);
		try  {
			this.betDB.remove(pb);
			pb.setAmount(amount);
			em.merge(pb);
			this.betDB.add(pb);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}
	
	/**
	 * Method to update a SingleWinnerBet found by the pk id 
	 * @param id
	 * @param amount
	 * @param player
	 * @param competition
	 * @param competitor
	 * @throws BadParametersException
	 */
	public void updateSingleWinnerBet(int id, long amount, Player player, Competition competition, Competitor competitor) 
	  throws BadParametersException {
		EntityManager em = JPAUtil.getEntityManager();
		SingleWinnerBet swb = findSingleWinnerBetById(id);
		try  {
			this.betDB.remove(swb);
			swb.setAmount(amount);
			em.merge(swb);
			this.betDB.add(swb);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}
	
	/**
	 * Method to delete a Bet from the DB found by the pk id
	 * @param id
	 * @throws BadParametersException
	 */
	public void delBet(int id ) throws BadParametersException {
		EntityManager em = JPAUtil.getEntityManager();
		Bet b = findBetById(id);
		try  {
			em.remove(b);
			this.betDB.remove(b);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}

	/**
	 * @return
	 */
	public ArrayList<PodiumBet> getPodiumBets() {
		Iterator<Bet> it = this.betDB.iterator();
		ArrayList<PodiumBet> res = new ArrayList<PodiumBet>();

		while (it.hasNext()) {
			Bet b = it.next();
			if (b instanceof PodiumBet) {
				res.add((PodiumBet) b);
			}
		}
		return res;
	}

	/**
	 * @return
	 */
	public ArrayList<SingleWinnerBet> getSingleWinnerBets() {
		Iterator<Bet> it = this.betDB.iterator();
		ArrayList<SingleWinnerBet> res = new ArrayList<SingleWinnerBet>();

		while (it.hasNext()) {
			Bet b = it.next();
			if (b instanceof SingleWinnerBet) {
				res.add((SingleWinnerBet) b);
			}
		}
		return res;
	}

	/**
	 * Find a Bet using its id
	 * 
	 * @param id
	 */
	public Bet findBetById(int id) throws BadParametersException {
		Iterator<Bet> it = getBets().iterator();
		boolean notFound = true;
		Bet res = null;
		while (it.hasNext() && notFound) {
			Bet b = it.next();
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
	 * @param id
	 * @return
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
	 * @param id
	 * @return
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