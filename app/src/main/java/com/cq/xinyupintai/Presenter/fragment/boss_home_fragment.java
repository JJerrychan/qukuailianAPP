package com.cq.xinyupintai.Presenter.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.cq.xinyupintai.Presenter.Adapter.RcBossHomeAdapter;
import com.cq.xinyupintai.Presenter.Adapter.messagePageAdapter;
import com.cq.xinyupintai.Presenter.WebSocketTest;
import com.cq.xinyupintai.R;
import com.cq.xinyupintai.data.Object2Map;
import com.cq.xinyupintai.data.model.RequestPackage;
import com.cq.xinyupintai.data.model.RespondPackage;
import com.cq.xinyupintai.data.model.statistic;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class boss_home_fragment extends Fragment  {
    private WebSocketTest wstest=WebSocketTest.getInstance();
    private RespondPackage datarespond = new  RespondPackage();
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
        RecyclerView rcvBossHome=view.findViewById(R.id.rc_boss_1);

        rcvBossHome.setLayoutManager (new GridLayoutManager(getActivity(),3));
        rcvBossHome.setAdapter(new RcBossHomeAdapter(getActivity(),Datainit()));
        //设置adapter
        viewPager.setAdapter(new messagePageAdapter(getChildFragmentManager(), tabLayout1.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));
        tabLayout1.setupWithViewPager(viewPager);
    }

    private List<statistic> Datainit() {
        List<statistic> data = new ArrayList<>();
        datarespond=wstest.getRespondPackage();
        if(WebSocketTest.getmCurrentStatus()==0){
            data.add(new statistic("日收入",datarespond.getdata().get("Income_d").toString()));
            data.add(new statistic("使用人数",datarespond.getdata().get("Income_m").toString()));
            data.add(new statistic("售出数",datarespond.getdata().get("Income_y").toString()));
        }
        else{
            data.add(new statistic("日收入","100"));
            data.add(new statistic("月收入","100"));
            data.add(new statistic("年收入","100"));
        }
        return data;
    }



    public static boss_home_fragment newInstance(int index) {
        boss_home_fragment fragment = new boss_home_fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        fragment.setArguments(bundle);
        return fragment;
    }
}
