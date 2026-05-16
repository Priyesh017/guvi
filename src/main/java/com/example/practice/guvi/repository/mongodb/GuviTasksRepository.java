package com.example.practice.guvi.repository.mongodb;

import com.example.practice.guvi.model.mongodb.GuviTask;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuviTasksRepository extends MongoRepository<GuviTask, Integer> {

}
