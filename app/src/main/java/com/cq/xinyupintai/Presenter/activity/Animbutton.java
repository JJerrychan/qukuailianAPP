package com.cq.xinyupintai.Presenter.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.cq.xinyupintai.R;

import java.lang.reflect.GenericArrayType;


@SuppressLint("AppCompatCustomView")
public class Animbutton extends Button {


    private int width;
    private int heigh;

    private GradientDrawable gradientDrawable;// 创建图形 动态改变

    private boolean isMorphing;// 是否变化
    private int startAngle;

    private Paint paint; //画笔

    private ValueAnimator valueAnimator; //数值变化器

    public Animbutton(Context context) {
        super(context);
        init(context);
    }

    public Animbutton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Animbutton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        isMorphing=false;

        gradientDrawable=new GradientDrawable();
        int colorDrawable=context.getColor(R.color.appblue);
        gradientDrawable.setColor(colorDrawable);
        gradientDrawable.setCornerRadius(120);
        setBackground(gradientDrawable);

        setText("登陆");

        paint=new Paint();
        paint.setColor(getResources().getColor(R.color.white));
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(2);
    }

    @Override
    // 作用 计算出自定义View 的宽度和高度
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int heighMode=MeasureSpec.getMode(heightMeasureSpec);
        int heighSize=MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode==MeasureSpec.EXACTLY){//相当于我们设置为match_parent或者为一个具体的值
            width=widthSize;
        }
        if (heighMode==MeasureSpec.EXACTLY){
            heigh=heighSize;
        }
    }

    public void startAnim(){
        isMorphing=true;

        setText("");
        ValueAnimator valueAnimator=ValueAnimator.ofInt(width,heigh);

        //UpdateListener检测到值变化
       // gradientDrawable.setBounds重新绘制gradientDrawable的范围

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 计算最新的值
                int value= (int) animation.getAnimatedValue();
                int leftOffset=(width-value)/2;
                int rightOffset=width-leftOffset;

                gradientDrawable.setBounds(leftOffset,0,rightOffset,heigh);
            }
        });
        //开始实现动画  动画框架
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(gradientDrawable,"cornerRadius",120,heigh/2);

        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.setDuration(500); // 动画时间
        animatorSet.playTogether(valueAnimator,objectAnimator);// 多组动画同时进行
        animatorSet.start();



        showArc();//画中间的白色的圈
    }
    public void gotoNew(){
        isMorphing=false;

        valueAnimator.cancel();
        setVisibility(GONE);

    }
    public void regainBackground(){
        setVisibility(VISIBLE);
        gradientDrawable.setBounds(0,0,width,heigh);
        // 返回效果动画时间
        gradientDrawable.setCornerRadius(120);
        setBackground(gradientDrawable);
        setText("登陆");
        isMorphing=false;
    }

    private void showArc() {
        valueAnimator=ValueAnimator.ofInt(0,1080);//转速 绘画频率
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                startAngle= (int) animation.getAnimatedValue();
                invalidate();
            }
        });

        // 设置圆弧的旋转是匀速的
        // 有accelerated(加速)，decelerated(减速),repeated(重复),bounced(弹跳)LinearInterpolator(匀速)等
        // 如果不设置，系统会默认先加速后减速

        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setDuration(3000);
        valueAnimator.start();


    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        if (isMorphing==true){
            // 设置 加载的动画时的 pain 画弧度 (弧度画到页面中间)


            // 340 55
            final RectF rectF = new RectF(getWidth()*6/14,getHeight()/8,getWidth()*8/14,getHeight()-getHeight()/8);
//            final RectF rectF = new RectF(getWidth()*7/16,getHeight()/10,getWidth()*9/16,getHeight()-getHeight()/10);
            //final RectF rectF=new RectF(getWidth()*5/12,getHeight()/7,getWidth()*7/12,getHeight()-getHeight()/7);
            canvas.drawArc(rectF,startAngle,270,false,paint);


        }
    }
}





