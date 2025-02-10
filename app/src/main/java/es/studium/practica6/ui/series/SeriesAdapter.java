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

// Adaptador para el RecyclerView
public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder> {

    // Lista de series y el listener para manejar los clics
    private final List<Series> seriesList;
    private final OnSerieClickListener listener;

    // Interfaz para manejar los clics en una serie
    public interface OnSerieClickListener {
        void onSerieClick(Series serie);
    }

    // Constructor del adaptador, recibe la lista de series y el listener
    public SeriesAdapter(List<Series> seriesList, OnSerieClickListener listener) {
        this.seriesList = seriesList;
        this.listener = listener;
    }

    // Infla el layout de cada ítem de la lista y crea el ViewHolder
    @NonNull
    @Override
    public SeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_series, parent, false);
        return new SeriesViewHolder(view);
    }

    // Vincula los datos de la serie con el ViewHolder
    @Override
    public void onBindViewHolder(@NonNull SeriesViewHolder holder, int position) {
        Series serie = seriesList.get(position);  // Obtiene la serie en la posición actual
        holder.ivImagenSerie.setImageResource(serie.getImagen());  // Asigna la imagen
        holder.tvTituloSerie.setText(serie.getNombre());  // Asigna el título

        // Agrega un evento de clic para cada ítem de la lista
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onSerieClick(serie);
            }
        });
    }

    // Devuelve el número de elementos en la lista
    @Override
    public int getItemCount() {
        return seriesList.size();
    }

    // Clase interna que representa cada ítem de la lista
    public static class SeriesViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImagenSerie;
        TextView tvTituloSerie, tvTemporadas;

        public SeriesViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagenSerie = itemView.findViewById(R.id.ivImagenSerie);  // Imagen de la serie
            tvTituloSerie = itemView.findViewById(R.id.tvTituloSerie);  // Título de la serie
            tvTemporadas = itemView.findViewById(R.id.tvTemporadas);  // Número de temporadas
        }
    }
}
