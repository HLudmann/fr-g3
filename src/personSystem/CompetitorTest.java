package personSystem;
import betSystem.Competition;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CompetitorTest {

	private Competitor c1;
	private Competitor c2;


	@Before
	public void beforeTest(){
		System.out.println("doing beforeTest");
		c1 = new Competitor("Jean","Rousseau",11);
		c2 = new Competitor("Michel","Cesar",42);
	}


	@Test
	public void testGetId(){
		System.out.println("Testing getId...");
		assertEquals("wrong id returned ",c1.getId(),11);
	}

	@Test
	public void testGetCompetitionList(){
		System.out.println("Testing getCompetitionList");
		assertTrue("list not correct",c1.getCompetitionList() instanceof ArrayList<?>);
	}

	@Test
	public void testAddCompetition() throws Exception{
		System.out.println("Testing addCompetition");
		try{
			c1.addCompetition(new Competition());
		}
		catch (Exception e){
			fail("couldnt add new Competition");
		}

	}

	@Test(expected = Exception.class)
	public void testAddTwoIdenticCompetitions() throws Exception{
		System.out.println("Adding 2 identic competitions");
		Competition eve = new Competition();
		c2.addCompetition(eve);
		c2.addCompetition(eve);
	}

	@Test
	public void testRemoveCompetition() {
		System.out.println("Testing removeCompetition");
		try{
			Competition eve = new Competition();
			c1.addCompetition(eve);
			c1.removeCompetition(eve);
		}
		catch (Exception e){
			fail("couldnt remove competition");
		}
	}

	@Test(expected = Exception.class)
	public void testRemoveNonExistingCompetition() throws Exception{
		System.out.println("Removing non existing competition");
		c2.removeCompetition(new Competition());
	}

}
