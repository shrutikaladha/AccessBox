package com.accessbox.activity;

import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.accessbox.R;
import com.accessbox.adapter.ViewPagerAdapter;
import com.accessbox.dialog.AddCategoryDialogFragment;

public class HomePageActivity extends BaseActivity {

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    Toolbar toolbar;
    TabLayout tabLayout;
    FloatingActionButton fab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);

        setUpToolbar();
        setUpTabLayout();
        setUpViewPager();
        setStatusBarColor();
        setUpFab();
    }

    private void setUpViewPager() {
        viewPager = (ViewPager) findViewById(R.id.vpPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                // Floating action button is not visible in favorites and shortlist fragment
                if(tab.getPosition() == 1 || tab.getPosition() == 2) {
                    fab.setVisibility(View.GONE);
                } else {
                    fab.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpTabLayout() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("All"));
        tabLayout.addTab(tabLayout.newTab().setText("Favorites"));
        tabLayout.addTab(tabLayout.newTab().setText("Shortlist"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }

    private void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_title);
    }


    private void setStatusBarColor() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if(Build.VERSION.SDK_INT >= 21 )
            window.setStatusBarColor(this.getResources().getColor(R.color.theme_color));
    }


    private void setUpFab() {
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddCategoryDialog();
            }
        });
    }

    private void showAddCategoryDialog() {
        FragmentManager fragmentManager = getFragmentManager();
        AddCategoryDialogFragment categoryDialogFragment = new AddCategoryDialogFragment();
        categoryDialogFragment.show(fragmentManager, "Add_Category");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
