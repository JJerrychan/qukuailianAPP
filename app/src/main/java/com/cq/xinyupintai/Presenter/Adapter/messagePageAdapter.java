package com.cq.xinyupintai.Presenter.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.cq.xinyupintai.Presenter.fragment.User_eva_fragment;
import com.cq.xinyupintai.Presenter.fragment.boss_message_fragment;

public class  messagePageAdapter extends FragmentPagerAdapter {
    private Context mContext;
    public messagePageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    public messagePageAdapter(FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager, tabCount);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return User_eva_fragment.newInstance(position);
            case 1:
                return boss_message_fragment.newInstance(position);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "评价";
            case 1:
                return "消息";
            default:
                return null;
        }
    }

}
