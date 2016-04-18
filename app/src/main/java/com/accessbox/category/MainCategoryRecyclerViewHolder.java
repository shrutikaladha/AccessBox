package com.accessbox.category;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.accessbox.R;
import com.accessbox.activity.SubCategoryActivity;
import com.accessbox.fragment.MainCategoryFragment;
import com.accessbox.util.ListUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by shrutika on 12/3/16.
 */
public class MainCategoryRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvCategoryTitle;
    private TextView tvCategoryDesc;
    private ImageView ivCategory;
    public LinearLayout llMainView;
    private Context mContext;
    private ImageView ivDelete;

    public MainCategoryRecyclerViewHolder(View itemView, Context context) {
        super(itemView);
        llMainView = (LinearLayout) itemView.findViewById(R.id.ll_main_view);
        tvCategoryTitle = (TextView) itemView.findViewById(R.id.tv_category_title);
        tvCategoryDesc = (TextView) itemView.findViewById(R.id.tv_category_desc);
        ivCategory = (ImageView) itemView.findViewById(R.id.iv_category);
        ivDelete = (ImageView) itemView.findViewById(R.id.iv_delete);
        itemView.setOnClickListener(this);
        ivDelete.setOnClickListener(this);
        mContext = context;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_delete:
                showDeleteCategoryDialog();
                break;


            case R.id.card_view:
                Intent intent = new Intent(mContext, SubCategoryActivity.class);
                intent.putExtra("Category", ListUtils.getMainCategoryItemList(mContext).get(getAdapterPosition()));
                intent.putExtra("position", getAdapterPosition());
                mContext.startActivity(intent);
                break;
        }

    }

    private void showDeleteCategoryDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        dialogBuilder.setTitle("Delete Category");
        dialogBuilder.setMessage("Are you sure you want to delete?");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                MainCategoryFragment mainCategoryFragment = new MainCategoryFragment();
                mainCategoryFragment.onMainCategoryItemDeleted(getAdapterPosition());
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }
}