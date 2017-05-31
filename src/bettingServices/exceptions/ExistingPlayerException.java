package bettingServices.exceptions;

/**
 * 
 * @author prou
 *
 */
public class ExistingPlayerException extends Exception {
	private static final long serialVersionUID = 135435732731L;

    public ExistingPlayerException() {
        super();
     }
	public ExistingPlayerException(String reason) {
        super(reason);
     } 
}



