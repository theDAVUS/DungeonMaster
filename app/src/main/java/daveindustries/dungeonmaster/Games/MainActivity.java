package daveindustries.dungeonmaster.Games;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import daveindustries.dungeonmaster.R;

public class MainActivity extends AppCompatActivity implements GamesListFragment.GamesListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //    CreateTestData();
    }




    @Override
    public void onGameSelected(Game game) {

    }

    public void CreateTestData() {

        Player char1 = new Player("Long");
        Player char2 = new Player("Dong");
        Player char3 = new Player("Ching");
        Player char4 = new Player("Chong");

        Game game1 = new Game("Farts");
        game1.addToCharList(char1);
        game1.addToCharList(char2);
        game1.addToCharList(char3);
        game1.addToCharList(char4);
        DatabaseAccess.CreateGame(game1);

        Game game2 = new Game("Hearts");
        game2.addToCharList(char1);
        game2.addToCharList(char2);
        game2.addToCharList(char3);
        game2.addToCharList(char4);
        DatabaseAccess.CreateGame(game2);

        Game game3 = new Game("Shartz");
        game3.addToCharList(char1);
        game3.addToCharList(char2);
        game3.addToCharList(char3);
        game3.addToCharList(char4);
        DatabaseAccess.CreateGame(game3);

        Game game4 = new Game("Gnomes");
        game4.addToCharList(char1);
        game4.addToCharList(char2);
        game4.addToCharList(char3);
        game4.addToCharList(char4);
        DatabaseAccess.CreateGame(game4);

    }
}
