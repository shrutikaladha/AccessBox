package com.accessbox.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.accessbox.R;
import com.accessbox.adapter.MainCategoryItemAdapter;
import com.accessbox.category.MainCategoryItem;
import com.accessbox.util.ListUtils;

import java.util.ArrayList;

/**
 * Created by shrutika on 30/3/16.
 */
public class MainCategoryFragment extends Fragment {

    RecyclerView mRecyclerView;
    Context mContext;
    ArrayList<MainCategoryItem> mainCategoryItemList;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_category_layout, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        ArrayList<MainCategoryItem> mainCategoryItemList = ListUtils.getMainCategoryItemList(mContext);
        setUpAdapter(mainCategoryItemList);
        return view;
    }


    private void setUpAdapter(ArrayList<MainCategoryItem> mainCategoryItemList) {
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        MainCategoryItemAdapter mainCategoryItemAdapter = new MainCategoryItemAdapter(mContext, mainCategoryItemList);
        mRecyclerView.setAdapter(mainCategoryItemAdapter);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        mRecyclerView.setItemAnimator(itemAnimator);
    }



    public void onMainCategoryItemAdded(Context mContext, MainCategoryItem mainCategoryItem) {
        ArrayList<MainCategoryItem> mainCategoryItemList = ListUtils.getMainCategoryItemList(mContext);
        mainCategoryItemList.add(mainCategoryItem);
    }

    public void onMainCategoryItemDeleted(Context context, int adapterPosition) {
        mContext = context;
        ArrayList<MainCategoryItem> mainCategoryItemList = ListUtils.getMainCategoryItemList(mContext);
        mainCategoryItemList.remove(adapterPosition);
    }
}
