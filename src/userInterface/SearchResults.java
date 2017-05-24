package userInterface;

import java.sql.Array;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import betSystem.*;
import personSystem.*;

/**
 * SearchResults
 * 
 * Since results of the visitorInterface's search method, an auxilary class is needed
 */
public class SearchResults {

    private Competition[] competitions = None;
    private Competitor[] competitors = None;
    private Player[] players = None;
    private Bet[] bets = None;
    public SearchResults () {
    }
    /**
     * Set the competitions list
     * 
     * @param competitions
     *          ArryList of Competitions
     */
    public void setCompetitions(ArrayList<Competition> competitions) {
        this.competitions = competitions;
    }
    /**
     * Set the competitors list
     * 
     * @param competitors
     *          ArryList of Competitors
     */
    public void setCompetitiors(ArrayList<Competitor> competitors) {
        this.competitors = competitors;
    }
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    public void setBets(ArrayList<Bet> bets) {
        this.bets = bets;
    }
}
