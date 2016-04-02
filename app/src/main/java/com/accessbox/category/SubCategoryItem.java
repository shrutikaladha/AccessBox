package com.accessbox.category;

import java.io.Serializable;

/**
 * Created by shrutika on 11/3/16.
 */
public class SubCategoryItem implements Serializable{
    private String catId;
    private String itemId;
    private String brandName;
    private String imgPath;
    private String shortNote;

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void setShortNote(String shortNote) {
        this.shortNote = shortNote;
    }

    public String getCatId() {
        return catId;
    }

    public String getItemId() {
        return itemId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getShortNote() {
        return shortNote;
    }

    public String getBrandName() {
        return brandName;
    }
}
