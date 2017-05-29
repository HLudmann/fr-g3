package personSystem;
import betSystem.Bet;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.IncorrectString;
import exceptions.InvalidWallet;
import exceptions.ItemAlreadyInList;
import exceptions.ItemNotInList;

public class PlayerTest {

	@Test
	public void testConstructor() throws IncorrectString{
		Player p = new Player("jean", "dupont", "jdupont", "1234");
	}

	@Test
	public void testValidWallet() throws IncorrectString, InvalidWallet{
		Player p = new Player("jean", "dupont", "jdupont", "1234");

		p.setWallet(0);
		p.setWallet(1257755);
		p.setWallet((long)Integer.MAX_VALUE+10);
	}

	@Test(expected=InvalidWallet.class)
	public void testInvalidWallet() throws IncorrectString, InvalidWallet{
		Player p = new Player("jean", "dupont", "jdupont", "1234", -5);
	}

	@Test
	public void testAddBet() throws IncorrectString, InvalidWallet, ItemAlreadyInList{
		Player p = new Player("jean", "dupont", "jdupont", "1234");
		p.addBet(new Bet());
	}

	@Test(expected=ItemAlreadyInList.class)
	public void testAddBetTwice() throws IncorrectString, InvalidWallet, ItemAlreadyInList{
		Player p = new Player("jean", "dupont", "jdupont", "1234");
		Bet b = new Bet();
		p.addBet(b);
		p.addBet(b);
	}

	@Test
	public void testRemoveValidBet() throws IncorrectString,
																			InvalidWallet,
																		  ItemAlreadyInList,
																			ItemNotInList
																														{
		Player p = new Player("jean", "dupont", "jdupont", "1234");
		Bet b = new Bet();
		p.addBet(b);
		p.removeBet(b);
	}

	@Test(expected=ItemNotInList.class)
	public void testRemoveInvalidBet() throws IncorrectString,
																			InvalidWallet,
																		  ItemAlreadyInList,
																			ItemNotInList
	{
		Player p = new Player("jean", "dupont", "jdupont", "1234");
		p.removeBet(new Bet());
	}


}
