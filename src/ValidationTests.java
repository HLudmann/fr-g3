
import bettingServices.*;
import exceptions.*;
import tests.validation.*;

public class ValidationTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new TestBettingServices() {

			@Override
			public Betting plugToBetting() {
				try {
					return new BettingSoft("ilesCaimans");
				} catch (BadParametersException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			public String getManagerPassword() {
				return "ilesCaimans";
			}
		};

	}
}