package personSystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	@Test
	public void testConstructor(){


		Competitor c=new Competitor("jean", "dupont", 0);
		//insance de compétition car person est abstract

		if (c.getFirstName()!= "jean"){
			fail("Constructor can't set firstName or getter is fucked up");
			//it's impossible to differentiate an error from the constructor or the getter
		}
		if (c.getLastName()!= "dupond"){
			fail("Constructor can't set lastName or getter is fucked up");
			//it impossible to differentiate an error in the constructor or in the getter
		}
	}

	@Test
	public void testSetFirstName(){
		Competitor c=new Competitor("jean", "dupont", 0);
		c.setFirstName("paul");
		if (c.getFirstName()!= "jean"){
			fail("Setter can't set firstName or getter is fucked up");
			//it's impossible to differentiate an error from the constructor or the getter
		}

	}

	@Test
	public void testSetLastName(){
		Competitor c=new Competitor("jean", "dupont", 0);
		c.setLastName("paul");
		if (c.getLastName()!= "jean"){
			fail("Setter can't set lastName or getter is fucked up");
			//it's impossible to differentiate an error from the constructor or the getter
		}
	}

	@Test(expected = Exception.class)
	public void testSetIncorrectFirstName(){
		//TODO
	}

	@Test(expected = Exception.class)
	public void testSetIncorrectLastName(){
		//TODO
	}

}
