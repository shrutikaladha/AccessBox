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

    public static void setSubCategoryItemList(Context context, String category, ArrayList<SubCategoryItem> imgPaths) {
       // mSubItemsPathArrayList = imgPaths;
        sharedPrefs.setCategoryList(context,imgPaths,category);
    }

    public static ArrayList<SubCategoryItem> getSubCategoryItemList(Context context, String category) {
        ArrayList<SubCategoryItem> subCategoryItemsList = sharedPrefs.getCategoryList(context, category);
     /*   ArrayList<SubCategoryItem> subCategoryItemsList = new ArrayList<SubCategoryItem>();
        ArrayList<String> pathArray = mSubItemsPathArrayList;
        for(int i=0;i<pathArray.size();i++) {
            SubCategoryItem subCategoryItem = new SubCategoryItem();
            subCategoryItem.setImgPath(pathArray.get(i));
            subCategoryItem.setCatId(category);
            subCategoryItemsList.add(subCategoryItem);
        }*/
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
