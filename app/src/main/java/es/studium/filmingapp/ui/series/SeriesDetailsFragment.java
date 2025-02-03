package es.studium.filmingapp.ui.series;

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

public class SeriesDetailsFragment extends Fragment implements View.OnClickListener
{
    ImageView miniPosterSerie;

    TextView tituloSerie;
    TextView directorSerie;
    RatingBar clasificacionSerie;
    TextView temporadasSerie;
    TextView repartoSerie;
    TextView sinopsisSerie;

    public SeriesDetailsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflamos la vista del fragmento
        View view = inflater.inflate(R.layout.fragment_series_details, container, false);

        // Ahora encontramos la ImageView dentro de la vista inflada
        miniPosterSerie = view.findViewById(R.id.miniPosterSerie);
        tituloSerie = view.findViewById(R.id.titulo_serie);
        directorSerie = view.findViewById(R.id.nombre_director_serie);
        clasificacionSerie = view.findViewById(R.id.puntuacion_serie);
        temporadasSerie = view.findViewById(R.id.lbl_temporadas);
        repartoSerie = view.findViewById(R.id.reparto_serie);
        sinopsisSerie = view.findViewById(R.id.sinopsis_serie);

        // Recibe los datos del Bundle
        Bundle args = getArguments();
        if (args != null)
        {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(args.getString("tituloSerie"));

            miniPosterSerie.setImageResource(args.getInt("miniPosterSerie"));
            tituloSerie.setText(args.getString("tituloSerie"));
            directorSerie.setText(args.getString("directorSerie"));
            clasificacionSerie.setRating(args.getFloat("puntuacionSerie"));
            temporadasSerie.setText(getString(R.string.lblTemporadas, args.getInt("temporadasSerie"), args.getInt("numEpisodiosSerie")));
            repartoSerie.setText(args.getString("repartoSerie"));
            sinopsisSerie.setText(args.getString("sinopsisSerie"));
        }

        // Configuramos el click listener
        miniPosterSerie.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.miniPosterSerie)
        {
            // Aquí obtenemos el NavController
            NavController navController = Navigation.findNavController(requireView());

            // Crear un Bundle y pasar el título de la película
            Bundle bundle = new Bundle();
            String tituloS = tituloSerie.getText().toString();
            bundle.putString("title_serie", tituloS);

            // Realizamos la navegación
            navController.navigate(R.id.action_seriesDetailsFragment_to_seriesPosterFragment, bundle);

        }
    }
}