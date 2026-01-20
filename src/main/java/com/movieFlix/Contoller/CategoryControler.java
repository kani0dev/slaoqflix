package com.movieFlix.Contoller;

import com.movieFlix.Contoller.Request.CategoryRequest;
import com.movieFlix.Contoller.Response.CategoryResponse;
import com.movieFlix.Entity.Category;
import com.movieFlix.Mapper.CategoryMapper;
import com.movieFlix.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie/category")
@RequiredArgsConstructor
public class CategoryControler {

    private final CategoryService serviceCategory;


    @GetMapping()
    public List<CategoryResponse> getAllCategorys(){
        List<Category> categories = serviceCategory.findall();
        return categories.stream()
                .map(CategoryMapper::toResponse)
                .toList();
    }

    @PostMapping()
    public CategoryResponse saveCategory(@RequestBody CategoryRequest request){
        Category category = CategoryMapper.toCategory(request);
        Category saved = serviceCategory.createCategory(category);
        return CategoryMapper.toResponse(saved);
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryByID(@PathVariable long id){
        Category category = serviceCategory.findById(id);
        return CategoryMapper.toResponse(category);
    }

    @PutMapping("/{id}")
    public CategoryResponse putCategory(@PathVariable long id , @RequestBody CategoryRequest request){
        Category editedCategory = CategoryMapper.toCategory(request);
        Category category = serviceCategory.editCategory(id, editedCategory);

        return CategoryMapper.toResponse(category);
    }

    @DeleteMapping("/{id}")
    public void deletCategory(@PathVariable long id){
         serviceCategory.harddeletCategory(id);
    }
}
