package daveindustries.dungeonmaster.Games;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import daveindustries.dungeonmaster.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GamesListListener} interface
 * to handle interaction events.
 */
public class GamesListFragment extends Fragment implements DatabaseAccess.DatabaseListener {

    private GamesListAdapter adapter;
    private List<Game> mGamesList;
    private View view;
    private RecyclerView recycler;

    private GamesListListener mListener;

    public GamesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_games_list, container, false);
        recycler = (RecyclerView) view.findViewById(R.id.list);

        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        DatabaseAccess.getGames(this);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
     //       mListener.onGameSelected(game);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof GamesListListener) {
            mListener = (GamesListListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement GamesListListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void receiveData(Object data) {
        mGamesList = (ArrayList<Game>) data;
        adapter = new GamesListAdapter(mGamesList, mListener);
        recycler.setAdapter(adapter);
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
    public interface GamesListListener {
        // TODO: Update argument type and name
        void onGameSelected(Game game);
    }
}
