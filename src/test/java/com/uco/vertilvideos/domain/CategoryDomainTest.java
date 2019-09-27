package com.uco.vertilvideos.domain;

import com.uco.vertilvideos.entity.CategoryEntity;
import com.uco.vertilvideos.model.CategoryModel;
import com.uco.vertilvideos.repository.CategoryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class CategoryDomainTest {
    @InjectMocks
    private CategoryDomain categoryDomain;
    @MockBean
    private CategoryRepository categoryRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSearchAllCategoryReturnAllCategoryIsExist() throws Exception {
        List<CategoryEntity> categoryEntityList = new ArrayList<>();
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName("Acción");
        categoryEntityList.add(categoryEntity);
        Mockito.when(categoryRepository.findAll()).thenReturn(categoryEntityList);

        List<CategoryModel> categoryModelList = categoryDomain.searchAllCategory();

        Assert.assertEquals(categoryModelList.get(0).getCategoryName(),categoryEntityList.get(0).getCategoryName());
        Assert.assertFalse(categoryModelList.isEmpty());
    }

    @Test
    public void testSearchAllCategoryNotReturnAnyCategory() throws Exception {
        List<CategoryEntity> categoryEntityList = new ArrayList<>();
        Mockito.when(categoryRepository.findAll()).thenReturn(categoryEntityList);

        List<CategoryModel> categoryModelList = categoryDomain.searchAllCategory();

        Assert.assertTrue(categoryModelList.isEmpty());
    }

}
