package personSystem;

import exceptions.IncorrectString;
import exceptions.WrongPassword;


abstract class SystemUser extends Person{

	private String nickname;
	private String password;

	private static String regex="[a-zA-Z0-9áàâäãåçéèêëíìîïñóòôöõúùûüýÿæœÁÀÂÄÃÅÇÉÈÊËÍÌÎÏÑÓÒÔÖÕÚÙÛÜÝŸÆŒøğ]{4,}";


	public SystemUser(String firstName, String lastName, String nickname, String password) throws IncorrectString{
			super(firstName, lastName);
			checkNickname(nickname);
			this.nickname=nickname;
			this.password=password;
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
