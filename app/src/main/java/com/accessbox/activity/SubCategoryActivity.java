package com.accessbox.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.accessbox.R;
import com.accessbox.adapter.SubCategoryItemAdapter;
import com.accessbox.category.MainCategoryItem;
import com.accessbox.category.SubCategoryItem;
import com.accessbox.util.ListUtils;

import java.util.ArrayList;

/**
 * Created by shrutika on 24/3/16.
 */
public class SubCategoryActivity extends BaseActivity {
    SubCategoryItemAdapter mSubCategoryItemAdapter;
    MainCategoryItem mMainCategoryItem;
    private final int UPLOAD = 1;
    int position;
    ArrayList<SubCategoryItem> mSubCategoryItemList;
    RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category_layout);
        mMainCategoryItem = (MainCategoryItem) getIntent().getSerializableExtra("Category");
        position = getIntent().getIntExtra("position", 0);
        setCoverPhoto();
        setupFab();
        setUpAdapter();

    }

    private void setUpAdapter() {
        mSubCategoryItemList = new ArrayList<SubCategoryItem>();
        mSubCategoryItemList = ListUtils.getSubCategoryItemList(this,mMainCategoryItem.getCategoryName());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mSubCategoryItemAdapter = new SubCategoryItemAdapter(this, mSubCategoryItemList);
        mRecyclerView.setAdapter(mSubCategoryItemAdapter);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        mRecyclerView.setItemAnimator(itemAnimator);
    }

    private void setupFab() {
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SubCategoryActivity.this, SelectPhotosActivity.class);
                i.putExtra("CATEGORY_TYPE", mMainCategoryItem.getCategoryName());
                startActivityForResult(i, UPLOAD);
            }
        });
    }

    private void setCoverPhoto() {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        switch (position % 5) {
            case 0:
                collapsingToolbarLayout.setBackgroundColor(getResources().getColor(R.color.vibrant_color_1));
                break;
            case 1:
                collapsingToolbarLayout.setBackgroundColor(getResources().getColor(R.color.vibrant_color_2));
                break;
            case 2:
                collapsingToolbarLayout.setBackgroundColor(getResources().getColor(R.color.vibrant_color_3));
                break;
            case 3:
                collapsingToolbarLayout.setBackgroundColor(getResources().getColor(R.color.vibrant_color_4));
                break;
            case 4:
                collapsingToolbarLayout.setBackgroundColor(getResources().getColor(R.color.vibrant_color_5));
                break;
        }

        collapsingToolbarLayout.setTitle(mMainCategoryItem.getCategoryName());
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == UPLOAD) {
            if (resultCode == Activity.RESULT_OK) {
                ArrayList<SubCategoryItem> subCategoryItemList = (ArrayList<SubCategoryItem>) data.getSerializableExtra("selectedPath");
                ListUtils.addToCategory(this, mMainCategoryItem.getCategoryName(), subCategoryItemList);
                setUpAdapter();

            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(this, "Problem uploading images.", Toast.LENGTH_SHORT).show();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
