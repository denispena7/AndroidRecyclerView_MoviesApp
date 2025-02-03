package es.studium.filmingapp.ui.series;

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

public class SeriesPosterFragment extends Fragment implements View.OnClickListener
{
    ImageView poster_serie;

    public SeriesPosterFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflamos la vista del fragmento
        View view = inflater.inflate(R.layout.fragment_series_poster, container, false);

        // Ahora encontramos la ImageView dentro de la vista inflada
        poster_serie = view.findViewById(R.id.poster_film_serie);  // Usa el ID correcto del XML

        Bundle args = getArguments();
        if (args != null) {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(args.getString("title_serie"));

            String nSerie = args.getString("title_serie");
            Log.d("SeriesPosterFragment", "Título recibido: " + nSerie);

            switch (nSerie) {
                case "El Pingüino":
                    poster_serie.setImageResource(R.drawable.card_penguin);
                    break;
                case "El Pacificador":
                    poster_serie.setImageResource(R.drawable.card_peacemaker);
                    break;
                case "The Boys":
                    poster_serie.setImageResource(R.drawable.the_boys_card);
                    break;
                case "Invencible":
                    poster_serie.setImageResource(R.drawable.card_invincible);
                    break;
                case "Mis aventuras con Superman":
                    poster_serie.setImageResource(R.drawable.my_adventures_with_superman_card);
                    break;
                case "Creature Commandos":
                    poster_serie.setImageResource(R.drawable.card_creature_commandos);
                    break;
                case "Gen V":
                    poster_serie.setImageResource(R.drawable.genv_poster);
                    break;
                default:
                    Log.e("SeriesPosterFragment", "No se encontró la película en el switch");
            }
        } else {
            Log.e("SeriesPosterFragment", "No se recibieron argumentos");
        }

        // Configuramos el click listener
        poster_serie.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.poster_film_serie)
        {
            //   Toast.makeText(this.getContext(), "Pulsado", Toast.LENGTH_SHORT).show();
            // Aquí obtenemos el NavController
            NavController navController = Navigation.findNavController(requireView());

            // Realizamos la navegación
            navController.navigateUp();

        }
    }
}