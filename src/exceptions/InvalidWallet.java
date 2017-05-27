package exceptions;

public class InvalidWallet extends Exception{

  public InvalidWallet(){

  }

  public InvalidWallet(String message){
    super(message);
  }
}
