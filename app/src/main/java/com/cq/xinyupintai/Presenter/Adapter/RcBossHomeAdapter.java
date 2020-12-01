package com.cq.xinyupintai.Presenter.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cq.xinyupintai.Presenter.activity.StatisticsActivity;
import com.cq.xinyupintai.R;
import com.cq.xinyupintai.data.model.statistic;

import java.util.List;
public class RcBossHomeAdapter extends RecyclerView.Adapter<RcBossHomeAdapter.TextHolder> {
    private Context mContext;
    private List<statistic> texts;
    public RcBossHomeAdapter(Context context, List<statistic> textInfo){
        mContext = context;
        texts = textInfo;
    }

    @Override
    public TextHolder onCreateViewHolder(ViewGroup parent, int viewType) {          //创建viewholder
        View view = View.inflate(mContext,R.layout.item_boss,null);            //获取视图
        return new TextHolder(view);
    }

    @Override
    public void onBindViewHolder(TextHolder holder, int position) {                 //绑定数据
        //后续获取数据需要修改此处
        holder.setnameText(texts.get(position).getName());
        holder.setdataText(texts.get(position).getNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, StatisticsActivity.class);
                mContext.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {                             //获取项目数量
        return texts.size();
    }

    public void changeItem(statistic mstatistic1,statistic mstatistic2,statistic mstatistic3){
        texts.clear();
        texts.add(mstatistic1);
        texts.add(mstatistic2);
        texts.add(mstatistic3);
        notifyDataSetChanged();
    }

    public static class TextHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView data;
        public TextHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tv_item_bh1);
            data=itemView.findViewById(R.id.tv_item_bh2);
        }
        public void setnameText(String nameText){
            name.setText(nameText);
        }
        public void setdataText(String dataText){
            data.setText(dataText);
        }
    }
}
