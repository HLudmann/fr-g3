package personSystem;

public class Player extends SystemUser {
	private int wallet=0;

	private betSystem.Bet[] betList;

	public Player(String firstName, String lastname, String password, String nickname){
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.nickname = nickname;
	}	

	public void setWallet(int w){
		this.wallet = w;
	}

	public int getWallet(){
		return wallet;
	}

}
