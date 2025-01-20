package es.studium.practica6.ui.series;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import es.studium.practica6.R;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder> {

    private final List<Series> seriesList;
    private final OnSerieClickListener listener;

    public interface OnSerieClickListener {
        void onSerieClick(Series serie);
    }

    public SeriesAdapter(List<Series> seriesList, OnSerieClickListener listener) {
        this.seriesList = seriesList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_series, parent, false);
        return new SeriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesViewHolder holder, int position) {
        Series serie = seriesList.get(position);
        holder.ivImagenSerie.setImageResource(serie.getImagen());
        holder.tvTituloSerie.setText(serie.getNombre());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onSerieClick(serie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return seriesList.size();
    }

    public static class SeriesViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImagenSerie;
        TextView tvTituloSerie, tvTemporadas;

        public SeriesViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagenSerie = itemView.findViewById(R.id.ivImagenSerie);
            tvTituloSerie = itemView.findViewById(R.id.tvTituloSerie);
            tvTemporadas = itemView.findViewById(R.id.tvTemporadas);
        }
    }
}
