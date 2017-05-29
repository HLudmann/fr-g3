package personSystem;

import exceptions.IncorrectString;
import exceptions.WrongPassword;

/**
 * Abstract class that represent a manager or a player.
 */
abstract class SystemUser extends Person{

	private String nickname;
	private String password;

	private String regex="[a-zA-Z0-9áàâäãåçéèêëíìîïñóòôöõúùûüýÿæœÁÀÂÄÃÅÇÉÈÊËÍÌÎÏÑÓÒÔÖÕÚÙÛÜÝŸÆŒøğ]{4,}";
													//all letters, numbers, accentuated characters. at least 4 chars.



	public SystemUser(String firstName, String lastName, String nickname, String password) throws IncorrectString{
			super(firstName, lastName);
			checkNickname(nickname); //if nickname not valid it will throw an error
			this.nickname=nickname;
			this.password=password;
	}

	/**
	 * This will match the nickname with the regex. throws an error if not valid
	 */
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
