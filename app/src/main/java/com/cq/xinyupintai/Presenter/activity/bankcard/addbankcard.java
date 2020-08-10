package com.cq.xinyupintai.Presenter.activity.bankcard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cq.xinyupintai.R;

public class addbankcard extends Activity implements View.OnClickListener {


    private EditText editText1;
    private EditText editText2;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addbankcard);



        editText2 = findViewById(R.id.bank_id);

        textView = findViewById(R.id.returnlast);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addbankcard.this,bankcard.class);
                startActivity(intent);
            }
        });




        Drawable drawable2 = getResources().getDrawable(R.mipmap.photo);
        drawable2.setBounds(0,0,60,60);
        editText2.setCompoundDrawables(null,null,drawable2,null);


        //设置popwindpw button没有显示


        //设置 popwindow
        editText1 = findViewById(R.id.bank_name);

        final Drawable[] drawables = editText1.getCompoundDrawables();
        final int attationWidth = drawables[2].getBounds().width();
        final Drawable drawable = getResources().getDrawable(R.mipmap.attation);

        Drawable drawable1 = getResources().getDrawable(R.mipmap.attation);
        drawable1.setBounds(0,0,60,60);
        editText1.setCompoundDrawables(null,null,drawable1,null);

        drawable.setBounds(drawables[2].getBounds());

        editText1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (event.getAction() == MotionEvent.ACTION_UP) {
                    float et_pwdMinX = v.getWidth() - attationWidth - editText1.getPaddingRight();
                    float et_pwdMaxX = v.getWidth();
                    float et_pwdMinY = 0;
                    float et_pwdMaxY = v.getHeight();
                    float x = event.getX();
                    float y = event.getY();

                    if (x < et_pwdMaxX && x > et_pwdMinX && y > et_pwdMinY && y < et_pwdMaxY) {
                        // 点击了图标的位置
                        setdialog();
                    }
                }
                return false;
            }

        }
        );


    }

    private void setdialog() {
        Dialog dialog = new Dialog(this, R.style.BottomDialog);
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.popwindowbankcard, null);

        //button 点击
        root.findViewById(R.id.pop3).setOnClickListener(this);
        
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


    @Override
    public void onClick(View v) {

    }
}