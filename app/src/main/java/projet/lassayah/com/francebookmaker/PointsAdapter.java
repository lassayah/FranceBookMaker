package projet.lassayah.com.francebookmaker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import objet.Points;

/**
 * Created by LaMarseillaise on 10/18/2015.
 */
public class PointsAdapter extends RecyclerView.Adapter<PointsAdapter.ViewHolder> {

    private List<Points> points;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nomPoints;
        public TextView scorePoints;
        public TextView rankPoints;
        public ViewHolder(View v) {
            super(v);
           nomPoints = (TextView)v.findViewById(R.id.pointsName);
            scorePoints = (TextView)v.findViewById(R.id.pointsScore);
            rankPoints = (TextView)v.findViewById(R.id.pointsRank);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PointsAdapter(List<Points> points) {
        this.points = points;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PointsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pointslistviewitems, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
       Points p = points.get(position);
        holder.rankPoints.setText(p.getRank());
        holder.scorePoints.setText(p.getPoints());
        holder.nomPoints.setText(p.getNom());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return points.size();
    }




}
