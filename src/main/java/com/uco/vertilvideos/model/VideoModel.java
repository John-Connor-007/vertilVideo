package com.uco.vertilvideos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoModel {
    @JsonProperty
    private Integer id;

    @JsonProperty
    private String url;

    @JsonProperty
    private Integer idPerson;

    @JsonProperty
    private String title;

    @JsonProperty
    private Integer idCategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }
}
