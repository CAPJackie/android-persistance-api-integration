package co.edu.pdam.eci.persistenceapiintegration.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(TeamsAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name;

        private TextView shortName;

        private ImageView logo;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
