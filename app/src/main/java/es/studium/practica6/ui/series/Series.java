package es.studium.practica6.ui.series;

public class Series {

    private final int imagen;
    private final String nombre;
    private final String titulo;
    private final String director;
    private final String reparto;
    private final int clasificacion;
    private final String temporadas;
    private final String sinopsis;

    public Series(int imagen, String nombre, String titulo, String director, String reparto, int clasificacion, String temporadas, String sinopsis) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.titulo = titulo;
        this.director = director;
        this.reparto = reparto;
        this.sinopsis = sinopsis;
        this.temporadas = temporadas; // Asegurarse de que haya al menos una temporada
        this.clasificacion = clasificacion; // Limitar clasificación entre 1 y 5
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

    public String getTemporadas() {
        return temporadas;
    }

    public String getSinopsis() {
        return sinopsis;
    }
}
