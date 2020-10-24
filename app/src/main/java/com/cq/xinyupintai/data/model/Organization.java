package com.cq.xinyupintai.data.model;

/*
    公司信息
 */
public class Organization extends User {
    private int Org_id;             //组织唯一ID
    private String Org_name;        //组织名称
    private String Org_shortname;   //组织简称
    private String Unit_code;       //组织机构代码
    private String Org_type;        //组织类别（商家V，运营商O，代理商A，银行B）
    private String Province_id;
    private String City_id;
    private String District_id;
    private String Street;
    private String Road;
    private String Door;
    private String Phone;
    private String Director;        //负责人
    private String Introduct;       //组织简介
    private String Photo;           //图片
    private String Account;         //收款账户
    private String Account_name;    //银行账户名称
    private String Bankname;        //开户银行

    public int getOrg_id() {
        return Org_id;
    }

    public void setOrg_id(int org_id) {
        Org_id = org_id;
    }

    public String getOrg_name() {
        return Org_name;
    }

    public void setOrg_name(String org_name) {
        Org_name = org_name;
    }

    public String getOrg_shortname() {
        return Org_shortname;
    }

    public void setOrg_shortname(String org_shortname) {
        Org_shortname = org_shortname;
    }

    public String getUnit_code() {
        return Unit_code;
    }

    public void setUnit_code(String unit_code) {
        Unit_code = unit_code;
    }

    public String getOrg_type() {
        return Org_type;
    }

    public void setOrg_type(String org_type) {
        Org_type = org_type;
    }

    public String getProvince_id() {
        return Province_id;
    }

    public void setProvince_id(String province_id) {
        Province_id = province_id;
    }

    public String getCity_id() {
        return City_id;
    }

    public void setCity_id(String city_id) {
        City_id = city_id;
    }

    public String getDistrict_id() {
        return District_id;
    }

    public void setDistrict_id(String district_id) {
        District_id = district_id;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getRoad() {
        return Road;
    }

    public void setRoad(String road) {
        Road = road;
    }

    public String getDoor() {
        return Door;
    }

    public void setDoor(String door) {
        Door = door;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getIntroduct() {
        return Introduct;
    }

    public void setIntroduct(String introduct) {
        Introduct = introduct;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getAccount_name() {
        return Account_name;
    }

    public void setAccount_name(String account_name) {
        Account_name = account_name;
    }

    public String getBankname() {
        return Bankname;
    }

    public void setBankname(String bankname) {
        Bankname = bankname;
    }
}
