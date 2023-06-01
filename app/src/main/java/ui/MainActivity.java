package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import adapters.AnimeAdapter;
import adapters.MovieItemClickListener;
import models.Anime;
import models.Movies;
import adapters.MoviesAdapter;
import com.dotvik.coldstarui.R;
import models.Slide;
import adapters.SliderPagerAdapter;
import utils.DataSource;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstSlides;
    private ViewPager sliderPager;
    private TabLayout indicator;
    private RecyclerView moviesRV, moviesRvWeek , rv_anime;
    private AnimeAdapter animeAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniViews();
        iniSlider();
        iniPopularMovies();
        iniWeekMovies();
        //anime cast
        setupRvAnime();
    }

    private void setupRvAnime() {

        List<Anime>mData=new ArrayList<>();
        mData.add(new Anime("name",R.drawable.anime1));
        mData.add(new Anime("name",R.drawable.anime2));
        mData.add(new Anime("name",R.drawable.anime3));
        mData.add(new Anime("name",R.drawable.anime4));
        mData.add(new Anime("name",R.drawable.anime5));
        mData.add(new Anime("name",R.drawable.anime6));
        mData.add(new Anime("name",R.drawable.anime7));

        animeAdapter = new AnimeAdapter(this,mData);
        rv_anime.setAdapter(animeAdapter);
        rv_anime.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }

    private void iniWeekMovies() {

       MoviesAdapter weekMoviesAdapter = new MoviesAdapter(this,DataSource.getWeekMovies(),this);
       moviesRvWeek.setAdapter(weekMoviesAdapter);
       moviesRvWeek.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }

    private void iniPopularMovies() {
        //recyclerview setup
        //ini data



        MoviesAdapter moviesAdapter = new MoviesAdapter(this, DataSource.getPopularMovies(),this);
        moviesRV.setAdapter(moviesAdapter);
        moviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void iniSlider() {
        //prepare a list of slides
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.movie,"MI:6"));
        lstSlides.add(new Slide(R.drawable.movie2,"HIMYM"));
        lstSlides.add(new Slide(R.drawable.movie3,"Friends"));
        lstSlides.add(new Slide(R.drawable.movie4,"Little Krishna"));
        lstSlides.add(new Slide(R.drawable.movie5,"Your Name"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);
        sliderPager.setAdapter(adapter);
        //setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),4000,6000);
        indicator.setupWithViewPager(sliderPager,true);
    }

    private void iniViews() {
        rv_anime=findViewById(R.id.rv_anime);
        sliderPager=findViewById(R.id.slider_pager);
        indicator=findViewById(R.id.indicator);
        moviesRV=findViewById(R.id.RVMovies);
        moviesRvWeek=findViewById(R.id.rv_movies_week);
    }

    @Override
    public void onMovieClick(Movies movies, ImageView movieImageView) {
        //here we send movie info to detail Activity
        //we will also create animation between the two activities

        Intent intent = new Intent(this,MovieDetailActivity.class);
        //send movie info to detail activity
        intent.putExtra("title",movies.getTitle());
        intent.putExtra("imgURL",movies.getThumbnail());
        intent.putExtra("imgCover",movies.getCoverPhoto());

        //let's animate
        ActivityOptions options = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,movieImageView
            ,"sharedName");
        }

        startActivity(intent,options.toBundle());

        //check if click works
        Toast.makeText(this, "item clicked : "+ movies.getTitle(), Toast.LENGTH_SHORT).show();
    }


    class SliderTimer extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(sliderPager.getCurrentItem()<lstSlides.size()-1){
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem()+1);
                    }
                    else{
                        sliderPager.setCurrentItem(0);
                    }
                }
            });
        }
    }


}