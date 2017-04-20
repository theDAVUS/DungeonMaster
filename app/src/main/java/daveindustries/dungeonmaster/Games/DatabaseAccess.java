package daveindustries.dungeonmaster.Games;

import android.util.Log;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import daveindustries.dungeonmaster.Games.Messaging.ChatMessage;

/**
 * Created by daver on 4/17/2017.
 */
public class DatabaseAccess {

    /* User Interface */
    private static DatabaseReference mUserRef;
    private static DatabaseReference mCharacterRef;
    private static String mUid;

    /* Messaging Interface */
    private static DatabaseReference mMessagingRef;

    /* Games Interface */
    private static DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private static DatabaseReference mGamesRef = mRootRef.child("games");
    private static DatabaseReference thisGamesRef;
    private static Game game;
    private static List<Game> gamesList;
    private static MessageListener messageListener;

    private static DatabaseListener mListener;

    private static Queue<ChatMessage> queue = new LinkedList<>();

    public static String getmUid() {
        return mUid;
    }

    public static void setUser(FirebaseUser mUser) {
        mUid = mUser.getUid();
        mUserRef = mRootRef.child("users").child(mUid);
        mMessagingRef = mUserRef.child("messages");
        mCharacterRef = mUserRef.child("characters");
    }


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
                game.setLFP(Boolean.parseBoolean(dataSnapshot.child("lfp").getValue().toString()));
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


    public static void SendMessage(ChatMessage mMessage) {
        mRootRef.child("users").child(mMessage.getSendTo()).child("messages").child(mUid).setValue(mMessage.getMessage());
    }

    public static void getMessages(MessageListener listener) {
        messageListener = listener;
        mMessagingRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                         messageListener.receiveMessage(messageSnapshot.getValue().toString());
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        setMessageListener(listener);
    }


    public static void setMessageListener(MessageListener listener) {
        messageListener = listener;
        mRootRef.child("users").child(mUid).child("messages").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                messageListener.receiveMessage(dataSnapshot.getValue().toString());

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                messageListener.receiveMessage(dataSnapshot.getValue().toString());
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



    public interface MessageListener {

        void receiveMessage(String message);

    }



}
