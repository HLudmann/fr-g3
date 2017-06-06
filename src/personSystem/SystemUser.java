package personSystem;

import java.util.Date;
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
	private String nickname;
	
	private String password;
	

	@Temporal(TemporalType.DATE)
	private Date bornDate;
	
	private static String regex="[a-zA-Z0-9áàâäãåçéèêëíìîïñóòôöõúùûüýÿæœÁÀÂÄÃÅÇÉÈÊËÍÌÎÏÑÓÒÔÖÕÚÙÛÜÝŸÆŒøğ]{4,}";

	public SystemUser() {
	}

	public SystemUser(String firstName, String lastName, Date bornDate, String nickname, String password) throws IncorrectString{
			super(firstName, lastName);
			checkNickname(nickname);
			this.bornDate = bornDate;
			this.nickname=nickname;
			this.password=password;
	}
	
	private void checkNickname(String str) throws IncorrectString{
		if (!str.matches(regex)){
			throw new IncorrectString("Nickname not valid");
		}
	}
	
	public Date getBornDate() {
		return this.bornDate;
	}

	public String getNickname(){
		return this.nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setNickname(String nickname) throws IncorrectString {
		if (nickname == null)
			throw new IncorrectString("username is not valid");
		checkNickname(nickname);
		this.nickname = nickname;
	}

	public void authentificate(String str) throws WrongPassword {
		if (password != str){
			throw new WrongPassword("Password doesn't match");
		}

	}

	public void updatePassword(String str){
		password = str;
	}

	/**
	 * check if this subscriber has the username of the parameter
	 * 
	 * @param nicjname the username to check
	 * 
	 * @return true if this username is the same as the parameter false
	 * otherwise
	 */
	public boolean hasNickname(String nickname) {
		if (nickname == null)
			return false;
		return this.nickname.equals(nickname);
	}

}
