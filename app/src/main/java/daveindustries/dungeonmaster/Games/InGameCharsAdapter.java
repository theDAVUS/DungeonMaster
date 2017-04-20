package daveindustries.dungeonmaster.Games;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import java.util.List;

import daveindustries.dungeonmaster.R;

/**
 * Created by daver on 4/20/2017.
 */

public class InGameCharsAdapter extends ArrayAdapter<Player> {

    private List<Player> players;

    InGameCharsAdapter(Context context, List<Player> players) {
        super(context, R.layout.in_game_grid_item, players);
        this.players = players;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.in_game_grid_item, parent, false);

        Player playerItem = getItem(position);
        TextView tvPlayerName = (TextView) customView.findViewById(R.id.tvPlayerName);
        TextView tvPlayerLvl = (TextView) customView.findViewById(R.id.tvPlayerLvl);
        TextView tvPlayerClass = (TextView) customView.findViewById(R.id.tvPlayerClass);

        tvPlayerName.setText(playerItem.getPlayerName());
        tvPlayerLvl.setText(playerItem.getPlayerLevel());
        tvPlayerClass.setText(playerItem.getPlayerClass());

        return customView;
    }

    @Override
    public int getCount() {
        if(players != null) {
            return players.size();
        }
        else {
            return 0;
        }
    }
}

