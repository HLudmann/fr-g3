package bettingServices.exceptions;
/**
 *  
 * @author prou
 *
 */
public class PlayerException extends Exception {
	private static final long serialVersionUID = 921436814L;
	
	public PlayerException() {
         super();
      }
       public PlayerException(String reason) {
         super(reason);
      }
   }