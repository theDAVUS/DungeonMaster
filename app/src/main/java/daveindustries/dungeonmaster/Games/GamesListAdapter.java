package daveindustries.dungeonmaster.Games;

import android.content.Context;
import android.location.Geocoder;
import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import daveindustries.dungeonmaster.R;

/**
 * Created by daver on 4/17/2017.
 */

public class GamesListAdapter extends RecyclerView.Adapter<GamesListAdapter.ViewHolder>  {


    private List<Game> mGamesList = new ArrayList<>();

    private AdapterListener mAdapterListener;
    private Game game;


    public GamesListAdapter(List<Game> myGamesList, AdapterListener listener) {
        mGamesList = myGamesList;
        mAdapterListener = listener;
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



    @SuppressWarnings("MissingPermission")
    @Override
    public void onBindViewHolder(GamesListAdapter.ViewHolder holder, int position) {
        final Game game = mGamesList.get(position);
        Location gameLocation = new Location("");
        gameLocation.setLongitude(game.getLongitude());
        gameLocation.setLatitude(game.getLatitude());

        holder.tvGameName.setText(mGamesList.get(position).getName());
        holder.tvGameLocation.setText(""/*+mLocation.distanceTo(gameLocation)*/);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("onClick", "GamesListAdapter "+game.getName());
                mAdapterListener.selectedGame(game);
               // mListener.onGameSelected(game);
            }
        });
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
    public interface AdapterListener {
        void selectedGame(Game game);
    }


}
