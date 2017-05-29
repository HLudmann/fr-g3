package userInterface.tests;

import static org.junit.Assert.*;

import org.junit.*;
import exceptions.*;
import userInterface.*;

public class VisitorInterfaceTest {

    private VisitorInterface intrf;

    @Test
    public void testSignInManager() throws BadParametersException {
        this.intrf = new VisitorInterface();
        try {
            intrf.signInManager("RogerMng", "azertyuiop");
        } catch (FalseNickname fn) {
            fail("Test true signIn failed with nickname");
        } catch (WrongPassword fp) {
            fail("Test true signIn failed with password");
        }

        try {
            intrf.signInManager("RogerMng", "alberto");
            fail("Test false signIn failed");
        } catch (FasleNickname fn) {

        } catch (WrongPassword fp) {
            
        }
    }

}
