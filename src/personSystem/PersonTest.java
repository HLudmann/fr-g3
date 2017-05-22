package personSystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	private Competitor c1;
	private Competitor c2;
	private Player p1;
	private Player p2;
	private Manager m1;
	private Manager m2;
	
	
	@Before
	public void beforeTest(){
		System.out.println("doing beforeTest");
		c1 = new Competitor("Jean","Rousseau",11);
		c2 = new Competitor("Michel","Cesar",42);
		p1 = new Player("Joris","Thaveau","password1","Joris");
		p2 = new Player("PierreVictor","Besson","password2","PV");
		m1 = new Manager("Kevin","Surget","password3","Kevin");
		m2 = new Manager("Bruno","Mateu","password4","Bruno");
	}
	
	@Test
	public void testGetFirstNameComp(){
		System.out.println("Testing getFirstName for comp...");
		assertEquals("wrong first name returned ",c1.getFirstName(),"Jean");
	}

	@Test
	public void testGetLastNameComp(){
		System.out.println("Testing getLastName for comp...");
		assertEquals("wrong last name returned ",c1.getLastName(),"Rousseau");
	}

	@Test
	public void testSetFirstNameComp(){
		System.out.println("Testing setFirstName for comp...");
		c2.setFirstName("Hugo");
		assertEquals("wrong first name returned ",c2.getFirstName(),"Hugo");
	}

	@Test
	public void testSetLastNameComp(){
		System.out.println("Testing setLastName for comp...");
		c2.setLastName("Victor");
		assertEquals("wrong last name returned ",c2.getLastName(),"Victor");
	}
	
	@Test
	public void testGetFirstNamePlayer(){
		System.out.println("Testing getFirstName for player...");
		assertEquals("wrong first name returned ",p1.getFirstName(),"Joris");
	}

	@Test
	public void testGetLastNamePlayer(){
		System.out.println("Testing getLastName for player...");
		assertEquals("wrong last name returned ",p1.getLastName(),"Thaveau");
	}

	@Test
	public void testSetFirstNamePlayer(){
		System.out.println("Testing setFirstName for player...");
		c2.setFirstName("Hugo");
		assertEquals("wrong first name returned ",p2.getFirstName(),"Hugo");
	}

	@Test
	public void testSetLastNamePlayer(){
		System.out.println("Testing setLastName for player...");
		c2.setLastName("Victor");
		assertEquals("wrong last name returned ",p2.getLastName(),"Victor");
	}
	
	@Test
	public void testGetFirstNameManager(){
		System.out.println("Testing getFirstName for manager...");
		assertEquals("wrong first name returned ",m1.getFirstName(),"Kevin");
	}

	@Test
	public void testGetLastNameManager(){
		System.out.println("Testing getLastName for manager...");
		assertEquals("wrong last name returned ",m1.getLastName(),"Surget");
	}

	@Test
	public void testSetFirstNameManager(){
		System.out.println("Testing setFirstName for manager...");
		c2.setFirstName("Hugo");
		assertEquals("wrong first name returned ",m2.getFirstName(),"Hugo");
	}

	@Test
	public void testSetLastNameManager(){
		System.out.println("Testing setLastName for manager...");
		c2.setLastName("Victor");
		assertEquals("wrong last name returned ",m2.getLastName(),"Victor");
	}

}
