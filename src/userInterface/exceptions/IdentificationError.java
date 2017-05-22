package src.userInterface.exceptions;

public class IdentificationError extends Exception{
	private static final long serialVersionUID = -385186352928310148L;

	public IdentificationError() {
        super();
     }
      public IdentificationError(String reason) {
        super(reason);
     }
}
