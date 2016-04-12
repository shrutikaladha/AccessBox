package com.accessbox.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.accessbox.R;
import com.accessbox.adapter.SubCategoryItemAdapter;
import com.accessbox.category.SubCategoryItem;
import com.accessbox.util.ListUtils;
import com.accessbox.util.Utils;

import java.util.ArrayList;

/**
 * Created by shrutika on 30/3/16.
 */
public class ShortlistFragment extends Fragment {
    RecyclerView recyclerView;
    Context mContext;

    @Override
    public void onAttach(Context context) {
        mContext = context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_category_layout, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        setUpList();
        return view;
    }

    private void setUpList() {
        ArrayList<SubCategoryItem> shortlistItemList = new ArrayList<SubCategoryItem>();
        shortlistItemList = ListUtils.getSubCategoryItemList(mContext, "Shortlist");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        SubCategoryItemAdapter subCategoryItemAdapter = new SubCategoryItemAdapter(mContext, shortlistItemList);
        recyclerView.setAdapter(subCategoryItemAdapter);
    }
}
