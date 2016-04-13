package com.accessbox.dialog;


import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.accessbox.R;
import com.accessbox.category.MainCategoryItem;
import com.accessbox.fragment.MainCategoryFragment;
import com.accessbox.util.ListUtils;

import javax.security.auth.callback.Callback;

/**
 * Created by shrutika on 13/3/16.
 */
public class CategoryDialogFragment extends DialogFragment {

    private EditText etCategoryName;
    private EditText etShortNote;
    private Button btnCreate;
    private Context mContext;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    public CategoryDialogFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_add_category_layout, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        etCategoryName = (EditText) view.findViewById(R.id.etCategoryName);
        etShortNote = (EditText) view.findViewById(R.id.etShortNote);
        btnCreate = (Button) view.findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = String.valueOf(etCategoryName.getText());
                String desc = String.valueOf(etShortNote.getText());
                if (name == null) {
                    etCategoryName.setError("Name cannot be empty");
                } else {
                    MainCategoryItem mainCategoryItem = new MainCategoryItem(name, desc);
                    ListUtils.addCategory(mContext, mainCategoryItem);
                    MainCategoryFragment mainCategoryFragment = new MainCategoryFragment();
                    mainCategoryFragment.onMainCategoryItemAdded();
                    dismiss();
                }

            }
        });
        etCategoryName.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }
}
