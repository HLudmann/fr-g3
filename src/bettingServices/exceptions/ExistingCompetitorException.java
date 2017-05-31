package bettingServices.exceptions;
/**
 *  
 * @author prou
 *
 */
public class ExistingCompetitorException extends Exception {
	private static final long serialVersionUID = 95423285186814L;
	
	public ExistingCompetitorException() {
         super();
      }
       public ExistingCompetitorException(String reason) {
         super(reason);
      }
   }