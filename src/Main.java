
import java.util.ArrayList;
import java.util.Date;
import database.DBConnection;
import container.*;
import personSystem.*;


public class Main {
    
    public static void main(String[] args) throws Exception {

		String[] argv = {};
		DBConnection.main(argv);
		
		PersonContainer pc = new PersonContainer();

        pc.addManager("Jacques", "Fripouille", "alberto", "azertyuiop");
        
        System.out.println(pc.getManagerDB().get(0).getNickname());
        
        pc.addPlayer("Jean", "Dutrout","03/11/96", "plottwist", "janot");

        pc.addCompetitor("cun", "cunLastName","12/11/88");
        pc.addCompetitor("cdeux", "cdeuxLastName","04/07/87");
        pc.addCompetitor("ctrois", "ctroisLastName","06/12/92");
        

        CompContainer cc = new CompContainer();

        ArrayList<Competitor> list = pc.getCompetitors();
        cc.addComp("comp", new Date(), new Competitor[] {list.get(0), list.get(1), list.get(2)});
    }
}
