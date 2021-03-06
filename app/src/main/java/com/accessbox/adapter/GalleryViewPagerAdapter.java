package com.accessbox.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.accessbox.R;
import com.accessbox.category.SubCategoryItem;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by shrutika on 13/3/16.
 */
public class GalleryViewPagerAdapter extends PagerAdapter {
    private Activity activity;
    private ArrayList<SubCategoryItem> subCategoryItemList;
    private LayoutInflater inflater;
    private ImageLoader imageLoader = ImageLoader.getInstance();

    // constructor
    public GalleryViewPagerAdapter(Activity activity, ArrayList<SubCategoryItem> subCategoryItemList) {
        this.activity = activity;
        this.subCategoryItemList = subCategoryItemList;
    }

    @Override
    public int getCount() {
        return subCategoryItemList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imgDisplay;
        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.gallery_view_pager_layout, container,
                false);

        imgDisplay = (ImageView) viewLayout.findViewById(R.id.imgDisplay);
        imageLoader.displayImage("file://" + subCategoryItemList.get(position).getImgPath(),imgDisplay);

        /*BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = BitmapFactory.decodeFile(subCategoryItemList.get(position).getImgPath(), options);
        imgDisplay.setImageBitmap(bitmap);*/

        ((ViewPager) container).addView(viewLayout);

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);


    }
}
