package com.viviansanches.catalogservice.repository;

import com.viviansanches.catalogservice.model.Chapter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChapterRepository extends MongoRepository<Chapter, String> {
}
