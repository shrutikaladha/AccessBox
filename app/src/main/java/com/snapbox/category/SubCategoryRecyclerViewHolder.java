package com.snapbox.category;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.snapbox.R;
import com.snapbox.activity.GalleryViewActivity;

/**
 * Created by shrutika on 24/3/16.
 */
public class SubCategoryRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView ivCategory;
    public Context mContext;
    private String categoryName;

    public SubCategoryRecyclerViewHolder(View itemView, Context context, String categoryName) {
        super(itemView);
        itemView.setOnClickListener(this);
        ivCategory = (ImageView) itemView.findViewById(R.id.ivCategory);
        mContext = context;
        this.categoryName = categoryName;
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(mContext, GalleryViewActivity.class);
        intent.putExtra("position", getAdapterPosition());
        intent.putExtra("category", categoryName);
        mContext.startActivity(intent);
    }
}
