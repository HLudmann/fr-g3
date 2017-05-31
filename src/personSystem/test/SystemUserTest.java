package personSystem.test;

import static org.junit.Assert.*;

import org.junit.*;

import personSystem.*;
import exceptions.*;

public class SystemUserTest {

    @Test
    public void testConstructorValidNickname() throws IncorrectString{
      Manager m=new Manager("jean", "dupont", "jdupont", "21041975");

      m = new Manager("jean", "dupont", "jEandUpond5572", "21041975");
      m = new Manager("jean", "dupont", "éjÀn", "21041975");

      //use a manager instance because SystemUser is abstract
    }

    @Test
    public void testConstructorInvalidNickname() throws IncorrectString{
      Manager m=new Manager("jean", "dupont", "jdupont", "21041975");

      String[] incorrectNicknames = {"test-lol", "abc", "jojo du 33", "1_23soleil"};

      for (String item:incorrectNicknames){
        try{
          m = new Manager("jean", "dupont", item, "21041975");
          fail(String.format("Invalid string \'%s\' does not throws an exception", item));
        }
        catch (IncorrectString e){
          //this is normal
        }
      }
    }



    @Test
    public void testAuthentificateRightPassword() throws IncorrectString, WrongPassword{
      Manager m=new Manager("jean", "dupont", "jdupont", "21041975");
      m.authentificate("21041975");
    }

    @Test(expected=WrongPassword.class)
    public void testAuthentificateWrongPassword() throws IncorrectString, WrongPassword{
      Manager m=new Manager("jean", "dupont", "jdupont", "21041975");
      m.authentificate("123soleil");
    }




}
