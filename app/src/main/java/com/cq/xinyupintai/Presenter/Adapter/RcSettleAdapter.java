package com.cq.xinyupintai.Presenter.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cq.xinyupintai.Presenter.activity.EvaActivity;
import com.cq.xinyupintai.R;
import com.xuexiang.xui.widget.button.shadowbutton.ShadowButton;
import com.xuexiang.xui.widget.edittext.materialedittext.MaterialEditText;

import java.util.ArrayList;
import java.util.List;

public class RcSettleAdapter extends RecyclerView.Adapter<RcSettleAdapter.TextHolder> {
    private Context mContext;
    private List<Integer>texts ;

    public RcSettleAdapter(Context context,List<Integer> textInfo){
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
    public void onBindViewHolder(final TextHolder holder, int position) {                 //绑定数据
        holder.clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(holder.getLayoutPosition());
            }
        });

    }

    public void addItem(int position) {
        texts.add(position);
        notifyItemInserted(position);//通知演示插入动画
    }
    public void removeItem(int position) {
        texts.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public int getItemCount() {
        //获取项目数量
        return texts.size();
    }

    public static class TextHolder extends RecyclerView.ViewHolder{
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
        }
        }
    }