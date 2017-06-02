package bettingServices;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import betSystem.*;
import bettingServices.exceptions.*;
import exceptions.*;
import personSystem.*;
import userInterface.*;
import utils.*;

/**
 * 
 * @author prou + mallet <br>
 * <br>
 *         This class implements methods of the interface Betting. <br>
 * <br>
 *         <ul>
 *         <li>manager password validity:
 *         <ul>
 *         <li>only letters and digits are allowed</li>
 *         <li>password size should be at least 8 characters</li>
 *         </ul>
 *         </li>
 *         </ul>
 */

public class BettingSoft implements Betting {

	/*
	 * Manager password
	 */
	private String managerPassword;

	/**
	 * Manger interface
	 */
	private ManagerInterface mngInt;

	/*
	 * Players of the betting software
	 */
	/** 
	 * @uml.property name="subscribers"
	 * @uml.associationEnd multiplicity="(0 -1)" inverse="bettingSoft:fr.uv1.bettingServices.Player"
	 */
	private Collection<Player> subscribers;

	/**
	 * constructor of BettingSoft
	 * 
	 * @param managerPwd
	 *            manager password.
	 * 
	 * @throws BadParametersException
	 *             raised if a_managerPwd is incorrect.
	 */
	public BettingSoft(String managerPwd) throws BadParametersException {


		// The password should be valid
		setManagerPassword(managerPwd);
		this.subscribers = new ArrayList<Player>();

		// Set interfaces
		try {
			this.mngInt = new ManagerInterface(new Manager("Jean", "Dupont", "Jannot", this.managerPassword));
		} catch (IncorrectString e) {
			throw new BadParametersException();
		}
	}

	
	/***********************************************************************
	 * MANAGER FONCTIONNALITIES
	 ***********************************************************************/

	private void setManagerPassword(String managerPassword)
			throws BadParametersException {
		if (managerPassword == null)
			throw new BadParametersException("manager's password not valid");
		// The password should be valid
		if (!BettingPasswordsVerifier.verify(managerPassword))
			throw new BadParametersException("manager's password not valid");
		this.managerPassword = managerPassword;
	}

	/**
	 * From Betting interface
	 */
	@Override
	public String subscribe(String lastName, String firstName, String username,
			String borndate, String managerPwd) throws AuthenticationException,
			ExistingPlayerException, PlayerException,
			BadParametersException {
		// Authenticate manager
		authenticateMngr(managerPwd);
		// Look if a subscriber with the same username already exists
		Player s = searchPlayerByUsername(username);
		if (s != null)
			throw new ExistingPlayerException(
					"A subscriber with the same username already exists");
		// Creates the new subscriber
		String password = RandPass.getPass(Constraints.LONG_PWD);
		try {
			s = new Player(firstName, lastName, new Date(borndate), username, password);
			this.mngInt.addNewPlayer(firstName, lastName, borndate, username, password);
		} catch (IncorrectString e) {
			throw new BadParametersException();
		}
		// Add it to the collection of subscribers
		subscribers.add(s);
		return password;
	}

	/**
	 * From Betting interface
	 */
	@Override
	public long unsubscribe(String username, String managerPwd)
			throws AuthenticationException, ExistingPlayerException {
		Long wallet;
		// Authenticate manager
		authenticateMngr(managerPwd);
		// Look if a subscriber with the same username already exists
		Player s = searchPlayerByUsername(username);
		if (s != null) {
			wallet = s.getWallet();
			subscribers.remove(s); // remove it
		} else {
			throw new ExistingPlayerException("Player does not exist");
		}
		return wallet;
	}

	/**
	 * From Betting interface
	 */
	@Override
	public List<List<String>> listPlayers(String managerPwd)
			throws AuthenticationException {
		// Authenticate manager
		authenticateMngr(managerPwd);
		// Calculate the list of subscribers
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> subsData = new ArrayList<String>();
		for (Player s : subscribers) {
			subsData.add(s.getLastName());
			subsData.add(s.getFirstName());
			subsData.add(s.getNickname());

			result.add(subsData);
		}
		return result;
	}

	/**
	 * From Betting interface
	 */
	@Override
	public void authenticateMngr(String managerPwd)
			throws AuthenticationException {
		if (managerPwd == null)
			throw new AuthenticationException("invalid manager's password");

		if (!this.managerPassword.equals(managerPwd))
			throw new AuthenticationException("incorrect manager's password");
	}

	/**
	 * search a subscriber by username
	 * 
	 * @param username
	 *            the username of the subscriber.
	 * 
	 * @return the found subscriber or null
	 */
	private Player searchPlayerByUsername(String username) {
		if (username == null)
			return null;
		for (Player s : subscribers) {
			if (s.getNickname() == username) {
				return s;
			}
		}
		return null;
	}

	/**
	 * From Betting interface
	 */
	@Override
	public void addCompetition(String competition, Calendar closingDate,
			Collection<Competitor> competitors, String managerPwd)
			throws AuthenticationException, ExistingCompetitionException,
			CompetitionException, BadParametersException {
				authenticateMngr(managerPwd);
				Date dateOfClosing = closingDate.getTime();
				Competitor[] comps = (Competitor[]) competitors.toArray();
				this.mngInt.addNewCompetition(competition, dateOfClosing, comps);
			}

	/**
	 * From Betting interface
	 */
	@Override
	public void cancelCompetition(String competition, String managerPwd)
			throws AuthenticationException, ExistingCompetitionException,
			CompetitionException {
				authenticateMngr(managerPwd);
				this.mngInt.cancelCompetition(competition);
			}

	/**
	 * From Betting interface
	 */
	@Override
	public void deleteCompetition(String competition, String managerPwd)
			throws AuthenticationException, ExistingCompetitionException,
			CompetitionException {
				authenticateMngr(managerPwd);				
				try {
					this.mngInt.deleteCompetition(competition);
				} catch (BadParametersException e) {
					throw new ExistingCompetitionException();
				}
			}
	
	/**
	 * From Betting Interface
	 */
	@Override
	public void addCompetitor(String competition, Competitor competitor,
			String managerPwd) throws AuthenticationException,
			ExistingCompetitionException, CompetitionException,
			ExistingCompetitorException, BadParametersException {
				authenticateMngr(managerPwd);
				this.mngInt.addCompetitorToCompetition(competition, competitor);
			}

	/**
	 * From Betting interface
	 */
	@Override
	public Competitor createCompetitor(String lastName, String firstName,
			String borndate, String managerPwd) throws AuthenticationException, BadParametersException {
				authenticateMngr(managerPwd);
				Competitor c = new Competitor();
				try {
					c = new Competitor(firstName, lastName, new Date(borndate));
					this.mngInt.addNewCompetitor(firstName, lastName, borndate);				
				} catch (IncorrectString e) {
					throw new BadParametersException();
				}
				return c;
			}

	/**
	 * From Bettting interface
	 */
	@Override
	public Competitor createCompetitor(String name, String managerPwd)
			throws AuthenticationException,
			BadParametersException {
				authenticateMngr(managerPwd);
				Competitor c = new Competitor();
				try {
					c = new Competitor(name);
					this.mngInt.addNewCompetitor(name);
				} catch (IncorrectString e) {
					throw new BadParametersException();
				}
				return c;
			}
		
	/**
	 * From Betting interface.
	 */
	@Override
	public void deleteCompetitor(String competition, Competitor competitor,
			String managerPwd) throws AuthenticationException,
			ExistingCompetitionException, CompetitionException,
			ExistingCompetitorException {
				authenticateMngr(managerPwd);
				this.mngInt.removeCompetitorfromCompetition(competition, competitor);
			}

	/**
	 * From Betting interface.
	 */
	@Override
	public void creditPlayer(String username, long numberTokens, String managerPwd)
			throws AuthenticationException, ExistingPlayerException,
			BadParametersException {
				authenticateMngr(managerPwd);
				this.mngInt.changeWallet(username, numberTokens);
			}
	
	/**
	 * From Betting interface.
	 */
	@Override
	public void debitPlayer(String username, long numberTokens, String managerPwd)
			throws AuthenticationException, ExistingPlayerException,
			PlayerException, BadParametersException {
				authenticateMngr(managerPwd);
				this.mngInt.changeWallet(username, -1*numberTokens);
			}

	/** 
	 * From Betting interface
	 */
	@Override
	public void settleWinner(String competition, Competitor winner, String managerPwd)
			throws AuthenticationException, ExistingCompetitionException,
			CompetitionException {
				authenticateMngr(managerPwd);
				try {
					this.mngInt.creditSingleWinnerBet(competition, winner);
				} catch (BadParametersException e) {
					throw new CompetitionException();
				}
			}
		
	/**
	 * From Betting interface.
	 */
	@Override
	public void settlePodium(String competition, Competitor winner, Competitor second,
			Competitor third, String managerPwd)
			throws AuthenticationException, ExistingCompetitionException,
			CompetitionException {
				authenticateMngr(managerPwd);
				try {
					this.mngInt.creditPodiumBet(competition, winner, second, third);
				} catch (BadParametersException e) {
					throw new CompetitionException();
				}
			}

	/***********************************************************************
	 * SUBSCRIBERS FONCTIONNALITIES
	 ***********************************************************************/

	/**
	 * From Betting interface.
	 */
	@Override
	public void betOnWinner(long numberTokens, String competition, Competitor winner,
			String username, String pwdSubs) throws AuthenticationException,
			CompetitionException, ExistingCompetitionException,
			PlayerException, BadParametersException {
				Player p = searchPlayerByUsername(username);
				try {
					p.authentificate(pwdSubs);
				} catch (WrongPassword e) {
					throw new AuthenticationException();
				}
				PlayerInterface plrInt = new PlayerInterface(p);
				plrInt.makeBet(competition, numberTokens, winner.getId());
			}
	/**
	 * From Betting interface.
	 */
	@Override
	public void betOnPodium(long numberTokens, String competition, Competitor winner,
			Competitor second, Competitor third, String username, String pwdSubs)
			throws AuthenticationException, CompetitionException,
			ExistingCompetitionException, PlayerException,
			BadParametersException {
				Player p = searchPlayerByUsername(username);
				try {
					p.authentificate(pwdSubs);
				} catch (WrongPassword e) {
					throw new AuthenticationException();
				}
				PlayerInterface plrInt = new PlayerInterface(p);
				plrInt.makeBet(competition, numberTokens, winner.getId(), second.getId(), third.getId());
			}

	/**
	 * From Betting interface.
	 */
	@Override
	public void changeSubsPwd(String username, String newPwd, String currentPwd)
			throws AuthenticationException, BadParametersException {
				Player p = searchPlayerByUsername(username);
				try {
					p.authentificate(newPwd);
				} catch (WrongPassword e) {
					throw new AuthenticationException();
				}
				PlayerInterface plrInt = new PlayerInterface(p);
				try {
					plrInt.changePassword(currentPwd, newPwd, newPwd);
				} catch (WrongPassword e) {
					throw new AuthenticationException();
				}
			}

	/**
	 * From Betting interface.
	 */
	@Override
	public ArrayList<String> infosPlayer(String username, String pwdSubs)
			throws AuthenticationException {
				Player p = searchPlayerByUsername(username);
				try {
					p.authentificate(pwdSubs);
				} catch (WrongPassword e) {
					throw new AuthenticationException();
				}
				ArrayList<String> res = new ArrayList<String>();
				res.add(p.getLastName());
				res.add(p.getFirstName());
				res.add(p.getBornDate().toString());
				res.add(p.getNickname());
				res.add(String.valueOf(p.getWallet()));
				res.add(String.valueOf(p.getBettedWallet()));
				for (Bet b : p.getBetList()) {
					res.add(b.toString());
				}
				return res;
			}

	/**
	 * From Betting interface.
	 */
	@Override
	public void deleteBetsCompetition(String competition, String username,
			String pwdSubs) throws AuthenticationException,
			CompetitionException, ExistingCompetitionException {
				Competition comp = this.mngInt.searchACompetitionByName(competition);
				Player p = searchPlayerByUsername(username);
				PlayerInterface plrInt = new PlayerInterface(p);
				try {
					p.authentificate(pwdSubs);
				} catch (WrongPassword e) {
					throw new AuthenticationException();
				}
				for (Bet b : p.getBetList()) {
					if (comp.getBetList().contains(b)) {
						try {
							plrInt.deleteBet(b.getId());
						} catch (BadParametersException e) {
							throw new CompetitionException();
						}
					}
				}
			}

	/***********************************************************************
	 * VISITORS FONCTIONNALITIES
	 ***********************************************************************/
	 /**
	 * From Betting interface.
	 */
	@Override
	public List<List<String>> listCompetitions() {
		ArrayList<Competition> auxRes = this.mngInt.getAllCompetitions();
		List<List<String>> res = new ArrayList<List<String>>();
		for (Competition c : auxRes) {
			ArrayList<String> auxList = new ArrayList<String>();
			auxList.add(c.getName());
			auxList.add(c.getDate().toString());
			auxList.add(c.getBetList().toString());
			auxList.add(c.getCompetitorList().toString());
		}
		return res;
	}

	/**
	 * From Betting interface.
	 */
	@Override
	public Collection<Competitor> listCompetitors(String competition)
			throws ExistingCompetitionException, CompetitionException {
				Competition comp = this.mngInt.searchACompetitionByName(competition);
				return comp.getCompetitorList();
			}
	
	/**
	 * From Betting interface.
	 */
	@Override
	public ArrayList<String> consultBetsCompetition(String competition)
			throws ExistingCompetitionException {
				Competition comp = this.mngInt.searchACompetitionByName(competition);
				ArrayList<String> res = new ArrayList<String>();
				for (Bet b : comp.getBetList()) {
					res.add(b.toString());
				}
				return res;
			}

	/**
	 * From Betting interface.
	 */
	@Override
	public ArrayList<Competitor> consultResultsCompetition(String competition)
			throws ExistingCompetitionException {
				Competition comp = this.mngInt.searchACompetitionByName(competition);
				if (comp.getDate().after(new Date())) {
					throw new ExistingCompetitionException();
				}
				return comp.getResults();
			}

}