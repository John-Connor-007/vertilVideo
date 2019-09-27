package com.uco.vertilvideos.domain;

import com.uco.vertilvideos.entity.CategoryEntity;
import com.uco.vertilvideos.model.CategoryModel;
import com.uco.vertilvideos.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDomain {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private CategoryRepository categoryRepository;

    public void createCategory (CategoryModel categoryModel) throws Exception {
        CategoryEntity categoryEntity = modelMapper.map(categoryModel, CategoryEntity.class);
        categoryRepository.save(categoryEntity);
    }

    public List<CategoryModel> searchAllCategory() throws Exception {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        List<CategoryModel> categoryModelList = new ArrayList<>();
        if(!categoryEntityList.isEmpty()){
            categoryEntityList.forEach((CategoryEntity categoryEntity )-> {
                CategoryModel categoryModel = modelMapper.map(categoryEntity, CategoryModel.class);
                categoryModelList.add(categoryModel);
            });
        }
        return categoryModelList;
    }
}
