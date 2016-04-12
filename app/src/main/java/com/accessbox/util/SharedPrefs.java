package com.accessbox.util;

import android.content.Context;
import android.content.SharedPreferences;

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


    public void setCategoryList(Context context, ArrayList<SubCategoryItem> itemList, String categoryId) {
        settings = context.getSharedPreferences(AppConstants.PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();
        Gson gson = new Gson();
        String jsonList = gson.toJson(itemList);
        editor.putString(categoryId, jsonList);
        editor.commit();
    }

    public ArrayList getCategoryList(Context context, String categoryId) {
// used for retrieving arraylist from json formatted string
        SharedPreferences settings;
        List itemList;
        ArrayList<SubCategoryItem> favoriteArrayList = new ArrayList<SubCategoryItem>();
        settings = context.getSharedPreferences(AppConstants.PREFS_NAME, Context.MODE_PRIVATE);
        if (settings.contains(categoryId)) {
            String jsonList = settings.getString(categoryId, null);
            Gson gson = new Gson();
            SubCategoryItem[] subCategoryItemList = gson.fromJson(jsonList, SubCategoryItem[].class);
            itemList = Arrays.asList(subCategoryItemList);
            favoriteArrayList = new ArrayList(itemList);
        }
        return favoriteArrayList;
    }

    public void setFavoriteList(Context context, List favorites) {
// used for store arrayList in json format
        settings = context.getSharedPreferences(AppConstants.PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);
        editor.putString(AppConstants.PREFS_FAVORITE_LIST, jsonFavorites);
        editor.commit();
    }

    public ArrayList getFavoriteList(Context context) {
// used for retrieving arraylist from json formatted string
        SharedPreferences settings;
        List favorites;
        ArrayList<SubCategoryItem> favoriteArrayList = new ArrayList<SubCategoryItem>();
        settings = context.getSharedPreferences(AppConstants.PREFS_NAME, Context.MODE_PRIVATE);
        if (settings.contains(AppConstants.PREFS_FAVORITE_LIST)) {
            String jsonFavorite = settings.getString(AppConstants.PREFS_FAVORITE_LIST, null);
            Gson gson = new Gson();
            SubCategoryItem[] favoriteItems = gson.fromJson(jsonFavorite, SubCategoryItem[].class);
            favorites = Arrays.asList(favoriteItems);
            favoriteArrayList = new ArrayList(favorites);
        }
        return favoriteArrayList;
    }

    public void addToFavorite(Context context, SubCategoryItem subCategoryItem) {
        List favorites = getFavoriteList(context);
        if (favorites == null)
            favorites = new ArrayList();
        favorites.add(subCategoryItem);
        setFavoriteList(context, favorites);
    }

    public void removeFromFavorite(Context context, SubCategoryItem subCategoryItem) {
        ArrayList favorites = getFavoriteList(context);
        if (favorites != null) {
            favorites.remove(subCategoryItem);
            setFavoriteList(context, favorites);
        }
    }

    public void setShortlistedItemsList(Context context, List shortlist) {
// used for store arrayList in json format
        settings = context.getSharedPreferences(AppConstants.PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();
        Gson gson = new Gson();
        String jsonShortlist = gson.toJson(shortlist);
        editor.putString(AppConstants.PREFS_SHORTLIST_LIST, jsonShortlist);
        editor.commit();
    }

    public ArrayList getShortlistedItemsList(Context context) {
// used for retrieving arraylist from json formatted string
        List shortlist;
        ArrayList<SubCategoryItem> shortlistedArrayItems = new ArrayList<SubCategoryItem>();
        settings = context.getSharedPreferences(AppConstants.PREFS_NAME, Context.MODE_PRIVATE);
        if (settings.contains(AppConstants.PREFS_SHORTLIST_LIST)) {
            String jsonShortlist = settings.getString(AppConstants.PREFS_SHORTLIST_LIST, null);
            Gson gson = new Gson();
            SubCategoryItem[] shortlistItems = gson.fromJson(jsonShortlist, SubCategoryItem[].class);
            shortlist = Arrays.asList(shortlistItems);
            shortlistedArrayItems = new ArrayList(shortlist);
        }
        return shortlistedArrayItems;
    }

    public void addToShortlist(Context context, SubCategoryItem subCategoryItem) {
        List shortlist = getShortlistedItemsList(context);
        if (shortlist == null)
            shortlist = new ArrayList();
        shortlist.add(subCategoryItem);
        setShortlistedItemsList(context, shortlist);
    }

    public void removeFromShortlist(Context context, SubCategoryItem subCategoryItem) {
        ArrayList shortlist = getShortlistedItemsList(context);
        if (shortlist != null) {
            shortlist.remove(subCategoryItem);
            setShortlistedItemsList(context, shortlist);
        }
    }



}
