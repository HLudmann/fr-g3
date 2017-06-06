package tests.validation.withoutPersistence;

import java.text.SimpleDateFormat;
import java.util.*;

import bettingServices.*;
import personSystem.*;
import utils.MyCalendar;

/**
 * 
 * @author segarra
 * 
 */
public class AddCompetitionValidationTests {
	private FirstIncrementValidationTests increment;
	private boolean addCompetition = false;
	private boolean addTeamCompetition = false;

	private ArrayList<Competitor> competitors;
	private ArrayList<Competitor> competitorTeams;
	private Competitor pc1, pc2, pc3, madrid, barca;

	private Scanner sc = new Scanner(System.in);
	public String c = "x";

	public String getResponse() {
		String s = "x";
		while (!s.equals("y") && !s.equals("n")) {
			s = sc.next();
		}
		return s;
	}

	public AddCompetitionValidationTests() {
		increment = FirstIncrementValidationTests.getIncrement();

		System.out.print("  ----- Comp�tition sans �quipes (y/n) ?\n");
		c = getResponse();
		if (c.equals("y")) {
			this.addCompetition = true;

			this.setUp();

			this.testNullParameters();
			System.out.println("  >>>>> Fin tests param�tre non instanci�\n");

			this.testInvalidParameters();
			System.out.println("  >>>>> Fin tests param�tre invalide\n");

			this.testNotEnoughCompetitors();
			System.out.println("  >>>>> Fin tests pas assez de comp�titeurs\n");

			this.testInThePast();
			System.out.println("  >>>>> Fin tests comp�tition dans le pass�\n");

			this.testOK();
			System.out.println("  >>>>> Fin tests param�tres valides\n");

			this.testExisting();
			System.out.println("  >>>>> Fin tests comp�tition existante\n");
		}

		// Soit les �quipes ont juste un nom
		// Soit les �quipes ont des membres
		System.out
				.print("  ----- Comp�tition avec �quipes sans membres ? (y/n)\n");
		c = getResponse();
		if (c.equals("y")) {
			this.addTeamCompetition = true;
			this.setUpTeam();

			this.testTeamNullParameters();
			System.out.println("  >>>>> Fin tests param�tre non instanci�\n");

			this.testTeamInvalidParameters();
			System.out.println("  >>>>> Fin tests param�tre invalide\n");

			this.testTeamNotEnoughCompetitors();
			System.out.println("  >>>>> Fin tests pas assez de comp�titeurs\n");

			this.testTeamInThePast();
			System.out.println("  >>>>> Fin tests comp�tition dans le pass�\n");

			this.testTeamOK();
			System.out.println("  >>>>> Fin tests param�tres valides\n");

			this.testTeamExisting();
			System.out.println("  >>>>> Fin tests comp�tition existante\n");
		} else {
			System.out
					.print("  ------- Comp�tition avec �quipes ayant des membres ? (y/n)\n");
			c = this.getResponse();
			if (c.equals("y")) {
				this.addTeamCompetition = true;

				this.testTeamWithCompetitorsNullParameters();
				System.out
						.println("  >>>>> Fin tests param�tre non instanci�\n");

				this.testTeamWithCompetitorsInvalidParameters();
				System.out.println("  >>>>> Fin tests param�tre invalide\n");

				this.testTeamWithCompetitorsNotEnoughCompetitors();
				System.out
						.println("  >>>>> Fin tests pas assez de comp�titeurs\n");

				this.testTeamWithCompetitorsInThePast();
				System.out
						.println("  >>>>> Fin tests comp�tition dans le pass�\n");

				this.testTeamWithCompetitorsOK();
				System.out.println("  >>>>> Fin tests param�tres valides\n");

				this.testTeamWithCompetitorsExisting();
				System.out.println("  >>>>> Fin tests comp�tition existante\n");
			}
		}

		System.out.print("  ------- Lister les comp�titions ? (y/n)\n");
		c = this.getResponse();
		if (c.equals("y")) {
			new ListCompetitionsValidationTests(addCompetition,
					addTeamCompetition);
		}
	}

	private void setUp() {
		try {
			// On fixe la date au 01/08/2011
			MyCalendar.setDate(2011, 8, 1);
			System.out.println("Nous sommes au " + MyCalendar.getDate());

			competitors = new ArrayList<Competitor>();
			competitors.add(increment.getBetting().createCompetitor(
					new String("Durant"),
					new String("Miguel"),
					new SimpleDateFormat("dd-MM-yyyy").format(new MyCalendar(
							1984, 7, 20).getTime()),
					increment.getManagerPassword()));
			competitors.add(increment.getBetting().createCompetitor(
					new String("Duranto"),
					new String("Miguel"),
					new SimpleDateFormat("dd-MM-yyyy").format(new MyCalendar(
							1983, 12, 13).getTime()),
					increment.getManagerPassword()));
		} catch (Exception e) {
			System.out.println("Exception impr�vue " + e.getClass());
			e.printStackTrace();
		}
	}

	private void testNullParameters() {
		// Tests entries : null
		try {
			increment.getBetting().addCompetition(null, MyCalendar.getDate(),
					competitors, increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec un nom non instanci� n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			increment.getBetting().addCompetition(new String("une_compet"),
					null, competitors, increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec une date de cl�ture non instanci�e n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			increment.getBetting().addCompetition(new String("une_compet"),
					MyCalendar.getDate(), null, increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec une liste de comp�titeurs non instanci�e n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			increment.getBetting().addCompetition(new String("une_compet"),
					MyCalendar.getDate(), competitors, null);
			System.out
					.println("Ajout d'une comp�tition avec un mdp gestionnaire non instanci� n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			increment.getBetting().addCompetition(null, MyCalendar.getDate(),
					competitors, null);
			System.out
					.println("Ajout d'une comp�tition avec un nom et mdp gestionnaire non instanci�s n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			increment.getBetting().addCompetition(null, MyCalendar.getDate(),
					null, null);
			System.out
					.println("Ajout d'une competition avec un nom, comp�titeurs et mdp gestionnaire non instanci�s n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
	}

	private void testInvalidParameters() {
		// Tests entries : invalid format
		try {
			increment.getBetting().addCompetition(new String(" "),
					MyCalendar.getDate(), competitors,
					increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec un nom invalide (\" \") n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			increment.getBetting().addCompetition(new String("a compet"),
					MyCalendar.getDate(), competitors,
					increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec un nom invalide (a compet) n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			increment.getBetting().addCompetition(new String("a_compet"),
					new MyCalendar(2014, 2, 1), competitors, new String(" "));
			System.out
					.println("l'ajout d'une comp�tition avec un mdp gestionnaire invalide (\" \") n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
	}

	private void testNotEnoughCompetitors() {

		// Less than two competitors
		try {
			increment.getBetting().addCompetition(new String("a_compet"),
					new MyCalendar(2014, 2, 1), new ArrayList<Competitor>(),
					increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec moins de deux comp�titeurs (0) n'a pas lev� d'exception ");
		} catch (Exception e) {
		}

		// Less than two competitors
		ArrayList<Competitor> compts = new ArrayList<Competitor>();
		try {

			compts.add(increment.getBetting().createCompetitor(
					new String("Dupont"),
					new String("Jose"),
					new SimpleDateFormat("dd-MM-yyyy").format(new MyCalendar(
							1981, 1, 6).getTime()),
					increment.getManagerPassword()));
		} catch (Exception e) {
			assert (false);
		}
		try {
			increment.getBetting().addCompetition(new String("a_compet"),
					new MyCalendar(2014, 2, 1), compts,
					increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec moins de deux comp�titeurs (1) n'a pas lev� d'exception ");
		} catch (Exception e) {
		}

		try {
			// The same two competitors
			compts.add(increment.getBetting().createCompetitor(
					new String("Dupont"),
					new String("Jose"),
					new SimpleDateFormat("dd-MM-yyyy").format(new MyCalendar(
							1981, 1, 6).getTime()),
					increment.getManagerPassword()));
		} catch (Exception e) {
			assert (false);
		}

		try {
			increment.getBetting().addCompetition(new String("a_compet"),
					new MyCalendar(2014, 2, 1), compts,
					increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec deux comp�titeurs identiques n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
	}

	private void testInThePast() {
		// Date de clot�re dans le pass�
		try {
			// Par rapport � la "date simul�e"
			increment.getBetting().addCompetition(new String("a_compet"),
					new MyCalendar(2009, 2, 1), competitors,
					increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec une date dans le pass� n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
	}

	private void testOK() {
		try {
			increment.getBetting().addCompetition(new String("a_compet"),
					new MyCalendar(2020, 2, 1), competitors,
					increment.getManagerPassword());
			// Suppose listCompetitions correct
			if (increment.getBetting().listCompetitions().size() != 1) {
				System.out
						.println("le nombre de comp�titions est incorrect (1 != "
								+ increment.getBetting().listCompetitions()
										.size() + ")");
			}
		} catch (Exception e) {
			System.out
					.println("Ajout d'une comp�tition valide (a_compet,01-02-2020) a lev� l'exception "
							+ e.getClass());
			e.printStackTrace();
		}
		try {
			increment.getBetting().addCompetition(new String("another-compet"),
					new MyCalendar(2020, 2, 1), competitors,
					increment.getManagerPassword());
			// Suppose listCompetitions correct
			if (increment.getBetting().listCompetitions().size() != 2) {
				System.out
						.println("le nombre de comp�titions est incorrect (2 != "
								+ increment.getBetting().listCompetitions()
										.size() + ")");
			}
		} catch (Exception e) {
			System.out
					.println("Ajout d'une comp�tition valide (another-compet,01-02-2020) a lev� l'exception "
							+ e.getClass());
			e.printStackTrace();
		}
	}

	private void testExisting() {

		try {
			increment.getBetting().addCompetition(new String("a_compet"),
					new MyCalendar(2014, 2, 1), competitors,
					increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition d�j� existante (a_compet,01-02-2014) n'a pas lev� d'exception");
		} catch (Exception e) {
			// Suppose listCompetitions correct
			if (increment.getBetting().listCompetitions().size() != 2) {
				System.out
						.println("le nombre de comp�titions est incorrect (2 != "
								+ increment.getBetting().listCompetitions()
										.size() + ")");
			}
		}

		try {
			increment.getBetting().addCompetition(new String("a_compet"),
					new MyCalendar(2020, 2, 1), competitors,
					increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition d�j� existante (a_compet,01-02-2020) n'a pas lev� d'exception");
		} catch (Exception e) {
			// Suppose listCompetitions correct
			if (increment.getBetting().listCompetitions().size() != 2) {
				System.out
						.println("le nombre de comp�titions est incorrect (2 != "
								+ increment.getBetting().listCompetitions()
										.size() + ")");
			}
		}
	}

	private void setUpTeam() {

		try {
			// Set current date to 01/08/2011
			MyCalendar.setDate(2011, 8, 1);
			System.out.println("Nous sommes au " + MyCalendar.getDate());

			// Suppose createCompetitor correct
			competitorTeams = new ArrayList<Competitor>();
			competitorTeams.add(increment.getBetting().createCompetitor(
					new String("Madrid"), increment.getManagerPassword()));
			competitorTeams.add(increment.getBetting().createCompetitor(
					new String("Barca"), increment.getManagerPassword()));
		} catch (Exception e) {
			System.out.println("Exception impr�vue " + e.getClass());
			e.printStackTrace();
		}
	}

	private void testTeamNullParameters() {
		// Tests entries : null
		try {
			increment.getBetting().addCompetition(null, MyCalendar.getDate(),
					competitorTeams, increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec un nom non instanci� n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			increment.getBetting().addCompetition(new String("otra_compet"),
					null, competitorTeams, increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec une date de cl�ture non instanci�e n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			increment.getBetting().addCompetition(new String("otra_compet"),
					MyCalendar.getDate(), null, increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec une liste de competiteurs non instanci�e n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			increment.getBetting().addCompetition(new String("otra_compet"),
					MyCalendar.getDate(), competitorTeams, null);
			System.out
					.println("Ajout d'une comp�tition avec un mdp gestionnaire non instanci� n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			increment.getBetting().addCompetition(null, MyCalendar.getDate(),
					competitorTeams, null);
			System.out
					.println("Ajout d'une comp�tition avec un nom et mdp gestionnaire non instanci�s n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			increment.getBetting().addCompetition(null, MyCalendar.getDate(),
					null, null);
			System.out
					.println("Ajout d'une competition avec un nom, comp�titeurs et mdp gestionnaire non instanci�s n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
	}

	private void testTeamInvalidParameters() {
		// Tests entries : invalid format
		try {
			increment.getBetting().addCompetition(new String(" "),
					MyCalendar.getDate(), competitorTeams,
					increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec un nom invalide (\" \") n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			increment.getBetting().addCompetition(new String("otra compet"),
					MyCalendar.getDate(), competitorTeams,
					increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec un nom invalide (a compet) n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			increment.getBetting().addCompetition(new String("otra_compet"),
					new MyCalendar(2014, 2, 1), competitorTeams,
					new String(" "));
			System.out
					.println("l'ajout d'une comp�tition avec un mdp gestionnaire incorrect n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
	}

	private void testTeamNotEnoughCompetitors() {
		// Less than two competitors
		try {
			increment.getBetting().addCompetition(new String("otra_compet"),
					new MyCalendar(2016, 5, 23), new ArrayList<Competitor>(),
					increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec moins de deux comp�titeurs (0) n'a pas lev� d'exception ");
		} catch (Exception e) {
		}

		// Less than two competitors
		ArrayList<Competitor> compts = new ArrayList<Competitor>();
		try {

			compts.add(increment.getBetting().createCompetitor(
					new String("Betis"), increment.getManagerPassword()));
		} catch (Exception e) {
			assert (false);
		}
		try {
			increment.getBetting().addCompetition(new String("otra_compet"),
					new MyCalendar(2016, 5, 23), compts,
					increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec moins de deux comp�titeurs (1) n'a pas lev� d'exception ");
		} catch (Exception e) {
		}

		try {
			// The same two competitors
			compts.add(increment.getBetting().createCompetitor(
					new String("Betis"), increment.getManagerPassword()));
		} catch (Exception e) {
			assert (false);
		}

		try {
			increment.getBetting().addCompetition(new String("otra_compet"),
					new MyCalendar(2016, 5, 23), compts,
					increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec deux comp�titeurs identiques n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
	}

	private void testTeamInThePast() {
		// Closing date in the past: competition closed
		try {
			// Related to the "simulated date"
			increment.getBetting().addCompetition(new String("otra_compet"),
					new GregorianCalendar(2009, Calendar.FEBRUARY, 01),
					competitorTeams, increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition avec une date dans le pass� n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		if (this.addCompetition) {
		} else {
		}
	}

	private void testTeamOK() {
		try {
			increment.getBetting().addCompetition(new String("otra_compet"),
					new MyCalendar(2018, 8, 15), competitorTeams,
					increment.getManagerPassword());
			// Suppose listCompetitions correct
			if (increment.getBetting().listCompetitions().size() != 1) {
				System.out
						.println("le nombre de comp�titions est incorrect (1 != "
								+ increment.getBetting().listCompetitions()
										.size() + ")");
			}
		} catch (Exception e) {
			System.out
					.println("Ajout d'une comp�tition valide (otra_compet,15-08-2018) a lev� l'exception "
							+ e.getClass());
		}
	}

	private void testTeamExisting() {
		try {
			increment.getBetting().addCompetition(new String("otra_compet"),
					new MyCalendar(2018, 8, 15), competitorTeams,
					increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition d�j� existante (otra_compet,15-08-2018) n'a pas lev� d'exception");
		} catch (Exception e) {
			// Suppose listCompetitions correct
			if (increment.getBetting().listCompetitions().size() != 1) {
				System.out
						.println("le nombre de comp�titions est incorrect (1 != "
								+ increment.getBetting().listCompetitions()
										.size() + ")");
			}
		}

		try {
			increment.getBetting().addCompetition(new String("otra_compet"),
					new MyCalendar(2016, 2, 16), competitorTeams,
					increment.getManagerPassword());
			System.out
					.println("Ajout d'une comp�tition d�j� existante (otra_compet) n'a pas lev� d'exception");
		} catch (Exception e) {
			// Suppose listCompetitions correct
			if (increment.getBetting().listCompetitions().size() != 1) {
				System.out
						.println("le nombre de comp�titions est incorrect (1 != "
								+ increment.getBetting().listCompetitions()
										.size() + ")");
			}
		}
	}


	private void testTeamWithCompetitorsNullParameters() {
		this.testTeamNullParameters();
	}

	private void testTeamWithCompetitorsInvalidParameters() {
		this.testTeamInvalidParameters();
	}

	private void testTeamWithCompetitorsNotEnoughCompetitors() {
		this.testTeamNotEnoughCompetitors();
	}

	private void testTeamWithCompetitorsInThePast() {
		this.testTeamInThePast();
	}

	private void testTeamWithCompetitorsOK() {
		try {
			increment.getBetting().addCompetition(new String("otra_compet"),
					new MyCalendar(2018, 8, 15), competitorTeams,
					increment.getManagerPassword());
			// Suppose listCompetitions correct
			if (increment.getBetting().listCompetitions().size() != 1) {
				System.out
						.println("le nombre de comp�titions est incorrect (1 != "
								+ increment.getBetting().listCompetitions()
										.size() + ")");
			}
		} catch (Exception e) {
			System.out
					.println("Ajout d'une comp�tition valide (otra_compet,15-08-2018) a lev� l'exception "
							+ e.getClass());
		}
	}

	private void testTeamWithCompetitorsExisting() {
		this.testTeamExisting();
	}
}