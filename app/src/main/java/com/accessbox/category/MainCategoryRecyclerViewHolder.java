package com.accessbox.category;

import android.content.Context;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.accessbox.R;
import com.accessbox.activity.SubCategoryActivity;
import com.accessbox.util.ListUtils;

/**
 * Created by shrutika on 12/3/16.
 */
public class MainCategoryRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvCategoryTitle;
    public ImageView ivCategory;
    public LinearLayout llMainView;
    public Context mContext;

    public MainCategoryRecyclerViewHolder(View itemView, Context context) {
        super(itemView);
        itemView.setOnClickListener(this);
        llMainView = (LinearLayout) itemView.findViewById(R.id.ll_main_view);
        tvCategoryTitle = (TextView) itemView.findViewById(R.id.tv_category_title);
        ivCategory = (ImageView) itemView.findViewById(R.id.iv_category);
        mContext = context;
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(mContext, SubCategoryActivity.class);
        intent.putExtra("Category", ListUtils.getMainCategoryItemList(mContext).get(getAdapterPosition()));
        intent.putExtra("position", getAdapterPosition());
        mContext.startActivity(intent);
    }
}