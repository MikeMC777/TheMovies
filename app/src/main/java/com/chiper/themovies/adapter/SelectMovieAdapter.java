package com.chiper.themovies.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.chiper.themovies.DescriptionActivity;
import com.chiper.themovies.R;
import com.chiper.themovies.model.Movie;

import java.util.ArrayList;
import java.util.Map;

public class SelectMovieAdapter extends BaseExpandableListAdapter {

    private ArrayList<String> categoriesList;
    private Map<String, ArrayList<Movie>> mapChild;
    private Context context;
    private GridView gridMoviesByCategory;
    private TableRow selectedItem;
    private int selectedGroupPos, selectedPos;


    public SelectMovieAdapter(ArrayList<String> provincesList, Map<String, ArrayList<Movie>> mapChild, Context context) {
        this.categoriesList = provincesList;
        this.mapChild = mapChild;
        this.context = context;
    }
    @Override
    public int getGroupCount() {
        return categoriesList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return categoriesList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mapChild.get(categoriesList.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (null == convertView) {
            String title = (String) getGroup(groupPosition);
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_select_movie_group, null);

            holder = new ViewHolder();

            holder.category = convertView.findViewById(R.id.tv_name_select_category);
            holder.category.setText(title);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    private static class ViewHolder {
        private TextView category;
    }

    @Override
    public View getChildView(final int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_select_movie_child, null);
        }
        gridMoviesByCategory = convertView.findViewById(R.id.grid_select_category);
        GridAdapter adapter = new GridAdapter(context, mapChild.get(categoriesList.get(groupPosition)));
        gridMoviesByCategory.setAdapter(adapter);
        int totalHeight = 0;
        int count = adapter.getCount();
        int rows = (count % 2 == 0) ? count / 2 : count / 2 + 1;

        for (int size = 0; size < rows; size++) {
            LinearLayout linearLayout = (LinearLayout) adapter.getView(size, null,
                    gridMoviesByCategory);
            linearLayout.measure(0,0);
            totalHeight += linearLayout.getMeasuredHeight() + 20;
        }
        ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) gridMoviesByCategory.getLayoutParams();
        if (params != null)
        {
            params.height = totalHeight;
        }

        gridMoviesByCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = view.findViewById(R.id.check_movie_logo);
                selectedItem.setBackgroundColor(context.getResources().getColor(R.color.colorSelectedLogoItem));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent;
                selectedGroupPos = groupPosition;
                selectedPos = position;

                intent = new Intent(context, DescriptionActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                updateMovie(selectedGroupPos, selectedPos, intent);
                context.startActivity(intent);

            }
        });
        return convertView;
    }

    private void updateMovie(int groupPos, int itemPos, Intent intent) {
        Movie selectedMovie = mapChild.get(categoriesList.get(groupPos)).get(itemPos);
        intent.putExtra("movie", selectedMovie);
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

}
