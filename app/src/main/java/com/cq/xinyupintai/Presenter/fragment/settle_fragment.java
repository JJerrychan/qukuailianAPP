package com.cq.xinyupintai.Presenter.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cq.xinyupintai.Presenter.Adapter.RcSettleAdapter;
import com.cq.xinyupintai.Presenter.Adapter.UserEvaAdapter;
import com.cq.xinyupintai.R;
import com.xuexiang.xui.XUI;
import com.xuexiang.xui.widget.textview.supertextview.SuperButton;
import com.xuexiang.xui.widget.textview.supertextview.SuperTextView;

import java.util.ArrayList;
import java.util.List;

public class settle_fragment extends Fragment {
    SuperButton sTvAdd;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settle_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sTvAdd=view.findViewById(R.id.bd_settle_add);
        RecyclerView rcSettle=view.findViewById(R.id.rc_settle);
        rcSettle.setLayoutManager(new LinearLayoutManager(getActivity()));
        final RcSettleAdapter myAdapter=new RcSettleAdapter(getActivity(),initData());
        rcSettle.setAdapter(myAdapter);
        sTvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter.addItem(1);
            }
        });
    }
    private ArrayList<Integer> initData() {
        ArrayList<Integer> mDatas = new ArrayList<Integer>();
        mDatas.add(0);
        return mDatas;
    }
    public static settle_fragment newInstance(int index) {
        settle_fragment fragment = new settle_fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        fragment.setArguments(bundle);
        return fragment;
    }
}
