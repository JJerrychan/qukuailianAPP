<?xml version="1.0" encoding="utf-8"?>
<ScrollView
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".registerActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="20dp"
        android:background="#4169E1"
        android:orientation="vertical">

        <TextView
            android:id="@+id/tv1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="8dp"
            android:text="登录信预"
            android:textSize="15sp"
            android:textColor="#ffffff"/>

        <TextView
            android:id="@+id/tv2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="商家注册"
            android:textSize="22sp"
            android:textColor="#ffffff"
            android:gravity="center"
            android:layout_centerHorizontal="true"/>

        <TableLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_below="@id/tv2"
            android:layout_marginTop="5dp"
            android:background="@drawable/background"
            android:padding="10dp">

            <RelativeLayout
                android:layout_marginTop="20dp">


                <TextView
                    android:id="@+id/id"
                    android:layout_width="wrap_content"
                    android:layout_height="40dp"
                    android:text="登录账号"
                    android:gravity="center"
                    android:textSize="18sp"
                    android:textColor="#6495ED"/>

                <EditText
                    android:layout_width="match_parent"
                    android:layout_height="40dp"
                    android:textSize="16sp"
                    android:hint="  请输入用于登录系统的用户名"
                    android:background="@null"
                    android:layout_toRightOf="@id/id"
                    android:layout_marginLeft="20dp"
                    />

                <View
                    android:layout_below="@id/id"
                    android:layout_width="match_parent"
                    android:layout_height="1dip"
                    android:background="@android:color/darker_gray" />


            </RelativeLayout>

            <RelativeLayout
                android:layout_marginTop="20dp">

                <TextView
                    android:id="@+id/pwd"
                    android:layout_width="wrap_content"
                    android:layout_height="40sp"
                    android:gravity="center"
                    android:text="登录密码"
                    android:textSize="18sp"
                    android:textColor="#6495ED"/>

                <EditText
                    android:layout_width="match_parent"
                    android:layout_height="40sp"
                    android:hint="  请输入密码"
                    android:background="@null"
                    android:layout_toRightOf="@+id/pwd"
                    android:textSize="16sp"
                    android:layout_marginLeft="20dp"/>

                <View
                    android:layout_below="@id/pwd"
                    android:layout_width="match_parent"
                    android:layout_height="1dip"
                    android:background="@android:color/darker_gray" />


            </RelativeLayout>

            <RelativeLayout
                android:layout_marginTop="20dp">

                <TextView
                    android:id="@+id/pwd2"
                    android:layout_width="wrap_content"
                    android:layout_height="40sp"
                    android:gravity="center"
                    android:text="确认密码"
                    android:textSize="18sp"
                    android:textColor="#6495ED"/>

                <EditText
                    android:layout_width="match_parent"
                    android:layout_height="40sp"
                    android:hint="  请再一次输入相同的密码"
                    android:background="@null"
                    android:layout_toRightOf="@+id/pwd2"
                    android:textSize="16sp"
                    android:layout_marginLeft="20dp"/>

                <View
                    android:layout_below="@id/pwd2"
                    android:layout_width="match_parent"
                    android:layout_height="1dip"
                    android:background="@android:color/darker_gray" />

            </RelativeLayout>

            <RelativeLayout
                android:layout_marginTop="20dp">

                <TextView
                    android:id="@+id/company"
                    android:layout_width="wrap_content"
                    android:layout_height="40sp"
                    android:gravity="center"
                    android:text="公司名称"
                    android:textSize="18sp"
                    android:textColor="#6495ED"/>

                <EditText
                    android:layout_width="match_parent"
                    android:layout_height="40sp"
                    android:hint="  请输入在工商登记的公司名称"
                    android:background="@null"
                    android:textSize="16sp"
                    android:layout_toRightOf="@+id/company"
                    android:layout_marginLeft="20dp"/>

                <View
                    android:layout_below="@id/company"
                    android:layout_width="match_parent"
                    android:layout_height="1dip"
                    android:background="@android:color/darker_gray" />


            </RelativeLayout>

            <RelativeLayout
                android:layout_marginTop="20dp">

                <TextView
                    android:id="@+id/companyid"
                    android:layout_width="wrap_content"
                    android:layout_height="40sp"
                    android:gravity="center"
                    android:text="组织代码"
                    android:textSize="18sp"
                    android:textColor="#6495ED"/>

                <EditText
                    android:layout_width="match_parent"
                    android:layout_height="40sp"
                    android:hint="  请输入在工商登记的公司名称"
                    android:background="@null"
                    android:layout_toRightOf="@id/companyid"
                    android:textSize="16sp"
                    android:layout_marginLeft="20dp"/>

                <View
                    android:layout_below="@id/companyid"
                    android:layout_width="match_parent"
                    android:layout_height="1dip"
                    android:background="@android:color/darker_gray" />


            </RelativeLayout>

            <RelativeLayout
                android:layout_marginTop="20dp">

                <TextView
                    android:id="@+id/bankid"
                    android:layout_width="wrap_content"
                    android:layout_height="40sp"
                    android:text="银行账号"
                    android:textSize="18sp"
                    android:gravity="center"
                    android:textColor="#6495ED"/>

                <EditText
                    android:layout_width="match_parent"
                    android:layout_height="40sp"
                    android:hint="  请输入用于结账收款的银行账号"
                    android:background="@null"
                    android:layout_toRightOf="@+id/bankid"
                    android:textSize="16sp"
                    android:layout_marginLeft="20dp"/>

                <View
                    android:layout_below="@id/bankid"
                    android:layout_width="match_parent"
                    android:layout_height="1dip"
                    android:background="@android:color/darker_gray" />


            </RelativeLayout>

            <RelativeLayout
                android:layout_marginTop="20dp">

                <TextView
                    android:id="@+id/people"
                    android:layout_width="wrap_content"
                    android:layout_height="40dp"
                    android:gravity="center"
                    android:text="联系人"
                    android:textSize="18sp"
                    android:textColor="#6495ED"/>

                <EditText
                    android:layout_width="match_parent"
                    android:layout_height="40dp"
                    android:hint="  请输入公司联系人姓名"
                    android:background="@null"
                    android:layout_toRightOf="@+id/people"
                    android:textSize="16sp"
                    android:layout_marginLeft="39dp"/>
                <View
                    android:layout_below="@id/people"
                    android:layout_width="match_parent"
                    android:layout_height="1dip"
                    android:background="@android:color/darker_gray" />


            </RelativeLayout>

            <RelativeLayout
                android:layout_marginTop="20dp">

                <TextView
                    android:id="@+id/iphone"
                    android:layout_width="wrap_content"
                    android:layout_height="40dp"
                    android:gravity="center"
                    android:text="手机号码"
                    android:textSize="18sp"

                    android:textColor="#6495ED"/>

                <EditText
                    android:layout_width="match_parent"
                    android:layout_height="40dp"
                    android:hint="  请输入公司业务手机号码"
                    android:background="@null"
                    android:layout_toRightOf="@+id/iphone"
                    android:textSize="16sp"
                    android:layout_marginLeft="20dp"/>

                <View
                    android:layout_below="@id/iphone"
                    android:layout_width="match_parent"
                    android:layout_height="1dip"
                    android:background="@android:color/darker_gray" />


            </RelativeLayout>


            <RelativeLayout
                android:layout_marginTop="20dp">
                <TextView
                    android:id="@+id/email"
                    android:layout_width="wrap_content"
                    android:layout_height="40dp"
                    android:gravity="center"
                    android:text="电子邮箱"
                    android:textSize="18sp"
                    android:textColor="#6495ED"/>

                <EditText
                    android:layout_width="match_parent"
                    android:layout_height="40dp"
                    android:layout_toRightOf="@+id/email"
                    android:hint="  请输入公司电子邮箱"
                    android:background="@null"
                    android:textSize="16sp"
                    android:layout_marginLeft="20dp"/>

                <View
                    android:layout_below="@id/email"
                    android:layout_width="match_parent"
                    android:layout_height="1dip"
                    android:background="@android:color/darker_gray" />

            </RelativeLayout>


            <LinearLayout
                android:layout_marginTop="20dp"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="所 在 省   "
                    android:textSize="18sp"
                    android:textColor="#6495ED"/>

                <Spinner
                    android:id="@+id/province"
                    android:layout_width="90dp"
                    android:layout_height="wrap_content"
                    />

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text=" 城 市  "
                    android:textSize="18sp"
                    android:layout_marginLeft="20dp"
                    android:textColor="#6495ED"/>

                <Spinner
                    android:id="@+id/city"
                    android:layout_width="90dp"
                    android:layout_height="wrap_content" />


            </LinearLayout>


            <LinearLayout
                android:layout_marginTop="20dp"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="所 在 区   "
                    android:textSize="18sp"
                    android:textColor="#6495ED"/>

                <Spinner
                    android:id="@+id/district"
                    android:layout_width="90dp"
                    android:layout_height="wrap_content"
                    />

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text=" 街 道  "
                    android:textSize="18sp"
                    android:layout_marginLeft="20dp"
                    android:textColor="#6495ED"/>

                <Spinner
                    android:id="@+id/street"
                    android:layout_width="90dp"
                    android:layout_height="wrap_content" />


            </LinearLayout>

            <LinearLayout
                android:layout_marginTop="20dp"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="所 在 路   "
                    android:textSize="18sp"
                    android:textColor="#6495ED"/>

                <Spinner
                    android:id="@+id/way"
                    android:layout_width="90dp"
                    android:layout_height="wrap_content"
                    />

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text=" 门 牌  "
                    android:textSize="18sp"
                    android:layout_marginLeft="20dp"
                    android:textColor="#6495ED"/>

                <Spinner
                    android:id="@+id/doorplate"
                    android:layout_width="90dp"
                    android:layout_height="wrap_content" />



            </LinearLayout>

            <LinearLayout
                android:layout_marginTop="35dp"
                android:layout_height="wrap_content"
                android:layout_width="wrap_content"
                >
                <Button
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text="注册"
                    android:textSize="20sp"
                    android:gravity="center"
                    android:textColor="#ffffff"
                    android:background="@drawable/button"/>

            </LinearLayout>

        </TableLayout>






    </LinearLayout>



</ScrollView >
