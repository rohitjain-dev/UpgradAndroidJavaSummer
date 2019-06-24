package com.example.recyclerview;

public class Mylist {
    private String description;
    private Integer imageId;

    public Mylist(String description,Integer imageId){

        this.description = description;
        this.imageId = imageId;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setImageId(Integer imageId){
        this.imageId = imageId;
    }

    public Integer getImageId() {
        return imageId;
    }
}
