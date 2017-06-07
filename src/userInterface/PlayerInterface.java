package userInterface;

import java.util.ArrayList;

import personSystem.*;
import betSystem.*;
import container.*;
import exceptions.*;
import betSystem.exception.*;

/**
 * @author HLudmann + BusterJava
 *
 */
public class PlayerInterface extends VisitorInterface {

	private Player loggedPlayer;
	private BetContainer betList;

	public PlayerInterface (Player player) {
		this.loggedPlayer = player;
		this.betList = new BetContainer(this.loggedPlayer);
	}

	/**
	 * Sign Out
	 *
	 * @return a VisitorInterface to the gui.
	 */
	 public VisitorInterface signOut() {
		 personList.logOut(this.loggedPlayer);
		 return new VisitorInterface();
	 }

	 /**
	  * Change Password.
	  *
	  * @param currentPasswd
	  *				current password of the player.
	  * @param newPasswd
	  *				new password of the player.
	  * @param reNewPasswd.
	  *				confirmation of the new password.
	  *
	  * @throws BadParametersException
	  *				thrown if the new password does not respect all resctrictions.
	  * @throws WrongPassword
	  *				thrown if the current password entered is wrong.
	  */
	public void changePassword (String currentPasswd, String newPasswd, String reNewPasswd)
		throws BadParametersException, WrongPassword {
		if (newPasswd == reNewPasswd) {
			 try {
				this.loggedPlayer.authentificate(currentPasswd);
				this.loggedPlayer.updatePassword(newPasswd);
			} catch (WrongPassword wp) {
				throw wp;
			}
		} else {
			throw new BadParametersException("New password and confirmation don't match");
		}
	}

	/**
	 * Make a bet (simple bet).
	 *
	 * @param compName
	 * 			name of the competition the bet is made on.
	 * @param compId
	 * 			id of the competitor the bet is made on.
	 * @param amount
	 * 			the amount bet on the competitor.
	 *
	 * @throws BadParametersException
	 * 			thrown if the competitor is not in the competition
	 */
	public void makeBet (String compName, long amount, int compId) throws BadParametersException {
		Competition competition = competitionList.findCompetitionByName(compName).get(0);
		Competitor competitor = personList.findCompetitorById(compId).get(0);
		try {
			this.betList.addSingleWinnerBet(amount, this.loggedPlayer, competition, competitor);
		} catch (BadParametersException e) {
			throw e;
		}
	}

	/**
	 * Make a bet (podium bet).
	 *
	 * @param compName
	 * 			name of the competition the bet is made on.
	 * @param firstCompId
	 * 			id of the first competitor the bet is made on.
	 * @param secondCompId
	 * 			id of the second competitor the bet is made on.
	 * @param thirdCompId
	 * 			id of the third competitor the bet is made on.
	 * @param amount
	 * 			the amount bet on the competitor.
	 *
	 * @throws BadParametersException
	 * 			thrown if the competitor is not in the competition
	 */
	public void makeBet (String compName, long amount, int firstCompId, int secondCompId,
	  int thirdCompId) throws BadParametersException {
		Competition competition = competitionList.findCompetitionByName(compName).get(0);
		Competitor first = personList.findCompetitorById(firstCompId).get(0);
		Competitor second = personList.findCompetitorById(secondCompId).get(0);
		Competitor third = personList.findCompetitorById(thirdCompId).get(0);
		try {
			this.betList.addPodiumBet(amount, this.loggedPlayer, competition, first, second, third);
		} catch (BadParametersException e) {
			throw e;
		}
	}

	/**
	 * Make modifications to a player's single winner bet.
	 *
	 * @param id
	 * 			id of the bet which is to be modified.
	 * @param compName
	 * 			name of the competition the bet is made on.
	 * @param winnerId
	 * 			id of the competitor the bet is made on.
	 * @param amount
	 * 			the amount bet on the competitor.
	 *
	 * @throws BadParametersException
	 * 			thrown if the competitor is not in the competition
	 */
	public void changeSingleWinnerBet (int id, long amount, String compName, int winnerId)
	  throws BadParametersException {
		Competition competition = competitionList.findCompetitionByName(compName).get(0);
		Competitor winner = personList.findCompetitorById(winnerId).get(0);
		try {
			this.betList.updateSingleWinnerBet(id, amount, this.loggedPlayer, competition, winner);
		} catch (BadParametersException e) {
			throw e;
		}
	}

	/**
	 * Make changes to a player's podium bet.
	 *
	 * @param id
	 * 			id of the bet which is to be modified.
	 * @param compName
	 * 			name of the competition the bet is made on.
	 * @param firstCompId
	 * 			id of the first competitor the bet is made on.
	 * @param secondCompId
	 * 			id of the second competitor the bet is made on.
	 * @param thirdCompId
	 * 			id of the third competitor the bet is made on.
	 * @param amount
	 * 			the amount bet on the competitor.
	 *
	 * @throws BadParametersException
	 * 			thrown if the competitor is not in the competition
	 */
	public void changePodiumBet (int id, long amount, String compName, int firstCompId,
	  int secondCompId,int thirdCompId)
	  throws BadParametersException {
		Competition competition = competitionList.findCompetitionByName(compName).get(0);
		Competitor first = personList.findCompetitorById(firstCompId).get(0);
		Competitor second = personList.findCompetitorById(firstCompId).get(0);
		Competitor third = personList.findCompetitorById(firstCompId).get(0);
		try {
			this.betList.updatePodiumBet(id, amount, this.loggedPlayer, competition, new Competitor[] {first, second, third});
		} catch (BadParametersException e) {
			throw e;
		}
	}

	/**
	 * Delete a bet.
	 *
	 * @param id
	 * 			id of the bet which is to be deleted.
	 *
	 * @throws BadParametersException
	 * 			thrown if the id does not correspond to any known bet.
	 */
	public void deleteBet (int id) throws BadParametersException {
		try {
			betList.delBet(id);
		} catch (BadParametersException e) {
			throw e;
		}
	}

	/**
	 * Listing of the player's bets.
	 *
	 * @return all the info about the player's bets.
	 */
	public String[][] listBets() throws ObjectNotFound {
		ArrayList<Bet> list = betList.getBets();
		String[][] res = new String[list.size()][6];
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof SingleWinnerBet) {
				SingleWinnerBet b = (SingleWinnerBet) list.get(i);
				res[i][0] = String.valueOf(b.getId());
            	res[i][1] = String.valueOf(b.getAmount());
				res[i][2] = b.getCompetition().getName();
				res[i][3] = String.valueOf(b.getFirstCompetitor().getId());
				res[i][4] = new String("");
				res[i][5] = new String("");
			} else if (list.get(i) instanceof PodiumBet) {
				PodiumBet b = (PodiumBet) list.get(i);
				res[i][0] = String.valueOf(b.getId());
            	res[i][1] = String.valueOf(b.getAmount());
				res[i][2] = b.getCompetition().getName();
				res[i][3] = String.valueOf(b.getFirstCompetitor().getId());
				res[i][4] = String.valueOf(b.getSecondCompetitor().getId());
				res[i][5] = String.valueOf(b.getThirdCompetitor().getId());
			}
        }
        return res;
	}
}
