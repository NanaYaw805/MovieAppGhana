package com.ulimited.movieapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.ulimited.movieapp.model.Movie;
import com.ulimited.movieapp.model.MovieRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MovieRepository movieRepository;
    private MutableLiveData<List<Movie>> allMovie;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.movieRepository = new MovieRepository(application);
    }

    public MutableLiveData<List<Movie>> getAllMovies() {
        if (allMovie == null) {
            allMovie = new MutableLiveData<>();
        }
        allMovie = movieRepository.getPopularMovies();
        return allMovie;
    }
}
