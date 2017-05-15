package betSystem;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import personSystem.Competitor;
import personSystem.Player;

public class BetTest {

	private Player p1;
	private Player p2;
	private Competitor c1;
	private Competitor c2;
	private Competitor c3;
	private Competition comp;
	
	@Before
	public void before(){
		p1 = new Player("p1", "p1lastname", "password", "p1");
		p1.setWallet(100);
		
		p2 = new Player("p2", "p2LastName", "password", "p2");
		p2.setWallet(100);
		
		System.out.println("Initialisation");
		System.out.println("p1 Wallet : " + p1.getWallet());
		System.out.println("p2 Wallet : " + p2.getWallet());
		System.out.println("");
		
		c1 = new Competitor("c1", "c1LastName", 1);
		c2 = new Competitor("c2", "c2LastName", 2);
			
		comp = new Competition("comp", Calendar.getInstance());
	}
	
	@Test
	public void testResultsSingle() {
		
		p1.addBet(new SingleWinnerBet(50, p1, comp, c1));
		p2.addBet(new SingleWinnerBet(40, p2, comp, c2));
		
		assertTrue(p1.getWallet() == 50);
		assertTrue( p2.getWallet() == 60);
		
		
		Competitor[] l1 = new Competitor[1];
		l1[0] = c1;
		comp.results(l1);
		
		assertTrue(p1.getWallet() == 150);
		assertTrue(p2.getWallet() == 60);
	}
	
	@Test
	public void testResultsPodium(){
		
		p1.addBet(new PodiumBet(50, p1, comp, new Competitor[] {c1,c2,c3}));
		p2.addBet(new PodiumBet(40, p2, comp, new Competitor[] {c1,c3,c2}));
		
		assertTrue(p1.getWallet() == 50);
		assertTrue( p2.getWallet() == 60);
		
		comp.results(new Competitor[] {c1, c2, c3});
		
		assertTrue(p1.getWallet() == 150);
		assertTrue(p2.getWallet() == 60);
	}
	
	@Test
	public void testHasBegun(){
		Calendar futur = Calendar.getInstance();
		Calendar passe = Calendar.getInstance();
		futur.add(Calendar.DATE, 1);
		passe.add(Calendar.DATE, -1);
		
		assertTrue(comp.hasBegun());
		
		comp.setDate(futur);
		assertTrue(! comp.hasBegun());
		
		comp.setDate(passe);
		assertTrue(comp.hasBegun());
	}
	
	@Test
	public void testIdBet(){
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

