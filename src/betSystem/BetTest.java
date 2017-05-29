package betSystem;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import betSystem.exception.*;
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
	public void before() throws BadParametersException{
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
		c3 = new Competitor("c3", "c3LastName", 3);
		
		comp = new Competition("comp", Calendar.getInstance(),new Competitor[] {c1, c2, c3});
	}
	
	@Test(expected = BadParametersException.class)
	public void testWrongSingleAmount()throws BadParametersException, ObjectNotFound{
		p1.addBet(new SingleWinnerBet(-20,p1,comp,c1));
	}
	
	
	@Test(expected = BadParametersException.class)
	public void testWrongPodiumAmount()throws BadParametersException, ObjectNotFound{
		p1.addBet(new PodiumBet(-20,p1,comp,new Competitor[] {c1,c2,c3}));
	}
	
	
	@Test
	public void testResultsSingle() throws ObjectNotFound, BadParametersException {
		comp = new Competition ("comp", Calendar.getInstance(), new Competitor[] {c1, c2});
		
		p1.addBet(new SingleWinnerBet(50, p1, comp, c1));
		p2.addBet(new SingleWinnerBet(40, p2, comp, c2));
		
		assertTrue(p1.getWallet() == 50);
		assertTrue( p2.getWallet() == 60);
		
		comp.results(new Competitor[] {c1});
		
		assertTrue(p1.getWallet() == 150);
		assertTrue(p2.getWallet() == 60);
	}
	
	@Test
	public void testResultsPodium() throws BadParametersException, ObjectNotFound{
		
		p1.addBet(new PodiumBet(50, p1, comp, new Competitor[] {c1,c2,c3}));
		p2.addBet(new PodiumBet(40, p2, comp, new Competitor[] {c1,c3,c2}));
		
		assertTrue(p1.getWallet() == 50);
		assertTrue( p2.getWallet() == 60);
		
		comp.results(new Competitor[] {c1, c2, c3});
		
		assertTrue(p1.getWallet() == 150);
		assertTrue(p2.getWallet() == 60);
	}
	
	@Test(expected = BadParametersException.class)
	public void testInvalidPodiumResult() throws ObjectNotFound, BadParametersException {
		p1.addBet(new PodiumBet(50, p1, comp, new Competitor[] {c1,c2,c3}));
		p2.addBet(new PodiumBet(40, p2, comp, new Competitor[] {c1,c3,c2}));
		
		assertTrue(p1.getWallet() == 50);
		assertTrue( p2.getWallet() == 60);
		
		comp.results(new Competitor[] {c1, c2});
	}
	
	@Test(expected = BadParametersException.class)
	public void testInvalidSingleResult() throws ObjectNotFound, BadParametersException {
		comp = new Competition ("comp", Calendar.getInstance(), new Competitor[] {c1, c2});
		
		p1.addBet(new SingleWinnerBet(50, p1, comp, c1));
		p2.addBet(new SingleWinnerBet(40, p2, comp, c2));
		
		assertTrue(p1.getWallet() == 50);
		assertTrue( p2.getWallet() == 60);
		
		comp.results(new Competitor[] {c1, c2});
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
	public void testIdBet() throws BadParametersException, ObjectNotFound{
		Bet b0 = new PodiumBet(50, p1, comp, new Competitor[] {c1,c2,c3});
		Bet b1 = new PodiumBet(40, p2, comp, new Competitor[] {c1,c3,c2});
		Bet b2 = new SingleWinnerBet(50, p1, comp, c1);
		Bet b3 = new SingleWinnerBet(40, p2, comp, c2);
		
		assertTrue(b1.getId() == b0.getId()+1);
		assertTrue(b2.getId() == b0.getId()+2);
		assertTrue(b3.getId() == b0.getId()+3);
		
	}
	
	 @Test(expected = ObjectNotFound.class)
     public void testInvalidSingleWinnerBet() throws ObjectNotFound, BadParametersException {
		comp = new Competition ("comp", Calendar.getInstance(), new Competitor[] {c1, c2});
         SingleWinnerBet bet = new SingleWinnerBet(50,p1,comp,c3);
     }
     
	 @Test(expected = BadParametersException.class) 
     public void testInvalidPodiumBet() throws BadParametersException, ObjectNotFound{
    	 new PodiumBet(50,p1,comp, new Competitor[] {c1, c2});
     }
	 
     @Test(expected = ObjectNotFound.class)
     public void testInvalidCompetitors() throws BadParametersException, ObjectNotFound {
        comp = new Competition ("comp", Calendar.getInstance(), new Competitor[] {c1, c2});
        new PodiumBet(50, p1, comp, new Competitor[] {c1,c2,c3});
     }
     
     @Test(expected = BadParametersException.class)
     public void testInvalidCompetition() throws BadParametersException {
        comp = new Competition ("comp", Calendar.getInstance(), new Competitor[] {c1});
     }
	
     @Test(expected = MultiplicityException.class)
     public void testRemoveCompetitors() throws MultiplicityException{
    	 comp.removeCompetitor(c1);
    	 comp.removeCompetitor(c2);
     }
     
     @Test(expected = BadParametersException.class)
     public void testSameCompetitors() throws BadParametersException, ObjectNotFound {
    	 new PodiumBet(50, p1, comp, new Competitor[] {c1,c2,c2});
     }
     
}

