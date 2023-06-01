package adapters;

import android.widget.ImageView;

import models.Movies;

public interface MovieItemClickListener {
    void onMovieClick(Movies movies , ImageView movieImageView);//we will need imageview to make the shared animation between two actvity
}
