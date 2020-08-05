package com.cq.xinyupintai.Presenter.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cq.xinyupintai.R;
import com.xuexiang.xui.XUI;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        XUI.initTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
    }
}