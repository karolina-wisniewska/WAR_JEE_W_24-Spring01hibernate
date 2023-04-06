package pl.coderslab.service;

import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface CategoryService {

    Category findById(Long id);

    List<Category> findAll();

}
