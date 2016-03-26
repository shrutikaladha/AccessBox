package com.accessbox.category;

import java.io.Serializable;

/**
 * Created by shrutika on 11/3/16.
 */
public class MainCategoryItem implements Serializable{
    private String catId;
    private String categoryName;
    private int categoryImg;
    private String shortNote;

    public MainCategoryItem(String categoryName, int categoryImg, String shortNote, String catId) {
        this.catId = catId;
        this.categoryName = categoryName;
        this.categoryImg = categoryImg;
        this.shortNote = shortNote;
    }

    public MainCategoryItem(String categoryName, String catId) {
        this.categoryName = categoryName;
        this.catId = catId;
    }

    public MainCategoryItem(String categoryName, String catId, int categoryImg) {
        this.catId = catId;
        this.categoryName = categoryName;
        this.categoryImg = categoryImg;
    }

    private void setCatId(String catId) {
        this.catId = catId;
    }

    private void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    private void setCategoryImg(int categoryImg) {
        this.categoryImg = categoryImg;
    }

    private void setShortNote(String shortNote) {
        this.shortNote = shortNote;
    }

    private String getCatId() {
        return catId;
    }

    public int getCategoryImg() {
        return categoryImg;
    }

    private String getShortNote() {
        return shortNote;
    }

    public String getCategoryName() {
        return categoryName;
    }

}
