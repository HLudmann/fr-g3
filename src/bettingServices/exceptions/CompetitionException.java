package bettingServices.exceptions;
/**
 *  
 * @author prou
 *
 */
public class CompetitionException extends Exception {
	private static final long serialVersionUID = 92143826285186814L;
	
	public CompetitionException() {
         super();
      }
       public CompetitionException(String reason) {
         super(reason);
      }
   }