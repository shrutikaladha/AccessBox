package com.accessbox.util;

import android.content.Context;
import android.os.Environment;

import com.accessbox.R;
import com.accessbox.category.MainCategoryItem;
import com.accessbox.category.SubCategoryItem;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by shrutika on 12/3/16.
 */
public class ListUtils {

    static ArrayList<MainCategoryItem> mainCategoryItemsList = new ArrayList<MainCategoryItem>();
    private static ArrayList<SubCategoryItem> favoriteItemsList =  new ArrayList<SubCategoryItem>();
    private static ArrayList<SubCategoryItem> shortlistItemsList =  new ArrayList<SubCategoryItem>();
    private static ArrayList<String> mSubItemsPathArrayList =  new ArrayList<String>();
    static SharedPrefs sharedPrefs = new SharedPrefs();

    public static ArrayList<MainCategoryItem> getMainCategoryItemList() {
        return mainCategoryItemsList;
    }

    public static void addCategory(MainCategoryItem mainCategoryItem) {
        mainCategoryItemsList.add(mainCategoryItem);
    }

    public static void setProfileCategory(String gender) {
        switch (gender) {
            case "female":
                mainCategoryItemsList.add(new MainCategoryItem("Watches", "watch", R.drawable.watches));
                mainCategoryItemsList.add(new MainCategoryItem("Earrings", "Earring", R.drawable.earrings));
                break;

            case "male":
                mainCategoryItemsList.add(new MainCategoryItem("Wallets", "wallet", R.drawable.wallet));
                mainCategoryItemsList.add(new MainCategoryItem("Belts", "belt", R.drawable.belt));
                mainCategoryItemsList.add(new MainCategoryItem("Tie", "tie", R.drawable.tie));
                mainCategoryItemsList.add(new MainCategoryItem("Watches", "watch", R.drawable.watches));
                break;

            default:
                mainCategoryItemsList.clear();
        }
    }

    public static void setSubCategoryItemList(String category, ArrayList<String> imgPaths) {
        mSubItemsPathArrayList = imgPaths;
    }

    public static ArrayList<SubCategoryItem> getSubCategoryItemList(String category) {

        ArrayList<SubCategoryItem> subCategoryItemsList = new ArrayList<SubCategoryItem>();
        ArrayList<String> pathArray = mSubItemsPathArrayList;
        for(int i=0;i<pathArray.size();i++) {
            SubCategoryItem subCategoryItem = new SubCategoryItem();
            subCategoryItem.setImgPath(pathArray.get(i));
            subCategoryItem.setCatId(category);
            subCategoryItemsList.add(subCategoryItem);
        }
        return subCategoryItemsList;
    }

    public static void addToFavorites(Context context, SubCategoryItem subCategoryItem) {
        favoriteItemsList.add(subCategoryItem);
        sharedPrefs.addToFavorite(context, subCategoryItem);
    }

    public static void removeFromFavorites(Context context, SubCategoryItem subCategoryItem) {
        favoriteItemsList.remove(subCategoryItem);
        sharedPrefs.removeFromFavorite(context, subCategoryItem);
    }

    public static ArrayList<SubCategoryItem> getFavoriteItemsList(Context context) {
        favoriteItemsList = sharedPrefs.getFavoriteList(context);
        return favoriteItemsList;
    }

    public static void addToShortlist(Context context,SubCategoryItem subCategoryItem) {
        shortlistItemsList.add(subCategoryItem);
        sharedPrefs.addToShortlist(context, subCategoryItem);
    }

    public static void removeFromShortlist(Context context,SubCategoryItem subCategoryItem) {
        shortlistItemsList.remove(subCategoryItem);
        sharedPrefs.removeFromShortlist(context, subCategoryItem);
    }

    public static ArrayList<SubCategoryItem> getShortlistItemsList(Context context) {
        shortlistItemsList = sharedPrefs.getShortlistedItemsList(context);
        return shortlistItemsList;
    }


}
