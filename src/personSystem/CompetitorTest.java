package personSystem;
import betSystem.Competition;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import exceptions.ItemNotInList;
import exceptions.ItemAlreadyInList;
import exceptions.IncorrectString;

public class CompetitorTest {


	@Test
	public void testConstructor()throws IncorrectString{
		Competitor c = new Competitor("jean", "dupont", 0);

	}

	@Test
	public void testAddValidCompetition() throws IncorrectString, ItemAlreadyInList{
		Competitor c = new Competitor("jean", "dupont", 0);
		c.addCompetition(new Competition());
	}

	@Test(expected=ItemAlreadyInList.class)
	public void testAddCompetitionTwice() throws ItemAlreadyInList, IncorrectString{
		Competitor c = new Competitor("jean", "dupont", 0);
		Competition comp = new Competition();

		c.addCompetition(comp);
		c.addCompetition(comp);
	}

	@Test(expected=ItemNotInList.class)
	public void testRemoveNotExistingCompetition() throws ItemNotInList,
																										IncorrectString{
		Competitor c = new Competitor("jean", "dupont", 0);
		c.removeCompetition(new Competition());
	}

	@Test
	public void testRemoveValidCompetition() throws ItemAlreadyInList,
																							ItemNotInList,
																							IncorrectString{
		Competitor c = new Competitor("jean", "dupont", 0);
		Competition comp = new Competition();
		c.addCompetition(comp);
		c.removeCompetition(comp);
	}



}
