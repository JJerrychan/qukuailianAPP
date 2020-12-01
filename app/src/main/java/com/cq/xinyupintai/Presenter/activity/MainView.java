package com.cq.xinyupintai.Presenter.activity;

import android.Manifest;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.cq.xinyupintai.Presenter.WebSocketTest;
import com.cq.xinyupintai.ui.Titanic.Titanic;
import com.cq.xinyupintai.ui.Titanic.TitanicTextView;
import com.cq.xinyupintai.R;
import com.cq.xinyupintai.data.Object2Map;
import com.cq.xinyupintai.data.model.RequestPackage;
import com.cq.xinyupintai.data.model.RespondPackage;
import com.cq.xinyupintai.data.model.Staff;
import com.cq.xinyupintai.ui.Animbutton;
import com.google.gson.Gson;
import com.xuexiang.xui.widget.edittext.materialedittext.MaterialEditText;

import java.util.Map;

public class MainView extends Activity implements View.OnClickListener {

    private final int REQUEST_EXTERNAL_STORAGE = 1;
    private WebSocketTest wstest;
    private TextView register;
    private TextView forgetpass;
    private EditText editinput;
    private EditText etpassword;
    private ImageView inputclear;
    private ImageView password;
    private boolean isHideFirst = true;
    private Animbutton animbutton;
    private RelativeLayout layout;
    private Handler handler;
    private Animator animator;
    private RelativeLayout background;
    private WebSocketTest.ServerListener mServerListener;
    private RespondPackage LoginRespond;
    private Gson gson = new Gson();
    //测试 后期删除
    private TextView test;
    private TitanicTextView title;
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


    // 跳转界面 动画设置
    private String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @SuppressLint({"ClickableViewAccessibility", "WrongViewCast", "WrongConstant"})

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        verifyStoragePermissions(this);



        initview();
        initListerner();


        editinput = findViewById(R.id.user);
        editinput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus == true) {// 点击获取
                    editinput.setHint("");
                } else {
                    SpannableString spannableString1 = new SpannableString("请输入手机号/用户名/邮箱/公司全称");
                    AbsoluteSizeSpan absoluteSizeSpan1 = new AbsoluteSizeSpan(13, true);
                    spannableString1.setSpan(absoluteSizeSpan1, 0, spannableString1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    editinput.setHint(new SpannableString(spannableString1));
            }
            }
        });


        etpassword = findViewById(R.id.password);
        etpassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus == true) {
                    etpassword.setHint("");
                } else {
                    SpannableString spannableString2 = new SpannableString("请输入密码");
                    AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(13, true);
                    spannableString2.setSpan(absoluteSizeSpan2, 0, spannableString2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    etpassword.setHint(new SpannableString(spannableString2));

                }
            }
        });


        //测试 后期删除
        test = findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        register = findViewById(R.id.newuser);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainView.this, register.class);
                startActivity(intent);
            }
        });


        forgetpass = findViewById(R.id.forgetpass);
        forgetpass.setOnClickListener(this);


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

        animbutton = findViewById(R.id.bt);
        layout = findViewById(R.id.MainView);

        layout.getBackground().setAlpha(0);

        wstest = WebSocketTest.getInstance();//获取websocket实例
        wstest.setServerListener(new WebSocketTest.ServerListener() {
            @Override
            public void onNewMessage(RespondPackage respond) {
                LoginRespond=respond;
            }
        });
        handler = new Handler();
        animbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animbutton.startAnim();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            RequestPackage LoginRequest = new RequestPackage();
                            LoginRequest.setReqCode("B001001");
                            Staff staff = new Staff();
                            staff.setLogin_name(editinput.getText().toString());
                            staff.setPassword_hash(etpassword.getText().toString());
                            hideSoftKeyboard(MainView.this);
                            try {
                                Map<String, Object> map = Object2Map.Obj2Map(staff);
                                LoginRequest.setData(map);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            wstest.sendData(LoginRequest);
                            //等待信息返回
                            while (wstest.getmCurrentStatus()==2){
                                Thread.sleep(1000);
                                Log.e("test","sleep完成");
                            }
                            handler.postDelayed(() -> {
//                    RespondPackage LoginRespond = wstest.getRespondPackage();
                    switch (LoginRespond.getrespId()) {
                        case 0://登陆成功
                            //跳转
                            gotoNew();
                            break;
                        case 101://商家名或密码不正确
                            Toast.makeText(MainView.this, "商家名或密码不正确!", Toast.LENGTH_SHORT).show();
                            animbutton.stopAnim();
                            break;
                        case 102://商家已登录
                            animbutton.stopAnim();
                            Toast.makeText(MainView.this, "不可重复登录," + LoginRespond.getMessage(), Toast.LENGTH_SHORT).show();
                            break;
                        case 111://未知错误
                            animbutton.stopAnim();
                            Toast.makeText(MainView.this, "未知错误", Toast.LENGTH_SHORT).show();
                            gotoNew();
                            break;
                    }
                }, 3000);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
        title = findViewById(R.id.id_hello);
        //字体设置
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/myfont.ttf");
//        title.setTypeface(typeface);
        new Titanic().start(title);

        background = findViewById(R.id.background);
        background.getBackground().mutate().setAlpha(160);

    }
    public void hideSoftKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
    private void gotoNew() {
        animbutton.gotoNew();

        final Intent intent = new Intent(this, BossActivity.class);


        int xc = (animbutton.getLeft() + animbutton.getRight()) / 2;
        int yc = (animbutton.getTop() + animbutton.getBottom()) / 2;

        // 按钮放大，以圆的形式向外扩展
        // 第一个参数是当前承载你动画的view 根布局，
        // 第二个参数是动画中心x轴坐标，就是按钮的中心x轴坐标
        // 第三个参数是动画中心y轴坐标，是按钮的中心y坐标
        // 第四个参数是开始动画开始的半径
        // 第五个是动画结束的半径

        animator = ViewAnimationUtils.createCircularReveal(layout, xc, yc, 0, 1111);
        animator.setDuration(300);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run(){
//                            RequestPackage bossHomeReq =new RequestPackage();
//                            bossHomeReq.setReqCode("B003001");
//                            wstest.sendData(bossHomeReq);
                            startActivity(intent);
                        //activity 页面跳转动画
                        // 注意：这个方法必须在startActivity/finish 后调用才会生效

                        overridePendingTransition(R.anim.anim_in, R.anim.anim_out);

                    }
                }, 200);
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();

        layout.getBackground().setAlpha(255);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //animator.cancel();
        layout.getBackground().setAlpha(0);
        animbutton.regainBackground();
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

    public void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }
    }
}