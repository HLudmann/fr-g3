package personSystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SystemUserTest {

	private Player p1;
	private Player p2;
	private Manager m1;
	private Manager m2;
	
	
	@Before
	public void beforeTest(){
		System.out.println("doing beforeTest");
		p1 = new Player("Joris","Thaveau","password1","Joris");
		p2 = new Player("PierreVictor","Besson","password2","PV");
		m1 = new Manager("Kevin","Surget","password3","Biro");
		m2 = new Manager("Bruno","Mateu","password4","Britaliope");
	}
	
	@Test
	public void testGetNicknamePlayer(){
		System.out.println("Testing getNickname for player...");
		assertEquals("wrong nickname returned ",p2.getNickname(),"PV");
	}

	@Test
	public void testGetPasswordPlayer(){
		System.out.println("Testing getPassword for player...");
		assertEquals("wrong password returned ",p1.getPassword(),"password1");
	}
	
	@Test
	public void testUpdatePasswordPlayer(){
		System.out.println("Testing updatePassword player...");
		p2.updatePassword("newpassword");
		assertEquals("wrong password returned ",p2.getPassword(),"newpassword");
	}
	
	@Test(expected = Exception.class)
	public void testAuthenticateErrorPlayer() throws Exception{
		System.out.println("Testing authenticate error for player...");
		p1.authenticate("isthisthepassword?");
	}
	
	@Test
	public void testAuthenticatePlayer() throws Exception{
		System.out.println("Testing authenticate for player...");
		Player p3 = new Player("Jean","Rousseau","password123","Jacque");
		p3.authenticate("password123");
		assertTrue(true);
	}
	
	@Test
	public void testGetNicknameManager(){
		System.out.println("Testing getNickname for manager...");
		assertEquals("wrong nickname returned ",m2.getNickname(),"Britaliope");
	}

	@Test
	public void testGetPasswordManager(){
		System.out.println("Testing getPassword for player...");
		assertEquals("wrong password returned ",m1.getPassword(),"password3");
	}
	
	@Test
	public void testUpdatePasswordManager(){
		System.out.println("Testing updatePassword player...");
		m2.updatePassword("newpassword");
		assertEquals("wrong password returned ",m2.getPassword(),"newpassword");
	}
	
	@Test(expected = Exception.class)
	public void testAuthenticateErrorManager() throws Exception{
		System.out.println("Testing authenticate error for player...");
		m1.authenticate("isthisthepassword?");
	}
	
	@Test
	public void testAuthenticateManager() throws Exception{
		System.out.println("Testing authenticate for player...");
		Manager m3 = new Manager("Jean","Rousseau","password123","Jacque");
		m3.authenticate("password123");
		assertTrue(true);
	}

}
