package com.cq.xinyupintai.Presenter.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cq.xinyupintai.R;

public class MainView extends Activity implements View.OnClickListener {

    private TextView tv1;
    private TextView tv2;


    private EditText editinput;
    private EditText etpassword;

    private ImageView inputclear;
    private ImageView password;

    private Button ensure;

    private boolean isHideFirst = true;

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            if (editinput.getEditableText().length() >= 1) {
                inputclear.setVisibility(View.VISIBLE);
            } else {
                inputclear.setVisibility(View.GONE);
            }

            if (etpassword.getEditableText().length() >= 1) {
                password.setVisibility(View.VISIBLE);
            } else {
                password.setVisibility(View.GONE);
            }

        }
    };

    @SuppressLint("ClickableViewAccessibility")

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
                Intent intent = new Intent(MainView.this, register.class);
                startActivity(intent);
            }
        });



        tv2 = findViewById(R.id.forgetpass);
        tv2.setOnClickListener(this);




        //设置 密码的显示 或者 隐藏 以及 眼睛的动态变化
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
        ensure = findViewById(R.id.bt);
        ensure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainView.this, BossActivity.class);
                startActivity(intent);
            }
        });



    }

    private void initview() {

        inputclear = findViewById(R.id.clearn);
        editinput = findViewById(R.id.user);
        inputclear.setVisibility(View.GONE);


        password = findViewById(R.id.clearnpwd);
        etpassword = findViewById(R.id.password);
        password.setVisibility(View.GONE);


    }

    private void initListerner() {
        editinput.addTextChangedListener(textWatcher);
        inputclear.setOnClickListener(this);

        etpassword.addTextChangedListener(textWatcher);
        password.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clearn:
                editinput.setText("");
                break;
            case R.id.clearnpwd:
                etpassword.setText("");
                break;
            case R.id.forgetpass:
                setDialog();
                break;
        }
    }



    //设置忘记密码操作
    private void setDialog() {

        Dialog dialog = new Dialog(this, R.style.BottomDialog);
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.popwindow, null);
        root.findViewById(R.id.btpop1).setOnClickListener(this);
        root.findViewById(R.id.btpop2).setOnClickListener(this);
        root.findViewById(R.id.btpop3).setOnClickListener(this);
        dialog.setContentView(root);
        Window dialogwindow = dialog.getWindow();
        dialogwindow.setGravity(Gravity.BOTTOM);




        WindowManager.LayoutParams lp = dialogwindow.getAttributes();// 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = 0; // 新位置Y坐标
        lp.width = (int) getResources().getDisplayMetrics().widthPixels; // 宽度
        root.measure(0, 0);
        lp.height = root.getMeasuredHeight();

//        lp.alpha = 9f; // 透明度
        dialogwindow.setAttributes(lp);
        dialog.show();

    }
}

