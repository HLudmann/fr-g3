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

    private ArrayList<Competition> competitions = None;
    private ArrayList<Competitor> competitors = None;
    private ArrayList<Player> players = None;
    private ArrayList<Bet> bets = None;
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
