package userInterface;

import java.util.ArrayList;

import personSystem.*;
import betSystem.*;
import container.*;
import exceptions.*;

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
		throws BadParametersException, WrongPassword {
		if (newPasswd == reNewPasswd) {
			 try {
				this.loggedPlayer.authentificate(curentPasswd);
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
		Competition competition = competitionList.findCompetitionByName(compName).get(0);
		Competitor first = personList.findCompetitorById(firstCompId).get(0);
		Competitor second = personList.findCompetitorById(secondCompId).get(0);
		Competitor third = personList.findCompetitorById(thirdCompId).get(0);
		Competitor[] competitors = new Competitor[] {first, second, third};
		try {
			this.betList.addPodiumBet(amount, this.loggedPlayer, competition, competitors);
		} catch (BadParametersException e) {
			throw e;
		}
	}

	/**
	 * Make modifications to a player's single winner bet.
	 * 
	 * @param id
	 * 			id of the bet whch is to be modified.
	 * @param winnerId
	 * 			id of the competitor the bet is made on.
	 * @param amount
	 * 			the amount bet on the competitor.
	 * 
	 * @throws BadParametersException
	 * 			thrown if the competitor is not in the competition
	 */
	public void modBet (int id, int winnerId, int secondCompId,int thirdCompId, long amount) 
	  throws BadParametersException {
		Competitor winner = personList.findCompetitorById(winnerId).get(0);
		try {
			this.betList.updateSingleWinnerBet(id, amount, this.loggedPlayer, winner);
		} catch (BadParametersException e) {
			throw e;
		}
	}

	/**
	 * Make changes to a player's podium bet.
	 * 
	 * @param id
	 * 			id of the bet whch is to be modified.
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
	public void changeBet (int id, int firstCompId, 
	  int secondCompId,int thirdCompId, long amount) 
	  throws BadParametersException {
		Competitor first = personList.findCompetitorById(firstCompId).get(0);
		Competitor second = personList.findCompetitorById(firstCompId).get(0);
		Competitor third = personList.findCompetitorById(firstCompId).get(0);
		try {
			this.betList.updatePodiumBet(id,amount, this.loggedPlayer, new Competitor[] {first, second, third});
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
	public String[][] listBets() {
		ArrayList<Bet> list = betList.getBets();
		String[][] res = new String[list.size()][6];
		for (int i = 0; i < list.size(); i++) {
            res[i][0] = String.valueOf(list.get(i).getId());
            res[i][1] = String.valueOf(list.get(i).getAmount());
			res[i][2] = list.get(i).getCompetition().getName();
			res[i][3] = String.valueOf(list.get(i).getCompetitor()[0].getId());
			res[i][4] = String.valueOf(list.get(i).getCompetitor()[1].getId());
			res[i][5] = String.valueOf(list.get(i).getCompetitor()[2].getId());
        }
        return res;
	}
}