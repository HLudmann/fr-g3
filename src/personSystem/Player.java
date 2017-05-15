package personSystem;
import betSystem;

public class Player extends SystemUser {
	private int wallet=0;

	private ArrayList<betSystem.Bet> betList;

	public Player(String firstName, String lastname, String password, String nickname){
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.nickname = nickname;
		betList = new ArrayList();
	}	

	public void setWallet(int w){
		this.wallet = w;
	}

	public int getWallet(){
		return wallet;
	}
	
	public void addBet(Bet b) {
		
		if !betList.contains(b){
			
			betList.add(b);
			
		}
	}
	
	public void removeBet(Bet b){
		
		if betList.contains(b){
			
			betList.remove(b);
			
		}
	}

}
