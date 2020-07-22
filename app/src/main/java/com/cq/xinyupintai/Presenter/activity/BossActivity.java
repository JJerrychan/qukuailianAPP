package com.cq.xinyupintai.Presenter.activity;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;


import com.cq.xinyupintai.Presenter.fragment.boss_home_fragment;

import com.cq.xinyupintai.Presenter.fragment.setting_fragment;
import com.cq.xinyupintai.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

class PageAdapter extends FragmentPagerAdapter {
    private Context mContext;
    public PageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return boss_home_fragment.newInstance(position);
            case 1:
                return setting_fragment.newInstance(position);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}

public class BossActivity extends AppCompatActivity {
    private ViewPager vp;
    private BottomNavigationView bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boss);
        vp=findViewById(R.id.vp);
        bnv=findViewById(R.id.bottomNavigation);
        vp.setAdapter(new PageAdapter(BossActivity.this,getSupportFragmentManager()));
        bnv.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                int menuId = menuItem.getItemId();
                switch (menuId) {
                    case R.id.message:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.settle:
                        vp.setCurrentItem(3);
                        break;
                }
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