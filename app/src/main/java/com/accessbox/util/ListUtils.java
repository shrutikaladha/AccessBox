package com.accessbox.util;

import android.os.Environment;

import com.accessbox.R;
import com.accessbox.category.MainCategoryItem;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by shrutika on 12/3/16.
 */
public class ListUtils {

    static ArrayList<MainCategoryItem> mainCategoryItems = new ArrayList<MainCategoryItem>();
    static ArrayList<String> itemList= new ArrayList<String>();

    public static String getCurrentPath(String category) {
        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/AccessBox/"+category ;
        return filePath;
    }

    public static ArrayList<MainCategoryItem> getMainCategoryItemList() {
        return mainCategoryItems;
    }

    public static void addCategory(MainCategoryItem mainCategoryItem) {
        mainCategoryItems.add(mainCategoryItem);
    }

    public static void setProfileCategory(String gender) {
        switch (gender) {
            case "female":
                mainCategoryItems.add(new MainCategoryItem("Watches", "watch", R.drawable.watches));
                mainCategoryItems.add(new MainCategoryItem("Earrings", "Earring", R.drawable.earrings));
                break;

            case "male":
                mainCategoryItems.add(new MainCategoryItem("Wallets", "wallet", R.drawable.wallet));
                mainCategoryItems.add(new MainCategoryItem("Belts", "belt", R.drawable.belt));
                mainCategoryItems.add(new MainCategoryItem("Tie", "tie", R.drawable.tie));
                mainCategoryItems.add(new MainCategoryItem("Watches", "watch", R.drawable.watches));
                break;

            default:
                mainCategoryItems.clear();
        }
    }

    public static ArrayList<String> getSubCategoryItemList(String category) {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/AccessBox/"+category ;
        File[] tShirtsFileList;
        File f = new File(path);
        if(!f.exists())
            f.mkdir();
        itemList = new ArrayList<String>();
        tShirtsFileList = f.listFiles();
        if(tShirtsFileList != null) {
            for (int i = 0; i < tShirtsFileList.length; i++) {
                itemList.add(tShirtsFileList[i].getPath());
            }
        }
        return itemList;
    }


    public static void setSubCategoryItemList(String category) {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/AccessBox/"+category ;
        File[] tShirtsFileList;
        File f = new File(path);
        if(!f.exists())
            f.mkdir();
        itemList = new ArrayList<String>();
        tShirtsFileList = f.listFiles();
        if(tShirtsFileList != null) {
            for (int i = 0; i < tShirtsFileList.length; i++) {
                itemList.add(tShirtsFileList[i].getPath());
            }
        }
    }

}
