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

    // Clave para el argumento que almacena la imagen
    private static final String ARG_IMAGEN = "imagen";

    // Método estático para crear una nueva instancia del fragmento con la imagen
    public static ImagenCompletaFragment newInstance(int imagen) {
        ImagenCompletaFragment fragment = new ImagenCompletaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGEN, imagen); // Se almacena la imagen en el bundle
        fragment.setArguments(args); // Se asignan los argumentos al fragmento
        return fragment;
    }

    // Método que crea la vista del fragmento de imagen completa
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflamos el layout fragment_imagen_completa.xml
        View view = inflater.inflate(R.layout.fragment_imagen_completa, container, false);
        ImageView imageView = view.findViewById(R.id.imgCompleta); // Referencia al ImageView

        // Si hay argumentos, obtenemos la imagen y la mostramos
        if (getArguments() != null) {
            int imagen = getArguments().getInt(ARG_IMAGEN);
            imageView.setImageResource(imagen);
        }

        // Cierra el diálogo al hacer clic en la imagen
        imageView.setOnClickListener(v -> dismiss());

        return view;
    }

    // Configuración del fragmento para ocupar toda la pantalla
    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null && getDialog().getWindow() != null) {
            Window window = getDialog().getWindow();
            // Establece el fragmento en pantalla completa sin márgenes
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            window.setBackgroundDrawableResource(android.R.color.transparent); // Fondo transparente
        }
    }
}
