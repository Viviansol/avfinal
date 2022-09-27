package com.viviansanches.serieservice.repository;

import com.viviansanches.serieservice.model.Season;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeasonRepository extends MongoRepository<Season, String> {
}
