package com.accessbox.util;

import com.accessbox.category.SubCategoryItem;

import java.util.ArrayList;

/**
 * Created by shrutika on 31/3/16.
 */
public class Utils {

    private static ArrayList<SubCategoryItem> favoriteItemList =  new ArrayList<SubCategoryItem>();
    private static ArrayList<SubCategoryItem> shortlistItemList =  new ArrayList<SubCategoryItem>();

    public static void addToFavorites(SubCategoryItem subCategoryItem) {
        favoriteItemList.add(subCategoryItem);
    }

    public static void removeFromFavorites(SubCategoryItem subCategoryItem) {
        favoriteItemList.remove(subCategoryItem);
    }

    public static ArrayList<SubCategoryItem> getFavoriteItemsList() {
        return favoriteItemList;
    }

    public static void addToShortlist(SubCategoryItem subCategoryItem) {
        shortlistItemList.add(subCategoryItem);
    }

    public static void removeFromShortlist(SubCategoryItem subCategoryItem) {
        shortlistItemList.remove(subCategoryItem);
    }

    public static ArrayList<SubCategoryItem> getShortlistItemsList() {
        return shortlistItemList;
    }

}
