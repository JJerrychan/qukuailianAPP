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

import java.util.List;

public class UserEvaAdapter extends RecyclerView.Adapter<UserEvaAdapter.TextHolder> {
    private Context mContext;
    private List<String> texts;//这里需要修改，获取结账记录

    public UserEvaAdapter(Context context, List<String> textInfo) {
        mContext = context;
        texts = textInfo;
    }

    @Override
    public TextHolder onCreateViewHolder(ViewGroup parent, int viewType) {          //创建viewholder
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_eva, parent, false);            //获取视图

        return new TextHolder(view);
    }

    @Override
    public void onBindViewHolder(TextHolder holder, int position) {                 //绑定数据
        //后续获取数据需要修改此处
        String mtext = texts.get(position);
        holder.setEvaMText(mtext);
        holder.require.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, EvaActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {                             //获取项目数量
        return texts.size();
    }

    public static class TextHolder extends RecyclerView.ViewHolder {
        private TextView time;
        private TextView phone;
        private TextView star;
        private TextView name;
        private TextView eva;
        private Button require;

        public TextHolder(View itemView) {
            super(itemView);

            time = itemView.findViewById(R.id.tv_item_date);
            phone = itemView.findViewById(R.id.tv_item_phone);
            star = itemView.findViewById(R.id.tv_item_star);
            name = itemView.findViewById(R.id.tv_item_name);
            eva = itemView.findViewById(R.id.tv_item_eva);
            require = itemView.findViewById(R.id.bt_request);
        }

        public void setTimeText(String timeText) {
            time.setText(timeText);
        }

        public void setPhoneText(String PhoneText) {
            phone.setText(PhoneText);
        }

        public void setStarMText(String StarText) {
            star.setText(StarText);
        }

        public void setNameMText(String NameText) {
            name.setText(NameText);
        }

        public void setEvaMText(String EvaText) {
            eva.setText(EvaText);
        }
    }
}