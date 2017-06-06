package exceptions;

public class WrongPassword extends Exception{
	private static final long serialVersionUID = 385987283L;
  public WrongPassword(){

  }

  public WrongPassword(String message){
    super(message);
  }

}
