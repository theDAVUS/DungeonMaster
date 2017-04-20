package daveindustries.dungeonmaster.Games;



/**
 * Created by daver on 4/17/2017.
 */

public class Player  {

    private String playerName;
    private String playerLevel;
    private String playerClass;

    public String getPlayerName(){
        return playerName;
    }

    public String getPlayerLevel() {
        return playerLevel;
    }
    public String getPlayerClass() {
        return playerClass;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerLevel(String playerLevel) {
        this.playerLevel = playerLevel;
    }
    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public Player() {

    }

    public Player(String name) {
        this.playerName = name;
    }
}
