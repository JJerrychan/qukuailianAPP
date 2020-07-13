package com.cq.xinyupintai.data.model;

/*
用户预付卡信息
 */
public class CustomerCard extends PrepayCard {
    private String cid;     //唯一id
    private String BelongToWho;     //属于哪个用户id
    private String BelongToCompany; //属于哪个商家id
    private short cusStatus;        //此卡当前状态
    private int nowValues;          //当前余额

    public CustomerCard(String cardNum, String cid) {
        super(cardNum);
        this.cid = cid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getBelongToWho() {
        return BelongToWho;
    }

    public void setBelongToWho(String belongToWho) {
        BelongToWho = belongToWho;
    }

    public String getBelongToCompany() {
        return BelongToCompany;
    }

    public void setBelongToCompany(String belongToCompany) {
        BelongToCompany = belongToCompany;
    }

    public short getCusStatus() {
        return cusStatus;
    }

    public void setCusStatus(short cusStatus) {
        this.cusStatus = cusStatus;
    }

    public int getNowValues() {
        return nowValues;
    }

    public void setNowValues(int nowValues) {
        this.nowValues = nowValues;
    }
}
