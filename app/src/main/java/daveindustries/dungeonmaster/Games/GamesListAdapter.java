package daveindustries.dungeonmaster.Games;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import daveindustries.dungeonmaster.R;

/**
 * Created by daver on 4/17/2017.
 */

public class GamesListAdapter extends RecyclerView.Adapter<GamesListAdapter.ViewHolder>  {

    private List<Game> mGamesList = new ArrayList<>();
    private GamesListFragment.GamesListListener mListener;
    private Game game;


    public GamesListAdapter(List<Game> myGamesList, GamesListFragment.GamesListListener myListener) {
        mGamesList = myGamesList;
        mListener = myListener;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvGameName;
        public TextView tvGameLocation;
        public TextView tvLFP;
        public TextView tvNumPlayers;
        public RelativeLayout rlGameItem;


        public ViewHolder(View itemView) {
            super(itemView);
            tvGameName = (TextView) itemView.findViewById(R.id.tvGameName);
            tvGameLocation = (TextView) itemView.findViewById(R.id.tvLocation);
            tvLFP = (TextView) itemView.findViewById(R.id.tvLFP);
//          tvNumPlayers = (TextView) itemView.findViewById(R.id.tvNumPlayers);
            //rlGameItem.findViewById(R.id.rlGameItem);
        }
    }

    @Override
    public GamesListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.games_list_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(GamesListAdapter.ViewHolder holder, int position) {
        game = mGamesList.get(position);

        holder.tvGameName.setText(mGamesList.get(position).getName());
  /*      holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("onClick", "GamesListAdapter");
                mListener.getGame(game);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        if(mGamesList != null) {
            return mGamesList.size();
        }
        else {
            return 0;
        }
    }
}
