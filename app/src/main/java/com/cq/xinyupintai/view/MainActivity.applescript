package com.example.quproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv1;
    private EditText editinput;
    private EditText etpassword;
    private boolean isHideFirst = true;
    private ImageView inputclear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initview();
        initListerner();



        tv1 = findViewById(R.id.newuser);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,registerActivity.class);
                startActivity(intent);
            }
        });

        etpassword = (EditText) findViewById(R.id.password);

        final Drawable[] drawables = etpassword.getCompoundDrawables();
        final int eyeWidth = drawables[2].getBounds().width();// 眼睛图标的宽度
        final Drawable drawableEyeOpen = getResources().getDrawable(R.mipmap.open_eye);

        drawableEyeOpen.setBounds(drawables[2].getBounds());//这一步不能省略

        etpassword.setOnTouchListener(new View.OnTouchListener() {

                                         @Override
                                         public boolean onTouch(View v, MotionEvent event) {


                                             if (event.getAction() == MotionEvent.ACTION_UP) {
                                                 float et_pwdMinX = v.getWidth() - eyeWidth - etpassword.getPaddingRight();
                                                 float et_pwdMaxX = v.getWidth();
                                                 float et_pwdMinY = 0;
                                                 float et_pwdMaxY = v.getHeight();
                                                 float x = event.getX();
                                                 float y = event.getY();

                                                 if (x < et_pwdMaxX && x > et_pwdMinX && y > et_pwdMinY && y < et_pwdMaxY) {
                                                     // 点击了眼睛图标的位置
                                                     isHideFirst = !isHideFirst;

                                                     if (isHideFirst) {
                                                         etpassword.setCompoundDrawables(null, null, drawables[2], null);
                                                         etpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

                                                     } else {
                                                         etpassword.setCompoundDrawables(null, null, drawableEyeOpen, null);
                                                         etpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                                                     }
                                                 }
                                             }
                                             return false;
                                         }

                                     }

        );
    }


    private void initview(){
        inputclear = findViewById(R.id.clearn);
        editinput = findViewById(R.id.user);

    }

    private void initListerner(){
        editinput.addTextChangedListener(textWatcher);
        inputclear.setOnClickListener(this);

    }
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(editinput.getEditableText().length() >= 1){
                inputclear.setVisibility(View.VISIBLE);
            }else {
                inputclear.setVisibility(View.GONE);
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.clearn:
                editinput.setText("");
                break;
        }
    }
}