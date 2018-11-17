package co.edu.pdam.eci.persistenceapiintegration.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.edu.pdam.eci.persistenceapiintegration.R;
import co.edu.pdam.eci.persistenceapiintegration.data.entity.Team;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    private List<Team> teams;

    public TeamsAdapter(List<Team> teams){
        this.teams = teams;
    }

    @Override
    public TeamsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.card_view, parent, false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TeamsAdapter.ViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.shortName.setText(team.shortName);
        holder.name.setText(team.name);
        holder.imageUrl.setText(team.imageUrl);
    }

    @Override
    public int getItemCount() {

        return teams == null ? 0 : teams.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView( R.id.name )
        TextView name;

        @BindView( R.id.shortName )
        TextView shortName;

        @BindView( R.id.imageUrl )
        TextView imageUrl;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
