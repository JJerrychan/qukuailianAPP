<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#F5F5F5"
    android:padding="10dp">

    <TextView
        android:id="@+id/tv2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="设置"
        android:textSize="22sp"
        android:background="@drawable/setborder"
        android:padding="20dp"
        android:textColor="#ffffff"
        android:gravity="center"
        android:layout_centerHorizontal="true"/>


    <RelativeLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="#ffffff"
        android:layout_marginTop="20dp">


        <TextView
            android:id="@+id/tv_1"
            android:layout_width="match_parent"
            android:layout_height="60dp"
            android:text="    营业员账户"
            android:gravity="center|left"
            android:textColor="#000000"
            android:textSize="18sp"
            android:drawableLeft="@mipmap/account"
            android:paddingLeft="10dp"/>


    </RelativeLayout>


    <RelativeLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="#ffffff"
        android:layout_marginTop="10dp">


        <TextView
            android:id="@+id/tv_2"
            android:layout_width="match_parent"
            android:layout_height="60dp"
            android:text="    公司资料\n    简介、图片、地址、联系人、邮箱"
            android:gravity="center|left"
            android:textColor="#000000"
            android:layout_marginTop="3dp"
            android:textSize="17sp"
            android:drawableLeft="@mipmap/document"
            android:padding="10dp"/>




    </RelativeLayout>



    <RelativeLayout
        android:layout_marginTop="10dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#ffffff">




        <TextView
            android:id="@+id/tv_3"
            android:layout_width="match_parent"
            android:layout_height="60dp"
            android:text="   手机绑定"
            android:gravity="center|left"
            android:textColor="#000000"
            android:layout_marginTop="3dp"
            android:drawableLeft="@mipmap/iphone"
            android:paddingLeft="10dp"
            android:textSize="18sp" />

        <View
            android:id="@+id/view3"
            android:layout_below="@+id/tv_3"
            android:layout_width="match_parent"
            android:layout_height="0.5dip"
            android:background="@android:color/darker_gray" />

        <TextView
            android:id="@+id/tv_4"
            android:layout_below="@+id/view3"
            android:layout_width="match_parent"
            android:layout_height="60dp"
            android:text="   银行卡绑定"
            android:textColor="#000000"
            android:drawableLeft="@mipmap/bank"
            android:paddingLeft="10dp"
            android:gravity="center|left"
            android:textSize="18sp" />
    </RelativeLayout>



    <RelativeLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:background="#ffffff"
            android:layout_marginTop="10dp"
            android:layout_below="@+id/tv_4">

            <TextView
                android:id="@+id/tv_5"
                android:layout_width="match_parent"
                android:layout_height="60dp"
                android:text="   安全与隐私\n   修改密码、密码提示问题、接受推荐"
                android:gravity="center|left"
                android:textColor="#000000"
                android:drawableLeft="@mipmap/security"
                android:paddingLeft="10dp"
                android:layout_marginTop="3dp"
                android:textSize="17sp" />


        </RelativeLayout>

    <RelativeLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="#ffffff"
            android:layout_marginTop="10dp">
            <TextView
                android:id="@+id/tv_6"
                android:layout_width="match_parent"
                android:layout_height="60dp"
                android:text="   公司使命认证"
                android:gravity="center|left"
                android:drawableLeft="@mipmap/company"
                android:paddingLeft="10dp"
                android:layout_marginTop="3dp"
                android:textSize="18sp"
                android:textColor="#000000"/>


        </RelativeLayout>


    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#ffffff"
        android:layout_marginTop="10dp">

        <TextView
            android:id="@+id/tv_7"
            android:layout_width="match_parent"
            android:layout_height="60dp"
            android:text="   关于信预"
            android:textColor="#000000"
            android:gravity="center|left"
            android:drawableLeft="@mipmap/essence"
            android:paddingLeft="10dp"
            android:layout_marginTop="3dp"
            android:textSize="18sp" />


    </RelativeLayout>

    <Button

        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:text="切换账号"
        android:textSize="20sp"
        android:gravity="center"
        android:layout_marginTop="40dp"
        android:textColor="#ffffff"
        android:background="@drawable/button"/>


    <Button

        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:text="退出登录"
        android:textSize="20sp"
        android:gravity="center"
        android:layout_marginTop="20dp"
        android:textColor="#ffffff"
        android:background="@drawable/button"/>



</LinearLayout>
