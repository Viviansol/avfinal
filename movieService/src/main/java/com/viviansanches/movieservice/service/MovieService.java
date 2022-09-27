package com.viviansanches.movieservice.service;

import com.viviansanches.movieservice.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllByGenre(String genre);

    Movie getMovieById(Long movieId);

    Movie saveMovie(Movie movie);
}
