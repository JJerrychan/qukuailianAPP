package com.cq.xinyupintai.Presenter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.cq.xinyupintai.R;
import com.xuexiang.xui.widget.statelayout.StatusLoader;
import com.xuexiang.xui.widget.textview.supertextview.SuperTextView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.TextHolder> {
    private Context mContext;
    private List<String> texts;
    public MessageAdapter(Context context, List<String> textInfo){
        mContext = context;
        texts = textInfo;
    }

    @Override
    public TextHolder onCreateViewHolder(ViewGroup parent, int viewType) {          //创建viewholder
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_message, parent, false);            //获取视图
        return new TextHolder(view);
    }

    @Override
    public void onBindViewHolder(TextHolder holder, int position) {                 //绑定数据
        //后续获取数据需要修改此处
        String mtext = texts.get(position);
        holder.setMessageText(mtext);
    }

    @Override
    public int getItemCount() {                             //获取项目数量
        return texts.size();
    }

    public static class TextHolder extends RecyclerView.ViewHolder{
        private SuperTextView stvMessage;
        public TextHolder(View itemView) {
            super(itemView);
            stvMessage=itemView.findViewById(R.id.stv_message);
        }
        public void setMessageText(String messageText){stvMessage.setLeftBottomString(messageText);}
    }
}