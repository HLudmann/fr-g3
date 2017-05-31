package userInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import personSystem.*;
import betSystem.*;
import betSystem.exception.MultiplicityException;
import container.*;
import exceptions.*;
import bettingServices.exceptions.*;


/**
 * @author HLudmann + BusterJava
 * 
 */
public class ManagerInterface extends VisitorInterface {

	private Manager loggedManager;
	private BetContainer betList = new BetContainer(this.loggedManager);

	public ManagerInterface (Manager manager) {
		this.loggedManager = manager;
	}

	/**
	 * Sign Out
	 * 
	 * @return a VisitorInterface to the gui.
	 */
	public VisitorInterface signOut() {
		personList.logOut(this.loggedManager);
		return new VisitorInterface();
	}

	/**
	  * Change Password.
	  *
	  * @param currentPasswd
	  *				current password of the manager.
	  * @param newPasswd
	  *				new password of the manager.
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
				this.loggedManager.authentificate(currentPasswd);
				this.loggedManager.updatePassword(newPasswd);
			} catch (WrongPassword wp) {
				throw wp;
			}
		} else {
			throw new BadParametersException("New password and confirmation don't match");
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
	 * Add a new player.
	 * 
	 * @param firstname
	 * 			firstname of the player.
	 * @param lastname
	 * 			lastname of the player.
	 * @param nickname
	 * 			nickname chosen by the player.
	 * @param password
	 * 			password chosen by the player.
	 * 
	 * @throws BadParametersException
	 * 			thrown if the nickname is already taken or does not match requirements.
	 */
	public void addNewPlayer (String firstname, String lastname,String nickname,
	  String password) throws BadParametersException {
		try {
			personList.addPlayer(firstname, lastname, nickname, password);
		} catch (BadParametersException e) {
			throw e;
		}
	}

	/**
	 * Delete a player.
	 * 
	 * @param nickname
	 * 			the nickname of the player to be deleted.
	 * 
	 * @throws BadParametersException
	 * 			thrown if the nickname does not match anyone in the database.
	 */
	public void deletePlayer (String nickname) throws BadParametersException{
		try {
			personList.delPlayer(nickname);
		} catch (BadParametersException e) {
			throw e;
		}
	}

	/**
	 * Add a new competition.
	 * 
	 * @param name
	 * 			name of the competition.
	 * @param date
	 * 			date when the competition will take place.
	 * @param competitors
	 * 			list of the competitors attending the competition.
	 * 
	 * @throws BadParametersException
	 * 			thrown if the name is already taken or does not match requirements,
	 * 				if the date has already passed or if the list of competitors 
	 * 				does not match requirements.
	 */
	public void addNewCompetition (String name, Date date, Competitor[] competitors) 
	  throws BadParametersException {
		try {
			competitionList.addComp(name, date, competitors);
		} catch (BadParametersException e) {
			throw e;
		}
	}

	/**
	 * Delete a competition.
	 * 
	 * @param name
	 * 			the exact name of the competition to be deleted.
	 * 
	 * @throws BadParametersException
	 * 			thrown if the name does not match exactly one competition in the database.
	 */
	public void deleteCompetition (String name) throws BadParametersException {
		try {
			competitionList.delComp(name);
		} catch (BadParametersException e) {
			throw e;
		}
	}

	/**
	 * Add a new competitor
	 * 
	 * @param firstname
	 * 			of the competitor.
	 * @param lastname
	 * 			of the competitor.
	 * @param id
	 * 			of the competitor.
	 * 
	 * @throws BadParametersException
	 * 			thrown if the competitor or his id is already in the database.
	 */
	public void addNewCompetitor (String firstname, String lastname)
	  throws BadParametersException {
		try {
			personList.addCompetitor(lastname, firstname);
		} catch (BadParametersException e) {
			throw e;
		}
	}

	/**
	 * Delete a competitor from the database.
	 * 
	 * @param id
	 * 			of the competitor to be deleted.
	 * 
	 * @throws BadParametersException
	 * 			thrown if id does not match exactly one competitor in the database.
	 */
	public void delCompetitor (int id) throws BadParametersException {
		try {
			personList.delCompetitor(id);
		} catch (BadParametersException e) {
			throw e;
		}
	}

	/**
	 * Add or withdraw coins to a player's wallet.
	 * 
	 * @param nickname
	 * 			of the player.
	 * @param change
	 * 			amount to be add (positive) or withdraw (negative).
	 * 
	 * @throws BadParametersException
	 * 			thrown if the nickname does not natch a player in the database
	 * 				or if the withdraw is higher than the wallet.
	 */
	public void changeWallet (String nickname, long change) throws BadParametersException {
		try {
			Player p = personList.findPlayer(nickname);
			p.setWallet(p.getWallet()+change);
		} catch (BadParametersException e) {
			throw new BadParametersException("Player not found");
		} catch (InvalidWallet e) {
			throw new BadParametersException("Wallet cannot be negative");
		}
	}

	/**
	 * End a competition by entering the results.
	 * 
	 * @param name
	 * 			of the competition.
	 * @param first
	 * 			id of the winner.
	 * @param second
	 * 			id of the second.
	 * @parma third
	 * 			id of the third if there is one, else null is expected.
	 * 
	 * @throws BadParametersException
	 * 			thrown if all of the parameters do not match each exactly one distinct entity in the database.
	 */
	public void endCompetition (String name, int first, int second, int third) throws BadParametersException {
		try {
			Competition c = competitionList.findCompetitionByName(name).get(0);
			Competitor f = personList.findCompetitorById(first).get(0);
			Competitor s = personList.findCompetitorById(second).get(0);
			Competitor t = personList.findCompetitorById(third).get(0);
			c.results(new Competitor[] {f,s,t});
		} catch (BadParametersException e) {
			throw e;
		}
	}

	/**
	 * Search for a player using his nickname.
	 * 
	 * @param nickname
	 * 			of the searched player.
	 * 
	 * @throws BadParametersException
	 * 			thrown if nickname does not match anyone in the database.
	 */
	public String[][] searchPlayers (String nickname) throws BadParametersException {
		try {
			ArrayList<Player> list = personList.findPlayers(nickname);
			String[][] res = new String[list.size()][4];
			for (int i = 0; i < list.size(); i++) {
				res[i][0] = list.get(i).getFirstName();
				res[i][1] = list.get(i).getLastName();
				res[i][2] = list.get(i).getNickname();
				res[i][3] = String.valueOf(list.get(i).getWallet());
			}
			return res;
		} catch (Exception e) {
			throw new BadParametersException("No player found");
		}
	}

	/**
	 * Add a competitor to a competition. 
	 * 
	 * @param competition
	 * 
	 * @param competitor
	 */
	public void addCompetitorToCompetition(String competition, Competitor competitor) throws ExistingCompetitionException{
		ArrayList<Competition> list = competitionList.findCompetitionByName(competition);
		if (list.size() != 1) {
			throw new ExistingCompetitionException();
		}
		Competition comp = list.get(0);
		comp.addCompetitor(competitor);
	}

	/**
	 * Cancel a competiton.
	 * 
	 * @param competition
	 * 
	 */
	public void cancelCompetition(String competition) throws ExistingCompetitionException, CompetitionException {
		ArrayList<Competition> list = competitionList.findCompetitionByName(competition);
		if (list.size() != 1) {
			throw new ExistingCompetitionException();
		}
		Competition comp = list.get(0);
		Date d = comp.getDate();
		if (d.before(new Date())) {
			throw new CompetitionException();
		} else {
		 comp.setDate(new Date());
		}
	}

	/**
	 * Remove a competitor from a competition.
	 * 
	 * @param competition
	 * 
	 * @param competitor
	 * 
	 */
	public void removeCompetitorfromCompetition(String competition, Competitor competitor) 
		throws ExistingCompetitionException, CompetitionException {
		ArrayList<Competition> list = competitionList.findCompetitionByName(competition);
		if (list.size() != 1) {
			throw new ExistingCompetitionException();
		}
		Competition comp = list.get(0);
		try {
			comp.removeCompetitor(competitor);;
		} catch (MultiplicityException e) {
			throw new CompetitionException();
		}
	}

	/**
	 * Credit sigle winner bets.
	 * 
	 * @param competition
	 * 
	 * @param winner
	 */
	public void creditSingleWinnerBet(String competiton, Competitor winner)
	  throws ExistingCompetitionException, CompetitionException {
		ArrayList<Competition> list = competitionList.findCompetitionByName(competition);
		if (list.size() != 1) {
			throw new ExistingCompetitionException();
		}
		Competition comp = list.get(0);
		comp.results(new Competitor[] {winner});
	}

	/**
	 * Credit podium bets.
	 * 
	 * @param competition
	 * 
	 * @param winner
	 * 
	 * @param second
	 * 
	 * @param third
	 */
	public void creditPodiumBet(String competition, Competitor winner, Competitor second, Competitor third) 
	 throws ExistingCompetitionException, CompetitionException {
		ArrayList<Competition> list = competitionList.findCompetitionByName(competition);
		if (list.size() != 1) {
			throw new ExistingCompetitionException();
		}
		Competition comp = list.get(0);
		comp.results(new Competitor[] {winner, second, third});
	}
}
