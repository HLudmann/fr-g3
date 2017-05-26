package personSystem;
import exceptions.IncorrectString;


public class Manager extends SystemUser{

        public Manager(String firstName, String lastName, String nickname, String password) throws IncorrectString{
					super(firstName, lastName, nickname, password);
        }

}
