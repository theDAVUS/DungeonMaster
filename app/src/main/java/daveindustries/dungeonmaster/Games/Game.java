package daveindustries.dungeonmaster.Games;

import android.location.Address;
import android.location.Location;

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
    private double latitude;
    private double longitude;
    private String playTime;
    private List<Player> charList = new ArrayList<>();
    private boolean isLFP = false;

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

    public void setCharList(List<Player> players) {
        this.charList = players;
    }

    public void setLatitude(double location) {
        this.latitude = location;
    }
    public void setLongitude(double location) {
        this.longitude = location;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
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

    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }

    public String getPlayTime() {
        return playTime;
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

    public Game(String name, boolean isLFP) {
        this.name = name;
        this.isLFP = isLFP;

    }

    /** Methods **/
    public void addToCharList(Player character){
        this.charList.add(character);
    }

}
