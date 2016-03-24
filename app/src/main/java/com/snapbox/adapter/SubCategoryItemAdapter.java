package com.snapbox.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snapbox.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.snapbox.category.SubCategoryRecyclerViewHolder;

import java.util.ArrayList;

/**
 * Created by shrutika on 11/3/16.
 */
public class SubCategoryItemAdapter extends RecyclerView.Adapter<SubCategoryRecyclerViewHolder> {

    ArrayList<String> itemList;
    LayoutInflater mInflater;
    Context mContext;
    public ImageLoader imageLoader = ImageLoader.getInstance();
    private DisplayImageOptions options;
    private String viewType;
    public String categoryName;

    public SubCategoryItemAdapter(Context context, ArrayList<String> imageList, String categoryName) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        itemList = new ArrayList<String>();
        this.itemList = imageList;
        this.viewType = viewType;
        this.categoryName=categoryName;
        options = new DisplayImageOptions.Builder().cacheInMemory().cacheOnDisc().build();
        imageLoader.init(ImageLoaderConfiguration.createDefault(mContext));
    }


    @Override
    public SubCategoryRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_category_item_layout, parent, false);
        SubCategoryRecyclerViewHolder rcv = new SubCategoryRecyclerViewHolder(layoutView, mContext,categoryName);
        return rcv;
    }

    @Override
    public void onBindViewHolder(SubCategoryRecyclerViewHolder holder, int position) {
        imageLoader.displayImage("file://"+itemList.get(position), holder.ivCategory);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
