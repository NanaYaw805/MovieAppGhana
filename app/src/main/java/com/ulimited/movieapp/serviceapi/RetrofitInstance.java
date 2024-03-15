package com.ulimited.movieapp.serviceapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit = null;
    private static String BaseUrl = "http://api.themoviedb.org/3/";


    public static MovieApiService getInstance()
    {
        if (retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(MovieApiService.class);
    }

}
