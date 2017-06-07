package exceptions;

public class ItemNotInList extends Exception{
	private static final long serialVersionUID = 863529283L;
  public ItemNotInList(){

  }

  public ItemNotInList(String message){
    super(message);
  }

}
