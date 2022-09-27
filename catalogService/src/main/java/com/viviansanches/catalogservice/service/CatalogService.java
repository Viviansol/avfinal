package com.viviansanches.catalogservice.service;

import com.viviansanches.catalogservice.dto.CatalogDTO;
import com.viviansanches.catalogservice.model.Movie;
import com.viviansanches.catalogservice.model.Serie;

public interface CatalogService {

    Movie getMovieById(String movieId);

    CatalogDTO getCatalogByGenre(String genre);

    void addNewMovie(Movie movie);

    void addNewSerie(Serie serie);
}
