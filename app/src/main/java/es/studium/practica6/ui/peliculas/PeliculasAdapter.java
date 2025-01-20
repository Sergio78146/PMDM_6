package es.studium.practica6.ui.peliculas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.studium.practica6.R;

public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasAdapter.PeliculaViewHolder> {

    private final List<Peliculas> listaPeliculas;
    private final OnPeliculaClickListener listener;

    public interface OnPeliculaClickListener {
        void onPeliculaClick(Peliculas pelicula);
    }

    public PeliculasAdapter(List<Peliculas> listaPeliculas, OnPeliculaClickListener listener) {
        this.listaPeliculas = listaPeliculas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_peliculas, parent, false);
        return new PeliculaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder holder, int position) {
        Peliculas pelicula = listaPeliculas.get(position);
        holder.imgPelicula.setImageResource(pelicula.getImagen());
        holder.txtNombre.setText(pelicula.getNombre());
        holder.itemView.setOnClickListener(v -> listener.onPeliculaClick(pelicula));
    }

    @Override
    public int getItemCount() {
        return listaPeliculas.size();
    }

    static class PeliculaViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPelicula;
        TextView txtNombre;

        public PeliculaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPelicula = itemView.findViewById(R.id.ivImagenPelicula);
            txtNombre = itemView.findViewById(R.id.tvTituloPelicula);
        }
    }
}
