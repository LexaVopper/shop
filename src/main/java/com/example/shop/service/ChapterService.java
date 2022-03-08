package com.example.shop.service;

import com.example.shop.entity.Chapter;
import com.example.shop.entity.UserEntity;
import com.example.shop.exception.ChapterNotFoundEx;
import com.example.shop.model.ChapterModel;
import com.example.shop.repository.ChapterRepo;
import com.example.shop.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterService {

    @Autowired
    private ChapterRepo chapterRepo;
    @Autowired
    private UserRepo userRepo;

    public Chapter createChapter(Chapter chapter, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        chapter.setUser(user);
        return chapterRepo.save(chapter);
    }

    public Chapter getChapter(Long id) throws ChapterNotFoundEx {
        Chapter chapter = chapterRepo.findById(id).get();
        if (chapter != null) {
            return chapter;
        }
        throw new ChapterNotFoundEx("Нет такого курса");
    }



    public List<ChapterModel> getAll() {
        List<Chapter> chapters = (List) chapterRepo.findAll();
        List<ChapterModel> newChapter = new ArrayList<>();
        for (Chapter chapter : chapters) {
            newChapter.add(ChapterModel.AllOutputModel(chapter));
        }

        return newChapter;
    }
}
