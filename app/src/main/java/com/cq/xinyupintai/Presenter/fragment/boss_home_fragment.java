package com.cq.xinyupintai.Presenter.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import com.cq.xinyupintai.Presenter.Adapter.RcBossHomeAdapter;
import com.cq.xinyupintai.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


class messagePageAdapter extends FragmentPagerAdapter {
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
                return boss_message_fragment.newInstance(position);
            case 1:
                return User_eva_fragment.newInstance(position);
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
                return "顾客评价";
            case 1:
                return "消息";
            default:
                return null;
        }
    }

}

public class boss_home_fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.boss_home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout1=view.findViewById(R.id.tb_boss_1);
        ViewPager viewPager = view.findViewById(R.id.vp_boss_1);
/*
        RecyclerView rcvBossHome=view.findViewById(R.id.rc_boss_1);
        rcvBossHome.setLayoutManager (new GridLayoutManager(getActivity(),3));
        rcvBossHome.setAdapter(new RcBossHomeAdapter(getActivity(),TextInit()));
 */
        //设置adapter
        viewPager.setAdapter(new messagePageAdapter(getChildFragmentManager(), tabLayout1.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));
        tabLayout1.setupWithViewPager(viewPager);
    }
/*
    private List<String> TextInit() {
        List<String> text = new ArrayList<>();
        text.add("收入");
        text.add("使用人数");
        text.add("售出数");
        return text;
    }
 */


    public static boss_home_fragment newInstance(int index) {
        boss_home_fragment fragment = new boss_home_fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        fragment.setArguments(bundle);
        return fragment;
    }
}
