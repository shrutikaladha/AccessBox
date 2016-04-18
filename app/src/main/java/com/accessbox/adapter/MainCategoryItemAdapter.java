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
    private Context mContext;

    public MainCategoryItemAdapter(Context context, ArrayList<MainCategoryItem> itemList) {
        this.itemList = itemList;
        mContext = context;
    }

    @Override
    public MainCategoryRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_category_item_list_layout, parent, false);
        MainCategoryRecyclerViewHolder rcv = new MainCategoryRecyclerViewHolder(layoutView, mContext);
        return rcv;
    }

    @Override
    public void onBindViewHolder(MainCategoryRecyclerViewHolder holder, int position) {
        switch (position % 5) {
            case 0:
                holder.llMainView.setBackgroundColor(mContext.getResources().getColor(R.color.vibrant_color_1));
                itemList.get(position).setCategoryColor("@string/vibrant_color_1");
                break;
            case 1:
                holder.llMainView.setBackgroundColor(mContext.getResources().getColor(R.color.vibrant_color_2));
                itemList.get(position).setCategoryColor("@string/vibrant_color_2");
                break;
            case 2:
                holder.llMainView.setBackgroundColor(mContext.getResources().getColor(R.color.vibrant_color_3));
                itemList.get(position).setCategoryColor("@string/vibrant_color_3");
                break;
            case 3:
                holder.llMainView.setBackgroundColor(mContext.getResources().getColor(R.color.vibrant_color_4));
                itemList.get(position).setCategoryColor("@string/vibrant_color_4");
                break;
            case 4:
                holder.llMainView.setBackgroundColor(mContext.getResources().getColor(R.color.vibrant_color_5));
                itemList.get(position).setCategoryColor("@string/vibrant_color_5");
                break;

        }
        // holder.llMainView.setBackgroundColor(mContext.getResources().getColor(R.color.vibrant_color_1));
        holder.tvCategoryTitle.setText(itemList.get(position).getCategoryName());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
