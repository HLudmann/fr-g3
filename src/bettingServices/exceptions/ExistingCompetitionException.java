package bettingServices.exceptions;
/**
 *  
 * @author prou
 *
 */
public class ExistingCompetitionException extends Exception {
	private static final long serialVersionUID = 92143826345186814L;
	
	public ExistingCompetitionException() {
         super();
      }
       public ExistingCompetitionException(String reason) {
         super(reason);
      }
   }