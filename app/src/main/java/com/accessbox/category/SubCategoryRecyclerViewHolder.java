package com.accessbox.category;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.accessbox.R;
import com.accessbox.activity.GalleryViewActivity;
import com.accessbox.util.ListUtils;
import com.accessbox.util.Utils;

import java.util.ArrayList;

/**
 * Created by shrutika on 24/3/16.
 */
public class SubCategoryRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView ivCategory;
    private Context mContext;
    private String categoryName;
    private ImageView ivMoreOptions;
    private ArrayList<SubCategoryItem> subCategoryItemsList;

    public SubCategoryRecyclerViewHolder(View itemView, Context context, String categoryName) {
        super(itemView);
        itemView.setOnClickListener(this);
        ivCategory = (ImageView) itemView.findViewById(R.id.ivCategory);
        ivMoreOptions = (ImageView) itemView.findViewById(R.id.iv_more_options);
        ivMoreOptions.setOnClickListener(this);
        mContext = context;
        this.categoryName = categoryName;
        subCategoryItemsList = ListUtils.getSubCategoryItemList(categoryName);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_more_options:
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(mContext, ivMoreOptions);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_sub_category_item, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_favorite:
                                Utils.addToFavorites(subCategoryItemsList.get(getAdapterPosition()));
                                break;
                            case R.id.action_shortlist:
                                Utils.addToShortlist(subCategoryItemsList.get(getAdapterPosition()));
                                break;
                            case R.id.action_share:
                                shareIt();
                                break;
                            case R.id.action_delete:
                                break;

                        }
                        Toast.makeText(mContext, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popup.show();//showing popup menu

                break;
            case R.id.card_view:
                Intent intent = new Intent(mContext, GalleryViewActivity.class);
                intent.putExtra("position", getAdapterPosition());
                intent.putExtra("category", categoryName);
                mContext.startActivity(intent);
                break;

        }

    }

    private void shareIt() {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        Uri screenshotUri = Uri.parse(String.valueOf(subCategoryItemsList.get(getAdapterPosition())));
        sharingIntent.setType("image/jpeg");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
        mContext.startActivity(Intent.createChooser(sharingIntent, "Share image using"));
    }
}
