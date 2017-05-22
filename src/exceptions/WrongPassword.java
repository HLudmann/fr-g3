package exceptions;

class WrongPassword extends Exception{

  public WrongPassword(){

  }

  public WrongPassword(String message){
    super(message);
  }

}
