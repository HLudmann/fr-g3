package userInterface.tests;

import static org.junit.Assert.*;

import org.junit.*;
import java.util.ArrayList;
import java.util.Date;

import container.CompContainer;
import container.PersonContainer;
import personSystem.*;
import exceptions.*;
import userInterface.*;
import userInterface.exceptions.*;

public class VisitorInterfaceTest {

    private static VisitorInterface intrf;
    private static PersonContainer pc;
    private static CompContainer cc;

    @BeforeClass
    public static void beforeClass() throws BadParametersException {

        pc = new PersonContainer();

        pc.addManager("Jacques", "Fripouille", "azertyuiop", "alberto");
        pc.addPlayer("Jean", "Dutrout","03/11/96", "plottwist", "janot");

        pc.addCompetitor("cun", "cunLastName","12/11/88");
        pc.addCompetitor("cdeux", "cdeuxLastName","04/07/87");
        pc.addCompetitor("ctrois", "ctroisLastName","06/12/92");
        

        cc = new CompContainer();

        ArrayList<Competitor> list = pc.getCompetitors();
        cc.addComp("comp", new Date(), new Competitor[] {list.get(0), list.get(1), list.get(2)});
           
        
        intrf = new VisitorInterface();


    }

    @AfterClass
    public static void afterClass() throws BadParametersException {
        cc.delComp("comp");

        pc.delCompetitor(1);
        pc.delCompetitor(2);
        pc.delCompetitor(3);

        pc.delPlayer("janot");
    }

    @Test
    public void testId() {
        assertTrue(intrf.getId() == 0);
    }


    /**
     * Tests for signInManager
     */
    @Test
    public void testSignInManager() throws IdentificationError, BadParametersException {
        ManagerInterface mngInt = intrf.signInManager("alberto", "azertyuiop");
        assertTrue(mngInt instanceof ManagerInterface);
    }

    @Test(expected=BadParametersException.class)
    public void testSignInManagerFail1() throws IdentificationError, BadParametersException {
        ManagerInterface mngInt = intrf.signInManager("", "");
        assertFalse(mngInt instanceof ManagerInterface);
    }

    @Test(expected=IdentificationError.class)
    public void testSignInManagerFail2() throws IdentificationError, BadParametersException {
        ManagerInterface mngInt = intrf.signInManager("albertina", "azertyuiop");
        assertFalse(mngInt instanceof ManagerInterface);
    }

    @Test(expected=IdentificationError.class)
    public void testSignInManagerFail() throws IdentificationError, BadParametersException {
        ManagerInterface mngInt = intrf.signInManager("alberto", "quelquechose");
        assertFalse(mngInt instanceof ManagerInterface);
    }

    /**
     * Tests for signInPlayer
     */
    @Test
    public void testSignInPlayer() throws IdentificationError, BadParametersException {
        PlayerInterface plrInt = intrf.signInPlayer("janot", "plottwist");
        assertTrue(plrInt instanceof PlayerInterface);
    }

    @Test(expected=BadParametersException.class)
    public void testSignInPlayerFail1() throws IdentificationError, BadParametersException {
        PlayerInterface plrInt = intrf.signInPlayer("", "");
        assertFalse(plrInt instanceof PlayerInterface);
    }

    @Test(expected=IdentificationError.class)
    public void testSignInPlayerFail2() throws IdentificationError, BadParametersException {
        PlayerInterface plrInt = intrf.signInPlayer("janotte", "plottwist");
        assertFalse(plrInt instanceof PlayerInterface);
    }

    @Test(expected=IdentificationError.class)
    public void testSignInPlayerFail() throws IdentificationError, BadParametersException {
        PlayerInterface plrInt = intrf.signInPlayer("janot", "quelquechose");
        assertFalse(plrInt instanceof PlayerInterface);
    }

    /**
     * Test for competitonListing
     */
     @Test
     public void testCompetitionListing() {
         String[][] res = intrf.competitionListing();
         assertTrue(res.length == 1);
     }

     /**
     * Test for competiorListing
     */
     @Test
     public void testCompetitorListing() {
         String[][] res = intrf.competitorListing();
         assertTrue(res.length == 3);
     }

     /**
      * Tests for searchCompetitionByName
      */
      @Test
      public void testsearchCompetitionByName1() {
          String[][] res = intrf.searchCompetitionByName("comp");
          assertTrue(res.length == 1);
      }

      @Test
      public void testsearchCompetitionByName2() {
          String[][] res = intrf.searchCompetitionByName("camp");
          assertTrue(res.length == 0);
      }
}
