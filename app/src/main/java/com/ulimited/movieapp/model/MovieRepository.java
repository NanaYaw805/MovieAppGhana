package com.ulimited.movieapp.model;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.ulimited.movieapp.R;
import com.ulimited.movieapp.model.Movie;
import com.ulimited.movieapp.model.Result;
import com.ulimited.movieapp.serviceapi.MovieApiService;
import com.ulimited.movieapp.serviceapi.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData;
    private Application application;
    private MovieApiService movieApiService;

    public MovieRepository(Application application) {
        this.application = application;
        this.mutableLiveData = new MutableLiveData<>();
        this.movieApiService = RetrofitInstance.getInstance();
    }

    public MutableLiveData<List<Movie>> getPopularMovies() {
        Call<Result> call = movieApiService.getPopularMovies(application.getString(R.string.api_key));
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                if (result != null && result.getResults() != null) {
                    movies = new ArrayList<>(result.getResults());
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                // Handle failure here, e.g., log error message
                Log.e("MovieRepository", "Failed to fetch popular movies", t);
            }
        });

        return mutableLiveData;
    }
}
