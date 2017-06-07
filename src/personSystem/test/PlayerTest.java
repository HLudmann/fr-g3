package personSystem.test;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.Date;

import betSystem.*;
import personSystem.*;
import exceptions.IncorrectString;
import exceptions.InvalidWallet;
import exceptions.ItemAlreadyInList;
import exceptions.ItemNotInList;

public class PlayerTest {

	@Test
	public void testConstructor() throws IncorrectString{
		Player p = new Player("jean", "dupont", new Date(), "jdupont", "1234");
		assertTrue(p instanceof Player);
	}

	@Test
	public void testValidWallet() throws IncorrectString, InvalidWallet{
		Player p = new Player("jean", "dupont", new Date(), "jdupont", "1234");

		p.setWallet(0);
		p.setWallet(1257755);
		p.setWallet((long)Integer.MAX_VALUE+10);
	}

	@Test(expected=InvalidWallet.class)
	public void testInvalidWallet() throws IncorrectString, InvalidWallet{
		Player p = new Player("jean", "dupont", new Date(), "jdupont", "1234", -5);
		assertFalse(p instanceof Player);
	}

	@Test
	public void testAddBet() throws IncorrectString, InvalidWallet, ItemAlreadyInList{
		Player p = new Player("jean", "dupont", new Date(), "jdupont", "1234");
		p.addBet(new PodiumBet());
	}

	@Test(expected=ItemAlreadyInList.class)
	public void testAddBetTwice() throws IncorrectString, InvalidWallet, ItemAlreadyInList {
		Player p = new Player("jean", "dupont", new Date(), "jdupont", "1234");
		Bet b = new PodiumBet();
		p.addBet(b);
		p.addBet(b);
	}

	@Test
	public void testRemoveValidBet() throws IncorrectString, InvalidWallet, ItemAlreadyInList, ItemNotInList
	{
		Player p = new Player("jean", "dupont", new Date(), "jdupont", "1234");
		Bet b = new PodiumBet();
		p.addBet(b);
		p.removeBet(b);
	}

	@Test(expected=ItemNotInList.class)
	public void testRemoveInvalidBet() throws IncorrectString, InvalidWallet, ItemAlreadyInList, ItemNotInList											
	{
		Player p = new Player("jean", "dupont", new Date(), "jdupont", "1234");
		p.removeBet(new PodiumBet());
	}


}
