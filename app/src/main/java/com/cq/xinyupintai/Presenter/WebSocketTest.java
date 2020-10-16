package com.cq.xinyupintai.Presenter;

import android.os.Handler;
import android.util.Log;

import com.cq.xinyupintai.data.model.RequestPackage;
import com.cq.xinyupintai.data.model.RespondPackage;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class WebSocketTest {

    // 每隔2秒发送一次心跳包，检测连接没有断开
//    private static final long HEART_BEAT_RATE = 2 * 1000;
//    private long sendTime = 0L;

    private static volatile WebSocketTest WsInstance = null;//WS实例
    private static Gson gson = new Gson();
    private Handler mHandler = new Handler();
    private static WebSocket mSocket;
    private static RespondPackage respondPackage = new RespondPackage();

    //获取Ws实例
    public static WebSocketTest getInstance() {
        if (WsInstance == null) {
            synchronized (WebSocketTest.class) {
                if (WsInstance == null) {
                    WsInstance = new WebSocketTest();
                }
            }
        }
        return WsInstance;
    }

    public static String buildRequestParams(Object params) {
        String jsonStr = gson.toJson(params);
        return jsonStr;
    }

    public RespondPackage getRespondPackage() {
        return respondPackage;
    }
// 发送心跳包
//    private Runnable heartBeatRunnable = new Runnable() {
//        @Override
//        public void run() {
//            if (System.currentTimeMillis() - sendTime >= HEART_BEAT_RATE) {
//                String message = sendData();
//                mSocket.send(message);
//                sendTime = System.currentTimeMillis();
//            }
//            mHandler.postDelayed(this, HEART_BEAT_RATE); //每隔一定的时间，对长连接进行一次心跳检测
//        }
//    };

    public static void init() {
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .readTimeout(3, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(3, TimeUnit.SECONDS)//设置写的超时时间
                .connectTimeout(3, TimeUnit.SECONDS)//设置连接超时时间
                .build();
        Request request = new Request.Builder().url("ws://172.16.16.59:8888/cenyou").build();
        EchoWebSocketListener socketListener = new EchoWebSocketListener();
        // 刚进入界面，就开启心跳检测
        // mHandler.postDelayed(heartBeatRunnable, HEART_BEAT_RATE);
        mSocket = mOkHttpClient.newWebSocket(request, socketListener);

        mOkHttpClient.dispatcher().executorService().shutdown();
    }

    public Boolean sendData(RequestPackage requestP) {
        String jsonHead = "";
        jsonHead = buildRequestParams(requestP);
        Log.e("TAG", "sendData: " + jsonHead);
        Boolean result = mSocket.send(jsonHead);
        if (result)
            Log.v("websocket", "发送成功！");
        return result;
    }

//    private String sendHeart() {
//        String jsonHead = "";
//        Map<String, Object> mapHead = new HashMap<>();
//        mapHead.put("heart", "heart");
//        jsonHead = buildRequestParams(mapHead);
//        Log.e("TAG", "sendHeart：" + jsonHead);
//        return jsonHead;
//    }

    private final static class EchoWebSocketListener extends WebSocketListener {
        @Override
        public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t, @Nullable Response response) {
            super.onFailure(webSocket, t, response);
            Log.v("WebSocket", "Failure:" + t.toString());
        }

        @Override
        public void onClosed(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
            super.onClosed(webSocket, code, reason);
            Log.v("WebSocket", "Closed:" + reason);
        }

        @Override
        public void onClosing(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
            super.onClosing(webSocket, code, reason);
            Log.v("WebSocket", "Closing:" + reason);
        }

        @Override
        public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
            super.onMessage(webSocket, text);
            Log.e("WebSocket", "Message:" + text);
            respondPackage = gson.fromJson(text, RespondPackage.class);
        }

        @Override
        public void onMessage(@NotNull WebSocket webSocket, @NotNull ByteString bytes) {
            super.onMessage(webSocket, bytes);
            Log.v("WebSocket", "Message:" + bytes);
        }

        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            super.onOpen(webSocket, response);
            mSocket = webSocket;
            Log.e("WebSocket", "连接成功!");
        }
    }
}
