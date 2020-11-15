package com.cq.xinyupintai.Presenter.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cq.xinyupintai.Presenter.activity.EvaActivity;
import com.cq.xinyupintai.R;
import com.cq.xinyupintai.data.model.checkout;
import com.xuexiang.xui.widget.button.shadowbutton.ShadowButton;
import com.xuexiang.xui.widget.edittext.materialedittext.MaterialEditText;
import com.xuexiang.xui.widget.textview.supertextview.SuperTextView;

import java.util.ArrayList;
import java.util.List;

public class RcSettleAdapter extends RecyclerView.Adapter<RcSettleAdapter.TextHolder> {
    private Context mContext;
    private List<checkout>texts;
    public RcSettleAdapter(Context context,List<checkout> textInfo){
        mContext = context;
        texts=textInfo;
    }
    @Override
    public TextHolder onCreateViewHolder(ViewGroup parent, int viewType) {          //创建viewholder
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_commdity, parent, false);            //获取视图
        return new TextHolder(view);
    }
    @Override
    public void onBindViewHolder(TextHolder holder, int position) {                 //绑定数据
        holder.setMetNameText(texts.get(position).getName());
        holder.setMetNumberText(texts.get(position).getNumber());
        holder.setMetYuanText(texts.get(position).getYuan());
    }

    public void addItem(int position,checkout data) {
        texts.add(position,data);
        notifyItemInserted(position);//通知演示插入动画
    }
    public void removeItem(int position) {
        texts.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        //获取项目数量
        return texts.size();
    }

    public interface OnItemClickListener  {
        void onItemClick(View v, int position);
        void onItemLongClick(View v);
    }
    public OnItemClickListener mOnItemClickListener;//第二步：声明自定义的接口

    //第三步：定义方法并暴露给外面的调用者
    public void setOnItemClickListener(OnItemClickListener  listener) {
        this.mOnItemClickListener  = listener;
    }

    public class TextHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private MaterialEditText MetName;
        private MaterialEditText MetNumber;
        private MaterialEditText MetYuan;
        private ShadowButton clean;
        public TextHolder(View itemView) {
            super(itemView);
            MetName=itemView.findViewById(R.id.ed_commdity_name);
            MetNumber=itemView.findViewById(R.id.ed_commdity_number);
            MetYuan=itemView.findViewById(R.id.ed_commdity_yuan);
            clean=itemView.findViewById(R.id.sb_commdity_clean);
            MetName.setFocusable(false);
            MetNumber.setFocusable(false);
            MetYuan.setFocusable(false);
            clean.setOnClickListener(this);
        }
        public void setMetNameText(String MetNameText) {MetName.setText(MetNameText); }
        public void setMetNumberText(String MetNumberText) {MetNumber.setText(MetNumberText); }
        public void setMetYuanText(String MetYuanText) {MetYuan.setText(MetYuanText); }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }

    public List<checkout> getTexts() {
        return texts;
    }
    public String totalNumber(){
        Integer totalNumber=texts.stream().mapToInt(e->{
            int yuan=Integer.valueOf(e.getYuan());
            int number=Integer.valueOf(e.getNumber());
            return yuan*number;
        }).sum();
        return totalNumber.toString();
    }
}