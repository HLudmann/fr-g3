package exceptions;

public class CompetitionNotInList extends Exception{

  public CompetitionNotInList(){

  }

  public CompetitionNotInList(String message){
    super(message);
  }

}
