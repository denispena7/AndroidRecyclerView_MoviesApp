package es.studium.filmingapp.ui.series;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.studium.filmingapp.R;
import es.studium.filmingapp.databinding.FragmentSeriesBinding;
import es.studium.filmingapp.ui.movies.MovieAdapter;

public class SeriesFragment extends Fragment
{
    private FragmentSeriesBinding binding;

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState)
    {
        // Inicializar peliculas
        List items = new ArrayList();

        items.add(new Series(R.drawable.card_penguin, "El Pingüino"));
        items.add(new Series(R.drawable.card_peacemaker, "El Pacificador"));
        items.add(new Series(R.drawable.the_boys_card, "The Boys"));
        items.add(new Series(R.drawable.invincible_card, "Invencible"));
        items.add(new Series(R.drawable.my_adventures_with_superman_card, "Mis Aventuras Con Superman"));
        items.add(new Series(R.drawable.card_creature_commandos, "Creature Commandos"));
        items.add(new Series(R.drawable.card_genv, "Gen V"));

        binding = FragmentSeriesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Obtener el recycler
        recycler = binding.myRecyclerViewSeries;
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        adapter = new SeriesAdapter(items, serie -> {
            Bundle bundle = new Bundle();

            switch (items.indexOf(serie))
            {
                case 0:
                    bundle.putInt("miniPosterSerie", R.drawable.card_penguin);
                    bundle.putString("tituloSerie", getString(R.string.penguin));
                    bundle.putString("directorSerie", getString(R.string.director_penguin));
                    bundle.putFloat("puntuacionSerie", 4.5f);
                    bundle.putInt("temporadasSerie", 1);
                    bundle.putInt("numEpisodiosSerie", 8);
                    bundle.putString("repartoSerie", getString(R.string.reparto_penguin));
                    bundle.putString("sinopsisSerie", getString(R.string.sinopsis_penguin));
                    break;
                case 1:
                    bundle.putInt("miniPosterSerie", R.drawable.card_peacemaker);
                    bundle.putString("tituloSerie", getString(R.string.peacemaker));
                    bundle.putString("directorSerie", getString(R.string.director_superman));
                    bundle.putFloat("puntuacionSerie", 5);
                    bundle.putInt("temporadasSerie", 1);
                    bundle.putInt("numEpisodiosSerie", 8);
                    bundle.putString("repartoSerie", getString(R.string.reparto_peacemaker));
                    bundle.putString("sinopsisSerie", getString(R.string.sinopsis_peacemaker));
                    break;
                case 2:
                    bundle.putInt("miniPosterSerie", R.drawable.the_boys_card);
                    bundle.putString("tituloSerie", getString(R.string.theboys));
                    bundle.putString("directorSerie", getString(R.string.director_theboys));
                    bundle.putFloat("puntuacionSerie", 4.5f);
                    bundle.putInt("temporadasSerie", 4);
                    bundle.putInt("numEpisodiosSerie", 32);
                    bundle.putString("repartoSerie", getString(R.string.reparto_theboys));
                    bundle.putString("sinopsisSerie", getString(R.string.sinopsis_theboys));
                    break;
                case 3:
                    bundle.putInt("miniPosterSerie", R.drawable.invincible_card);
                    bundle.putString("tituloSerie", getString(R.string.invincible));
                    bundle.putString("directorSerie", getString(R.string.director_invincible));
                    bundle.putFloat("puntuacionSerie", 3.5f);
                    bundle.putInt("temporadasSerie", 3);
                    bundle.putInt("numEpisodiosSerie", 24);
                    bundle.putString("repartoSerie", getString(R.string.reparto_invincible));
                    bundle.putString("sinopsisSerie", getString(R.string.sinopsis_invincible));
                    break;
                case 4:
                    bundle.putInt("miniPosterSerie", R.drawable.my_adventures_with_superman_card);
                    bundle.putString("tituloSerie", getString(R.string.superman_animado));
                    bundle.putString("directorSerie", getString(R.string.director_superman_animado));
                    bundle.putFloat("puntuacionSerie", 3);
                    bundle.putInt("temporadasSerie", 2);
                    bundle.putInt("numEpisodiosSerie", 20);
                    bundle.putString("repartoSerie", getString(R.string.reparto_superman_animado));
                    bundle.putString("sinopsisSerie", getString(R.string.sinopsis_superman_animado));
                    break;
                case 5:
                    bundle.putInt("miniPosterSerie", R.drawable.card_creature_commandos);
                    bundle.putString("tituloSerie", getString(R.string.creature_commandos));
                    bundle.putString("directorSerie", getString(R.string.director_creature_commandos));
                    bundle.putFloat("puntuacionSerie", 3.5f);
                    bundle.putInt("temporadasSerie", 1);
                    bundle.putInt("numEpisodiosSerie", 8);
                    bundle.putString("repartoSerie", getString(R.string.reparto_creature_commandos));
                    bundle.putString("sinopsisSerie", getString(R.string.sinopsis_creature_commandos));
                    break;
                case 6:
                    bundle.putInt("miniPosterSerie", R.drawable.card_genv);
                    bundle.putString("tituloSerie", getString(R.string.genv));
                    bundle.putString("directorSerie", getString(R.string.director_genv));
                    bundle.putFloat("puntuacionSerie", 5);
                    bundle.putInt("temporadasSerie", 1);
                    bundle.putInt("numEpisodiosSerie", 8);
                    bundle.putString("repartoSerie", getString(R.string.reparto_genv));
                    bundle.putString("sinopsisSerie", getString(R.string.sinopsis_genv));
                    break;
                default:
            }

            // Aquí obtenemos el NavController
            NavController navController = Navigation.findNavController(requireView());

            // Realizamos la navegación
            navController.navigate(R.id.action_seriesFragment_to_seriesDetailsFragment, bundle);
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