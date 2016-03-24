package com.snapbox.activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.snapbox.R;
import com.snapbox.adapter.MainCategoryItemAdapter;
import com.snapbox.category.MainCategoryItem;
import com.snapbox.dialog.CategoryDialogFragment;
import com.snapbox.util.ListUtils;

import java.util.ArrayList;

public class MainCategoryActivity extends SnapboxBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_category_activity_layout);
        ListUtils.setMainCategoryItems("female");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setCoverPhoto();
        setUpFab();
        setUpList();
    }

    private void setUpList() {
        ArrayList<MainCategoryItem> mainCategoryItemList = ListUtils.getMainCategoryItemList();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        MainCategoryItemAdapter mainCategoryItemAdapter = new MainCategoryItemAdapter(this, mainCategoryItemList);
        recyclerView.setAdapter(mainCategoryItemAdapter);
    }

    private void setUpFab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddCategoryDialog();
            }
        });
    }

    private void showAddCategoryDialog() {
        FragmentManager fragmentManager = getFragmentManager();
        CategoryDialogFragment categoryDialogFragment = new CategoryDialogFragment();
        categoryDialogFragment.show(fragmentManager, "Add_Category");
    }

    private void setCoverPhoto() {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setBackground(getResources().getDrawable(R.drawable.cover_category));
        collapsingToolbarLayout.setTitle("");
    }

    @Override
    protected void onDestroy() {
        ListUtils.setMainCategoryItems("clear");
        super.onDestroy();
    }


}
