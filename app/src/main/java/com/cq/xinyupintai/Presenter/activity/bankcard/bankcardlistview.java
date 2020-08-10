package com.cq.xinyupintai.Presenter.activity.bankcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cq.xinyupintai.R;

//适配器
public class bankcardlistview extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    //LayoutInflater 类似于 findviewbyid
    public bankcardlistview(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    //列表长度
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView textname,textnum,textsearch,textcard;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.bankcardlistview,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.bankimage);
            viewHolder.textname = convertView.findViewById(R.id.id_name);
            viewHolder.textnum = convertView.findViewById(R.id.id_number);
            viewHolder.textsearch = convertView.findViewById(R.id.id_search);
            viewHolder.textcard = convertView.findViewById(R.id.id_card);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //给控件赋值
        viewHolder.textname.setText("中国建设银行储蓄卡");
        return convertView;
    }

}