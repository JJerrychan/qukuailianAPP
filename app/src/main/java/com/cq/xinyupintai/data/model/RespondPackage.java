package com.cq.xinyupintai.data.model;

import com.cq.xinyupintai.data.Object2Map;

import java.util.HashMap;
import java.util.Map;

/*
Json格式 定义服务器的反馈包或主动推动数据包
 */
public class RespondPackage extends Object2Map {
    private String ReqCode;             //对应请求包的ReqCode
    private int respId = 111;                 //服务器反馈的状态码：000成功，001-110不同的错误码，111未知错误，200-999推送不同类别信息
    private String Message;             //说明信息
    private Map<String, Object> data = new HashMap<>();   //JSON结构的数据body

    public String getReqCode() {
        return ReqCode;
    }

    public void setReqCode(String reqCode) {
        ReqCode = reqCode;
    }

    public int getrespId() {
        return respId;
    }

    public void setrespId(int respId) {
        respId = respId;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Map<String, Object> getdata() {
        return data;
    }

    public void setdata(Map<String, Object> data) {
        this.data = data;
    }
}
