package com.cq.xinyupintai.Presenter.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cq.xinyupintai.Presenter.Adapter.MyAdapter;
import com.cq.xinyupintai.R;
import com.xuexiang.xui.XUI;

import java.util.ArrayList;
import java.util.List;


public class ClosingStockActivity extends AppCompatActivity {
    private RecyclerView Cs_rcv;
    private MyAdapter mMyAdapter;
    private List<String> textInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        XUI.initTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closing_stock);
        Cs_rcv =  findViewById(R.id.rc_item);
        Cs_rcv.setLayoutManager(new LinearLayoutManager(this));
        Cs_rcv.setAdapter(new MyAdapter(ClosingStockActivity.this,TextInit()));
    }
    //测试用后期删除
    private List<String> TextInit() {
        List<String> text = new ArrayList<>();

        for(int i=0; i<20; ++i){
            String itemText = "";
            itemText = "测试第" + (i+1) + "条数据";
            text.add(itemText);
        }

        return text;
    }

}