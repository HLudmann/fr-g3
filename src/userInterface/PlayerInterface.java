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
	  * Change Password
	  *
	  * @throws BadParametersException
	  *				thrown if the new password does not respect all resctrictions.
	  * 
	  * @throws FalsePassord
	  				thrown if the actual password entered is wrong.
	  */
	public void changePassword (String actualPasswd, String newPasswd, String reNewPasswd) 
		throws BadParametersException, FalsePassord {
		if (newPasswd == reNewPasswd) {
			 try {
				this.loggedPlayer.authentificate(actualPasswd);
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
	 * 
	 * @param compId
	 * 			id of the competitor the bet is made on.
	 * 
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

	public void changeBet () {

	}

	public void delBet () {

	}

	public String[][] listBets() {
		
	}
}