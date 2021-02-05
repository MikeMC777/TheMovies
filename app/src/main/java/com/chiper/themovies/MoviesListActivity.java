package com.chiper.themovies;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import com.chiper.themovies.Interface.TheMovieDBApi;
import com.chiper.themovies.adapter.SelectMovieAdapter;
import com.chiper.themovies.model.Movie;
import com.chiper.themovies.model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesListActivity extends AppCompatActivity {

    private ExpandableListView categoriesGroup;
    private SelectMovieAdapter adapter;
    private ArrayList<String> categoriesList;
    private ProgressDialog progress;
    private Map<String, ArrayList<Movie>> mapChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);
        categoriesList = new ArrayList<>();
        mapChild = new HashMap<>();
        categoriesGroup = findViewById(R.id.elv_select_movie);
        getMovies();
    }

    private void getMovies(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TheMovieDBApi theMovieDBApi = retrofit.create(TheMovieDBApi.class);

        progress = new ProgressDialog(this);
        progress.setMessage("Loading ...");
        progress.show();
        callHttp(1, theMovieDBApi);
    }

    private void callHttp(int i, TheMovieDBApi theMovieDBApi){
        Call<Post> call = theMovieDBApi.getMovies("Bearer " + getResources().getString(R.string.tmbd_access_token),
                i, 1, getResources().getString(R.string.tmbd_api_key), "es");

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()) {
                    return;
                }

                if (i < 10) {
                    getMoviesMap(response.body().getName(), response.body().getResults());
                    callHttp(i + 1, theMovieDBApi);
                } else if (i == 10) {
                    getMoviesMap(response.body().getName(), response.body().getResults());
                    adapter = new SelectMovieAdapter(categoriesList, mapChild,MoviesListActivity.this);
                    categoriesGroup.setAdapter(adapter);
                    categoriesList = new ArrayList<>();
                    progress.hide();
                    progress.dismiss();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
            }
        });
    }

    private void getMoviesMap(String name, ArrayList<Movie> movies) {
        if(movies.size() > 0) {
            categoriesList.add(name);
            mapChild.put(name, movies);
        }
    }
}
