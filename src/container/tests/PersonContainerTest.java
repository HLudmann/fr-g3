package container.tests;

import java.util.ArrayList;
import java.util.Date;

import betSystem.*;
import container.*;
import exceptions.*;
import personSystem.*;



public class PersonContainerTest {
	private static PersonContainer pc;
    private static CompContainer cc;
    private static BetContainer bc;
    
    @BeforeClass
    public static void beforeClass() throws BadParametersException {
        pc = new PersonContainer();
        
        pc.addManager("Hugo", "Selle", "lucuaetibam", "Hsb511");
        pc.addPlayer("Jean", "Dutrout", "plottwist", "janot");
        pc.addCompetitor("cun", "cunLastName", 1);
        pc.addCompetitor("cdeux", "cdeuxLastName", 2);
        pc.addCompetitor("ctrois", "ctroisLastName", 3);
                
        ArrayList<Competitor> list = pc.getCompetitors();
        
        cc = new CompContainer();
        cc.addComp("comp1", new Date(), new Competitor[] {list.get(0), list.get(1), list.get(2)});
        cc.addComp("comp2", new Date(), new Competitor[] {list.get(1), list.get(2)});
        
        bc = new BetContainer(new Manager());
        bc.addPodiumBet(23, pc.findPlayer("janot"), cc.findCompByName("comp1"), pc.findCompetitorById(1),  pc.findCompetitorById(2), pc.findCompetitorById(3));
        bc.addSingleWinnerBet(23, pc.findPlayer("janot"), cc.findCompByName("comp1"), pc.findCompetitorById(2));
    }

    @AfterClass
    public static void afterClass() throws BadParametersException {
    	ArrayList<PodiumBet> pbList = bc.getPodiumBets();
    	ArrayList<SingleWinnerBet> swbList = bc.getSingleWinnerBets();
    	
    	bc.delBet(pbList.get(0).getId());
    	bc.delBet(swbList.get(0).getId());
    	
    	cc.delComp("comp1");

        pc.delCompetitor(1);
        
        cc.delComp("comp2");
        
        pc.delCompetitor(2);
        pc.delCompetitor(3);

        pc.delPlayer("janot");
    }
    
    /**
     * Tests for findManager in PersonContainer
     */
    @Test
    public void testValidityFindPlayer() {
    	assertTrue(findManager("Hsb511").getName() == "Hugo");
    }
    
    @Test
    public void testFindManager() throws BadParametersException {
    	Manager mgr = findManager("Hsb511");
    }
    
    @Test(expected=BadParametersException.class)
    public void testFindManager() throws BadParametersException {
    	Manager mgr = findManager("janot");
    }    
    
    /**
     * Tests for findPlayer in PersonContainer
     */
    @Test
    public void testValidityFindPlayer() {
    	assertTrue(findPlayer("janot").getName() == "Jean");
    }
    
    @Test
    public void testFindPlayer() throws BadParametersException {
    	Player plr = findPlayer("janot");
    }
    
    @Test(expected=BadParametersException.class)
    public void testFindPlayer() throws BadParametersException {
    	Player plr = findPlayer("janots");
    }    
    
    /**
     * Tests for findPlayers in PersonContainer
     */
    @Test
    public void testValidityFindPlayers() {
    	assertTrue(findPlayers("jan").getList(0).getNickname() == "janot");
    }
    @Test
    public void testFindPlayers() throws BadParametersException {
    	ArrayList<Player> players = findPlayers("jan"); 
    }
    
    @Test(expected=BadParametersException)
    public void testFindPlayers() throws BadParametersException {
    	ArrayList<Player> players = findPlayers("q"); 
    }
    
    /**
     * Tests for findCompetitorsByName in PersonContainer /!\ name to change in PersonContainer 
     */
    @Test
    public void testValidityFindCompetitorsByName() {
    	assertTrue(findCompetitorsByName("cu").getList(0).getId() == 1);
    }
    
    @Test
    public void testFindCompetitorsByName() throws BadParametersException {
    	ArrayList<Competitors> competitors = findCompetitorsByName("cu"); 
    }
    
    @Test(expected=BadParametersException)
    public void testFindCompetitorsByName() throws BadParametersException {
    	ArrayList<Competitors> competitors = findCompetitorsByName("criendutout"); 
    }
    
    /**
     * Tests for findCompetitorById in PersonContainer
     */
    @Test
    public void testValidityFindCompetitorById() {
    	assertTrue(findCompetitorsByName(1).getFirstName() == "cun");
    }
    
    @Test
    public void testFindCompetitorsByName() throws BadParametersException {
    	Competitors competitor = findCompetitorById(1); 
    }
    
    @Test(expected=BadParametersException)
    public void testFindCompetitorsByName() throws BadParametersException {
    	Competitors competitor = findCompetitorById(23); 
    }
    
    /**
     * Tests for updatePasswordPlayer
     */
    @Test
    public void testUpdatePasswordPlayer() throws BadParametersException {
    	Player plr = new Player("Jean", "Dutrout", "plottwist", "janot");
    	pc.updatePasswordPlayer(plr, "newpassword");    	
    }
        
    @Test(expected = BadParametersException)
    public void testUpdatePasswordPlayer() throws BadParametersException {
    	Player plr = new Player("Jean", "Dutrout", "plottwist", "janot");
    	pc.updatePasswordPlayer(plr, 1);    	
    }
}
