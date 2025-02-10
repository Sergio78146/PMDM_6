package es.studium.practica6.ui.peliculas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.studium.practica6.R;

// Definimos la clase del Fragmento que muestra las películas
public class PeliculasFragment extends Fragment {

    // Método que se ejecuta cuando se crea la vista del fragmento
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflamos el layout del fragmento (fragment_peliculas.xml)
        View view = inflater.inflate(R.layout.fragment_peliculas, container, false);

        // Referencia al RecyclerView en el layout
        RecyclerView rvPeliculas = view.findViewById(R.id.rvPeliculas);
        // Configuramos el RecyclerView para que muestre los elementos en una lista vertical
        rvPeliculas.setLayoutManager(new LinearLayoutManager(getContext()));

        // Creamos una lista de películas con datos predefinidos
        List<Peliculas> listaPeliculas = new ArrayList<>();
        listaPeliculas.add(new Peliculas(R.drawable.luca, "Luca", "Luca", "Enrico Casarosa", "Jacob Tremblay, Jack Dylan Grazer", 4, "Un joven monstruo marino explora el mundo humano."));
        listaPeliculas.add(new Peliculas(R.drawable.nimona, "Nimona", "Nimona", "Nick Bruno", "Chloë Grace Moretz, Riz Ahmed", 5, "Una cambiaformas rebelde une fuerzas con un caballero deshonrado."));
        listaPeliculas.add(new Peliculas(R.drawable.shrek, "Shrek", "Shrek", "Andrew Adamson, Vicky Jenson", "Mike Myers, Eddie Murphy, Cameron Diaz", 5, "Un ogro y un burro salvan a una princesa."));
        listaPeliculas.add(new Peliculas(R.drawable.toy_story, "Toy Story", "Toy Story", "John Lasseter", "Tom Hanks, Tim Allen", 5, "Los juguetes cobran vida cuando los humanos no miran."));
        listaPeliculas.add(new Peliculas(R.drawable.monsters_inc, "Monsters Inc.", "Monsters Inc.", "Pete Docter", "John Goodman, Billy Crystal", 5, "Monstruos recolectan gritos para energía."));
        listaPeliculas.add(new Peliculas(R.drawable.frozen, "Frozen", "Frozen", "Chris Buck, Jennifer Lee", "Idina Menzel, Kristen Bell", 4, "Una princesa con poderes de hielo lucha contra su destino."));
        listaPeliculas.add(new Peliculas(R.drawable.coco, "Coco", "Coco", "Lee Unkrich, Adrian Molina", "Anthony Gonzalez, Gael García Bernal", 2, "Un niño viaja a la Tierra de los Muertos para descubrir su legado familiar."));

        // Creamos el adaptador y le pasamos la lista de películas
        PeliculasAdapter adapter = new PeliculasAdapter(listaPeliculas, pelicula -> {
            // Crear un Bundle para enviar los datos de la película seleccionada
            Bundle bundle = new Bundle();
            bundle.putInt("imagen", pelicula.getImagen());
            bundle.putString("nombre", pelicula.getNombre());
            bundle.putString("titulo", pelicula.getTitulo());
            bundle.putString("director", pelicula.getDirector());
            bundle.putString("reparto", pelicula.getReparto());
            bundle.putInt("clasificacion", pelicula.getClasificacion());
            bundle.putString("sinopsis", pelicula.getSinopsis());

            // Navegamos al fragmento de detalles enviando el Bundle con los datos de la película
            Navigation.findNavController(view).navigate(R.id.nav_detalles_pelicula, bundle);
        });

        // Asignamos el adaptador al RecyclerView
        rvPeliculas.setAdapter(adapter);

        // Retornamos la vista del fragmento
        return view;
    }
}
