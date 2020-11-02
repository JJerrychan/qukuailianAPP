package com.cq.xinyupintai.Presenter.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cq.xinyupintai.Presenter.Dialog.MyBottomDialog;
import com.cq.xinyupintai.Presenter.WebSocketTest;
import com.cq.xinyupintai.R;
import com.cq.xinyupintai.data.Object2Map;
import com.cq.xinyupintai.data.model.Organization;
import com.cq.xinyupintai.data.model.RequestPackage;
import com.cq.xinyupintai.data.model.RespondPackage;
import com.smarttop.library.bean.City;
import com.smarttop.library.bean.County;
import com.smarttop.library.bean.Province;
import com.smarttop.library.bean.Street;
import com.smarttop.library.db.manager.AddressDictManager;
import com.smarttop.library.widget.AddressSelector;
import com.smarttop.library.widget.OnAddressSelectedListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class register extends Activity implements View.OnClickListener, OnAddressSelectedListener,
        AddressSelector.OnDialogCloseListener {

    private WebSocketTest wstest = WebSocketTest.getInstance();
    private RequestPackage regPack = new RequestPackage();
    private Organization organization = new Organization();

    private TextView textView;
    private EditText editText_1, editText_2, editText_3, editText_4, editText_5,
            editText_6, editText_7, editText_8, editText_9, editText_10;
    private ImageView imageView_1, imageView_2, imageView_3, imageView_4, imageView_5,
            imageView_6, imageView_7, imageView_8, imageView_9, imageView_10;
    private Button submit_btn;

    private boolean isHideFirst = true;


    //仿JD  地址选择器
    private TextView selectcity;
    private AddressDictManager addressDictManager;
    private String provinceCode;
    private String cityCode;
    private String countyCode;
    private String streetCode;
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            if (editText_1.getEditableText().length() >= 1) {
                imageView_1.setVisibility(View.VISIBLE);
            } else {
                imageView_1.setVisibility(View.GONE);
            }

            if (editText_2.getEditableText().length() >= 1) {
                imageView_2.setVisibility(View.VISIBLE);
            } else {
                imageView_2.setVisibility(View.GONE);
            }

            if (editText_3.getEditableText().length() >= 1) {
                imageView_3.setVisibility(View.VISIBLE);
            } else {
                imageView_3.setVisibility(View.GONE);
            }

            if (editText_4.getEditableText().length() >= 1) {
                imageView_4.setVisibility(View.VISIBLE);
            } else {
                imageView_4.setVisibility(View.GONE);
            }

            if (editText_5.getEditableText().length() >= 1) {
                imageView_5.setVisibility(View.VISIBLE);
            } else {
                imageView_5.setVisibility(View.GONE);
            }

            if (editText_6.getEditableText().length() >= 1) {
                imageView_6.setVisibility(View.VISIBLE);
            } else {
                imageView_6.setVisibility(View.GONE);
            }

            if (editText_7.getEditableText().length() >= 1) {
                imageView_7.setVisibility(View.VISIBLE);
            } else {
                imageView_7.setVisibility(View.GONE);
            }

            if (editText_8.getEditableText().length() >= 1) {
                imageView_8.setVisibility(View.VISIBLE);
            } else {
                imageView_8.setVisibility(View.GONE);
            }

            if (editText_9.getEditableText().length() >= 1) {
                imageView_9.setVisibility(View.VISIBLE);
            } else {
                imageView_9.setVisibility(View.GONE);
            }

            if (editText_10.getEditableText().length() >= 1) {
                imageView_10.setVisibility(View.VISIBLE);
            } else {
                imageView_10.setVisibility(View.GONE);
            }

        }

    };

    //设置三级地址选择器 仿IOS 版本
//    private void getAddress(){
//        CityPicker cityPicker= new CityPicker.Builder(register.this)
//                .textSize(14)
//                .title("地址选择")
//                .titleBackgroundColor("#ffffff")
//                .confirTextColor("#696969")
//                .cancelTextColor("#696969")
//                .province("广东省")
//                .city("广州市")
//                .district("海珠区")
//                .textColor(Color.parseColor("#000000"))
//                .provinceCyclic(true)
//                .cityCyclic(false)
//                .districtCyclic(false)
//                .visibleItemsCount(7)
//                .itemPadding(10)
//                .onlyShowProvinceAndCity(false)
//                .build();
//        cityPicker.show();
//
//        //监听事件 获取结果
//        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
//            @Override
//            public void onSelected(String... citySelected) {
//                //省份
//                String province = citySelected[0];
//                //城市
//                String city = citySelected[1];
//                //区县
//                String district = citySelected[2];
//                //邮编
//                String code = citySelected[3];
//                //为展示区赋值
//                selectcity.setText(province.trim() + "-" + city.trim() + "-" + district.trim());
//            }
//        });
//
//    }
    private MyBottomDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //设置无标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  //设置全屏
        setContentView(R.layout.register);
        initView();
        initListener();


        regPack.setReqCode("Z001002");
        wstest.sendData(regPack);

        RespondPackage addressRespond;
        addressRespond = wstest.getRespondPackage();
        if (addressRespond.getrespId() == 0) {
            try {
                File file = new File(Environment.getDataDirectory(),"ADDRESS");
                file.setWritable(true);
                FileWriter fw = new FileWriter(file);
                fw.write(addressRespond.getdata().toString());
                fw.close();
                Log.e("TAG", "写入成功！");
                FileReader fr = new FileReader("ADDRESS");
                StringBuilder sb = new StringBuilder();
                int read = fr.read();
                // 能读取到字符
                while (read != -1) {
                    // 拼接字符串
                    sb.append((char) read);
                    // 读取下一个字符
                    read = fr.read();
                }
                fr.close();
                Log.e("json", sb.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        textView = findViewById(R.id.tv_back);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });

        //设置 密码的显示 或者 隐藏 以及 眼睛的动态变化
        editText_2 = (EditText) findViewById(R.id.ed_2);

        final Drawable[] drawables1 = editText_2.getCompoundDrawables();
        final int eyeWidth1 = drawables1[2].getBounds().width();// 眼睛图标的宽度
        final Drawable drawableEyeOpen1 = getResources().getDrawable(R.mipmap.open_eye);

        drawableEyeOpen1.setBounds(drawables1[2].getBounds());//这一步不能省略

        editText_2.setOnTouchListener(new View.OnTouchListener() {

                                          @Override
                                          public boolean onTouch(View v, MotionEvent event) {


                                              if (event.getAction() == MotionEvent.ACTION_UP) {
                                                  float et_pwdMinX = v.getWidth() - eyeWidth1 - editText_2.getPaddingRight();
                                                  float et_pwdMaxX = v.getWidth();
                                                  float et_pwdMinY = 0;
                                                  float et_pwdMaxY = v.getHeight();
                                                  float x = event.getX();
                                                  float y = event.getY();

                                                  if (x < et_pwdMaxX && x > et_pwdMinX && y > et_pwdMinY && y < et_pwdMaxY) {
                                                      // 点击了眼睛图标的位置
                                                      isHideFirst = !isHideFirst;

                                                      if (isHideFirst) {
                                                          editText_2.setCompoundDrawables(null, null, drawables1[2], null);
                                                          editText_2.setTransformationMethod(PasswordTransformationMethod.getInstance());

                                                      } else {
                                                          editText_2.setCompoundDrawables(null, null, drawableEyeOpen1, null);
                                                          editText_2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                                                      }
                                                  }
                                              }
                                              return false;
                                          }

                                      }

        );

        //设置 密码的显示 或者 隐藏 以及 眼睛的动态变化
        editText_3 = (EditText) findViewById(R.id.ed_3);

        final Drawable[] drawables2 = editText_3.getCompoundDrawables();
        final int eyeWidth2 = drawables2[2].getBounds().width();// 眼睛图标的宽度
        final Drawable drawableEyeOpen2 = getResources().getDrawable(R.mipmap.open_eye);

        drawableEyeOpen2.setBounds(drawables2[2].getBounds());//这一步不能省略

        editText_3.setOnTouchListener(new View.OnTouchListener() {

                                          @Override
                                          public boolean onTouch(View v, MotionEvent event) {


                                              if (event.getAction() == MotionEvent.ACTION_UP) {
                                                  float et_pwdMinX = v.getWidth() - eyeWidth2 - editText_3.getPaddingRight();
                                                  float et_pwdMaxX = v.getWidth();
                                                  float et_pwdMinY = 0;
                                                  float et_pwdMaxY = v.getHeight();
                                                  float x = event.getX();
                                                  float y = event.getY();

                                                  if (x < et_pwdMaxX && x > et_pwdMinX && y > et_pwdMinY && y < et_pwdMaxY) {
                                                      // 点击了眼睛图标的位置
                                                      isHideFirst = !isHideFirst;

                                                      if (isHideFirst) {
                                                          editText_3.setCompoundDrawables(null, null, drawables2[2], null);
                                                          editText_3.setTransformationMethod(PasswordTransformationMethod.getInstance());

                                                      } else {
                                                          editText_3.setCompoundDrawables(null, null, drawableEyeOpen2, null);
                                                          editText_3.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                                                      }
                                                  }
                                              }
                                              return false;
                                          }

                                      }

        );


        selectcity = findViewById(R.id.cityselectview);
        AddressSelector selector = new AddressSelector(this);
        selectcity.setOnClickListener(this);
        addressDictManager = selector.getAddressDictManager();
        selector.setTextSize(13);

        //设置指针颜色
        selector.setIndicatorBackgroundColor(R.color.setTextSelectedColor);
        //设置字体获得焦点的颜色
        selector.setTextSelectedColor(Integer.parseInt(String.valueOf((R.color.colocdDark))));
        //设置字体没有获得焦点的颜色
        selector.setTextUnSelectedColor(Integer.parseInt(String.valueOf(R.color.setTextSelectedColor)));

        //选择监听，用户选取中和选取完毕之后调用次方法
        selector.setOnAddressSelectedListener(new OnAddressSelectedListener() {
            @Override
            public void onAddressSelected(Province province, City city, County county, Street street) {
                String address = (province == null ? "" : province.name) +
                        (city == null ? "" : city.name) + (county == null ? "" : county.name) +
                        (street == null ? "" : street.name);

                selectcity.setText(address);

            }


        });


        //设置三级地址选择器 仿IOS 版本
//    selectcity = findViewById(R.id.cityselectview);
//    selectcity.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            getAddress();
//        }
//    });


    }

    //对变量进行初始化
    private void initView() {

        submit_btn = findViewById(R.id.submit_btn);
//        address = findViewById(R.id.cityselectview);
//        address.setOnClickListener(this);

        imageView_1 = findViewById(R.id.clearn_1);
        imageView_2 = findViewById(R.id.clearn_2);
        imageView_3 = findViewById(R.id.clearn_3);
        imageView_4 = findViewById(R.id.clearn_4);
        imageView_5 = findViewById(R.id.clearn_5);
        imageView_6 = findViewById(R.id.clearn_6);
        imageView_7 = findViewById(R.id.clearn_7);
        imageView_8 = findViewById(R.id.clearn_8);
        imageView_9 = findViewById(R.id.clearn_9);
        imageView_10 = findViewById(R.id.clearn_10);


        editText_1 = findViewById(R.id.ed_1);
        editText_2 = findViewById(R.id.ed_2);
        editText_3 = findViewById(R.id.ed_3);
        editText_4 = findViewById(R.id.ed_4);
        editText_5 = findViewById(R.id.ed_5);
        editText_6 = findViewById(R.id.ed_6);
        editText_7 = findViewById(R.id.ed_7);
        editText_8 = findViewById(R.id.ed_8);
        editText_9 = findViewById(R.id.ed_9);
        editText_10 = findViewById(R.id.ed_10);

        imageView_1.setVisibility(View.GONE);
        imageView_2.setVisibility(View.GONE);
        imageView_3.setVisibility(View.GONE);
        imageView_4.setVisibility(View.GONE);
        imageView_5.setVisibility(View.GONE);
        imageView_6.setVisibility(View.GONE);
        imageView_7.setVisibility(View.GONE);
        imageView_8.setVisibility(View.GONE);
        imageView_9.setVisibility(View.GONE);
        imageView_10.setVisibility(View.GONE);


    }

    //设置监听器
    private void initListener() {

        editText_1.addTextChangedListener(textWatcher);
        editText_2.addTextChangedListener(textWatcher);
        editText_3.addTextChangedListener(textWatcher);
        editText_4.addTextChangedListener(textWatcher);
        editText_5.addTextChangedListener(textWatcher);
        editText_6.addTextChangedListener(textWatcher);
        editText_7.addTextChangedListener(textWatcher);
        editText_8.addTextChangedListener(textWatcher);
        editText_9.addTextChangedListener(textWatcher);
        editText_10.addTextChangedListener(textWatcher);

        imageView_1.setOnClickListener(this);
        imageView_2.setOnClickListener(this);
        imageView_3.setOnClickListener(this);
        imageView_4.setOnClickListener(this);
        imageView_5.setOnClickListener(this);
        imageView_6.setOnClickListener(this);
        imageView_7.setOnClickListener(this);
        imageView_8.setOnClickListener(this);
        imageView_9.setOnClickListener(this);
        imageView_10.setOnClickListener(this);

        submit_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        selectaddress();
        switch (v.getId()) {
            case R.id.clearn_1:
                editText_1.setText("");
                break;
            case R.id.clearn_2:
                editText_2.setText("");
                break;
            case R.id.clearn_3:
                editText_3.setText("");
                break;
            case R.id.clearn_4:
                editText_4.setText("");
                break;
            case R.id.clearn_5:
                editText_5.setText("");
                break;
            case R.id.clearn_6:
                editText_6.setText("");
                break;
            case R.id.clearn_7:
                editText_7.setText("");
                break;
            case R.id.clearn_8:
                editText_8.setText("");
                break;
            case R.id.clearn_9:
                editText_9.setText("");
                break;
            case R.id.clearn_10:
                editText_10.setText("");
                break;
            case R.id.submit_btn:
                regPack.setReqCode("B002001");
                organization.setLogin_name("test1");
                organization.setPassword_hash("test");
                organization.setOrg_name("newtest公司");
                organization.setUnit_code("002001");
                organization.setProvince_id("广东");
                organization.setCity_id("珠海");
                organization.setDistrict_id("香洲");
                organization.setStreet("前山街道");
                organization.setRoad("梅华路");
                organization.setDoor("100号");
                organization.setPhone("13765515315");
                organization.setDirector("test1");

                try {
                    Map<String, Object> map = (Map<String, Object>) Object2Map.Obj2Map(organization);
                    map.put("Identity_no", "123456");
                    regPack.setData(map);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                wstest.sendData(regPack);

                RespondPackage RegRespond = wstest.getRespondPackage();
                switch (RegRespond.getrespId()) {
                    case 0://注册成功
                        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                    case 110:
                        Toast.makeText(this, "有未填写的数据", Toast.LENGTH_SHORT).show();
                        break;
                    case 101:
                        Toast.makeText(this, RegRespond.getMessage(), Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;

        }

        if (dialog != null) {
            dialog.show();
        } else {
            dialog = new MyBottomDialog(this);
            //地址选取监听
            dialog.setOnAddressSelectedListener(this);
            //dialog监听
            dialog.setDialogDismisListener(this);
            //设置字体的大小
            dialog.setTextSize(14);
            //设置指示器的颜色
            dialog.setIndicatorBackgroundColor(R.color.setTextSelectedColor);
            //设置字体获得焦点的颜色
            dialog.setTextSelectedColor(Integer.parseInt(String.valueOf(R.color.colocdDark)));
            //设置字体没有获得焦点的颜色
            dialog.setTextUnSelectedColor(Integer.parseInt(String.valueOf(R.color.setTextSelectedColor)));
            dialog.show();
        }


    }

    @Override
    public void dialogclose() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override
    public void onAddressSelected(Province province, City city, County county, Street street) {

        provinceCode = (province == null ? "" : province.code);
        cityCode = (city == null ? "" : city.code);
        countyCode = (county == null ? "" : county.code);
        streetCode = (street == null ? "" : street.code);

        String address = (province == null ? "" : province.name) + " "
                + (city == null ? "" : city.name) + " " + (county == null ? "" : county.name) + " "
                + (street == null ? "" : street.name);

        selectcity.setText(address);

        if (dialog != null) {
            dialog.dismiss();
        }

        //code 显示选择的地址
        getSeleltArea();


    }

    private void getSeleltArea() {

        String province = addressDictManager.getProvince(provinceCode);
        String city = addressDictManager.getCity(cityCode);
        String county = addressDictManager.getCounty(countyCode);
        String street = addressDictManager.getStreet(streetCode);

    }
}
