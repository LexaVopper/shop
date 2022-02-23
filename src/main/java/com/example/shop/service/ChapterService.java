package com.example.shop.service;

import com.example.shop.entity.Chapter;
import com.example.shop.entity.UserEntity;
import com.example.shop.exception.ChapterNotFoundEx;
import com.example.shop.repository.ChapterRepo;
import com.example.shop.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChapterService {

    @Autowired
    private ChapterRepo chapterRepo;
    @Autowired
    private UserRepo userRepo;

  public Chapter createChapter (Chapter chapter, Long userId) {
      UserEntity user = userRepo.findById(userId).get();
      chapter.setUser(user);
      return chapterRepo.save(chapter);
  }
}
