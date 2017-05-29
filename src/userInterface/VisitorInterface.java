package src.userInterface;
import src.personSystem.*;
import src.betSystem.*;
import src.container.*;
import src.container.*;
import src.userInterface.exceptions.*;

/**
 * @author HLudmann + BusterJava
 * 
 */
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

    /** 
     * Singn In.
     * 
     * @param nickname
     *              the nickname chosen by the User when he subscribed.
     * @param password
     *              the password chosen by the User when he subscribed.
     * 
     * @throws BadParametersException
     *              thrown if an empty nickname was given.
     * @throws IdentificationError
     *              thrown if parameters don't match anything in the container.
     * @throws ManagerAuthentifiction
     *              thrown if parameters match a manager's in the container.
     * @throws PlayerAuthentification
     *              thrown if parameters match a player's in the container.
     */
    public void signIn (String nickname, String password) throws IdentificationError,
            ManagerAuthentificated, PlayerAuthentificated, BadParametersException {

        if (nickname = "") {
            throw BadParametersException("The nickname can't be empty");
        }
        try {

            Manager mng = personList.getManager(nickname);
            mng.authentificate(password);
            throw ManagerAuthentificated("Manager authentification seccessful", mng);

        } catch (FalseNickname fn) {

            Player plr = personList.getPlayer(nickname);
            plr.authentificate(password);
            throw PlayerAuthentificated("Player Authentification successful", plr);

        } catch (FalsePassword fp) {
            throw new IdentificationError("Nickname ou password erroné");
        }
    }

    /**
     * Search a competition by name.
     * 
     * @param competition
     *              the name or the date of the searched competition or part of it.
     * 
     * @return the search results.
     */
    public Competition search (String competition) {
        return competitionList.searchCompetition(competition);
    }


    /**
     * Search a competition by name.
     * 
     * @param competitor
     *              the firstname, lastname or id of the searched competitor or part of it.
     * 
     * @return the search results.
     */
    public Competitor search (String competitor) {
        return competitorList.searchCompetitor(competitor);

    }
}
