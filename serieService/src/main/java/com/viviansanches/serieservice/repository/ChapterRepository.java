package com.viviansanches.serieservice.repository;

import com.viviansanches.serieservice.model.Chapter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChapterRepository extends MongoRepository<Chapter, String> {
}
