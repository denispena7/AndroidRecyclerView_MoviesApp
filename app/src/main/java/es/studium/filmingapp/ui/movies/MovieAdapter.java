package es.studium.filmingapp.ui.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.studium.filmingapp.R;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>
{
    private List<Movie> items;
    private OnItemClickListener listener;

    public interface OnItemClickListener
    {
        void onItemClick(Movie pelicula);
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder
    {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;

        public MovieViewHolder(View v)
        {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.poster_mini);
            nombre = (TextView) v.findViewById(R.id.nombre_peli);
        }

        public void bind(final Movie movie, final OnItemClickListener listener)
        {
            imagen.setImageResource(movie.getImagen());
            nombre.setText(movie.getNombre());

            itemView.setOnClickListener(v -> {
                if(listener != null)
                {
                    listener.onItemClick(movie);
                }
            });
        }
    }

    public MovieAdapter(List<Movie> items, OnItemClickListener listener)
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
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_card, viewGroup, false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int i)
    {
        holder.bind(items.get(i), listener);
    }
}
