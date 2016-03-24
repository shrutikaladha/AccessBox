package com.snapbox.dialog;


import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.snapbox.R;
import com.snapbox.category.MainCategoryItem;
import com.snapbox.util.ListUtils;

/**
 * Created by shrutika on 13/3/16.
 */
public class CategoryDialogFragment extends DialogFragment {

    private EditText etCategoryName;
    private EditText etShortNote;
    private Button btnCreate;

    public CategoryDialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_category_dialog_layout, container);
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
                if(name == null) {
                    etCategoryName.setError("Name cannot be empty");
                } else {
                    MainCategoryItem mainCategoryItem = new MainCategoryItem(name, name);
                    ListUtils.addCategory(mainCategoryItem);
                    dismiss();
                }

            }
        });
        etCategoryName.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }
}
