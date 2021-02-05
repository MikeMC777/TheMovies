package com.chiper.themovies.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Post implements Serializable {

    private String name;
    private ArrayList<Movie> results;

    public Post(ArrayList<Movie> results) {
        this.results = results;
    }

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
