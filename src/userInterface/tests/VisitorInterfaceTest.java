package userInterface.tests;

import static org.junit.Assert.*;

import org.junit.*;

public class VisitorInterfaceTest {

    private VisitorInterface intrf;

    @Test
    public void testSignInManager() throws BadParametersException {
        this.intrf = new VisitorInterface();
        try {
            intrf.signIn("RogerMng", "azertyuiop"); //
        } catch (FalseNickname fn) {
            fail("Test true signIn failed with nickname");
        } catch (FalsePassword fp) {
            fail("Test true signIn failed with password");
        }

        try {
            intrf.signIn("RogerMng", "alberto");
            fail("Test false signIn failed");
        } catch (FasleNickname fn) {

        } catch (FalsePassword fp) {
            
        }
    }

}
