package com.accessbox.dialog;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.accessbox.R;

/**
 * Created by shrutika on 16/4/16.
 */
public class DeleteCategoryDialogFragment extends DialogFragment{
    public Activity c;
    private TextView tvYes;
    private TextView tvNo;

    public DeleteCategoryDialogFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_main_category_delete,null);
      /*  tvYes = (TextView) view.findViewById(R.id.tv_yes);
        tvNo = (TextView) view.findViewById(R.id.tv_no);*/
        return super.onCreateView(inflater, container, savedInstanceState);
    }


}
