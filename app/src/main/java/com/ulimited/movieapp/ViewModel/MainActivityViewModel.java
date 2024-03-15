package com.ulimited.movieapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ulimited.movieapp.Model.Movie;
import com.ulimited.movieapp.Model.MovieRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MovieRepository movieRepository;
    private MutableLiveData<List<Movie>> allMovie;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        this.movieRepository = new MovieRepository(application);

    }

    public LiveData<List<Movie>> getAllMovies()
    {
        allMovie = movieRepository.getPopularMovies();
        return allMovie;
    }


}
