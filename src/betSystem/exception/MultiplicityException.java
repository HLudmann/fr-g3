package betSystem.exception;

public class MultiplicityException extends Exception{
	private static final long serialVersionUID = -385186352928310148L;

	public MultiplicityException() {
        super();
     }
	
      public MultiplicityException(String reason) {
        super(reason);
     }
}
