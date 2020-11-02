package com.cq.xinyupintai.Presenter.Adapter;

import android.content.Context;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.cq.xinyupintai.Presenter.WebSocketTest;
import com.cq.xinyupintai.Presenter.fragment.User_eva_fragment;
import com.cq.xinyupintai.Presenter.fragment.boss_message_fragment;
import com.cq.xinyupintai.data.model.RequestPackage;
import com.cq.xinyupintai.data.model.RespondPackage;

public class messagePageAdapter extends FragmentPagerAdapter {
    private WebSocketTest wstest = WebSocketTest.getInstance();
    private RequestPackage messagePageReq =new RequestPackage();
    private RespondPackage messagePageRsp =new RespondPackage();
    private Context mContext;

    public messagePageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    public messagePageAdapter(FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager, tabCount);
        messagePageReq.setReqCode("B003001");
        wstest.sendData(messagePageReq);
        messagePageRsp = wstest.getRespondPackage();
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

    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "评价";
            case 1:
                return "消息";
            default:
                return null;
        }
    }

}
