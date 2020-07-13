package com.cq.xinyupintai.data.model;
/*
    公司信息
 */
public class Company extends LoginUser{
    private String cName;       //公司名称
    private String cCode;       //组织代码
    private String cContract;   //联系人
    private String cEmail;      //电子邮箱
    private String cProvince;   //所在省
    private String cCity;       //城市
    private String cArea;       //所在区
    private String cBlock;      //街道
    private String cRoad;       //所在路
    private String cLocation;   //门牌
    private String cInfo;       //简介
    private String[] cPicture;  //轮播图
    private String BankCardNumber;  //银行卡号码

    public Company(int id) {
        super(id);
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getcContract() {
        return cContract;
    }

    public void setcContract(String cContract) {
        this.cContract = cContract;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcProvince() {
        return cProvince;
    }

    public void setcProvince(String cProvince) {
        this.cProvince = cProvince;
    }

    public String getcCity() {
        return cCity;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity;
    }

    public String getcArea() {
        return cArea;
    }

    public void setcArea(String cArea) {
        this.cArea = cArea;
    }

    public String getcBlock() {
        return cBlock;
    }

    public void setcBlock(String cBlock) {
        this.cBlock = cBlock;
    }

    public String getcRoad() {
        return cRoad;
    }

    public void setcRoad(String cRoad) {
        this.cRoad = cRoad;
    }

    public String getcLocation() {
        return cLocation;
    }

    public void setcLocation(String cLocation) {
        this.cLocation = cLocation;
    }

    public String getcInfo() {
        return cInfo;
    }

    public void setcInfo(String cInfo) {
        this.cInfo = cInfo;
    }

    public String[] getcPicture() {
        return cPicture;
    }

    public void setcPicture(String[] cPicture) {
        this.cPicture = cPicture;
    }

    public String getBankCardNumber() {
        return BankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        BankCardNumber = bankCardNumber;
    }
}
