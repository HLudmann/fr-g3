package userInterface;

import personSystem.*;
import userInterface.VisitorInterface;

/**
 * @author HLudmann + BusterJava
 * 
 */
public class PlayerInterface extends VisitorInterface {
	
	private Player loggedPlayer;

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
	  *
	  */
	public void changePassword () {

	}

	public void makeBet () {

	}

	public void changeBet () {

	}

	public void delBet () {

	}

	public String search (String comps) {
        SearchResults res = new SearchResults(comps);
        res.setCompetitions(competitionList.searchCompetition(comps));
        res.setCompetitors(personList.findSysUserByNick(comps));
		res.setBets(personList.fingBets(this.loggedPlayer, comp));
        return res.toString();
    }
}