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

// Clase adaptador que extiende RecyclerView.Adapter
public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasAdapter.PeliculaViewHolder> {

    // Lista de películas que se mostrarán en el RecyclerView
    private final List<Peliculas> listaPeliculas;
    // Listener para manejar los clics en los elementos de la lista
    private final OnPeliculaClickListener listener;

    // Interfaz para manejar clics en las películas
    public interface OnPeliculaClickListener {
        void onPeliculaClick(Peliculas pelicula);
    }

    // Constructor del adaptador, recibe la lista de películas y el listener
    public PeliculasAdapter(List<Peliculas> listaPeliculas, OnPeliculaClickListener listener) {
        this.listaPeliculas = listaPeliculas;
        this.listener = listener;
    }

    // Método que crea nuevas vistas cuando el RecyclerView lo necesita
    @NonNull
    @Override
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflamos el layout para cada elemento de la lista (item_peliculas.xml)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_peliculas, parent, false);
        return new PeliculaViewHolder(view);
    }

    // Método que asigna los datos a cada vista en el RecyclerView
    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder holder, int position) {
        // Obtener la película de la lista según la posición
        Peliculas pelicula = listaPeliculas.get(position);

        // Asignar la imagen de la película al ImageView
        holder.imgPelicula.setImageResource(pelicula.getImagen());

        // Asignar el nombre de la película al TextView
        holder.txtNombre.setText(pelicula.getNombre());

        // Agregar un evento de clic para navegar a los detalles de la película
        holder.itemView.setOnClickListener(v -> listener.onPeliculaClick(pelicula));
    }

    // Método que devuelve la cantidad de elementos en la lista
    @Override
    public int getItemCount() {
        return listaPeliculas.size();
    }

    // Clase interna que representa cada fila del RecyclerView
    public static class PeliculaViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPelicula; // Imagen de la película
        TextView txtNombre;    // Nombre de la película

        public PeliculaViewHolder(@NonNull View itemView) {
            super(itemView);
            // Referencias a los elementos del layout item_peliculas.xml
            imgPelicula = itemView.findViewById(R.id.ivImagenPelicula);
            txtNombre = itemView.findViewById(R.id.tvTituloPelicula);
        }
    }
}
