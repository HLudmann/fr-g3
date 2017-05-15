package userInterface;
import personSystem.*;
import betSystem.*;
import container.*;

public class VisitorInterface extends Thread {

    private long id;
    private static long nextId = 0;
    private static CompContainer competitionList = new CompContainer();
    private static PersonContainer personList = new PersonContainer();

    public VisitorInterface () {
        this.id = nextId;
        nextId++;
    }

    public long getId () {
        return this.id;
    }

    public VisitorInterface signIn (String nickname, String password) {
        try {

                Manager mng = personList.getManager(nickname);
                mng.authentificate(password);
                return new ManagerInterface(mng);

            } catch (FalseNickname fn) {

                Player plr = personList.getPlayer(nickname);
                plr.authentificate(password)
                return new PlayerInterface(mng);

            } catch (FalsePassword fp) {
                /*retourner l'erreur: Nickname ou password erroné*/
                throw new RuntimeError("Nickname ou password erroné");
            }
        }

    public void search (Competition competition) {

    }

    public void search (Competitor competitor) {

    }
}
