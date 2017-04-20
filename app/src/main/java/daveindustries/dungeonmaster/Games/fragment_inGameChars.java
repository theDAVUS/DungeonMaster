package daveindustries.dungeonmaster.Games;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import daveindustries.dungeonmaster.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragment_inGameChars.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragment_inGameChars#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_inGameChars extends Fragment implements DatabaseAccess.InGameListener{

    private View view;
    private GridView grid;
    private List<Player> mPlayersList;
    private InGameCharsAdapter mAdapter;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    public fragment_inGameChars() {
        // Required empty public constructor
    }

    public static fragment_inGameChars newInstance(String param1, String param2) {
        fragment_inGameChars fragment = new fragment_inGameChars();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment_in_game_chars, container, false);
        grid = (GridView) view.findViewById(R.id.gvPlayers);
        DatabaseAccess.GetInGameChars("-KiCOwQkVUwKedwaB10b", this);
        return view;
    }




    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void receiveGame(List<Player> players) {
        mPlayersList = players;
        mAdapter = new InGameCharsAdapter(view.getContext(), mPlayersList);
        grid.setAdapter(mAdapter);
        Log.d("receiveGame", "fired");
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
