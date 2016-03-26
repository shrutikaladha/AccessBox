package com.accessbox.category;

/**
 * Created by shrutika on 11/3/16.
 */
public class SubCategoryItem {
    private String catId;
    private String itemId;
    private String brandName;
    private String imgPath;
    private String shortNote;

    private void setCatId(String catId) {
        this.catId = catId;
    }

    private void setItemId(String itemId) {
        this.itemId = itemId;
    }

    private void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    private void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    private void setShortNote(String shortNote) {
        this.shortNote = shortNote;
    }

    private String getCatId() {
        return catId;
    }

    private String getItemId() {
        return itemId;
    }

    private String getImgPath() {
        return imgPath;
    }

    private String getShortNote() {
        return shortNote;
    }

    private String getBrandName() {
        return brandName;
    }
}
