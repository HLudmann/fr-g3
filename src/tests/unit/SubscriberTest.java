package tests.unit;

import static org.junit.Assert.*;

import org.junit.*;

import bettingServices.*;
import bettingServices.exceptions.BadParametersException;

public class SubscriberTest {

	private Subscriber subs;

	/*
	 * Subscribers should be created with valid strings
	 */
	@Test
	public void testSubscriber() throws BadParametersException {
		subs = new Subscriber(new String("Duran"), new String("Miguel"),
				new String("worldChamp"));
		assertTrue(subs.getFirstname().equals("Miguel"));
		assertTrue(subs.getLastname().equals("Duran"));
		assertTrue(subs.getUsername().equals("worldChamp"));
		assertTrue(subs.getPassword() != null);
	}

	@Test(expected = BadParametersException.class)
	public void testNullLastnameSubscriber() throws BadParametersException {
		new Subscriber(null, new String("Miguel"), new String("worldChamp"));
	}

	@Test(expected = BadParametersException.class)
	public void testNullFirstnameSubscriber() throws BadParametersException {
		new Subscriber(new String("Duran"), null, new String("worldChamp"));
	}

	@Test(expected = BadParametersException.class)
	public void testNullUsernameSubscriber() throws BadParametersException {
		new Subscriber(new String("Duran"), new String("Miguel"), null);
	}

	@Test(expected = BadParametersException.class)
	public void testInvalidLastnameSubscriber() throws BadParametersException {
		new Subscriber(new String(" "), new String("Miguel"), new String(
				"worldChamp"));
	}

	@Test(expected = BadParametersException.class)
	public void testInvalidFirstnameSubscriber() throws BadParametersException {
		new Subscriber(new String("Duran"), new String(""), new String(
				"worldChamp"));
	}

	@Test(expected = BadParametersException.class)
	public void testInvalidUsernameSubscriber() throws BadParametersException {
		new Subscriber(new String("Duran"), new String("Miguel"),
				new String(""));
	}

	@Test
	public void testHasUsername() throws BadParametersException {
		subs = new Subscriber(new String("Duran"), new String("Miguel"),
				new String("worldChamp"));
		
		assertTrue(subs.hasUsername("worldChamp"));
		assertFalse(subs.hasUsername("wddfkjddfk"));
	}

	@Test
	public void testEqualsObject() throws BadParametersException {
		subs = new Subscriber(new String("Duran"), new String("Miguel"),
				new String("worldChamp"));
		
		// Same subscriber = same username
		Subscriber s = new Subscriber(new String("Duran"),
				new String("Miguel"), new String("worldChamp"));
		assertTrue(subs.equals(s));

		s = new Subscriber(new String("Durano"), new String("Miguel"),
				new String("worldChamp"));
		assertTrue(subs.equals(s));

		// Different subscriber = different username
		s = new Subscriber(new String("Duran"), new String("Miguelo"),
				new String("worldC"));
		assertFalse(subs.equals(s));
	}
}