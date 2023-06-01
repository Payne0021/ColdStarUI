package utils;

import com.dotvik.coldstarui.R;

import java.util.ArrayList;
import java.util.List;

import models.Movies;

public class DataSource {

    public static List<Movies> getPopularMovies(){
        List<Movies> lstMovies = new ArrayList<>();
        lstMovies.add(new Movies("Death Note", R.drawable.death_note,R.drawable.deathote));
        lstMovies.add(new Movies("Garden of Words",R.drawable.garden_of_words,R.drawable.garden));
        lstMovies.add(new Movies("Rango",R.drawable.rango,R.drawable.rambobg));
        lstMovies.add(new Movies("Rio",R.drawable.rio,R.drawable.riobg));
        lstMovies.add(new Movies("The Social Network",R.drawable.socialnetworkbg,R.drawable.the_social_network));
        lstMovies.add(new Movies("MI:3",R.drawable.mi3,R.drawable.mibg));
        lstMovies.add(new Movies("Hangover",R.drawable.hangover,R.drawable.hangoverbg));
        return lstMovies;
    }

    public static List<Movies> getWeekMovies(){
        List<Movies> lstMovies = new ArrayList<>();
        lstMovies.add(new Movies("Death Note", R.drawable.death_note,R.drawable.deathote));
        lstMovies.add(new Movies("Garden of Words",R.drawable.garden_of_words,R.drawable.garden));
        lstMovies.add(new Movies("Rango",R.drawable.rango,R.drawable.rambobg));
        lstMovies.add(new Movies("Rio",R.drawable.rio,R.drawable.riobg));
        lstMovies.add(new Movies("The Social Network",R.drawable.socialnetworkbg,R.drawable.the_social_network));
        lstMovies.add(new Movies("MI:3",R.drawable.mi3,R.drawable.mibg));
        lstMovies.add(new Movies("Hangover",R.drawable.hangover,R.drawable.hangoverbg));
        return lstMovies;
    }
}
