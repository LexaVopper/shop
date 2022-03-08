package com.example.shop.model;

import com.example.shop.entity.Chapter;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChapterModel {

    private Long id;
    private String name;
    private Boolean isViewed;

    public  static ChapterModel AllOutputModel (Chapter entity) {
        ChapterModel model = new ChapterModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setIsViewed(entity.getIsViewed());
        return model;
    }

}
