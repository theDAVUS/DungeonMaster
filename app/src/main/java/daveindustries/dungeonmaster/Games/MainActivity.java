package daveindustries.dungeonmaster.Games;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import daveindustries.dungeonmaster.R;

public class MainActivity extends AppCompatActivity implements GamesListFragment.GamesListListener, GamesDetailFragment.GamesDetailListener, CreateGameFragment.CreateGameInterface {

   // CreateGameFragment createGameFragment = (CreateGameFragment) getSupportFragmentManager().findFragmentById(R.id.CreateGameFrag);
    FragmentManager fragmentManager = getSupportFragmentManager();
    Button btCreateGame;

        GamesDetailFragment detailsFrag = new GamesDetailFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CreateTestData();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.fragView, detailsFrag);
        ft.commit();


        btCreateGame = (Button) findViewById(R.id.btStartCreate);
        btCreateGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction ft = fragmentManager.beginTransaction();
                CreateGameFragment createGameFragment = new CreateGameFragment();
                ft.replace(R.id.fragView, createGameFragment);
                ft.commit();
            }

        });
    }



    @Override
    public void GamesDetail(Uri uri) {

    }

    @Override
    public void onGameSelected(Game game) {
         //(GamesDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFrag);
        Bundle bundle = new Bundle();

        bundle.putSerializable("game", game);

        detailsFrag.setArguments(bundle);
    }

    @Override
    public void CreateGameInteraction(Uri uri) {

    }


    public void CreateTestData() {

        Player char1 = new Player("Long");
        Player char2 = new Player("Dong");
        Player char3 = new Player("Ching");
        Player char4 = new Player("Chong");

        Game game1 = new Game("Farts", true);
        game1.addToCharList(char1);
        game1.addToCharList(char2);
        game1.addToCharList(char3);
        game1.addToCharList(char4);
        DatabaseAccess.CreateGame(game1);

        Game game2 = new Game("Hearts", false);
        game2.addToCharList(char1);
        game2.addToCharList(char2);
        game2.addToCharList(char3);
        game2.addToCharList(char4);
        DatabaseAccess.CreateGame(game2);

        Game game3 = new Game("Shartz", true);
        game3.addToCharList(char1);
        game3.addToCharList(char2);
        game3.addToCharList(char3);
        game3.addToCharList(char4);
        DatabaseAccess.CreateGame(game3);

        Game game4 = new Game("Gnomes", true);
        game4.addToCharList(char1);
        game4.addToCharList(char2);
        game4.addToCharList(char3);
        game4.addToCharList(char4);
        DatabaseAccess.CreateGame(game4);

    }

}
