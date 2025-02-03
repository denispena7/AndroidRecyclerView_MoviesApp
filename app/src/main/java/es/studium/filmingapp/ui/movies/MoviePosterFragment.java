package es.studium.filmingapp.ui.movies;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import es.studium.filmingapp.R;

public class MoviePosterFragment extends Fragment implements View.OnClickListener
{
    ImageView poster;

    public MoviePosterFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflamos la vista del fragmento
        View view = inflater.inflate(R.layout.fragment_movie_poster, container, false);

        // Ahora encontramos la ImageView dentro de la vista inflada
        poster = view.findViewById(R.id.poster_film);  // Usa el ID correcto del XML

        Bundle args = getArguments();
        if (args != null) {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(args.getString("title_film"));

            String nPeli = args.getString("title_film");
            Log.d("MoviePosterFragment", "Título recibido: " + nPeli);

            switch (nPeli) {
                case "The Batman":
                    poster.setImageResource(R.drawable.the_batman_poster);
                    break;
                case "Superman":
                    poster.setImageResource(R.drawable.superman_poster);
                    break;
                case "Mujer Maravilla":
                    poster.setImageResource(R.drawable.wonder_woman_poster);
                    break;
                case "Joker":
                    poster.setImageResource(R.drawable.joker_poster);
                    break;
                case "Escuadrón Suicida":
                    poster.setImageResource(R.drawable.the_suicide_squad_poster);
                    break;
                case "Aquaman":
                    poster.setImageResource(R.drawable.aquaman_poster);
                    break;
                case "Shazam!":
                    poster.setImageResource(R.drawable.shazam_poster);
                    break;
                default:
                    Log.e("MoviePosterFragment", "No se encontró la película en el switch");
            }
        } else {
            Log.e("MoviePosterFragment", "No se recibieron argumentos");
        }


        // Configuramos el click listener
        poster.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.poster_film)
        {
            // Aquí obtenemos el NavController
            NavController navController = Navigation.findNavController(requireView());

            // Realizamos la navegación
            navController.navigateUp();

        }
    }
}