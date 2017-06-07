package exceptions;

public class IncorrectString extends Exception{
	
	private static final long serialVersionUID = 3851863529283L;
	
	public IncorrectString(){}

	public IncorrectString(String message){
		super(message);
	}

}
