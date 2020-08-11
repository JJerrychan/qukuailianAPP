package com.cq.xinyupintai.Presenter.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.cq.xinyupintai.Presenter.fragment.Card_Fragment;
import com.cq.xinyupintai.Presenter.fragment.boss_home_fragment;
import com.cq.xinyupintai.Presenter.fragment.setting_fragment;
import com.cq.xinyupintai.Presenter.fragment.settle_fragment;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {
    final ArrayList<Fragment> fgLists = new ArrayList<>(4);
    private Context mContext;

    public PageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        fgLists.add(new boss_home_fragment());
        fgLists.add(new settle_fragment());
        fgLists.add(new Card_Fragment());
        fgLists.add(new setting_fragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fgLists.get(position);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
