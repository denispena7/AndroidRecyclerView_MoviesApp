package es.studium.filmingapp.ui.movies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.studium.filmingapp.R;
import es.studium.filmingapp.databinding.FragmentMoviesBinding;

public class MovieFragment extends Fragment
{
    private FragmentMoviesBinding binding;

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

   // MovieDetailsFragment detallesPeliculas = new MovieDetailsFragment();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        // Inicializar peliculas
        List items = new ArrayList();

        items.add(new Movie(R.drawable.card_batman, "The Batman"));
        items.add(new Movie(R.drawable.card_superman, "Superman"));
        items.add(new Movie(R.drawable.card_wonder_woman, "Mujer Maravilla"));
        items.add(new Movie(R.drawable.joker_card, "Joker"));
        items.add(new Movie(R.drawable.card_suicide_squad, "Escuadrón Suicida"));
        items.add(new Movie(R.drawable.card_aquaman, "Aquaman"));
        items.add(new Movie(R.drawable.card_shazam, "Shazam!"));

        binding = FragmentMoviesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Obtener el recycler
        recycler = binding.myRecyclerViewPelis;
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        // Ajustar la caché para optimizar la memoria
        recycler.setItemViewCacheSize(5);
        recycler.setNestedScrollingEnabled(true); // Asegura que el scroll funcione bien

        adapter = new MovieAdapter(items, movie -> {
            Bundle bundle = new Bundle();

            switch (items.indexOf(movie))
            {
                case 0:
                    bundle.putInt("miniPoster", R.drawable.card_batman);
                    bundle.putString("titulo", getString(R.string.batman));
                    bundle.putString("director", getString(R.string.director_batman));
                    bundle.putFloat("puntuacion", 5);
                    bundle.putString("reparto", getString(R.string.reparto_batman));
                    bundle.putString("sinopsis", getString(R.string.sinopsis_batman));
                    break;
                case 1:
                    bundle.putInt("miniPoster", R.drawable.card_superman);
                    bundle.putString("titulo", getString(R.string.superman));
                    bundle.putString("director", getString(R.string.director_superman));
                    bundle.putFloat("puntuacion", 0);
                    bundle.putString("reparto", getString(R.string.reparto_superman));
                    bundle.putString("sinopsis", getString(R.string.sinopsis_superman));
                    break;
                case 2:
                    bundle.putInt("miniPoster", R.drawable.card_wonder_woman);
                    bundle.putString("titulo", getString(R.string.wonderwoman));
                    bundle.putString("director", getString(R.string.director_wonderwoman));
                    bundle.putFloat("puntuacion", 3.5f);
                    bundle.putString("reparto", getString(R.string.reparto_wonderwoman));
                    bundle.putString("sinopsis", getString(R.string.sinopsis_wonderwoman));
                    break;
                case 3:
                    bundle.putInt("miniPoster", R.drawable.joker_card);
                    bundle.putString("titulo", getString(R.string.joker));
                    bundle.putString("director", getString(R.string.director_joker));
                    bundle.putFloat("puntuacion", 5);
                    bundle.putString("reparto", getString(R.string.reparto_joker));
                    bundle.putString("sinopsis", getString(R.string.sinopsis_joker));
                    break;
                case 4:
                    bundle.putInt("miniPoster", R.drawable.card_suicide_squad);
                    bundle.putString("titulo", getString(R.string.suicidesquad));
                    bundle.putString("director", getString(R.string.director_suicidesquad));
                    bundle.putFloat("puntuacion", 4);
                    bundle.putString("reparto", getString(R.string.reparto_suicidesquad));
                    bundle.putString("sinopsis", getString(R.string.sinopsis_suicidesquad));
                    break;
                case 5:
                    bundle.putInt("miniPoster", R.drawable.card_aquaman);
                    bundle.putString("titulo", getString(R.string.aquaman));
                    bundle.putString("director", getString(R.string.director_aquaman));
                    bundle.putFloat("puntuacion", 3);
                    bundle.putString("reparto", getString(R.string.reparto_aquaman));
                    bundle.putString("sinopsis", getString(R.string.sinopsis_aquaman));
                    break;
                case 6:
                    bundle.putInt("miniPoster", R.drawable.card_shazam);
                    bundle.putString("titulo", getString(R.string.shazam));
                    bundle.putString("director", getString(R.string.director_shazam));
                    bundle.putFloat("puntuacion", 3.5f);
                    bundle.putString("reparto", getString(R.string.reparto_shazam));
                    bundle.putString("sinopsis", getString(R.string.sinopsis_shazam));
                    break;
                default:
            }

            NavController navController = Navigation.findNavController(requireView());
            navController.navigate(R.id.action_movieFragment_to_movieDetailsFragment, bundle);
        });

        recycler.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}