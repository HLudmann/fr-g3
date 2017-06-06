package personSystem;

import java.util.Date;
import exceptions.IncorrectString;
import javax.persistence.*;

@Entity
public class Manager extends SystemUser{
	
	private static final long serialVersionUID = 1573L;

		public Manager(String firstName, String lastName, String nickname, String password) throws IncorrectString{
					super(firstName, lastName, new Date(0), new String("MNG"), nickname, password);
        }
		
		public Manager(){
			
		}

}
