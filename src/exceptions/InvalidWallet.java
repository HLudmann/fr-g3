package exceptions;

public class InvalidWallet extends Exception{
	private static final long serialVersionUID = 38518635292866553L;

  public InvalidWallet(){

  }

  public InvalidWallet(String message){
    super(message);
  }
}
