package com.movieFlix.Mapper;

import com.movieFlix.Contoller.Request.CategoryRequest;
import com.movieFlix.Contoller.Response.CategoryResponse;
import com.movieFlix.Entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
    public static Category toCategory(CategoryRequest request){
        return Category.builder()
                .name(request.name())
                .descricao(request.descricao())
                .build();
    }
    public static CategoryResponse toResponse(Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .descricao(category.getDescricao())
                .build();
    }
}
