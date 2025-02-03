package es.studium.filmingapp.ui.movies;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import es.studium.filmingapp.R;

public class MovieDetailsFragment extends Fragment implements View.OnClickListener
{
    ImageView miniPoster;
//    private int currentImageResource;

    TextView titulo_pelicula;
    TextView director_pelicula;
    RatingBar clasificacion_pelicula;
    TextView reparto_pelicula;
    TextView sinopsis_pelicula;

    public MovieDetailsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_details, container, false);

        // Asocia las vistas correctamente
        miniPoster = view.findViewById(R.id.miniPosterPeli);
        titulo_pelicula = view.findViewById(R.id.titulo_peli);
        director_pelicula = view.findViewById(R.id.nombre_director);
        clasificacion_pelicula = view.findViewById(R.id.puntuacion);
        reparto_pelicula = view.findViewById(R.id.reparto_pelis);
        sinopsis_pelicula = view.findViewById(R.id.sinopsis_pelis);

        // Recibe los datos del Bundle
        Bundle args = getArguments();
        if (args != null)
        {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(args.getString("titulo"));

            miniPoster.setImageResource(args.getInt("miniPoster"));
            titulo_pelicula.setText(args.getString("titulo"));
            director_pelicula.setText(args.getString("director"));
            clasificacion_pelicula.setRating(args.getFloat("puntuacion"));
            reparto_pelicula.setText(args.getString("reparto"));
            sinopsis_pelicula.setText(args.getString("sinopsis"));
        }

        miniPoster.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.miniPosterPeli)
        {
            // Aquí obtenemos el NavController
            NavController navController = Navigation.findNavController(requireView());

            // Crear un Bundle y pasar el título de la película
            Bundle bundle = new Bundle();
            String tituloPeli = titulo_pelicula.getText().toString();
            bundle.putString("title_film", tituloPeli);

            // Realizamos la navegación
            navController.navigate(R.id.action_movieDetailsFragment_to_moviePosterFragment, bundle);

        }
    }
}