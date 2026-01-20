package com.movieFlix.Service;

import com.movieFlix.Entity.Category;
import com.movieFlix.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.data.metrics.DefaultRepositoryTagsProvider;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }


    public List<Category> findall() {
        return repo.findAll();
    }

    public Category createCategory(Category category) {
        return repo.save(category);
    }

    public Category findById(long id) {
        Optional<Category> thiscategory = repo.findById(id);
        return thiscategory.orElse(null);
    }

    public Category editCategory(long id, Category category) {
        Category thiscategory = findById(id);
        if(thiscategory != null){
            thiscategory = category;
            thiscategory.setId(id);
            return  repo.save(thiscategory);
        }
        return null;
    }

    public void harddeletCategory(long id) {
        Category thiscategory = findById(id);
        if(thiscategory !=null){
            repo.delete(thiscategory);
        }
    }
}
