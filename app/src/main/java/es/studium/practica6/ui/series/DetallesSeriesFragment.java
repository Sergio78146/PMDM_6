package es.studium.practica6.ui.series;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import es.studium.practica6.R;

public class DetallesSeriesFragment extends Fragment {

    // Este método infla el layout del fragmento cuando se crea.
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalles_serie, container, false);
    }

    // Este método se ejecuta después de que la vista se haya creado, aquí configuramos los elementos UI con los datos de la serie.
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Referencias a los elementos de la UI
        ImageView imgDetalle = view.findViewById(R.id.imgDetalle);
        TextView txtNombreDetalle = view.findViewById(R.id.txtNombreDetalle);
        TextView txtTituloDetalle = view.findViewById(R.id.txtTituloDetalle);
        TextView txtDirectorDetalle = view.findViewById(R.id.txtDirectorDetalle);
        TextView txtRepartoDetalle = view.findViewById(R.id.txtRepartoDetalle);
        TextView txtTemporadasDetalle = view.findViewById(R.id.txtTemporadasDetalle);
        TextView txtClasificacionDetalle = view.findViewById(R.id.txtClasificacionDetalle);
        TextView txtSinopsisDetalle = view.findViewById(R.id.txtSinopsisDetalle);

        // Si los argumentos no son nulos, se extraen los datos de la serie que se pasaron al fragmento
        if (getArguments() != null) {
            // Recuperamos los datos desde el Bundle que se pasó al fragmento
            int imagen = getArguments().getInt("imagen");
            String nombre = getArguments().getString("nombre");
            String titulo = getArguments().getString("titulo");
            String director = getArguments().getString("director");
            String reparto = getArguments().getString("reparto");
            String temporadas = getArguments().getString("temporadas");
            int clasificacion = getArguments().getInt("clasificacion");
            String sinopsis = getArguments().getString("sinopsis");

            // Configuramos la UI con los datos extraídos
            imgDetalle.setImageResource(imagen);
            txtNombreDetalle.setText(nombre);
            txtTituloDetalle.setText(titulo);
            txtDirectorDetalle.setText(director);
            txtRepartoDetalle.setText(reparto);
            txtTemporadasDetalle.setText(temporadas);
            txtClasificacionDetalle.setText(clasificacion + "/5 estrellas");
            txtSinopsisDetalle.setText(sinopsis);

            // Configuramos el listener para que cuando se haga clic en la imagen, se abra en pantalla completa
            imgDetalle.setOnClickListener(v -> {
                // Crear una nueva instancia de ImagenCompletaFragmentSeries pasando la imagen
                ImagenCompletaFragmentSeries fragment = ImagenCompletaFragmentSeries.newInstance(imagen);
                // Mostrar el fragmento con la imagen en pantalla completa
                fragment.show(requireActivity().getSupportFragmentManager(), "imagenCompleta");
            });
        }
    }
}

