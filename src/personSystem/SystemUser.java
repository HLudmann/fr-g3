package personSystem;

abstract class SystemUser extends Person{
	
	protected String nickname;
	protected String password;
	
	public String getNickname(){
		return nickname;
	}
	
	public String getPassword(){
		return password;
	}

	
	public void authenticate(String str) throws Exception {
		
		if password != str{
			throw new Exception("wrong password")
		}
		
	}
	
	public void updatePassword(String str){
		
		password = str;
		
	}

}
