package es.studium.filmingapp.ui.movies;

public class Movie
{
    private final int imagen;
    private final String nombre;

    public Movie(int imagen, String nombre)
    {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public int getImagen()
    {
        return imagen;
    }

    public String getNombre()
    {
        return nombre;
    }
}
