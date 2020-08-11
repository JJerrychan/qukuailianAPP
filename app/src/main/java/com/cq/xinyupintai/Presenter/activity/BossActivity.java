package com.cq.xinyupintai.Presenter.activity;


import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.cq.xinyupintai.Presenter.Adapter.PageAdapter;
import com.cq.xinyupintai.Presenter.fragment.Card_Fragment;
import com.cq.xinyupintai.Presenter.fragment.boss_home_fragment;
import com.cq.xinyupintai.Presenter.fragment.setting_fragment;
import com.cq.xinyupintai.Presenter.fragment.settle_fragment;
import com.cq.xinyupintai.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.xuexiang.xui.XUI;

import java.util.ArrayList;

public class BossActivity extends AppCompatActivity {
    private ViewPager vp;
    private BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        XUI.initTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boss);
        vp = findViewById(R.id.vp);
        bnv = findViewById(R.id.bottomNavigation);
        vp.setAdapter(new PageAdapter(BossActivity.this, getSupportFragmentManager()));
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int menuId = menuItem.getItemId();
                switch (menuId) {
                    case R.id.message:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.settle:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.pocket:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.setting:
                        vp.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                //将滑动到的页面对应的 menu 设置为选中状态
                bnv.getMenu().getItem(i).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}