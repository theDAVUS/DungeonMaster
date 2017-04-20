package daveindustries.dungeonmaster.Games;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


import daveindustries.dungeonmaster.Games.Messaging.MessagingFragment;
import daveindustries.dungeonmaster.R;

public class MainActivity extends AppCompatActivity implements GamesListFragment.GamesListListener,
        GamesDetailFragment.GamesDetailListener, CreateGameFragment.CreateGameInterface, DatabaseAccess.MessageListener {


    FragmentManager fragmentManager = getSupportFragmentManager();
    Button btCreateGame;

    GamesDetailFragment detailsFrag = new GamesDetailFragment();
    MessagingFragment messageFragment = new MessagingFragment();;

    FrameLayout messageView;

    private Toolbar mToolbar;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btMsg:
                if(!messageFragment.isVisible()) {
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.add(R.id.FragView, messageFragment);
                    ft.addToBackStack(null);
                    ft.commit();

                    return true;
                }
                else {
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.remove(messageFragment);

                    ft.commit();
                    messageView.setClickable(false);
                    findViewById(R.id.llFragView).setClickable(true);
                    return true;

                }
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_layout, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);
        messageView = (FrameLayout) findViewById(R.id.FragView);

       // CreateTestData();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.fragView, detailsFrag);
        ft.commit();


        btCreateGame = (Button) findViewById(R.id.btStartCreate);
        btCreateGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btCreateGame.setVisibility(View.GONE);
                FragmentTransaction ft = fragmentManager.beginTransaction();
                CreateGameFragment createGameFragment = new CreateGameFragment();
                ft.replace(R.id.fragView, createGameFragment);
                ft.addToBackStack(null);
                ft.commit();
            }

        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void GamesDetail(Uri uri) {

    }

    @Override
    public void onGameSelected(Game game) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("game", game);
        detailsFrag.setArguments(bundle);
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

    @Override
    public void CreateGameInteraction(Uri uri) {

    }


    @Override
    public void receiveMessage(String message) {

    }
}
