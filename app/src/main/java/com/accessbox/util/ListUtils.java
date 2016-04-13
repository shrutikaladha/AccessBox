package com.accessbox.util;

import android.content.Context;

import com.accessbox.category.MainCategoryItem;
import com.accessbox.category.SubCategoryItem;

import java.util.ArrayList;

/**
 * Created by shrutika on 12/3/16.
 */
public class ListUtils {

    static SharedPrefs sharedPrefs = new SharedPrefs();

    public static ArrayList<MainCategoryItem> getMainCategoryItemList(Context context) {
        ArrayList<MainCategoryItem> mainCategoryItemsList = sharedPrefs.getMainCategoryList(context);
        if(mainCategoryItemsList.size() == 0)
            setProfileCategory(context,"male");
        return mainCategoryItemsList;
    }

    public static void setMainCategoryItemList(Context context, ArrayList<MainCategoryItem> itemsList) {
       sharedPrefs.setMainCategoryList(context,itemsList);
    }

    public static void addCategory(Context context, MainCategoryItem mainCategoryItem) {
        ArrayList<MainCategoryItem> itemList = sharedPrefs.getMainCategoryList(context);
        itemList.add(mainCategoryItem);
        setMainCategoryItemList(context, itemList);
    }

    public static void setProfileCategory(Context context, String gender) {
        ArrayList<MainCategoryItem> mainCategoryItemList = new ArrayList<MainCategoryItem>();
        switch (gender) {
            case "female":
                mainCategoryItemList.add(new MainCategoryItem("Watches", "watch"));
                mainCategoryItemList.add(new MainCategoryItem("Earrings", "Earring"));
                break;

            case "male":
                mainCategoryItemList.add(new MainCategoryItem("Wallets", "wallet"));
                mainCategoryItemList.add(new MainCategoryItem("Belts", "belt"));
                mainCategoryItemList.add(new MainCategoryItem("Tie", "tie"));
                mainCategoryItemList.add(new MainCategoryItem("Watches", "watch"));
                break;

            default:
                mainCategoryItemList.clear();
        }
        sharedPrefs.setMainCategoryList(context,mainCategoryItemList);
    }

    public static void setSubCategoryItemList(Context context, String category, ArrayList<SubCategoryItem> imgPaths) {
        sharedPrefs.setSubCategoryList(context, imgPaths, category);
    }

    public static ArrayList<SubCategoryItem> getSubCategoryItemList(Context context, String category) {
        ArrayList<SubCategoryItem> subCategoryItemsList = sharedPrefs.getSubCategoryList(context, category);
        return subCategoryItemsList;
    }

    public static void addToCategory(Context context, String category, SubCategoryItem subCategoryItem) {
        ArrayList<SubCategoryItem> itemList = getSubCategoryItemList(context, category);
        itemList.add(subCategoryItem);
        setSubCategoryItemList(context,category,itemList);
    }

    public static void addToCategory(Context context, String category, ArrayList<SubCategoryItem> subCategoryItemList) {
        ArrayList<SubCategoryItem> itemList = getSubCategoryItemList(context, category);
        for(int i=0;i<subCategoryItemList.size();i++) {
            itemList.add(subCategoryItemList.get(i));
        }

        setSubCategoryItemList(context, category, itemList);
    }

    public static void removeFromCategory(Context context, String category, SubCategoryItem subCategoryItem) {
        ArrayList<SubCategoryItem> itemList = getSubCategoryItemList(context, category);
        itemList.remove(subCategoryItem);
        setSubCategoryItemList(context,category,itemList);
    }



}
