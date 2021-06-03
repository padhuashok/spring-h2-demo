package com.example.demo.repository;

import com.example.demo.domain.Lesson;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson,Long> {
    List<Lesson> findByTitle(String titleName);
}
