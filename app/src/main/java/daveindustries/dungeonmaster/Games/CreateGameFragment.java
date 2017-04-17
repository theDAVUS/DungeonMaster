package daveindustries.dungeonmaster.Games;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import daveindustries.dungeonmaster.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CreateGameInterface} interface
 * to handle interaction events.
 */
public class CreateGameFragment extends Fragment {

    private CreateGameInterface mListener;
    private View view;
    private EditText etGameName;
    private CheckBox cbLFP;
    private Button btCreateGame;

    public CreateGameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_create_game, container, false);

        etGameName = (EditText) view.findViewById(R.id.etGameName);
        cbLFP = (CheckBox) view.findViewById(R.id.cbLFP);
        btCreateGame = (Button) view.findViewById(R.id.btCreateGame);
        btCreateGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game game = new Game(etGameName.getText().toString(), cbLFP.isChecked());
                DatabaseAccess.CreateGame(game);
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.CreateGameInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CreateGameInterface) {
            mListener = (CreateGameInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement CreateGameInterface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface CreateGameInterface {
        void CreateGameInteraction(Uri uri);
    }
}
