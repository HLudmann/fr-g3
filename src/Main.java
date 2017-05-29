import java.util.Calendar;

import betSystem.*;
import personSystem.*;

public class Main {
    
    public static void main(String[] args) throws Exception {

		/**
		 * Creation of three competitors
		 */
		Competitor c1 = new Competitor("fun", "lun", 1);
		Competitor c2 = new Competitor("fdeux", "ldeux", 2);
		Competitor c3 = new Competitor("ftrois", "ltrois", 3);

		/**
		 * Creation of a competition
		 */
		Competition comp = new Competition("test", Calendar.getInstance(), new Competitor[] {c1, c2, c3});
		
		Player plr;
    	try {
			plr = new Player("Jean", "Dupont", "jannot", "azertyuiop", 50000);
		} catch (Exception e) {
			throw e;
		}
    	
		PodiumBet pb = new PodiumBet(250, plr, comp, new Competitor[] {c1, c2, c3});
		SingleWinnerBet sb = new SingleWinnerBet(500, plr, comp, c1);

		plr.addBet(pb);
		plr.addBet(sb);

		System.out.println(plr.getBetList().toString());
    }
}
