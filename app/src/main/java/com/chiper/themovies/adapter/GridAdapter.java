package com.chiper.themovies.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chiper.themovies.R;
import com.chiper.themovies.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> values;
    private ImageView imgMovieLogo;
    private View view;
    private LayoutInflater layoutInflater;
    private TextView nameMovie;

    public GridAdapter(Context context, ArrayList<Movie> values) {
        this.context = context;
        this.values = values;
    }
    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Movie getItem(int position) {
        return values.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            view = new View(context);
            view = layoutInflater.inflate(R.layout.fragment_select_movie_child_item, null);
            imgMovieLogo = view.findViewById(R.id.img_movie_logo);
            nameMovie = view.findViewById(R.id.movie_name);
            Picasso.get().load(context.getResources().getString(R.string.base_url_image) + getItem(position).getPoster_path()).into(imgMovieLogo);
            nameMovie.setText(getItem(position).getOriginal_title());
        }
        return view;
    }
}
