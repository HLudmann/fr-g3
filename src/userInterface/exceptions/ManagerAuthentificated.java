package src.userInterface.exceptions;

public class ManagerAuthentificated extends Exception{
	private static final long serialVersionUID = -385186352928310148L;

    Manager mng;

	public ManagerAuthentificated() {
        super();
     }
    public ManagerAuthentificated(String reason) {
        super(reason);
    }
    public ManagerAuthentificated(String reason, Manager mng) {
        super(reason);
        this.mng = mng;
    }
}
