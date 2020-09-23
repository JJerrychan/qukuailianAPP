package com.cq.xinyupintai.Presenter.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cq.xinyupintai.Presenter.activity.EditCard;
import com.cq.xinyupintai.Presenter.activity.MainView;
import com.cq.xinyupintai.Presenter.activity.register;
import com.cq.xinyupintai.R;
import com.xuexiang.xui.widget.button.ButtonView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Card_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Card_Fragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Card_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Card_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Card_Fragment newInstance(String param1, String param2) {
        Card_Fragment fragment = new Card_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButtonView add_btn = view.findViewById(R.id.add_card);
        add_btn.setOnClickListener(this);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card, container, false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_card:
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