package es.studium.practica6.ui.peliculas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import es.studium.practica6.R;

public class ImagenCompletaFragment extends DialogFragment {

    private static final String ARG_IMAGEN = "imagen";

    public static es.studium.practica6.ui.peliculas.ImagenCompletaFragmentSeries newInstance(int imagen) {
        es.studium.practica6.ui.peliculas.ImagenCompletaFragmentSeries fragment = new es.studium.practica6.ui.peliculas.ImagenCompletaFragmentSeries();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGEN, imagen);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_imagen_completa, container, false);
        ImageView imageView = view.findViewById(R.id.imgCompleta);

        if (getArguments() != null) {
            int imagen = getArguments().getInt(ARG_IMAGEN);
            imageView.setImageResource(imagen);
        }

        // Cerrar el fragmento al pulsar en la imagen
        imageView.setOnClickListener(v -> dismiss());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null && getDialog().getWindow() != null) {
            Window window = getDialog().getWindow();
            // Elimina márgenes y establece el tamaño en pantalla completa
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
    }
}
