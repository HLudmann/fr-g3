package tests.validation;

import bettingServices.exceptions.*;
import exceptions.*;

/**
 * 
 * @author segarra
 * 
 */
public abstract class TestBettingServices extends ValidationTest {

	public TestBettingServices() {
		super();
		this.launchTests();
	}

	private void launchTests() {

		// ****************************
		// * Tests "List players" *
		// ****************************
		System.out.println("\n * Tests pour lister joueurs\n");
		// Tests "entries" : null
		try {
			this.getBetting().listPlayers(null);
			System.out
					.println("la consultation des joueurs avec mdp gestionnaire non instanci� n'a pas lev� d'exception");
		} catch (AuthenticationException e) {
		}
		try {
			// Tests "number"
			if (this.getBetting().listPlayers(this.getManagerPassword())
					.size() != 0)
				System.out
						.println("il existe des joueurs alors que le m�tier vient d'�tre construit");

			System.out.println(">>>>> Tous les tests pass�s\n\n");

			// ********************************
			// * Tests "authenticate manager" *
			// ********************************
			System.out.println("\n * Tests pour autentifier manager\n");
			this.testAuthenticateMngr();
			System.out.println(">>>>> Tous les tests pass�s\n\n");

			// *********************
			// * Tests "subscribe" *
			// *********************
			System.out.println("\n * Tests pour inscrire un joueur\n");
			this.testSubscribe();
			System.out.println(">>>>> Tous les tests pass�s\n\n");

			// ****************************
			// * Tests "List players" *
			// ****************************
			System.out.println("\n * Tests pour lister joueurs\n");
			// Tests number
			if (this.getBetting().listPlayers(this.getManagerPassword())
					.size() != 6) {
				System.out.println("le nombre de joueurs est incorrect ");
				System.out.print("Il doit y avoir 6 joueurs. ");
				System.out.println("Il y en a "
						+ this.getBetting()
								.listPlayers(this.getManagerPassword())
								.size());
			}

			this.getBetting().subscribe(new String("Prou"),
					new String("Bernard"), new String("nanard"),
					new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
			if (this.getBetting().listPlayers(this.getManagerPassword())
					.size() != 7) {
				System.out.println("le nombre de joueurs est incorrect ");
				System.out.print("Il doit y avoir 7 joueurs. ");
				System.out.println("Il y en a "
						+ this.getBetting()
								.listPlayers(this.getManagerPassword())
								.size());
			}
			System.out.println(">>>>> Tous les tests pass�s\n\n");

			// ***********************
			// * Tests "Unsubscribe" *
			// ***********************
			System.out.println("\n * Tests pour d�sinscrire un joueur\n");

			testUnsubscribe();
			System.out.println(">>>>> Tous les tests pass�s\n\n");

		} catch (Exception e) {
			System.out.println("\n Exception impr�vue : " + e);
			e.printStackTrace();
		}
	}

	private void testAuthenticateMngr() {
		try {
			this.getBetting().authenticateMngr(new String("ilesLofotens"));
			System.out
					.println("l'utilisation d'un password gestionnaire incorrect n'a pas lev� d'exception");
		} catch (AuthenticationException e) {
		}
		try {
			this.getBetting().authenticateMngr(new String(" "));
			System.out
					.println("l'utilisation d'un password gestionnaire incorrect n'a pas lev� d'exception");
		} catch (AuthenticationException e) {
		}

		try {
			this.getBetting().authenticateMngr(null);
			System.out
					.println("l'utilisation d'un password gestionnaire non instanci� n'a pas lev� d'exception");
		} catch (AuthenticationException e) {
		}
	}

	private void testSubscribe() throws AuthenticationException,
			ExistingPlayerException, BadParametersException, PlayerException {

		// Tests entries : null
		try {
			this.getBetting().subscribe(null, new String("Albert"),
					new String("worldChamp"), new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
			System.out
					.println("l'ajout d'un joueur avec un nom non instanci� n'a pas lev� d'exception");
		} catch (BadParametersException e) {
		}
		try {
			this.getBetting().subscribe(new String("Duran"), null,
					new String("worldChamp"), new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
			System.out
					.println("l'ajout d'un joueur avec un pr�nom non instanci� n'a pas lev� d'exception");
		} catch (BadParametersException e) {
		}
		try {
			this.getBetting().subscribe(new String("Duran"),
					new String("Albert"), null, new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
			System.out
					.println("l'ajout d'un joueur avec un pseudo non instanci� n'a pas lev� d'exception");
		} catch (BadParametersException e) {
		}
		try {
			this.getBetting().subscribe(new String("Duran"),
					new String("Albert"), new String("worldChamp"), new String("1989-06-06T09:00:00.000Z"), null);
			System.out
					.println("l'ajout d'un joueur avec un mdp gestionnaire non instanci� n'a pas lev� d'exception");
		} catch (AuthenticationException e) {
		}

		// Tests entries : invalid format
		try {
			this.getBetting().subscribe(new String(" "), new String("Albert"),
					new String("worldChamp"), new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
			System.out
					.println("l'ajout d'un joueur avec un nom invalide ( ) n'a pas lev� d'exception");
		} catch (BadParametersException e) {
		}
		try {
			this.getBetting().subscribe(new String("Duran"), new String(" "),
					new String("worldChamp"), new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
			System.out
					.println("l'ajout d'un joueur avec un pr�nom invalide ( ) n'a pas lev� d'exception");
		} catch (BadParametersException e) {
		}
		try {
			this.getBetting().subscribe(new String("Duran87"),
					new String("Albert"), new String("worldChamp"),
					new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
			System.out
					.println("l'ajout d'un joueur avec un nom invalide (Duran87) n'a pas lev� d'exception");
		} catch (BadParametersException e) {
		}
		try {
			this.getBetting().subscribe(new String("87Duran87"),
					new String("Albert"), new String("worldChamp"),
					new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
			System.out
					.println("l'ajout d'un joueur avec un nom invalide (87Duran87) n'a pas lev� d'exception");
		} catch (BadParametersException e) {
		}

		try {
			this.getBetting().subscribe(new String("-Duran87"),
					new String("Albert"), new String("worldChamp"),
					new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
			System.out
					.println("l'ajout d'un joueur avec un nom invalide (-Duran87) n'a pas lev� d'exception");
		} catch (BadParametersException e) {
		}

		try {
			this.getBetting().subscribe(new String("Nobel"),
					new String("Alfred"), new String("tnt"),
					new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
			System.out
					.println("l'ajout d'un joueur avec un pseudo invalide (tnt) n'a pas lev� d'exception");
		} catch (BadParametersException e) {
		}

		try {
			this.getBetting().subscribe(new String("Nobel"),
					new String("Alfred"), new String("tnt988987-"),
					new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
			System.out
					.println("l'ajout d'un joueur avec un pseudo invalide (tnt988987-) n'a pas lev� d'exception");
		} catch (BadParametersException e) {
		}

		try {
			this.getBetting().subscribe(new String("Duran"),
					new String("Roberto"), new String("worldChamp"),
					new String("1989-06-06T09:00:00.000Z"), new String("abef"));
			System.out
					.println("l'ajout d'un joueur avec un password gestionnaire incorrect n'a pas lev� d'exception");
		} catch (AuthenticationException e) {
		}

		// Tests with valid parameters
		try {
			this.getBetting().subscribe(new String("Duran"),
					new String("Albert"), new String("fanfan"),
					new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
		} catch (ExistingPlayerException | BadParametersException e) {
			System.out
					.println("l'ajout d'un nouveau joueur (Duran, fanfan) a lev� une exception "
							+ e.getClass());
		}
		try {
			this.getBetting().subscribe(new String("Duran Dorton"),
					new String("Albert"), new String("fanfen"),
					new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
		} catch (ExistingPlayerException | BadParametersException e) {
			System.out
					.println("l'ajout d'un nouveau joueur (Duran Dorton, fanfen) a lev� une exception "
							+ e.getClass());
		}

		try {
			this.getBetting().subscribe(new String("Nobel"),
					new String("Alfred"), new String("9tnt988987"),
					new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
		} catch (BadParametersException e) {
			System.out
					.println("l'ajout d'un nouveau joueur (Nobel Alfred tnt988987) a lev� une exception");
		}

		// The same player
		try {
			this.getBetting().subscribe(new String("Duran"),
					new String("Albert"), new String("fanfan"),
					new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
			System.out
					.println("l'ajout d'un joueur existant (Duran, fanfan) n'a pas lev� d'exception");
		} catch (ExistingPlayerException e) {
		}
		// same firstname, username ; different lastname
		try {
			this.getBetting().subscribe(new String("Durano"),
					new String("Albert"), new String("fanfan"),
					new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
			System.out
					.println("l'ajout d'un joueur existant (Durano, fanfan) n'a pas lev� d'exception");
		} catch (ExistingPlayerException e) {
		}
		// same lastname, username; different firstname
		try {
			this.getBetting().subscribe(new String("Duran"),
					new String("Alfred"), new String("fanfan"),
					new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
			System.out
					.println("l'ajout d'un joueur existant (Duran, fanfan) n'a pas lev� d'exception ");
		} catch (ExistingPlayerException e) {
		}
		// same lastname, firstname; different username
		try {
			this.getBetting().subscribe(new String("Duran"),
					new String("Albert"), new String("fanfin"),
					new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
		} catch (ExistingPlayerException e) {
			System.out
					.println("l'ajout d'un joueur pas inscrit (Duran, fanfin) a lev� l'exception "
							+ e.getClass());
		}

		// same firstname; different lastname, username
		try {
			this.getBetting().subscribe(new String("Durano"),
					new String("Albert"), new String("fanfin"),
					new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
			System.out
					.println("l'ajout d'un joueur inscrit (Durano, fanfin) n'a pas lev� d'exception ");
		} catch (ExistingPlayerException e) {
		}

		// same lastname; different username and firstname
		try {
			this.getBetting().subscribe(new String("Duran"),
					new String("Morgan"), new String("fanfon"),
					new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
		} catch (ExistingPlayerException e) {
			System.out
					.println("l'ajout d'un nouveau joueur (Duran, fanfon) a lev� l'exception "
							+ e.getClass());
		}

		// different lastname, firstname and username
		try {
			this.getBetting().subscribe(new String("Mato"), new String("Anna"),
					new String("salto"), new String("1989-06-06T09:00:00.000Z"), this.getManagerPassword());
		} catch (ExistingPlayerException e) {
			System.out
					.println("l'ajout d'un nouveau joueur (Mato, salto) a lev� l'exception "
							+ e.getClass());
		}
	}

	private void testUnsubscribe() throws AuthenticationException,
			ExistingPlayerException {
		// Tests parameters : null
		try {
			this.getBetting().unsubscribe(null, this.getManagerPassword());
			System.out
					.println("retirer un joueur avec un pseudo non instanci� n'a pas lev� d'exception");
		} catch (ExistingPlayerException e) {
		}
		try {
			this.getBetting().unsubscribe(new String("nanard"), null);
			System.out
					.println("retirer un joueur avec un mdp gestionnaire non instanci� n'a pas lev� d'exception");
		} catch (AuthenticationException e) {
		}

		// Tests parameters: incorrect manager password
		try {
			this.getBetting()
					.unsubscribe(new String("nanard"), new String(" "));
			System.out
					.println(" retirer un joueur avec un mdp gestionnaire incorrect (\" \") n'a pas lev� d'exception");
		} catch (AuthenticationException e) {
		}

		// Test number
		int number = this.getBetting()
				.listPlayers(this.getManagerPassword()).size();
		if (number != 7) {
			System.out.println("le nombre de joueurs est incorrect");
			System.out.print("Il doit y avoir 7 joueurs. ");
			System.out.println("Il y en a "
					+ this.getBetting()
							.listPlayers(this.getManagerPassword()).size()
					+ ")");
		}

		// Unsubscribe an existing player
		try {
			this.getBetting().unsubscribe(new String("fanfan"),
					this.getManagerPassword());
		} catch (ExistingPlayerException e) {
			System.out
					.println("retirer un joueur existant (fanfan) a lev�e une exception");
		}

		number = this.getBetting().listPlayers(this.getManagerPassword())
				.size();

		// Unsubscribe an already unplayer player
		try {
			this.getBetting().unsubscribe(new String("fanfan"),
					this.getManagerPassword());
			System.out
					.println("retirer un joueur d�j� retir� (fanfan) n'a pas lev� d'exception");
		} catch (ExistingPlayerException e) {
		}

		// Unsubscribe a non existing player
		try {
			this.getBetting().unsubscribe(new String("tito"),
					this.getManagerPassword());
			System.out
					.println("retirer un joueur non enregistr� n'a lev� d'exception");
		} catch (ExistingPlayerException e) {
		}

		// Test number
		if (this.getBetting().listPlayers(this.getManagerPassword()).size() != 6) {
			System.out.println("le nombre de joueurs est incorrect");
			System.out.print("Il doit y avoir 6 joueurs. ");
			System.out.println("Il y en a "
					+ this.getBetting()
							.listPlayers(this.getManagerPassword()).size()
					+ ")");
		}
	}
}