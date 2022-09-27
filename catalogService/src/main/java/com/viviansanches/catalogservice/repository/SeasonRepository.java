package com.viviansanches.catalogservice.repository;

import com.viviansanches.catalogservice.model.Season;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeasonRepository extends MongoRepository<Season, String> {
}
