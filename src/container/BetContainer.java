package container;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import jpaUtils.JPAUtil;

import betSystem.Bet;
import betSystem.Competition;
import personSystem.Player;

public class BetContainer {
	ArrayList<Bet> BetDB;
	
	
	private int findBetById(int id) {
		return 8;
	}
	
	/** 
	 * Method to add a Bet in the DB
	 */
	public boolean addBet(long amount, Player player, Competition competition) {
		
		Bet b = new Bet(amount, player, competition);
		BetDB.addBet();
	}
	
	/**
	 * Method to update a Bet found by the pk id 
	 */
	public boolean updateBet(int id, Bet newB) {
		
	}
	
	/**
	 * Method to delete a Bet from the DB found by the pk id
	 */
	public boolean delBet(int id ) {
		
	}
}
