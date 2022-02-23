package com.example.shop.repository;

import com.example.shop.entity.Chapter;
import org.springframework.data.repository.CrudRepository;

public interface ChapterRepo extends CrudRepository<Chapter, Long> {
    Chapter findByName(String name);
}