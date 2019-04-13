package ru.shikhovtsev.videoShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shikhovtsev.videoShop.model.Category;
import ru.shikhovtsev.videoShop.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getByName(String name) {
        return categoryRepository.findByName(name);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
