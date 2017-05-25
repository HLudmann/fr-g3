package personSystem;
import exceptions.IncorrectString;


public class Manager extends SystemUser{
	
        public Manager(String firstName, String lastname, String password, String nickname){
                this.firstName = firstName;
                this.lastName = lastName;
                this.password = password;
                this.nickname = nickname;
        }

        public Manager(String firstName, String lastName, String password, String nickname) throws IncorrectString{

					super(firstName, lastName, nickname, password);
        }

}
