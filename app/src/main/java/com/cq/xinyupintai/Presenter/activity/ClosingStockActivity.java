package com.cq.xinyupintai.Presenter.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cq.xinyupintai.R;

import java.util.ArrayList;
import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.TextHolder> {
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

public class ClosingStockActivity extends AppCompatActivity {
    private RecyclerView Cs_rcv;
    private MyAdapter mMyAdapter;
    private List<String> textInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closing_stock);
        Cs_rcv =  findViewById(R.id.rc_item);
        Cs_rcv.setLayoutManager(new LinearLayoutManager(this));
        Cs_rcv.setAdapter(new MyAdapter(ClosingStockActivity.this,TextInit()));
    }
    //测试用后期删除
    private List<String> TextInit() {
        List<String> text = new ArrayList<>();

        for(int i=0; i<20; ++i){
            String itemText = "";
            itemText = "测试第" + (i+1) + "条数据";
            text.add(itemText);
        }

        return text;
    }

}