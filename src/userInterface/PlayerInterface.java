package userInterface;

import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.util.Status;

import personSystem.*;
import betSystem.*;
import container.*;
import userInterface.exceptions.*;

/**
 * @author HLudmann + BusterJava
 * 
 */
public class PlayerInterface extends VisitorInterface {
	
	private Player loggedPlayer;
	private BetContainer betList = new BetContainer(this.loggedPlayer);

	public PlayerInterface (Player player) {
		this.loggedPlayer = player;
	}

	/**
	 * Log Out
	 * 
	 * @return a VisitorInterface to the gui.
	 */
	 public VisitorInterface logOut() {
		 personList.unLog(this.player);
		 return new VisitorInterface();
	 }

	 /**
	  * Change Password.
	  *
	  * @param curentPasswd
	  *				curent password of the player.
	  * @param newPasswd
	  *				new password of the player.
	  * @param reNewPasswd.
	  *				confirmation of the new password.
	  *
	  * @throws BadParametersException
	  *				thrown if the new password does not respect all resctrictions.
	  * @throws FalsePassord
	  *				thrown if the curent password entered is wrong.
	  */
	public void changePassword (String curentPasswd, String newPasswd, String reNewPasswd) 
		throws BadParametersException, FalsePassord {
		if (newPasswd == reNewPasswd) {
			 try {
				this.loggedPlayer.authentificate(curentPasswd);
				this.loggedPlayer.updatePassword(newPasswd);
			} catch (FalsePassword fp) {
				throw fp;
			}
		} else {
			throw new BadParametersException("New password and confirmation don't match");
		}
	}

	/**
	 * Make a bet (simple bet).
	 * 
	 * @param compName
	 * 			name of the competition the bat is made on.
	 * @param compId
	 * 			id of the competitor the bet is made on.
	 * @param amount
	 * 			the amount bet on the competitor.
	 * 
	 * @throws BadParametersException
	 * 			thrown if the competitor is not in the competition
	 */
	public void makeBet (String compName, int compId, long amount) throws BadParametersException {
		Competition competition = competitionList.findCompetitionByName(compName)[0];
		Competitor competitor = personList.findCompetitorById(compId);
		try {
			this.betList.addBet(amount, this.player, competition, competitor);
		} catch (BadParametersException e) {
			throw e;
		}
	}

	/**
	 * Make a bet (podium bet).
	 * 
	 * @param compName
	 * 			name of the competition the bat is made on.
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
	public void makeBet (String compName, int firstCompId, int secondCompId,
	  int thirdCompId, long amount) throws BadParametersException {
		Competition competition = competitionList.findCompetitionByName(compName)[0];
		Competitor first = personList.findCompetitorById(firstCompId);
		Competitor second = personList.findCompetitorById(firstCompId);
		Competitor third = personList.findCompetitorById(firstCompId);
		try {
			this.betList.addBet(amount, this.player, competition, first, second, third);
		} catch (BadParametersException e) {
			throw e;
		}
	}

	/**
	 * Make changes to a player's bet.
	 * 
	 * @param id
	 * 			id of the bet whch is to be modified.
	 * @param compName
	 * 			name of the competition the bat is made on.
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
	public void changeBet (int id, String compName, int firstCompId, 
	  int secondCompId,int thirdCompId, long amount) 
	  throws BadParametersException {
		Competition competition = competitionList.findCompetitionByName(compName)[0];
		Competitor first = personList.findCompetitorById(firstCompId);
		Competitor second = personList.findCompetitorById(firstCompId);
		Competitor third = personList.findCompetitorById(firstCompId);
		try {
			this.betList.addBet(amount, this.player, competition, first, second, third);
			delBet(id);
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
	public void delBet (int id) {
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
	public String[][] listBets() {
		ArrayList<Bet> list = betList.getBets();
		String[][] res = new String[list.size()][6];
		for (int i; i < list.size(); i++) {
            res[i][0] = list[i].getId().toString();
            res[i][1] = list[i].getAmount().toString();
			res[i][2] = list[i].getCompetition.getName();
			res[i][3] = list[i].getCompetitor()[0].getId();
			res[i][4] = list[i].getCompetitor()[1].getId();
			res[i][5] = list[i].getCompetitor()[2].getId();
        }
        return res;
	}
}