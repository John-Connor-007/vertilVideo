package com.uco.vertilvideos.controller;

import com.uco.vertilvideos.domain.CategoryDomain;
import com.uco.vertilvideos.model.CategoryModel;
import com.uco.vertilvideos.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categoryController")
public class CategoryController {

    @Autowired
    private CategoryDomain categoryDomain;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping(value = "/saveCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveCategory(@RequestBody CategoryModel category) throws Exception{
        categoryDomain.createCategory(category);
    }

    @GetMapping(value = "/searchAllCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoryModel> searchAllCategory() throws Exception{
        return categoryDomain.searchAllCategory();
    }


}
