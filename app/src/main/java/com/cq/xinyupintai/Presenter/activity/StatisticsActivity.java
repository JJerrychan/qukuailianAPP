package com.cq.xinyupintai.Presenter.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cq.xinyupintai.R;
import com.xuexiang.xui.XUI;
import com.xuexiang.xui.widget.textview.supertextview.SuperTextView;

public class StatisticsActivity extends AppCompatActivity {
    private SuperTextView tvClosingStock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        XUI.initTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        tvClosingStock=findViewById(R.id.stv_card_4);
        tvClosingStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StatisticsActivity.this,ClosingStockActivity.class);
                startActivity(intent);
            }
        });
    }
}