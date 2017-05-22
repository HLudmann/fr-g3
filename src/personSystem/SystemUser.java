package personSystem;

abstract class SystemUser extends Person{

	private String nickname;
	private String password;

	public SystemUser(String firstName, String lastName, String nickname, String password){
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


	public void authenticate(String str) throws Exception {

		if (password != str){
			throw new Exception("wrong password");
		}

	}

	public void updatePassword(String str){

		password = str;

	}

}
