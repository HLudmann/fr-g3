package personSystem;

import exceptions.IncorrectString;
import exceptions.WrongPassword;
import javax.persistence.*;
import java.io.Serializable;

@Entity @Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING , length=3)
@Table(name="system_user")
abstract class SystemUser extends Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="SYSTEM_USER_NICKNAME_GENERATOR", sequenceName="SYSTEM_USER_NICKNAME_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SYSTEM_USER_NICKNAME_GENERATOR")
	private String nickname;
	private String password;

	private static String regex="[a-zA-Z0-9áàâäãåçéèêëíìîïñóòôöõúùûüýÿæœÁÀÂÄÃÅÇÉÈÊËÍÌÎÏÑÓÒÔÖÕÚÙÛÜÝŸÆŒøğ]{4,}";

	public SystemUser(String firstName, String lastName, String nickname, String password) throws IncorrectString{
			super(firstName, lastName);
			checkNickname(nickname);
			this.nickname=nickname;
			this.password=password;
	}
	
	public SystemUser(){
		
	}

	private void checkNickname(String str) throws IncorrectString{
		if (!str.matches(regex)){
			throw new IncorrectString("Nickname not valid");
		}
	}

	public String getNickname(){
		return nickname;
	}


	public void authentificate(String str) throws WrongPassword {
		if (password != str){
			throw new WrongPassword("Password doesn't match");
		}

	}

	public void updatePassword(String str){
		password = str;
	}

}
