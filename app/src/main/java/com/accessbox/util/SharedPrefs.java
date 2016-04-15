package com.accessbox.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.accessbox.category.MainCategoryItem;
import com.accessbox.category.SubCategoryItem;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shrutika on 3/4/16.
 */
public class SharedPrefs {

    SharedPreferences settings;
    SharedPreferences.Editor editor;

    public SharedPrefs() {
        super();
    }

    public void setSubCategoryList(Context context, ArrayList<SubCategoryItem> itemList, String categoryId) {
        settings = context.getSharedPreferences(AppConstants.PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();
        Gson gson = new Gson();
        String jsonList = gson.toJson(itemList);
        editor.putString(categoryId, jsonList);
        editor.commit();
    }

    public ArrayList getSubCategoryList(Context context, String categoryId) {

        SharedPreferences settings;
        List itemList;
        ArrayList<SubCategoryItem> subCategoryItemArrayList = new ArrayList<SubCategoryItem>();
        settings = context.getSharedPreferences(AppConstants.PREFS_NAME, Context.MODE_PRIVATE);
        if (settings.contains(categoryId)) {
            String jsonList = settings.getString(categoryId, null);
            Gson gson = new Gson();
            SubCategoryItem[] subCategoryItemList = gson.fromJson(jsonList, SubCategoryItem[].class);
            itemList = Arrays.asList(subCategoryItemList);
            subCategoryItemArrayList = new ArrayList(itemList);
        }
        return subCategoryItemArrayList;
    }

    public void setMainCategoryList(Context context, ArrayList<MainCategoryItem> itemList) {
        settings = context.getSharedPreferences(AppConstants.PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();
        Gson gson = new Gson();
        String jsonList = gson.toJson(itemList);
        editor.putString("MainCategoryList", jsonList);
        editor.commit();
    }

    public ArrayList<MainCategoryItem> getMainCategoryList(Context context) {

        SharedPreferences settings;
        List itemList;
        ArrayList<MainCategoryItem> mainCategoryItemArrayList = new ArrayList<MainCategoryItem>();
        settings = context.getSharedPreferences(AppConstants.PREFS_NAME, Context.MODE_PRIVATE);
        if (settings.contains("MainCategoryList")) {
            String jsonList = settings.getString("MainCategoryList", null);
            Gson gson = new Gson();
            MainCategoryItem[] subCategoryItemList = gson.fromJson(jsonList, MainCategoryItem[].class);
            itemList = Arrays.asList(subCategoryItemList);
            mainCategoryItemArrayList = new ArrayList(itemList);
        }
        return mainCategoryItemArrayList;
    }


}
