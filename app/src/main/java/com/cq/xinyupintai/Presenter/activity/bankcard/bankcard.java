package com.cq.xinyupintai.Presenter.activity.bankcard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.cq.xinyupintai.R;

public class bankcard extends Activity implements View.OnClickListener{

    private Button buttoncard;

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bankcard);

        listView = findViewById(R.id.listView);
        listView.setAdapter(new bankcardlistview(bankcard.this));


        buttoncard = findViewById(R.id.addcard);
        buttoncard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bankcard.this,addbankcard.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}