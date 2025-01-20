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
import es.studium.practica6.ui.peliculas.ImagenCompletaFragmentSeries;

public class DetallesSeriesFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalles_serie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imgDetalle = view.findViewById(R.id.imgDetalle);
        TextView txtNombreDetalle = view.findViewById(R.id.txtNombreDetalle);
        TextView txtTituloDetalle = view.findViewById(R.id.txtTituloDetalle);
        TextView txtDirectorDetalle = view.findViewById(R.id.txtDirectorDetalle);
        TextView txtRepartoDetalle = view.findViewById(R.id.txtRepartoDetalle);
        TextView txtTemporadasDetalle = view.findViewById(R.id.txtTemporadasDetalle);
        TextView txtClasificacionDetalle = view.findViewById(R.id.txtClasificacionDetalle);
        TextView txtSinopsisDetalle = view.findViewById(R.id.txtSinopsisDetalle);

        if (getArguments() != null) {
            int imagen = getArguments().getInt("imagen");
            String nombre = getArguments().getString("nombre");
            String titulo = getArguments().getString("titulo");
            String director = getArguments().getString("director");
            String reparto = getArguments().getString("reparto");
            String temporadas = getArguments().getString("temporadas");
            int clasificacion = getArguments().getInt("clasificacion");
            String sinopsis = getArguments().getString("sinopsis");

            imgDetalle.setImageResource(imagen);
            txtNombreDetalle.setText(nombre);
            txtTituloDetalle.setText(titulo);
            txtDirectorDetalle.setText(director);
            txtRepartoDetalle.setText(reparto);
            txtTemporadasDetalle.setText(temporadas);
            txtClasificacionDetalle.setText(clasificacion + "/5 estrellas");
            txtSinopsisDetalle.setText(sinopsis);

            // Escucha para mostrar la imagen en pantalla completa
            imgDetalle.setOnClickListener(v -> {
                ImagenCompletaFragmentSeries fragment = ImagenCompletaFragmentSeries.newInstance(imagen);
                fragment.show(requireActivity().getSupportFragmentManager(), "imagenCompleta");
            });
        }
    }
}
