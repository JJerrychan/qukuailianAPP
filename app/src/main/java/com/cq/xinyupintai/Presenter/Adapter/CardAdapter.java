package com.cq.xinyupintai.Presenter.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.cq.xinyupintai.Presenter.activity.EvaActivity;
import com.cq.xinyupintai.R;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.TextHolder> {
    private Context mContext;
    private List<String> texts;//这里需要修改，获取结账记录

    public CardAdapter(Context context, List<String> textInfo) {
        mContext = context;
        texts = textInfo;
    }

    @Override
    public TextHolder onCreateViewHolder(ViewGroup parent, int viewType) {          //创建viewholder
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.card_item, parent, false);            //获取视图

        return new TextHolder(view);
    }

    @Override
    public void onBindViewHolder(TextHolder holder, int position) {                 //绑定数据
        //后续获取数据需要修改此处
        String mtext = texts.get(position);
        holder.setNum_nameText(mtext);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //卡详细
//                Intent intent = new Intent(mContext, EvaActivity.class);
//                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {                             //获取项目数量
        return texts.size();
    }

    public static class TextHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private ImageView card_img;
        private TextView num_name;
        private TextView status;
        private TextView category;
        private TextView values;
        private TextView discount;

        public TextHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            card_img = itemView.findViewById(R.id.card_img);
            num_name = itemView.findViewById(R.id.num_name);
            status = itemView.findViewById(R.id.status);
            category = itemView.findViewById(R.id.category);
            values = itemView.findViewById(R.id.values);
            discount = itemView.findViewById(R.id.discount);
        }

        public void setCard_img(Drawable img) {
            card_img.setImageDrawable(img);
        }

        public void setNum_nameText(String num_nameText) {
            num_name.setText(num_nameText);
        }

        public void setStatusText(String statusText) {
            status.setText(statusText);
        }

        public void setCategoryText(String categoryText) {
            category.setText(categoryText);
        }

        public void setValuesMText(String valuesText) {
            values.setText(valuesText);
        }

        public void setDiscountMText(String discountText) {
            discount.setText(discountText);
        }
    }
}