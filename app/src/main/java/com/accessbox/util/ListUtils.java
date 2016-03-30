package com.accessbox.util;

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
    static ArrayList<SubCategoryItem> subCategoryItemsList = new ArrayList<SubCategoryItem>();
    static ArrayList<SubCategoryItem> favoriteItemsList =  new ArrayList<SubCategoryItem>();
    static ArrayList<SubCategoryItem>  shortlistItemsList = new ArrayList<SubCategoryItem>();

    public static String getCurrentPath(String category) {
        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/AccessBox/"+category ;
        return filePath;
    }

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

    public static ArrayList<SubCategoryItem> getSubCategoryItemList(String category) {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/AccessBox/"+category ;
        File[] subCategoryList;
        File f = new File(path);
        if(!f.exists())
            f.mkdir();
        subCategoryList = f.listFiles();
        if(subCategoryList != null) {
            for (int i = 0; i < subCategoryList.length; i++) {
                SubCategoryItem subCategoryItem = new SubCategoryItem();
                subCategoryItem.setImgPath(subCategoryList[i].getPath());
                subCategoryItem.setCatId(category);
                subCategoryItemsList.add(subCategoryItem);
            }
        }
        return subCategoryItemsList;
    }


    public static void setSubCategoryItemList(String category) {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/AccessBox/"+category ;
        File[] subCategoryList;
        File f = new File(path);
        if(!f.exists())
            f.mkdir();
        subCategoryList = f.listFiles();
        if(subCategoryList != null) {
            for (int i = 0; i < subCategoryList.length; i++) {
                SubCategoryItem subCategoryItem = new SubCategoryItem();
                subCategoryItem.setImgPath(subCategoryList[i].getPath());
                subCategoryItem.setCatId(category);
                subCategoryItemsList.add(subCategoryItem);
            }
        }
    }

}
