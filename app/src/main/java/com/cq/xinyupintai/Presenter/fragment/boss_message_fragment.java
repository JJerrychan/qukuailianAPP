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

import com.cq.xinyupintai.Presenter.Adapter.MessageAdapter;
import com.cq.xinyupintai.R;

import java.util.ArrayList;
import java.util.List;

public class boss_message_fragment extends Fragment {
    public static boss_message_fragment newInstance(int index) {
        boss_message_fragment fragment = new boss_message_fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.message_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rcBossMessage = view.findViewById(R.id.rc_boss_2);
        rcBossMessage.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcBossMessage.setAdapter(new MessageAdapter(getActivity(), TextInit()));
    }

    private List<String> TextInit() {
        List<String> text = new ArrayList<>();

        for (int i = 0; i < 20; ++i) {
            String itemText = "";
            itemText = "测试第" + (i + 1) + "条信息";
            text.add(itemText);
        }

        return text;
    }
}
