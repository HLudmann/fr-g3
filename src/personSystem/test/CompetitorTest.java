package personSystem.test;
import betSystem.Competition;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import personSystem.*;
import exceptions.*;

public class CompetitorTest {

	private Competitor c1;
	private Competitor c2;
	private Competitor c3;
	private Competition comp;

	@Before
	public void before() throws BadParametersException, IncorrectString, ItemAlreadyInList {
		
		this.c1 = new Competitor("cun", "cunLastName", new Date());
		this.c2 = new Competitor("cdeux", "cdeuxLastName", new Date());
		this.c3 = new Competitor("ctrois", "ctroisLastName", new Date());
			
		comp = new Competition("comp", new Date(), new Competitor[] {this.c1, this.c2, this.c3});
	}

	@Test
	public void testConstructor()throws IncorrectString{
		Competitor c = new Competitor("jean", "dupont", new Date());
		assertTrue(c instanceof Competitor);

	}

	@Test
	public void testAddValidCompetition() throws IncorrectString, ItemAlreadyInList{
		Competitor c = new Competitor("jean", "dupont", new Date());
		c.addCompetition(this.comp);
	}

	@Test(expected=ItemAlreadyInList.class)
	public void testAddCompetitionTwice() throws ItemAlreadyInList, IncorrectString{
		Competitor c = new Competitor("jean", "dupont", new Date());

		c.addCompetition(this.comp);
		c.addCompetition(this.comp);
	}

	@Test(expected=ItemNotInList.class)
	public void testRemoveNotExistingCompetition() throws ItemNotInList, IncorrectString{
		Competitor c = new Competitor("jean", "dupont", new Date());
		c.removeCompetition(this.comp);
	}

	@Test
	public void testRemoveValidCompetition() throws ItemAlreadyInList, ItemNotInList, IncorrectString{
		Competitor c = new Competitor("jean", "dupont", new Date());
		c.addCompetition(this.comp);
		c.removeCompetition(this.comp);
	}



}
