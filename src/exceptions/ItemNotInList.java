package exceptions;

public class ItemNotInList extends Exception{

  public ItemNotInList(){

  }

  public ItemNotInList(String message){
    super(message);
  }

}
