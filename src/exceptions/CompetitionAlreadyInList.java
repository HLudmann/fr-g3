package exceptions;

public class CompetitionAlreadyInList extends Exception{

  public CompetitionAlreadyInList(){

  }

  public CompetitionAlreadyInList(String message){
    super(message);
  }

}
