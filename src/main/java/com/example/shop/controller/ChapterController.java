package com.example.shop.controller;


import com.example.shop.entity.Chapter;
import com.example.shop.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chapter")
@CrossOrigin(origins = "*")
public class ChapterController {

    @Autowired //Инициализирует репозиторий
    private ChapterService chapterService;

    @PostMapping
    public ResponseEntity getChapter(@RequestBody Chapter chapter,
                                     @RequestParam(required = false) Long id) {
        try {
            return ResponseEntity.ok(chapterService.createChapter(chapter, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Chapter not found");
        }
    }

    @GetMapping
    public ResponseEntity getChapter(@RequestParam(required = false) Long id) {
        try {
            return ResponseEntity.ok(chapterService.getChapter(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Chapter not found");
        }
    }

    @GetMapping(path = "/all")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(chapterService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Chapter not found");
        }
    }
}
