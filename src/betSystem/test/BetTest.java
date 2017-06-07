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
	public void before() throws BadParametersException, IncorrectString, InvalidWallet, ItemAlreadyInList {
		this.p1 = new Player("pun", "punlastname", new Date(), "password", "plun", 100);
		
		this.p2 = new Player("pun", "pdeuxLastName", new Date(), "password", "pldeux", 100);

		
		this.c1 = new Competitor("cun", "cunLastName", new Date());
		this.c2 = new Competitor("cdeux", "cdeuxLastName", new Date());
		this.c3 = new Competitor("ctrois", "ctroisLastName", new Date());
			
		comp = new Competition("comp", new Date(), new Competitor[] {this.c1, this.c2, this.c3});
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testResultsSingle() throws ObjectNotFound, BadParametersException, ItemAlreadyInList, InvalidWallet {
		
		SingleWinnerBet b0 = new SingleWinnerBet(50, p1, comp, c1);
		SingleWinnerBet b1 = new SingleWinnerBet(40, p2, comp, c2);
		
		assertTrue(p1.getWallet() == 50);
		assertTrue(p2.getWallet() == 60);
		
		comp.results(new Competitor[] {c1, c2, c3});
		
		assertTrue(p1.getWallet() == 150);
		assertTrue(p2.getWallet() == 60);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testResultsPodium() throws ObjectNotFound, BadParametersException, ItemAlreadyInList, InvalidWallet {
		
//		System.out.println(p1.getWallet());
		
		PodiumBet b0 = new PodiumBet(50, p1, comp, c1, c2, c3);
		
//		System.out.println(p1.getWallet());
		
		PodiumBet b1 = new PodiumBet(40, p2, comp, c1, c3, c2);
		
//		System.out.println(p1.getWallet());
		
		assertTrue(p1.getWallet() == 50);
		assertTrue(p2.getWallet() == 60);
		
		comp.results(new Competitor[] {c1, c2, c3});
		
		assertTrue(p1.getWallet() == 150);
		assertTrue(p2.getWallet() == 60);
	}
	
	@SuppressWarnings("deprecation")
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
	public void testIdBet() throws ObjectNotFound, BadParametersException, InvalidWallet, ItemAlreadyInList {
//		System.out.println(p1.getWallet());
//		System.out.println(p2.getWallet());
		
		Bet b0 = new PodiumBet(50, p1, comp, c1, c2, c3);
		Bet b1 = new PodiumBet(40, p2, comp, c1, c3, c2);
		
//		System.out.println(p1.getWallet());
//		System.out.println(p2.getWallet());
		
		Bet b2 = new SingleWinnerBet(40, p1, comp, c1);
		Bet b3 = new SingleWinnerBet(40, p2, comp, c2);
		
//		System.out.println(b0.getId());
//		System.out.println(b1.getId());
//		System.out.println(b2.getId());
//		System.out.println(b3.getId());
		
		assertTrue(b0.getId() == 0);
		assertTrue(b1.getId() == 1);
		assertTrue(b2.getId() == 2);
		assertTrue(b3.getId() == 3);
		
	}
	
}

