package personSystem;
import betSystem.Bet;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	
	private Player p;
	
	@Before
	public void beforeTest(){
		System.out.println("doing beforeTest");
		p = new Player("Jean","Rousseau","password123","Jacques");
	}
	
	@Test
	public void testGetWallet(){
		System.out.println("Testing getWallet...");
		assertEquals("wrong wallet returned ",p.getWallet(),0);
	}
	
	@Test
	public void testSetWallet(){
		System.out.println("Testing setWallet...");
		p.setWallet(100);
		assertEquals("wrong wallet returned ",p.getWallet(),100);
	}
	
	@Test
	public void testGetBetList(){
		System.out.println("Testing getBetList...");
		assertEquals("wrong BetList returned ",p.getBetList().size(),0);
	}
	
	@Test
	public void testAddBet(){
		System.out.println("Testing addBetList...");
		Bet b1 = new Bet();
		p.addBet(b1);
		assertEquals("wrong BetList returned ",p.getBetList().get(0),b1);
	}
	
	@Test
	public void testAddingSameBetTwice(){
		System.out.println("Testing addBet...");
		Player p2 = new Player("ok","pkpas","fautiltjs","pseudo");
		Bet b2 = new Bet();
		p2.addBet(b2);
		p2.addBet(b2);
		assertEquals("wrong BetList returned ",p2.getBetList().size(),1);
	}
	
	@Test
	public void testRemoveBet(){
		System.out.println("Testing removeBet...");
		Player p2 = new Player("ok","pkpas","fautiltjs","pseudo");
		Bet b2 = new Bet();
		p2.addBet(b2);
		p2.removeBet(b2);
		assertEquals("wrong BetList returned ",p.getBetList().size(),0);
	}

}
