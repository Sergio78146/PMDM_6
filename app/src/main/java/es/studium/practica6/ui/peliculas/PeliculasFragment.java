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

public class PeliculasFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_peliculas, container, false);

        RecyclerView rvPeliculas = view.findViewById(R.id.rvPeliculas);
        rvPeliculas.setLayoutManager(new LinearLayoutManager(getContext()));

        // Lista de películas con datos completos
        List<Peliculas> listaPeliculas = new ArrayList<>();
        listaPeliculas.add(new Peliculas(R.drawable.luca, "Luca", "Luca", "Enrico Casarosa", "Jacob Tremblay, Jack Dylan Grazer", 4, "Un joven monstruo marino explora el mundo humano."));
        listaPeliculas.add(new Peliculas(R.drawable.nimona, "Nimona", "Nimona", "Nick Bruno", "Chloë Grace Moretz, Riz Ahmed", 5, "Una cambiaformas rebelde une fuerzas con un caballero deshonrado."));
        listaPeliculas.add(new Peliculas(R.drawable.shrek, "Shrek", "Shrek", "Andrew Adamson, Vicky Jenson", "Mike Myers, Eddie Murphy, Cameron Diaz", 5, "Un ogro y un burro salvan a una princesa."));
        listaPeliculas.add(new Peliculas(R.drawable.toy_story, "Toy Story", "Toy Story", "John Lasseter", "Tom Hanks, Tim Allen", 5, "Los juguetes cobran vida cuando los humanos no miran."));
        listaPeliculas.add(new Peliculas(R.drawable.monsters_inc, "Monsters Inc.", "Monsters Inc.", "Pete Docter", "John Goodman, Billy Crystal", 5, "Monstruos recolectan gritos para energía."));
        listaPeliculas.add(new Peliculas(R.drawable.frozen, "Frozen", "Frozen", "Chris Buck, Jennifer Lee", "Idina Menzel, Kristen Bell", 4, "Una princesa con poderes de hielo lucha contra su destino."));
        listaPeliculas.add(new Peliculas(R.drawable.coco, "Coco", "Coco", "Lee Unkrich, Adrian Molina", "Anthony Gonzalez, Gael García Bernal", 2, "Un niño viaja a la Tierra de los Muertos para descubrir su legado familiar."));


        PeliculasAdapter adapter = new PeliculasAdapter(listaPeliculas, pelicula -> {
            // Navegación al fragmento de detalles
            Bundle bundle = new Bundle();
            bundle.putInt("imagen", pelicula.getImagen());
            bundle.putString("nombre", pelicula.getNombre());
            bundle.putString("titulo", pelicula.getTitulo());
            bundle.putString("director", pelicula.getDirector());
            bundle.putString("reparto", pelicula.getReparto());
            bundle.putInt("clasificacion", pelicula.getClasificacion());
            bundle.putString("sinopsis", pelicula.getSinopsis());
            Navigation.findNavController(view).navigate(R.id.nav_detalles_pelicula, bundle);
        });

        rvPeliculas.setAdapter(adapter);
        return view;
    }
}
