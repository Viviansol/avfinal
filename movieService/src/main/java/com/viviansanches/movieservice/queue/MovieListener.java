package com.viviansanches.movieservice.queue;

import com.viviansanches.movieservice.model.Movie;
import com.viviansanches.movieservice.service.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MovieListener {

    private final MovieServiceImpl movieService;

    @RabbitListener(queues = {"${queue.movie-service.name}"})
    public void receiveMessage(Movie movie){
        movieService.saveMovie(movie);
    }
}
