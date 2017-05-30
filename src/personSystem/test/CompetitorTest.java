package personSystem.test;
import betSystem.Competition;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
	public void before() throws BadParametersException, IncorrectString {
		
		this.c1 = new Competitor("cun", "cunLastName", 1);
		this.c2 = new Competitor("cdeux", "cdeuxLastName", 2);
		this.c3 = new Competitor("ctrois", "ctroisLastName", 3);
			
		comp = new Competition("comp", new Date(), new Competitor[] {this.c1, this.c2, this.c3});
	}

	@Test
	public void testConstructor()throws IncorrectString{
		Competitor c = new Competitor("jean", "dupont", 0);

	}

	@Test
	public void testAddValidCompetition() throws IncorrectString, ItemAlreadyInList{
		Competitor c = new Competitor("jean", "dupont", 0);
		c.addCompetition(this.comp);
	}

	@Test(expected=ItemAlreadyInList.class)
	public void testAddCompetitionTwice() throws ItemAlreadyInList, IncorrectString{
		Competitor c = new Competitor("jean", "dupont", 0);

		c.addCompetition(this.comp);
		c.addCompetition(this.comp);
	}

	@Test(expected=ItemNotInList.class)
	public void testRemoveNotExistingCompetition() throws ItemNotInList, IncorrectString{
		Competitor c = new Competitor("jean", "dupont", 0);
		c.removeCompetition(this.comp);
	}

	@Test
	public void testRemoveValidCompetition() throws ItemAlreadyInList, ItemNotInList, IncorrectString{
		Competitor c = new Competitor("jean", "dupont", 0);
		c.addCompetition(this.comp);
		c.removeCompetition(this.comp);
	}



}
