package exceptions;

public class ItemAlreadyInList extends Exception{
	private static final long serialVersionUID = 385663L;
  public ItemAlreadyInList(){

  }

  public ItemAlreadyInList(String message){
    super(message);
  }

}
