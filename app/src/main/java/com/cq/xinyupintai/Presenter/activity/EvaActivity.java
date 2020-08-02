package com.cq.xinyupintai.Presenter.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cq.xinyupintai.R;
import com.xuexiang.xui.XUI;

public class EvaActivity extends AppCompatActivity {
    private Button ensure;
    private  Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        XUI.initTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eva);
        ensure =findViewById(R.id.rb_require_ensure);
        cancel=findViewById(R.id.rb_require_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ensure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(EvaActivity.this,"回复成功",Toast.LENGTH_LONG);
                toast.show();
                finish();
            }
        });
    }
}