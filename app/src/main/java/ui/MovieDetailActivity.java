package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dotvik.coldstarui.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import adapters.CastAdapter;
import models.Cast;

public class MovieDetailActivity extends AppCompatActivity {
    private ImageView MovieThumbnailImg, movieCoverImg;
    private TextView tv_title,tv_descritption;

    private FloatingActionButton play_fab;
    private RecyclerView rv_cast;
    private CastAdapter castAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        //ini views
        iniViews();

        //setUp list cast
        setUpRvCast();


    }

    void iniViews(){
        rv_cast=findViewById(R.id.rv_cast);
        play_fab=findViewById(R.id.play_fab);
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imageCover = getIntent().getExtras().getInt("imgCover");
        MovieThumbnailImg=findViewById(R.id.detailMovie_img);
        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourceId);
        movieCoverImg=findViewById(R.id.deatil_movie_cover);
        Glide.with(this).load(imageCover).into(movieCoverImg);
        tv_title=findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);
        tv_descritption=findViewById(R.id.detail_movie_desc);

        //setUp animation
        movieCoverImg.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));



    }
    void setUpRvCast(){
        List<Cast> mdata = new ArrayList<>();
        mdata.add(new Cast("name",R.drawable.cast1));
        mdata.add(new Cast("name",R.drawable.cast2));
        mdata.add(new Cast("name",R.drawable.cast3));
        mdata.add(new Cast("name",R.drawable.cast5));
        mdata.add(new Cast("name",R.drawable.cast6));
        mdata.add(new Cast("name",R.drawable.cast7));
        mdata.add(new Cast("name",R.drawable.cast8));

        castAdapter = new CastAdapter(this,mdata);
        rv_cast.setAdapter(castAdapter);
        rv_cast.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }

}