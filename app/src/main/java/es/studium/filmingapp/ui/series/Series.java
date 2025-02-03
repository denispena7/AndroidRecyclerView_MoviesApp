package es.studium.filmingapp.ui.series;

public class Series
{
    private final int imagen;
    private final String nombre;

    public Series(int imagen, String nombre)
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
