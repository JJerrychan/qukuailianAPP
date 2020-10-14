package com.cq.xinyupintai.data.model;


import com.cq.xinyupintai.data.Object2Map;

import java.util.HashMap;
import java.util.Map;

/*
Json格式请求包
 */
public class RequestPackage extends Object2Map {
    private String ReqCode;              //前端发来请求包的功能码：界面号+序号，如“B001001”，B001为界面号，001为序号
    private Map<String, Object> Data = new HashMap<>();     //JSON结构的数据body

    public String getReqCode() {
        return ReqCode;
    }

    public void setReqCode(String reqCode) {
        ReqCode = reqCode;
    }

    public Map<String, Object> getData() {
        return Data;
    }

    public void setData(Map<String, Object> data) {
        Data = data;
    }
}
