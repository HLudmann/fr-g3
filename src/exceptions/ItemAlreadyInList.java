package exceptions;

public class ItemAlreadyInList extends Exception{

  public ItemAlreadyInList(){

  }

  public ItemAlreadyInList(String message){
    super(message);
  }

}
