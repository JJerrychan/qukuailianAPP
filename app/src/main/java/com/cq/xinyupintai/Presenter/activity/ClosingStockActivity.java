package com.cq.xinyupintai.Presenter.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cq.xinyupintai.Presenter.Adapter.MyAdapter;
import com.cq.xinyupintai.R;
import com.xuexiang.xui.XUI;
import com.xuexiang.xui.utils.SnackbarUtils;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.xuexiang.xui.widget.searchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;


public class ClosingStockActivity extends AppCompatActivity {
    private RecyclerView Cs_rcv;
    private MyAdapter mMyAdapter;
    private List<String> textInfos;
    private MaterialSearchView mSearchView;
    private TitleBar mTitleBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        XUI.initTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closing_stock);
        Cs_rcv = findViewById(R.id.rc_item);
        Cs_rcv.setLayoutManager(new LinearLayoutManager(this));
        Cs_rcv.setAdapter(new MyAdapter(ClosingStockActivity.this, TextInit()));

        mTitleBar=findViewById(R.id.title_bar_1);
        mSearchView=findViewById(R.id.searchview_stock);
        mTitleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ClosingStockActivity.this,StatisticsActivity.class);
                startActivity(intent);
                finish();
            }
        }).addAction(new TitleBar.ImageAction(R.mipmap.search) {
            @Override
            public void performAction(View view) {
                mSearchView.showSearch();
            }
        });
        mSearchView.setVoiceSearch(false);
        mSearchView.setEllipsize(true);

        //查询监听
        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                SnackbarUtils.Long(mSearchView, "Query: " + query).show();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });
        
        //开关监听
        mSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }
            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });
        mSearchView.setSubmitOnClick(true);
    }
    //测试用后期删除
    private List<String> TextInit() {
        List<String> text = new ArrayList<>();

        for (int i = 0; i < 20; ++i) {
            String itemText = "";
            itemText = "第" + (i + 1) + "号营业员";
            text.add(itemText);
        }

        return text;
    }

}