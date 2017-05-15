package betSystem;
import personSystem.Player;
import personSystem.Competitor;

public class BetTest {


	public void testresultsSingle() {
		Player p1 = new Player("p1", "p1lastname", "password", "p1");
		p1.setWallet(100);
		
		Player p2 = new Player("p2", "p2LastName", "password", "p2");
		p2.setWallet(100);
		
		Competitor c1 = new Competitor("c1", "c1LastName", 1);
		Competitor c2 = new Competitor("c2", "c2LastName", 2);

		
		Competition comp = new Competition();
		
		p1.addBet(new SingleWinnerBet(50, p1, c1));
		p2.addBet(new SingleWinnerBet(40, p2, c2));
		
		
		
		
		Competitor[] l1 = new Competitor[1];
		l1[0] = c1;
		comp.results(l1);
		
		System.out.println(p1.getWallet() + " = 150"); //en fonction du comportement de addBet
		System.out.println(p2.getWallet() + " = 60");
	}

}
