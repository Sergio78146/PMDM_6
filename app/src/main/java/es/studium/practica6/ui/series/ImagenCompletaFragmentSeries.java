package es.studium.practica6.ui.series;

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


public class ImagenCompletaFragmentSeries extends DialogFragment {

    private static final String ARG_IMAGEN = "imagen";

    // Método para crear una nueva instancia del fragmento con la imagen a mostrar
    public static ImagenCompletaFragmentSeries newInstance(int imagen) {
        ImagenCompletaFragmentSeries fragment = new ImagenCompletaFragmentSeries();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGEN, imagen); // Pasamos la imagen al fragmento
        fragment.setArguments(args);
        return fragment;
    }

    // Inflamos el layout del fragmento para mostrar la imagen
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_imagen_completa, container, false);
        ImageView imageView = view.findViewById(R.id.imgCompleta);

        // Si el fragmento tiene argumentos, se configura la imagen
        if (getArguments() != null) {
            int imagen = getArguments().getInt(ARG_IMAGEN);
            imageView.setImageResource(imagen); // Establecemos la imagen en el ImageView
        }

        // Configuramos el listener para cerrar el fragmento al hacer clic en la imagen
        imageView.setOnClickListener(v -> dismiss());

        return view;
    }

    // Configuramos el tamaño de la ventana para que ocupe toda la pantalla
    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null && getDialog().getWindow() != null) {
            Window window = getDialog().getWindow();
            // Ajustamos el tamaño de la ventana para que ocupe toda la pantalla
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            // Establecemos el fondo como transparente
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
    }
}

