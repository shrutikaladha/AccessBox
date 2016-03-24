package com.snapbox.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.snapbox.R;
import com.snapbox.adapter.GalleryViewPagerAdapter;
import com.snapbox.util.AppConstants;
import com.snapbox.util.ListUtils;

/**
 * Created by shrutika on 13/3/16.
 */
public class GalleryViewActivity extends Activity{

    private GalleryViewPagerAdapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_view_layout);
        viewPager = (ViewPager) findViewById(R.id.pager);

        Intent intent = getIntent();
        int position = intent.getIntExtra(AppConstants.position, 0);
        String category = intent.getStringExtra(AppConstants.categoryName);
        adapter = new GalleryViewPagerAdapter(GalleryViewActivity.this,
                ListUtils.getSubCategoryItemList(category));

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
    }
}
