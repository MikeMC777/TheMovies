package com.chiper.themovies;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.chiper.themovies.model.Movie;
import com.squareup.picasso.Picasso;

public class DescriptionActivity extends AppCompatActivity {

    private TextView tvTitle, tvDate, tvLang, tvAverage, tvOverview, tvAdults;
    private ImageView imgPoster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        getDescriptionUI();
    }

    private void getDescriptionUI() {
        tvTitle = findViewById(R.id.description_title);
        tvAdults = findViewById(R.id.description_adults);
        tvAverage = findViewById(R.id.description_average);
        tvDate = findViewById(R.id.description_date);
        tvLang = findViewById(R.id.description_lang);
        tvOverview = findViewById(R.id.description_overview);
        imgPoster = findViewById(R.id.description_image);

        Movie selectedMovie = (Movie) getIntent().getSerializableExtra("movie");

        Log.d("lang38", selectedMovie.getOriginal_language());
        Log.d("average39", String.valueOf(selectedMovie.getVote_average()));
        Log.d("overview40", String.valueOf(selectedMovie.getOverview()));
        Picasso.get().load(getResources().getString(R.string.base_url_image) + selectedMovie.getPoster_path()).into(imgPoster);

        tvTitle.setText(selectedMovie.getOriginal_title());
        if (selectedMovie.isAdult()) {
            tvAdults.setText("Sí");
        } else {
            tvAdults.setText("No");
        }
        tvLang.setText(selectedMovie.getOriginal_language());
        tvDate.setText(selectedMovie.getRelease_date());
        tvAverage.setText(String.valueOf(selectedMovie.getVote_average()));
        tvOverview.setText(selectedMovie.getOverview());

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MoviesListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
