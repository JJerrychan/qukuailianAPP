package com.cq.xinyupintai.Presenter.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cq.xinyupintai.Presenter.Adapter.RcSettleAdapter;
import com.cq.xinyupintai.Presenter.Adapter.UserEvaAdapter;
import com.cq.xinyupintai.R;
import com.cq.xinyupintai.data.model.checkout;
import com.xuexiang.xui.XUI;
import com.xuexiang.xui.widget.button.shadowbutton.ShadowButton;
import com.xuexiang.xui.widget.edittext.materialedittext.MaterialEditText;
import com.xuexiang.xui.widget.popupwindow.easypopup.EasyPopup;
import com.xuexiang.xui.widget.popupwindow.easypopup.HorizontalGravity;
import com.xuexiang.xui.widget.popupwindow.easypopup.VerticalGravity;
import com.xuexiang.xui.widget.textview.supertextview.SuperButton;
import com.xuexiang.xui.widget.textview.supertextview.SuperTextView;

import java.util.ArrayList;
import java.util.List;

public class settle_fragment extends Fragment {
    SuperButton sTvAdd;
    MaterialEditText materialEditText;
    checkout data;
    List<checkout> datalist;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settle_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sTvAdd = view.findViewById(R.id.bd_settle_add);

        RecyclerView rcSettle = view.findViewById(R.id.rc_settle);
        rcSettle.setLayoutManager(new LinearLayoutManager(getActivity()));
        final RcSettleAdapter myAdapter = new RcSettleAdapter(getActivity(), initData());
        rcSettle.setAdapter(myAdapter);
        //popwindow定义
        EasyPopup mCirclePop = new EasyPopup(getContext())
                .setContentView(R.layout.popwindow_settle, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .setFocusAndOutsideEnable(true)
                .createPopup();

        sTvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置弹出popwindow
                mCirclePop.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        //popwindow销毁还原
                        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
                        lp.alpha = 1.0f;
                        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                        getActivity().getWindow().setAttributes(lp);
                    }
                });
                //设置popwindow背影遮罩
                WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
                lp.alpha = 0.3f;
                getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                getActivity().getWindow().setAttributes(lp);
                mCirclePop.showAtLocation(getView(), Gravity.BOTTOM, 0, 0);
            }
        });
        MaterialEditText Met1=mCirclePop.getView(R.id.ed_commdity_name);
        MaterialEditText Met2=mCirclePop.getView(R.id.ed_commdity_number);
        MaterialEditText Met3=mCirclePop.getView(R.id.ed_commdity_yuan);
        materialEditText=view.findViewById(R.id.ed_settle_money);
        materialEditText.setFocusable(false);
        Button mbSure=mCirclePop.getView(R.id.mb_1);
        mbSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=new checkout(Met1.getText().toString(),Met2.getText().toString(),Met3.getText().toString());
                myAdapter.addItem(myAdapter.getItemCount(),data);
                materialEditText.setText(myAdapter.totalNumber());
                mCirclePop.onDismiss();
            }
        });

    }

    private ArrayList<checkout> initData() {
        ArrayList<checkout> mDatas = new ArrayList<checkout>();
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
