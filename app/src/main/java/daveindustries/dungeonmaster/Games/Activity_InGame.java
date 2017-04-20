package daveindustries.dungeonmaster.Games;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import daveindustries.dungeonmaster.Games.Messaging.MessagingFragment;
import daveindustries.dungeonmaster.R;

public class Activity_InGame extends AppCompatActivity implements fragment_inGameChars.OnFragmentInteractionListener{

    private MessagingFragment messageFragment = new MessagingFragment();
    private FrameLayout messageView;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Toolbar mToolbar;
    private fragment_inGameChars inGameChars = new fragment_inGameChars();


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
        setContentView(R.layout.activity__in_game);

        mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);
        messageView = (FrameLayout) findViewById(R.id.FragView);

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.fvInGameChars, inGameChars);
        ft.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
