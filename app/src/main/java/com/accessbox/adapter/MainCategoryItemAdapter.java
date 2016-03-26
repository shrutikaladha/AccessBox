package com.accessbox.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.accessbox.R;
import com.accessbox.category.MainCategoryItem;
import com.accessbox.category.MainCategoryRecyclerViewHolder;

import java.util.ArrayList;

/**
 * Created by shrutika on 11/3/16.
 */
public class MainCategoryItemAdapter extends RecyclerView.Adapter<MainCategoryRecyclerViewHolder> {
    private ArrayList<MainCategoryItem> itemList;
    private Context context;

    public MainCategoryItemAdapter(Context context, ArrayList<MainCategoryItem> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public MainCategoryRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_category_item_layout, parent, false);
        MainCategoryRecyclerViewHolder rcv = new MainCategoryRecyclerViewHolder(layoutView, context);
        return rcv;
    }

    @Override
    public void onBindViewHolder(MainCategoryRecyclerViewHolder holder, int position) {
        holder.tvCategoryTitle.setText(itemList.get(position).getCategoryName());
        holder.ivCategory.setImageResource(itemList.get(position).getCategoryImg());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
