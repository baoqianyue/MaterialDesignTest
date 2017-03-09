package com.example.materialdesigntest;

/**
 * Created by 鲍骞月 on 2017/3/9.
 */

public class Hero {
    private String name;
    private int imageId;

    public Hero(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
