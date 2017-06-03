package personSystem.test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import personSystem.*;
import exceptions.IncorrectString;

public class PersonTest {

	@Test
	public void testConstructor() throws IncorrectString{
		Competitor c=new Competitor("jean", "dupont", 0);
		//insance de compétition car person est abstract
	}

	@Test
	public void testSetFirstName() throws IncorrectString{
		Competitor c=new Competitor("jean", "dupont", 0);
		//insance de compétition car person est abstract

		try{
			c.setFirstName("paul");
			assertEquals("Setter can't set firstName or getter is fucked up",
									c.getFirstName(), "paul");
				//it's impossible to differentiate an error from the setter or the getter
			}
		catch (IncorrectString e) {
			fail("lastName can not be set");

		}
	}

	@Test
	public void testSetLastName() throws IncorrectString{
		Competitor c=new Competitor("jean", "dupont", 0);
		//insance de compétition car person est abstract

		try{
			c.setLastName("paul");

			assertEquals("Setter can't set lastName or getter is fucked up",
									c.getLastName(), "paul");
				//it's impossible to differentiate an error from the setter or the getter
		}
		catch (IncorrectString e){
			fail("lastName can't be set");
		}
	}

	@Test(expected = IncorrectString.class)
	public void testSetEmptyFirstName() throws IncorrectString{
		Competitor c=new Competitor("", "dupont", 0);
	}

	@Test(expected = IncorrectString.class)
	public void testSetEmptyLastName() throws IncorrectString{
		Competitor c=new Competitor("jean", "", 0);
	}

	@Test
	public void testSetIncorrectFirstName() throws IncorrectString{
		Competitor c=new Competitor("jean", "dupont", 0);
		//insance de compétition car person est abstract

		String[] incorrectChars = {"0", "1", "2", ".", ",", ";", "_", ":", "*", "%", "&", "@"};

		for (String item:incorrectChars){
			try{
				c.setFirstName(item);
				fail(String.format("Invalid string \'%s\' does not throws an exception", item));
			}
			catch (IncorrectString e){
				//this is normal
			}
		}

	}


	@Test
	public void testSetIncorrectLastName() throws IncorrectString{
		Competitor c=new Competitor("jean", "dupont", 0);
		//insance de compétition car person est abstract

		String[] incorrectChars = {"0", "1", "2", ".", ",", ";", "_", ":", "*", "%", "&", "@"};

		for (String item:incorrectChars){
			try{
				c.setLastName(item);
				fail(String.format("Invalid string \'%s\' does not throws an exception", item));
			}
			catch (IncorrectString e){
				//this is normal
			}
		}

	}

	@Test
	public void testSetCorrectFirstName() throws IncorrectString{
		Competitor c=new Competitor("jean", "dupont", 0);

		c.setFirstName("Éva");
		c.setFirstName("Marie-hélènne");
		c.setFirstName("Jean Pierre");
		c.setFirstName("Öykü");
	}

	@Test
	public void testSetCorrectLastName() throws IncorrectString{
		Competitor c=new Competitor("jean", "dupont", 0);

		c.setLastName("Matthieu");
		c.setLastName("Dupont-Aignan");
		c.setLastName("Mørk");
		c.setLastName("Erdoğan");

	}


}
