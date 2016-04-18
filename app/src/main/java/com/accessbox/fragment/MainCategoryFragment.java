package com.accessbox.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

    RecyclerView recyclerView;
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
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        ArrayList<MainCategoryItem> mainCategoryItemList = ListUtils.getMainCategoryItemList(mContext);
        setUpAdapter(mainCategoryItemList);
        return view;
    }


    private void setUpAdapter(ArrayList<MainCategoryItem> mainCategoryItemList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        MainCategoryItemAdapter mainCategoryItemAdapter = new MainCategoryItemAdapter(mContext, mainCategoryItemList);
        recyclerView.setAdapter(mainCategoryItemAdapter);
    }



    public void onMainCategoryItemAdded(MainCategoryItem mainCategoryItem) {
        ArrayList<MainCategoryItem> mainCategoryItemList = ListUtils.getMainCategoryItemList(getActivity());
        mainCategoryItemList.add(mainCategoryItem);
        setUpAdapter(mainCategoryItemList);
    }

    public void onMainCategoryItemDeleted(int adapterPosition) {
        ArrayList<MainCategoryItem> mainCategoryItemList = ListUtils.getMainCategoryItemList(getActivity());
        mainCategoryItemList.remove(adapterPosition);
        setUpAdapter(mainCategoryItemList);
    }
}
