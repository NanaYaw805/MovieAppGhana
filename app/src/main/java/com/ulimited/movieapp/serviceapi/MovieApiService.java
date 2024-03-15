package com.ulimited.movieapp.serviceapi;

import com.ulimited.movieapp.Model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    //defines the structure and behaviour of the API requests and links the app to the api

    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String apiKey);






}
