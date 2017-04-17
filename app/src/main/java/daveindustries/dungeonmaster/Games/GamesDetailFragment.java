package daveindustries.dungeonmaster.Games;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;

import daveindustries.dungeonmaster.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GamesDetailListener} interface
 * to handle interaction events.
 */
public class GamesDetailFragment extends Fragment  {

    private GamesDetailListener mListener;

    private View view;
    private TextView tvGameName;
    private TextView tvGameLocation;
    private TextView tvLFP;
    private Button btJoinGame;

    public GamesDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_games_detail, container, false);

        tvGameName = (TextView) view.findViewById(R.id.tvGameName);
        tvGameLocation = (TextView) view.findViewById(R.id.tvGameLocation);
        tvLFP = (TextView) view.findViewById(R.id.tvLFP);
        btJoinGame = (Button) view.findViewById(R.id.btJoinGame);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.GamesDetail(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
            mListener = (GamesDetailListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void setArguments(Bundle args) {

        Game game = (Game) args.getSerializable("game");

        Log.d("GamesDetail ", game.getName());

        tvGameName.setText(game.getName());

        tvGameLocation.setText(game.getLocation());

        if (game.isLFP()) {
            tvLFP.setText(R.string.isLFP);
            btJoinGame.setClickable(true);
            btJoinGame.setVisibility(View.VISIBLE);
        } else {
            tvLFP.setText(R.string.isNotLFP);
            btJoinGame.setVisibility(View.GONE);
        }
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
    public interface GamesDetailListener {
        void GamesDetail(Uri uri);
    }
}
