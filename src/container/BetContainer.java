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
	
		
	/** 
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
	
	/** 
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
	
	/**
	 * Method to update a PodiumBet found by the pk id 
	 */
	public boolean updatePodiumBet(int id, long amount, Player player, Competition competition, Competitor[] competitor) {
		EntityManager em = JPAUtil.getEntityManager();
		PodiumBet pb = searchPodiumBetById(id);
		if (pb == null) {
			return false;
		} try  {
			pb.setAmount(amount);
			return em.merge(pb);
		} catch (Exception e) {
			System.err.println("Problem when updating ");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Method to update a SingleWinnerBet found by the pk id 
	 */
	public boolean updateSingleWinnerBet(int id, long amount, Player player, Competition competition, Competitor competitor) {
		EntityManager em = JPAUtil.getEntityManager();
		SingleWinnerBet swb = searchSingleWinnerBetById(id);
		if (swb == null) {
			return false;
		} try  {
			swb.setAmount(amount);
			return em.merge(swb);
		} catch (Exception e) {
			System.err.println("Problem when updating ");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/** 
	 * Method to delete a PodiumBet from the DB found by the pk id
	 */
	public boolean delPodiumBet(int id ) {
		EntityManager em = JPAUtil.getEntityManager();
		PodiumBet pb = searchPodiumBetById(id);
		if (pb == null) {
			return false;
		} try  {
			return em.remove(pb);
		} catch (Exception e) {
			System.err.println("Problem when removing ");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/** 
	 * Method to delete a SingleWinnerBet from the DB found by the pk id
	 */
	public boolean delSingleWinnerBet(int id ) {
		EntityManager em = JPAUtil.getEntityManager();
		SingleWinnerBet swb = searchSingleWinnerBetById(id);
		if (swb == null) {
			return false;
		} try  {
			return em.remove(swb);
		} catch (Exception e) {
			System.err.println("Problem when removing ");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/** Working ?
	 * Method to search a PodiumBet in the Database by the id
	 */
	public PodiumBet searchPodiumBetById(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		if (id == null)
			return null;

		PodiumBet pb = em.find(PodiumBet.class, id); //good instantiation ?
		return pb;
	}	
	
	/** Working ?
	 * Method to search a SingleWinnerBet in the Database by the id
	 */
	public SingleWinnerBet searchSingleWinnerBetById(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		if (id == null)
			return null;

		SingleWinnerBet swb = em.find(SingleWinnerBet.class, id); //good instantiation ?
		return swb;
	}	
}