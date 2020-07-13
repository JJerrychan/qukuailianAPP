<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical"
    android:padding="20dp"
    android:background="#4169E1">


    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="信预(区块链)预付消费系统\n商家平台"
        android:gravity="center"
        android:textSize="22sp"
        android:textColor="#ffffff"
        android:layout_marginTop="30dp"
        android:lineSpacingExtra = "5dp"/>



    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="欢迎登陆"
        android:textSize="20sp"
        android:textColor="#ffffff"
        android:layout_marginTop="50dp"/>



    <RelativeLayout


        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="#ffffff"
        android:padding="15dp"
        android:layout_marginTop="20dp">


        <EditText
            android:id="@+id/user"
            android:layout_width="match_parent"
            android:layout_height="40dp"
            android:hint="  请输入手机号/用户名/邮箱/公司全称"
            android:layout_marginTop="20dp"
            android:textSize="16sp"/>

        <ImageView
            android:id="@+id/clearn"
            android:layout_width="15dp"
            android:layout_height="15dp"
            android:layout_marginTop="30dp"
            android:layout_alignParentRight="true"
            android:background="@mipmap/delete"/>




        <EditText
            android:id="@+id/password"
            android:layout_width="match_parent"
            android:layout_height="40dp"
            android:layout_below="@+id/user"
            android:hint="  请输入密码"
            android:textSize="16sp"
            android:layout_marginTop="25dp"
            android:drawableRight="@mipmap/close_eye"/>



        <Button
            android:id="@+id/bt"
            android:layout_width="330dp"
            android:layout_height="wrap_content"
            android:text="登陆"
            android:textColor="#ffffff"
            android:background="@drawable/button"
            android:textSize="20sp"
            android:layout_marginTop="25dp"
            android:layout_below="@id/password"
            android:layout_centerHorizontal="true"/>


    </RelativeLayout>

    <RelativeLayout

        android:layout_width="match_parent"
        android:layout_height="30dp"
        android:layout_marginTop="20dp">

        <TextView
            android:id="@+id/forgetpass"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="忘记密码"
            android:textSize="15sp"
            android:textColor="#ffffff"
            android:layout_marginLeft="220dp"/>

        <TextView
            android:id="@+id/newuser"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="快速注册"
            android:textSize="15sp"
            android:textColor="#ffffff"
            android:layout_toRightOf="@id/forgetpass"
            android:layout_marginLeft="10dp"/>



    </RelativeLayout>


    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:text="登录即代表您已经同意《信预网商家协议》\n使用即代表信预登录时将获取您的头像昵称等公开信息"
        android:lines="2"
        android:maxLines="2"
        android:textColor="#ffffff"
        android:lineSpacingExtra = "5dp"
        android:layout_alignParentBottom="true"
        android:layout_marginTop="200dp" />

</LinearLayout>
