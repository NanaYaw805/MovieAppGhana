package com.ulimited.movieapp.Model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.ulimited.movieapp.R;
import com.ulimited.movieapp.serviceapi.MovieApiService;
import com.ulimited.movieapp.serviceapi.RetrofitInstance;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository  {
  public ArrayList<Movie> movies = new ArrayList<>();
  public MutableLiveData<List<Movie>> mutableLiveData;
  public Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    MovieApiService movieApiService = RetrofitInstance.getInstance();
    Call<Result> call = movieApiService.getPopularMovies(application.getApplicationContext().getString(R.string.api_key));

    public MutableLiveData<List<Movie>> getPopularMovies(){
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                if (result != null && result.getResults() != null){
                    movies = (ArrayList<Movie>) result.getResults();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
