package com.uco.vertilvideos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryModel {

    @JsonProperty
    public Integer id;

    @JsonProperty
    public String categoryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
