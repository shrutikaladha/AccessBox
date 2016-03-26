package com.accessbox.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.accessbox.R;
import com.accessbox.adapter.SubCategoryItemAdapter;
import com.accessbox.category.MainCategoryItem;
import com.accessbox.util.ListUtils;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by shrutika on 24/3/16.
 */
public class SubCategoryActivity extends BaseActivity {
    SubCategoryItemAdapter subCategoryItemAdapter;
    MainCategoryItem mainCategoryItem;
    private final int UPLOAD = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_category_activity_layout);
        mainCategoryItem = (MainCategoryItem) getIntent().getSerializableExtra("Category");
        setCoverPhoto();
        setupFab();
        ArrayList<String> commonItemArrayList = new ArrayList<String>();
        commonItemArrayList = ListUtils.getSubCategoryItemList(mainCategoryItem.getCategoryName());
        subCategoryItemAdapter = new SubCategoryItemAdapter(this, commonItemArrayList,mainCategoryItem.getCategoryName());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(subCategoryItemAdapter);
    }

    private void setupFab() {
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SubCategoryActivity.this, SelectPhotosActivity.class);
                i.putExtra("CATEGORY_TYPE", mainCategoryItem.getCategoryName());
                startActivityForResult(i, UPLOAD);
            }
        });
    }

    private void setCoverPhoto() {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setBackground(getResources().getDrawable(mainCategoryItem.getCategoryImg()));
        collapsingToolbarLayout.setTitle(mainCategoryItem.getCategoryName());
    }

    private void scanFile(String path) {
        File file = new File(path);
        Uri imageUri = Uri.fromFile(file);
        MediaScannerConnection.scanFile(this, new String[]{imageUri.getPath()}, null,
                new MediaScannerConnection.OnScanCompletedListener() {
                    @Override
                    public void onScanCompleted(String path, Uri uri) {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                ListUtils.setSubCategoryItemList(mainCategoryItem.getCategoryName());
                            }
                        });
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == UPLOAD) {
            if (resultCode == Activity.RESULT_OK) {
                scanFile(ListUtils.getCurrentPath(mainCategoryItem.getCategoryName()));
            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(this, "Problem uploading images.", Toast.LENGTH_SHORT).show();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
