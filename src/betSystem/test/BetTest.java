package betSystem.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.*;

import betSystem.exception.*;
import betSystem.*;
import exceptions.*;
import personSystem.*;

public class BetTest {

	private Player p1;
	private Player p2;
	private Competitor c1;
	private Competitor c2;
	private Competitor c3;
	private Competition comp;
	
	@Before
	public void before() throws BadParametersException, IncorrectString, InvalidWallet {
		this.p1 = new Player("pun", "punlastname", "password", "plun", 100);
		
		this.p2 = new Player("pun", "pdeuxLastName", "password", "pldeux", 100);
		
		// System.out.println("Initialisation");
		// System.out.println("p1 Wallet : " + p1.getWallet());
		// System.out.println("p2 Wallet : " + p2.getWallet());
		// System.out.println("");
		
		this.c1 = new Competitor("cun", "cunLastName", 1);
		this.c2 = new Competitor("cdeux", "cdeuxLastName", 2);
		this.c3 = new Competitor("ctrois", "ctroisLastName", 3);
			
		comp = new Competition("comp", new Date(), new Competitor[] {this.c1, this.c2, this.c3});
	}
	
	@Test
	public void testResultsSingle() throws ObjectNotFound, BadParametersException, ItemAlreadyInList, InvalidWallet {
		
		p1.addBet(new SingleWinnerBet(50, p1, comp, c1));
		p2.addBet(new SingleWinnerBet(40, p2, comp, c2));
		
		assertTrue(p1.getWallet() == 50);
		assertTrue(p2.getWallet() == 60);
		
		comp.results(new Competitor[] {c1, c2, c3});
		
		assertTrue(p1.getWallet() == 150);
		assertTrue(p2.getWallet() == 60);
	}
	
	@Test
	public void testResultsPodium() throws ObjectNotFound, BadParametersException, ItemAlreadyInList, InvalidWallet {
		
		p1.addBet(new PodiumBet(50, p1, comp, new Competitor[] {c1,c2,c3}));
		p2.addBet(new PodiumBet(40, p2, comp, new Competitor[] {c1,c3,c2}));
		
		assertTrue(p1.getWallet() == 50);
		assertTrue(p2.getWallet() == 60);
		
		comp.results(new Competitor[] {c1, c2, c3});
		
		assertTrue(p1.getWallet() == 150);
		assertTrue(p2.getWallet() == 60);
	}
	
	@Test
	public void testHasBegun() {
		Date futur = new Date();
		Date passe = new Date();
		futur.setDate(futur.getDate()+1);
		passe.setDate(passe.getDate()-1);
		
		assertTrue(comp.hasBegun());
		
		comp.setDate(futur);
		assertTrue(!comp.hasBegun());
		
		comp.setDate(passe);
		assertTrue(comp.hasBegun());
	}
	
	@Test
	public void testIdBet() throws ObjectNotFound, BadParametersException {
		Bet b0 = new PodiumBet(50, p1, comp, new Competitor[] {c1,c2,c3});
		Bet b1 = new PodiumBet(40, p2, comp, new Competitor[] {c1,c3,c2});
		Bet b2 = new SingleWinnerBet(50, p1, comp, c1);
		Bet b3 = new SingleWinnerBet(40, p2, comp, c2);
		
		assertTrue(b0.getId() == 0);
		assertTrue(b1.getId() == 1);
		assertTrue(b2.getId() == 2);
		assertTrue(b3.getId() == 3);
		
	}
	
}

