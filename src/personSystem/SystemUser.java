package src.personSystem;

abstract class SystemUser extends Person{
	
	protected String nickname;
	protected String password;
	
	public String getNickname(){
		return nickname;
	}
	
	public String getPassword(){
		return password;
	}

	
	public void authenticate(String str){
		//TODO
	}
	
	public void updatePassword(String str){
		//TODO
	}

}
