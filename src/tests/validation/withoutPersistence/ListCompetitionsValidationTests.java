package tests.validation.withoutPersistence;

public class ListCompetitionsValidationTests {
	private FirstIncrementValidationTests increment;

	public ListCompetitionsValidationTests(boolean addedCompetitions,
			boolean addedTeamCompetitions) {
		increment = FirstIncrementValidationTests.getIncrement();

		if (addedCompetitions && addedTeamCompetitions) {

			// a_compet with Durant and Duranto ; another-compet with Durant and
			// Duranto ; otra_compet with Madrid and
			// Barca
			if (increment.getBetting().listCompetitions().size() != 3) {
				System.out
						.println("le nombre de comp�titions est incorrect (3 != "
								+ increment.getBetting().listCompetitions()
										.size() + ")");
			}
		}

		if (addedCompetitions && !addedTeamCompetitions) {
			// a_compet with Durant and Duranto ; another-compet with Durant and
			// Duranto
			if (increment.getBetting().listCompetitions().size() != 2) {
				System.out.println("le nombre de comp�titions est incorrect");
				System.out.print("Il doit �tre de 2 mais ");
				System.out.println("il est de "
						+ increment.getBetting().listCompetitions().size());
			}
		}

		if (!addedCompetitions && !addedTeamCompetitions) {
			// Aucune comp�tition
			if (increment.getBetting().listCompetitions().size() != 0) {
				System.out
						.println("le nombre de comp�titions est incorrect (0 != "
								+ increment.getBetting().listCompetitions()
										.size() + ")");
			}
		}
	}
}