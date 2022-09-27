package com.viviansanches.catalogservice.service.impl;

import com.viviansanches.catalogservice.dto.CatalogDTO;
import com.viviansanches.catalogservice.model.Movie;
import com.viviansanches.catalogservice.model.Serie;
import com.viviansanches.catalogservice.repository.MovieRepository;
import com.viviansanches.catalogservice.repository.SerieRepository;
import com.viviansanches.catalogservice.service.CatalogService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private static final Logger log = Logger.getLogger(CatalogServiceImpl.class.getName());

    private final SerieRepository serieRepository;
    private final MovieRepository movieRepository;

    @Override
    public Movie getMovieById(String movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    @Override
    @CircuitBreaker(name="catalogServiceCircuitBreaker")
    @Retry(name="catalogServiceCircuitBreaker")
    public CatalogDTO getCatalogByGenre(String genre) {
        List<Movie> movies = movieRepository.findAllByGenre(genre);
        List<Serie> series = serieRepository.findAllByGenre(genre);
        return new CatalogDTO(genre.toUpperCase(),movies,series);
    }

    @Override
    @CircuitBreaker(name="catalogServiceCircuitBreaker")
    @Retry(name="catalogServiceCircuitBreaker")
    public void addNewMovie(Movie movie){
        log.info("Received a Movie by message from Rabbit Queue to save the Movie on CatalogService...");
        movieRepository.save(movie);
        log.info("... Movie saved at Catalog's database!");
    }

    @Override
    @CircuitBreaker(name="catalogServiceCircuitBreaker")
    @Retry(name="catalogServiceCircuitBreaker")
    public void addNewSerie(Serie serie) {
        log.info("Received a Series by message from Rabbit Queue to save the Series on CatalogService...");
        serieRepository.save(serie);
        log.info("... Series saved at Catalog's database!");
    }


//    public CatalogDTO getCatalogFallbackValue(CallNotPermittedException e) throws CircuitBreakerException {
//        throw new CircuitBreakerException("Circuit breaker was activated: Some error while trying to fetch movies for Catalog object");
//    }
//
//    public Movie getMovieFallbackValue(CallNotPermittedException e) throws CircuitBreakerException {
//        throw new CircuitBreakerException("Circuit breaker was activated: Some error occurred while trying to get a movie from movie-service");
//    }

}
