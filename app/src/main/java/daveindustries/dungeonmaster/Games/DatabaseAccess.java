package daveindustries.dungeonmaster.Games;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daver on 4/17/2017.
 */
public class DatabaseAccess {

    private static DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private static DatabaseReference mGamesRef = mRootRef.child("games");
    private static DatabaseReference thisGamesRef;

    private static Game game;
    private static List<Game> gamesList;

    private static DatabaseListener mListener;


    public static void CreateGame(Game game) {

        thisGamesRef = mGamesRef.push();
        game.setDbRef(thisGamesRef.getKey());

        thisGamesRef.setValue(game);

    }

    public static void getGames(DatabaseListener listener) {
        mListener = listener;
        getGamesFromDB();
    }

    private static void getGamesFromDB() {
        gamesList = new ArrayList();

        mGamesRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                game = new Game();

                game.setName(dataSnapshot.child("name").getValue().toString());
                game.setDbRef(dataSnapshot.child("dbRef").getValue().toString());
                //    game.setDmRef(messageSnapshot.child("dmRef").getValue().toString());
                Log.d("getGamesFromDB", "bueno");
                gamesList.add(game);

                mListener.receiveData(gamesList);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
              /*  for(DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    Game game = new Game();
                    game.setName(messageSnapshot.child("name").getValue().toString());
                    game.setDbRef(messageSnapshot.child("dbRef").getValue().toString());
                    //    game.setDmRef(messageSnapshot.child("dmRef").getValue().toString());
                    Log.d("getGamesFromDB", "bueno" );
                    gamesList.add(game);
                }
                mListener.receiveData(gamesList);*/
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public interface DatabaseListener {
        void receiveData(Object data);
    }

}
