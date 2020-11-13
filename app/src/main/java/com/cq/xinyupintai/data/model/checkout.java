package com.cq.xinyupintai.data.model;
//结账条目
public class checkout {
    private String name;//消费项目
    private String number;//消费数量
    private String yuan;//消费单价

    public checkout(String name, String number, String yuan) {
        this.name = name;
        this.number = number;
        this.yuan = yuan;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getYuan() {
        return yuan;
    }
}
