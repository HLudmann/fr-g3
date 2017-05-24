package userInterface;

import java.util.ArrayList;
import personSystem.*;
import betSystem.*;
import container.*;
import userInterface.exceptions.*;

/**
 * @author HLudmann + BusterJava
 * 
 */
public class VisitorInterface extends Thread {

    private long id;
    private static long nextId = 0; 
    protected static CompContainer competitionList = new CompContainer();
    protected static PersonContainer personList = new PersonContainer();

    public VisitorInterface () {
        this.id = nextId;
        nextId++;
    }

    public long getId () {
        return this.id;
    }

    /** 
     * Singn In for Managers.
     * 
     * @param nickname
     *              the nickname chosen by the Manager.
     * @param password
     *              the password chosen by the Manager.
     * 
     * @throws BadParametersException
     *              thrown if an empty nickname or password was given.
     * @throws IdentificationError
     *              thrown if parameters don't match anything in the container.
     */
    public ManagerInterface signInManager (String nickname, String password) throws IdentificationError,
            BadParametersException {

        if (nickname == "" || password == "") {
            throw BadParametersException("The nickname and/or password can't be empty");
        }
        try {

            Manager mng = personList.findManager(nickname);
            mng.authentificate(password);
            return new ManagerInterface(mng);

        } catch (FalseNickname fn) {
            throw new IdentificationError("Nickname ou password erroné");
        } catch (FalsePassword fp) {
            throw new IdentificationError("Nickname ou password erroné");
        }
    }

    /** 
     * Singn In for Player.
     * 
     * @param nickname
     *              the nickname chosen by the Player when he subscribed.
     * @param password
     *              the password chosen by the Player when he subscribed.
     * 
     * @throws BadParametersException
     *              thrown if an empty nickname or password was given.
     * @throws IdentificationError
     *              thrown if parameters don't match anything in the container.
     */
    public PlayerInterface signInPlayer (String nickname, String password) throws IdentificationError,
            BadParametersException {

        if (nickname == "" || password == "") {
            throw BadParametersException("The nickname and/or password can't be empty");
        }
        try {

            Player plr = personList.findPlayer(nickname);
            plr.authentificate(password);
            return new PlayerInterface(plr);

        } catch (FalseNickname fn) {
            throw new IdentificationError("Nickname ou password erroné");
        } catch (FalsePassword fp) {
            throw new IdentificationError("Nickname ou password erroné");
        }
    }

    /**
     * List competitions
     * 
     * @return all the public infos about each competition that has not ended.
     */
   public String[][] competitionListing() {
        ArrayList<Competition> list = competitionList.getListNotEnded();
        String[][] res = new String[list.size()][2];
        for (int i; i < list.size(); i++) {
            res[i][0] = list[i].getName();
            res[i][1] = list[i].getDate().toString();
        }
        return res;
    }

    /**
     * List competitors
     * 
     * @return all the public infos about each competitor 
     *              who is competiting in a upcomming competition
     */
    public String[][] competitorListing() {
        ArrayList<Competitor> list = personList.getCompetitors();
        String[][] res = new String[list.size()][3];
        for (int i; i < list.size(); i++) {
            res[i][0] = list[i].getId().toString();
            res[i][1] = list[i].getFirstname();
            res[i][2] = list[i].getLastname();
        }
        return res;
    }

    /**
     * Search a competition by name.
     * 
     * @param name
     *             partial or complete name of the competition.
     * 
     * @return the search results.
     */
    public String[][] searchCompetitionByName (String name) {
        ArrayList<Competition> list = competitionList.findCompetitionByName(name);
        String[][] res = new String[list.size()][2];
        for (int i; i < list.size(); i++) {
            res[i][0] = list[i].getName();
            res[i][1] = list[i].getDate().toString();
        }
        return res;
    }

    /**
     * Search a competition by date.
     * 
     * @param date
     *            date when the competition takes place.
     * 
     * @return the search results.
     */
    public String[][] searchCompetitionByDate (Date date) {
        ArrayList<Competition> list = competitionList.findCompetitionByDate(date);
        String[][] res = new String[list.size()][2];
        for (int i; i < list.size(); i++) {
            res[i][0] = list[i].getName();
            res[i][1] = list[i].getDate().toString();
        }
        return res;
    }

    /**
     * Search competitions by a competitor.
     * 
     * @param id
     *          complete id of a competitor.
     * 
     * @return the public detail of all the upcomming competitions attended by this competitor.     * 
     */
    public String[][] searchCompetitionByCompetitor(int id) {
        ArrayList<Competitions> list = personList.findCompetitorById(id)[0].getCompetitions();
        String[][] res = new String[list.size()][2];
        for (int i; i < list.size(); i++) {
            res[i][0] = list[i].getName();
            res[i][1] = list[i].getDate().toString();
        }
        return res;
    }

    /**
     * Search a competitor by name.
     * 
     * @param name
     *             partial or complete name of the competitor.
     * 
     * @return the search results.
     */
    public String[][] searchCompetitorByName (String name) {
        ArrayList<Competition> list = personList.findCompetitorByName(name);
        String[][] res = new String[list.size()][3];
        for (int i; i < list.size(); i++) {
            res[i][0] = list[i].getId().toString();
            res[i][1] = list[i].getFirstname();
            res[i][2] = list[i].getLastname();
        }
        return res;
    }

    /**
     * Search a competitor by id.
     * 
     * @param id
     *             partial or complete id of the competitor.
     * 
     * @return the search results.
     */
    public String[][] searchCompetitorById (int id) {
        ArrayList<Competition> list = personList.findCompetitorById(id);
        String[][] res = new String[list.size()][3];
        for (int i; i < list.size(); i++) {
            res[i][0] = list[i].getId().toString();
            res[i][1] = list[i].getFirstname();
            res[i][2] = list[i].getLastname();
        }
        return res;
    }

    /**
     * Search competitors by a competition.
     * 
     * @param name
     *          complete name of a competition.
     * 
     * @return the public detail of all the competitors attending the specified competition. 
     */
    public String[][] searchCompetitorByCompetition(String name) {
        ArrayList<Competitor> list = competitionList.findCompetitionByName(name)[0].getCompetitors();
        String[][] res = new String[list.size()][3];
        for (int i; i < list.size(); i++) {
            res[i][0] = list[i].getId().toString();
            res[i][1] = list[i].getFirstname();
            res[i][2] = list[i].getLastname();
        }
        return res;
    }
}
