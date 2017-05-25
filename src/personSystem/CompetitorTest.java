package personSystem;
import betSystem.Competition;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import exceptions.CompetitionNotInList;
import exceptions.CompetitionAlreadyInList;
import exceptions.IncorrectString;

public class CompetitorTest {


	@Test
	public void testConstructor()throws IncorrectString{
		Competitor c = new Competitor("jean", "dupont", 0);

	}

	@Test
	public void testAddValidCompetition() throws IncorrectString, CompetitionAlreadyInList{
		Competitor c = new Competitor("jean", "dupont", 0);
		c.addCompetition(new Competition());
	}

	@Test(expected=CompetitionAlreadyInList.class)
	public void testAddCompetitionTwice() throws CompetitionAlreadyInList, IncorrectString{
		Competitor c = new Competitor("jean", "dupont", 0);
		Competition comp = new Competition();

		c.addCompetition(comp);
		c.addCompetition(comp);
	}

	@Test(expected=CompetitionNotInList.class)
	public void testRemoveNotExistingCompetition() throws CompetitionNotInList,
																										IncorrectString{
		Competitor c = new Competitor("jean", "dupont", 0);
		c.removeCompetition(new Competition());
	}

	@Test
	public void testRemoveValidCompetition() throws CompetitionAlreadyInList,
																							CompetitionNotInList,
																							IncorrectString{
		Competitor c = new Competitor("jean", "dupont", 0);
		Competition comp = new Competition();
		c.addCompetition(comp);
		c.removeCompetition(comp);
	}



}
