package container;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import jpaUtils.JPAUtil;

import betSystem.Bet;
import betSystem.Competition;
import betSystem.PodiumBet;
import betSystem.SingleWinnerBet;
import personSystem.Player;

public class BetContainer {
	ArrayList<Bet> BetDB;
	
		
	/* 
	 * Method to add a PodiumBet in the DB
	 */
	public boolean addPodiumBet(long amount, Player player, Competition competition, Competitor[] competitor) {
		EntityManager em = JPAUtil.getEntityManager();
		PodiumBet pb = new PodiumBet(long amount, Player player, Competition competition, Competitor[] competitor);
		if (pb == null) {
			return false;
		} try {
			em.persist(pb);
		} catch (Exception e) {
			System.err.println("Problem when saving ");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/* 
	 * Method to add a SingleWinnerBet in the DB
	 */
	public boolean addSingleWinnerBet(long amount, Player player, Competition competition, Competitor competitor) {
		EntityManager em = JPAUtil.getEntityManager();
		SingleWinnerBet swb = new SingleWinnerBet(long amount, Player player, Competition competition, Competitor competitor);
		if (swb == null) {
			return false;
		} try {
			em.persist(swb);
		} catch (Exception e) {
			System.err.println("Problem when saving ");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/* TODO
	 * Method to update a PodiumBet found by the pk id 
	 */
	public boolean updatePodiumBet(int id, Bet newB) {
		
	}
	
	/* TODO
	 * Method to update a SingleWinnerBet found by the pk id 
	 */
	public boolean updateSingleWinnerBet(int id, Bet newB) {
		
	}
	
	/* TODO
	 * Method to delete a PodiumBet from the DB found by the pk id
	 */
	public boolean delPodiumBet(int id ) {
		
	}
	
	/* TODO
	 * Method to delete a SingleWinnerBet from the DB found by the pk id
	 */
	public boolean delSingleWinnerBet(int id ) {
		
	}
}