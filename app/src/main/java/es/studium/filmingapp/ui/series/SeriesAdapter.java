package es.studium.filmingapp.ui.series;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.studium.filmingapp.R;
import es.studium.filmingapp.ui.movies.MovieAdapter;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder>
{
    private List<Series> items;
    private OnItemClickListener listener;

    public interface OnItemClickListener
    {
        void onItemClick(Series serie);
    }

    public static class SeriesViewHolder extends RecyclerView.ViewHolder
    {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;

        public SeriesViewHolder(View v)
        {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.poster_serie);
            nombre = (TextView) v.findViewById(R.id.nombre_serie);
        }

        public void bind(final Series serie, final OnItemClickListener listener)
        {
            imagen.setImageResource(serie.getImagen());
            nombre.setText(serie.getNombre());

            itemView.setOnClickListener(v -> {
                if(listener != null)
                {
                    listener.onItemClick(serie);
                }
            });
        }
    }
    public SeriesAdapter(List<Series> items, SeriesAdapter.OnItemClickListener listener)
    {
        this.items = items;
        this.listener = listener;
    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }

    @Override
    public SeriesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.series_card, viewGroup, false);
        return new SeriesViewHolder(v);
    }
    @Override
    public void onBindViewHolder(SeriesViewHolder viewHolder, int i)
    {
        viewHolder.bind(items.get(i), listener);
    }
}
