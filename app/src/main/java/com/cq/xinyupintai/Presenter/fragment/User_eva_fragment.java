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

import com.cq.xinyupintai.Presenter.Adapter.UserEvaAdapter;
import com.cq.xinyupintai.R;
import com.xuexiang.xui.XUI;

import java.util.ArrayList;
import java.util.List;

public class User_eva_fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.message_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rcBossEva=view.findViewById(R.id.rc_boss_2);
        rcBossEva.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcBossEva.setAdapter(new UserEvaAdapter(getActivity(),TextInit()));
    }
    //测试用后期删除
    private List<String> TextInit() {
        List<String> text = new ArrayList<>();

        for(int i=0; i<20; ++i){
            String itemText = "";
            itemText = "测试第" + (i+1) + "条评语";
            text.add(itemText);
        }
        return text;
    }
    public static User_eva_fragment newInstance(int index) {
        User_eva_fragment fragment = new User_eva_fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        fragment.setArguments(bundle);
        return fragment;
    }
}
