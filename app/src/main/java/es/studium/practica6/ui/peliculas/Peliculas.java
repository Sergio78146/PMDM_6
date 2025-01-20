package es.studium.practica6.ui.peliculas;

public class Peliculas {

    private final int imagen;
    private final String nombre;
    private final String titulo;
    private final String director;
    private final String reparto;
    private final int clasificacion; // 1 a 5 estrellas
    private final String sinopsis;

    public Peliculas(int imagen, String nombre, String titulo, String director, String reparto, int clasificacion, String sinopsis) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.titulo = titulo;
        this.director = director;
        this.reparto = reparto;
        // Validación de clasificación entre 1 y 5
        if (clasificacion < 1) {
            this.clasificacion = 1; // Asignar 1 si el valor es menor a 1
        } else if (clasificacion > 5) {
            this.clasificacion = 5; // Asignar 5 si el valor es mayor a 5
        } else {
            this.clasificacion = clasificacion; // Asignar el valor si está entre 1 y 5
        }
        this.sinopsis = sinopsis;
    }

    public int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public String getReparto() {
        return reparto;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public String getSinopsis() {
        return sinopsis;
    }
}
