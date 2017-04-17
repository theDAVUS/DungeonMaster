package daveindustries.dungeonmaster.Games;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daver on 4/17/2017.
 */

public class Game implements Serializable {

    private String name;
    private String dmRef;
    private String dbRef;
    private String location;
    private ArrayList<Player> charList = new ArrayList<>();
    private boolean isLFP;

    /** Setters **/
    public void setName(String name) {
        this.name = name;
    }

    public void setDmRef(String dmRef) {
        this.dmRef = dmRef;
    }

    public void setDbRef(String dbRef) {
        this.dbRef = dbRef;
    }

    public void setCharList(ArrayList<Player> players) {
        this.charList = players;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLFP(boolean lfp) {
        this.isLFP = lfp;
    }

    /** Getters **/
    public String getName() {
        return name;
    }

    public String getDmRef() {
        return dmRef;
    }

    public String getDbRef() {
        return dbRef;
    }

    public List<Player> getCharList() {
        return charList;
    }

    public String getLocation() {
        return location;
    }

    public boolean isLFP() {
        return isLFP;
    }


    /** Constructors **/
    public Game() {

    }
    public Game(String name) {
        this.name = name;
    }

    /** Methods **/
    public void addToCharList(Player character){
        charList.add(character);
    }

}
