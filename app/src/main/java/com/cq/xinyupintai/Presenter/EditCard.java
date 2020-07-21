package com.cq.xinyupintai.Presenter;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.cq.xinyupintai.R;
import com.cq.xinyupintai.data.GetJsonDataUtil;
import com.cq.xinyupintai.data.model.CategoriesBean;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;


public class EditCard extends AppCompatActivity {
    private static final int MSG_LOAD_DATA = 0x0001;
    private static final int MSG_LOAD_SUCCESS = 0x0002;
    private static final int MSG_LOAD_FAILED = 0x0003;
    private static boolean isLoaded = false;
    private TextView categoryTv;

    //添加列表
    private ArrayList<CategoriesBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private Thread thread;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_LOAD_DATA:
                    if (thread == null) {//如果已创建就不再重新创建子线程了
                        thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                // 子线程中解析分类数据
                                initJsonData();
                            }
                        });
                        thread.start();
                    }
                    break;
                case MSG_LOAD_SUCCESS:
                    Toast.makeText(EditCard.this, "Parse Succeed", Toast.LENGTH_SHORT).show();
                    isLoaded = true;
                    break;
                case MSG_LOAD_FAILED:
                    Toast.makeText(EditCard.this, "Parse Failed", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_card);
        mHandler.sendEmptyMessage(MSG_LOAD_DATA);


        ImageView categoryIv = findViewById(R.id.category_btn);
        categoryIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLoaded) {
                    showPickerView();
                } else {
                    Toast.makeText(EditCard.this, "Please waiting until the data is parsed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showPickerView() {// 弹出选择器
        //三层选择器
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String opt1tx = options1Items.size() > 0 ?
                        options1Items.get(options1).getPickerViewText() : "";
                String opt2tx = options2Items.size() > 0
                        && options2Items.get(options1).size() > 0 ?
                        options2Items.get(options1).get(options2) : "";
                String opt3tx = options2Items.size() > 0
                        && options3Items.get(options1).size() > 0
                        && options3Items.get(options1).get(options2).size() > 0 ?
                        options3Items.get(options1).get(options2).get(options3) : "";
                String tx = opt1tx + "  " + opt2tx + "  " + opt3tx;
                categoryTv = findViewById(R.id.category_textview);
                categoryTv.setText(tx);
//                Toast.makeText(EditCard.this, tx, Toast.LENGTH_SHORT).show();
            }
        })
                .setCancelText("取消")
                .setSubmitText("确定")
                .setTitleText("类别选择")//标题
                .build();
        pvOptions.setPicker(options1Items, options2Items, options3Items);//添加数据源
        pvOptions.show();
    }

    private void initJsonData() {//解析数据
        String JsonData = new GetJsonDataUtil().getJson(this, "categories.json");//获取目录下的json文件数据
        ArrayList<CategoriesBean> categoriesBean = parseData(JsonData);//用Gson 转成实体
        options1Items = categoriesBean;

        for (int i = 0; i < categoriesBean.size(); i++) {//遍历一级类型
            ArrayList<String> Categories2 = new ArrayList<>();//该一级类型的所有二级类型
            ArrayList<ArrayList<String>> Categories3 = new ArrayList<>();//该一级类型的所有三级类型

            for (int c = 0; c < categoriesBean.get(i).getCategories2().size(); c++) {//遍历该一级类型的所有二级类型

                String cat2 = categoriesBean.get(i).getCategories2().get(c).getName();
                Categories2.add(cat2);//添加二级类型
                ArrayList<String> Cat2_Cat3List = new ArrayList<>();//该二级类型的所有三级类型

                //如果无数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (categoriesBean.get(i).getCategories2().get(c).getCategories3() == null
                        || categoriesBean.get(i).getCategories2().get(c).getCategories3().size() == 0) {
                    Cat2_Cat3List.add("");
                } else {
                    for (int a = 0; a < categoriesBean.get(i).getCategories2().get(c).getCategories3().size(); a++) {
                        Cat2_Cat3List.add(categoriesBean.get(i).getCategories2().get(c).getCategories3().get(a).getName());
                    }
                }

                Categories3.add(Cat2_Cat3List);//添加该省所有地区数据
            }
            options2Items.add(Categories2);
            options3Items.add(Categories3);
        }
        mHandler.sendEmptyMessage(MSG_LOAD_SUCCESS);
    }

    public ArrayList<CategoriesBean> parseData(String result) {//Gson 解析
        ArrayList<CategoriesBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                CategoriesBean entity = gson.fromJson(data.optJSONObject(i).toString(), CategoriesBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mHandler.sendEmptyMessage(MSG_LOAD_FAILED);
        }
        return detail;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
    }
}
