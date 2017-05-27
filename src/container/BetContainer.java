package container;

import java.util.ArrayList;

//import javax.persistence.EntityManager;
//import jpaUtil.JPAUtil;

import betSystem.Bet;
import betSystem.Competition;
import betSystem.SingleWinnerBet;
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

	private int findBetById(int id) {
		return 8;
	}
	
	/** 
	 * Method to add a Bet in the DB
	 */
	public void addBet(long amount, Player player, Competition competition, Competitor winner) throws BadParametersException {
		throw new BadParametersException();

	}

	public void addBet(long amount, Player player, Competition competition, 
	  Competitor fisrt, Competitor second, Competitor third) throws BadParametersException {
		throw new BadParametersException();
	}
	
	/**
	 * Method to update a Bet found by the pk id 
	 */
	public void updateBet(int id, Bet newB) throws BadParametersException {
		throw new BadParametersException();
	}
	
	/**
	 * Method to delete a Bet from the DB found by the pk id
	 */
	public void delBet(int id ) throws BadParametersException {
		throw new BadParametersException();
	}
}
