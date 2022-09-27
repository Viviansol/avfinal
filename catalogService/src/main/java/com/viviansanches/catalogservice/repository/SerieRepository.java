package com.viviansanches.catalogservice.repository;

import com.viviansanches.catalogservice.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SerieRepository extends MongoRepository<Serie, String> {

    List<Serie> findAllByGenre(String genre);
}
