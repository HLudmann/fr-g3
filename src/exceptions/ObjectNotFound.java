package exceptions;

public class ObjectNotFound extends Exception {
	private static final long serialVersionUID = -385186352928310148L;

	public ObjectNotFound() {
        super();
     }
	
      public ObjectNotFound(String reason) {
        super(reason);
     }
}
