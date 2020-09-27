package com.cq.xinyupintai.Presenter.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cq.xinyupintai.Presenter.Adapter.CardAdapter;
import com.cq.xinyupintai.Presenter.activity.EditCard;
import com.cq.xinyupintai.R;
import com.xuexiang.xui.widget.button.ButtonView;

import java.util.ArrayList;
import java.util.List;

public class Card_Fragment extends Fragment implements View.OnClickListener {


    public static Card_Fragment newInstance() {
        Bundle args = new Bundle();
        Card_Fragment fragment = new Card_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButtonView add_btn = view.findViewById(R.id.add_card_btn);
        add_btn.setOnClickListener(this);
        RecyclerView rcCard = view.findViewById(R.id.rc_settle);
        rcCard.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcCard.setAdapter(new CardAdapter(getActivity(), TextInit()));
//        Button add_btn=view.findViewById(R.id.add_btn);
//        Button edit_btn=view.findViewById(R.id.edit_btn);
//        Button push_btn=view.findViewById(R.id.push_btn);
//        Button delete_btn=view.findViewById(R.id.delete_btn);
//        Button close_btn=view.findViewById(R.id.close_btn);
//        Button stop_btn=view.findViewById(R.id.stop_btn);
//        add_btn.setOnClickListener(this);
//        edit_btn.setOnClickListener(this);
//        push_btn.setOnClickListener(this);
//        delete_btn.setOnClickListener(this);
//        close_btn.setOnClickListener(this);
//        stop_btn.setOnClickListener(this);
    }

    //测试用后期删除
    private List<String> TextInit() {
        List<String> text = new ArrayList<>();

        for (int i = 0; i < 5; ++i) {
            String itemText = "";
            itemText = "00" + i + "/测试第" + (i + 1) + "张卡";
            text.add(itemText);
        }

        return text;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card, container, false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_card_btn:
                Intent intent = new Intent(getActivity(), EditCard.class);
                startActivity(intent);
                break;
        }
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.add_btn:
//                Intent intent = new Intent(getActivity(), EditCard.class);
//                startActivity(intent);
//                break;
//            case R.id.edit_btn:
//                Intent intent1 = new Intent(getActivity(), EditCard.class);
//                startActivity(intent1);
//                break;
//            case R.id.push_btn:
//                break;
//            case R.id.stop_btn:
//                break;
//            case R.id.close_btn:
//                break;
//            case R.id.delete_btn:
//                break;
//        }
//    }
}