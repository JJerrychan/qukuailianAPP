package com.cq.xinyupintai.Presenter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cq.xinyupintai.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.TextHolder> {
    private Context mContext;
    private List<String> texts;//这里需要修改，获取结账记录
    public  MyAdapter(Context context, List<String> textInfo){
        mContext = context;
        texts = textInfo;
    }

    @Override
    public TextHolder onCreateViewHolder(ViewGroup parent, int viewType) {          //创建viewholder
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_closing_stock, parent, false);            //获取视图

        return new TextHolder(view);
    }

    @Override
    public void onBindViewHolder(TextHolder holder, int position) {                 //绑定数据
        //后续获取数据需要修改此处
        String mtext = texts.get(position);
        holder.setTimeText(mtext);
        holder.setStateText(mtext);
        holder.setMoneyText(mtext);
    }

    @Override
    public int getItemCount() {                             //获取项目数量
        return texts.size();
    }

    public static class TextHolder extends RecyclerView.ViewHolder{
        private TextView time;
        private TextView state;
        private TextView money;
        public TextHolder(View itemView) {
            super(itemView);

            time = (TextView) itemView.findViewById(R.id.tv_items1);
            state = (TextView) itemView.findViewById(R.id.tv_items2);
            money = (TextView) itemView.findViewById(R.id.tv_items3);
        }
        public void setTimeText(String timeText){
            time.setText(timeText);
        }
        public void setStateText(String StateText){
            state.setText(StateText);
        }
        public void setMoneyText(String MoneyText){
            money.setText(MoneyText);
        }
    }
}