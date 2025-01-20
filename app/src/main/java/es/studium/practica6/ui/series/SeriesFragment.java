package es.studium.practica6.ui.series;

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

public class SeriesFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series, container, false);

        RecyclerView rvSeries = view.findViewById(R.id.rvSeries);
        rvSeries.setLayoutManager(new LinearLayoutManager(getContext()));

        // Lista de series con datos completos
        List<Series> listaSeries = new ArrayList<>();
        listaSeries.add(new Series(R.drawable.breaking_bad, "Breaking Bad", "Breaking Bad", "Vince Gilligan", "Bryan Cranston, Aaron Paul", 5, "5", "Un profesor de química se convierte en fabricante de metanfetaminas."));
        listaSeries.add(new Series(R.drawable.stranger_things, "Stranger Things", "Stranger Things", "Los Duffer Brothers", "Millie Bobby Brown, Finn Wolfhard", 2, "4", "Un grupo de amigos descubre un mundo paralelo llamado Upside Down."));
        listaSeries.add(new Series(R.drawable.game_of_thrones, "Game of Thrones", "Game of Thrones", "David Benioff, D. B. Weiss", "Emilia Clarke, Kit Harington", 5, "8", "Nobles luchan por el Trono de Hierro en un mundo de fantasía."));
        listaSeries.add(new Series(R.drawable.the_office, "The Office", "The Office", "Greg Daniels", "Steve Carell, Rainn Wilson", 3, "9", "La vida cotidiana de los empleados de una oficina."));
        listaSeries.add(new Series(R.drawable.the_witcher, "The Witcher", "The Witcher", "Lauren Schmidt Hissrich", "Henry Cavill, Anya Chalotra", 4, "3", "Un cazador de monstruos intenta encontrar su lugar en un mundo lleno de magia y violencia."));
        listaSeries.add(new Series(R.drawable.lost, "Lost", "Lost", "J. J. Abrams, Damon Lindelof", "Matthew Fox, Evangeline Lilly", 4, "6", "Supervivientes de un accidente aéreo quedan atrapados en una isla llena de misterios."));
        listaSeries.add(new Series(R.drawable.dark, "Dark", "Dark", "Baran bo Odar, Jantje Friese", "Louis Hofmann, Lisa Vicari", 4, "3", "Una serie que explora los secretos de un pequeño pueblo y los viajes en el tiempo."));
        listaSeries.add(new Series(R.drawable.friends, "Friends", "Friends", "David Crane, Marta Kauffman", "Jennifer Aniston, Courteney Cox", 3, "10", "La vida y aventuras de un grupo de amigos en Nueva York."));

        SeriesAdapter adapter = new SeriesAdapter(listaSeries, serie -> {
            // Navegación al fragmento de detalles
            Bundle bundle = new Bundle();
            bundle.putInt("imagen", serie.getImagen());
            bundle.putString("nombre", serie.getNombre());
            bundle.putString("titulo", serie.getTitulo());
            bundle.putString("director", serie.getDirector());
            bundle.putString("reparto", serie.getReparto());
            bundle.putInt("clasificacion", serie.getClasificacion());
            bundle.putString("temporadas", serie.getTemporadas());
            bundle.putString("sinopsis", serie.getSinopsis());
            Navigation.findNavController(view).navigate(R.id.nav_detalles_serie, bundle);
        });

        rvSeries.setAdapter(adapter);
        return view;
    }
}
