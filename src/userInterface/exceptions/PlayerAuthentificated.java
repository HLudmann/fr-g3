
package userInterface.exceptions;

public class PlayerAuthentificated extends Exception{
	private static final long serialVersionUID = -385186352928310148L;

    Player plr;

	public PlayerAuthentificated() {
        super();
     }
    public PlayerAuthentificated(String reason) {
        super(reason);
    }
    public PlayerAuthentificated(String reason, Manager plr) {
        super(reason);
        this.plr = plr;
    }
}

