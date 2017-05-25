package personSystem;

import exceptions.IncorrectString;
import exceptions.WrongPassword;


abstract class SystemUser extends Person{

	private String nickname;
	private String password;

	public SystemUser(String firstName, String lastName, String nickname, String password) throws IncorrectString{
			super(firstName, lastName);
			this.nickname=nickname;
			this.password=password;
	}

	public String getNickname(){
		return nickname;
	}

	public String getPassword(){
		return password;
	}


	public void authenticate(String str) throws WrongPassword {
		if (password != str){
			throw new WrongPassword("Password doesn't match");
		}

	}

	public void updatePassword(String str){
		password = str;
	}

}
