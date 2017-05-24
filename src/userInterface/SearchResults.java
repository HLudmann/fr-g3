package userInterface;

import java.sql.Array;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import src.betSystem.*;
import src.personSystem.*;

/**
 * SearchResults
 * 
 * Since results of the visitorInterface's search method, an auxilary class is needed
 */
public class SearchResults {

    private String researchString;
    private ArrayList<Competition> competitions = None;
    private ArrayList<Competitor> competitors = None;
    private ArrayList<Player> players = None;
    private ArrayList<Bet> bets = None;
    public SearchResults (String demand) {
        this.researchString = demand;
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
    /**
     * To String method
     */
    public void toString() {

        String res = new String("Results of the search for: "+this.researchString+"\n");
        if (this.competitions != None) {
            res += "Competitions: \n";
            while (this.competitions.hasNext()) {
                String s = this.competitions.next().toString();
                res += s+"\n";
            }
        }
        if (this.competitors != None) {
            res += "Competitors: \n";
            while (this.competitors.hasNext()) {
                String s = this.competitors.next().toString();
                res += s+"\n";
            }
        }
        if (this.players != None) {
            res += "Players: \n";
            while (this.players.hasNext()) {
                String s = this.players.next().toString();
                res += s+"\n";
            }
        }
        if (this.bets != None) {
            res += "Bets: \n";
            while (this.bets.hasNext()) {
                String s = this.bets.next().toString();
                res += s+"\n";
            }
        }
        return res;
    }
}
