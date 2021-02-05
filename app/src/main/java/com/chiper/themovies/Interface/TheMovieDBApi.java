package com.chiper.themovies.Interface;
import com.chiper.themovies.model.Post;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TheMovieDBApi {
    @Headers({
            "Content-Type: application/json;charset=utf-8"
    })
    @GET("4/list/{list_id}")
    Call<Post> getMovies(@Header("Authorization") String authorization, @Path("list_id") int idList, @Query("page") int pageNumber,
                         @Query("api_key") String apiKey, @Query("language") String lang);
}
