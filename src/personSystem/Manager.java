package personSystem;
import exceptions.IncorrectString;
import javax.persistence.*;

@Entity
public class Manager extends SystemUser{
	
	private static final long serialVersionUID = 1573L;

		public Manager(String firstName, String lastName, String nickname, String password) throws IncorrectString{
					super(firstName, lastName, nickname, password);
        }
		
		public Manager(){
			
		}

}
