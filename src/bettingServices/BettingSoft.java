package bettingServices;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

import org.omg.PortableInterceptor.TRANSPORT_RETRY;

import bettingServices.exceptions.*;
import exceptions.BadParametersException;
import exceptions.IncorrectString;
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
	}

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
			s = new Player(firstName, lastName, username, password);
		} catch (IncorrectString e) {
			throw new BadParametersException();
		}
		// Add it to the collection of subscribers
		subscribers.add(s);
		return s.getPassword();
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
					c = new Competitor(firstName, lastName);					
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
	public 
}