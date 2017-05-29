package container;

import java.util.ArrayList;
import java.util.Iterator;

import betSystem.*;
import personSystem.*;
import exceptions.*;

public class BetContainer {
	private ArrayList<Bet> betDB;
	
	public BetContainer (Player plr) {
		this.betDB = plr.getBetList();
	}

	public BetContainer(Manager mng) {
		this.betDB = new ArrayList<Bet>();
	}
	
	public ArrayList<Bet> getBets() {
		return this.betDB;
	}
	
	/** 
	 * Method to add a PodiumBet in the DB
	 */
	public void addPodiumBet(long amount, Player player, Competition competition, Competitor[] competitors) throws BadParametersException {
		try {
			PodiumBet pb = new PodiumBet(amount, player, competition, competitors);
			this.betDB.add(pb);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}

	/** 
	 * Method to add a SingleWinnerBet in the DB
	 */
	public void addSingleWinnerBet(long amount, Player player, Competition competition, Competitor competitor) throws BadParametersException {
		try {
			SingleWinnerBet pb = new SingleWinnerBet(amount, player, competition, competitor);
			this.betDB.add(pb);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}
	
	/**
	 * Method to update a PodiumBet found by the pk id 
	 */
	public void updatePodiumBet(int id, long amount, Player player, Competitor[] competitors) 
	 throws BadParametersException {
		try  {
			PodiumBet pb = findPodiumBetById(id);
			if (pb.getPlayer() != player) {
				throw new BadParametersException();
			}
			pb.setAmount(amount);
			pb.setCompetitors(competitors);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}
	
	/**
	 * Method to update a SingleWinnerBet found by the pk id 
	 */
	public void updateSingleWinnerBet(int id, long amount, Player player, Competitor competitor) 
	  throws BadParametersException {
		try  {
			SingleWinnerBet swb = findSingleWinnerBetById(id);
			if (swb.getPlayer() != player) {
				throw new BadParametersException("");
			}
			swb.setAmount(amount);
			swb.setCompetitors(new Competitor[] {competitor});
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}
	
	/** 
	 * Method to delete a Bet from the DB found by the pk id
	 */
	public void delBet(int id ) throws BadParametersException {
		try  {
			Bet pb = findBetById(id);			
			this.betDB.remove(pb);
		} catch (Exception e) {
			throw new BadParametersException();
		}
	}

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
