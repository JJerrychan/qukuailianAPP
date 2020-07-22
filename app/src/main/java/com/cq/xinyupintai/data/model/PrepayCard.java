package com.cq.xinyupintai.data.model;

/*
    商家预付卡信息
 */
public class PrepayCard {
    private String CardNum;     //商家自编号
    private String CardName;    //卡名
    private int cValue;         //面值
    private int cDiscount;      //折扣
    private boolean isUnited;   //是否联盟卡
    private String cInfo;       //说明
    private String cPic;        //封面图
    private short cStatus;      //商家状态(0:未发布,1:已发布,2:已删除)
    private short cCategory1;   //类别1(1丽人2汽车3保健4零售5娱乐6休闲7教育8生活)
    private short cCategory2;
    private short cCategory3;

    public PrepayCard(String cardNum) {
        CardNum = cardNum;
    }

    public String getCardNum() {
        return CardNum;
    }

    public void setCardNum(String cardNum) {
        CardNum = cardNum;
    }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String cardName) {
        CardName = cardName;
    }

    public int getcValue() {
        return cValue;
    }

    public void setcValue(int cValue) {
        this.cValue = cValue;
    }

    public int getcDiscount() {
        return cDiscount;
    }

    public void setcDiscount(int cDiscount) {
        this.cDiscount = cDiscount;
    }

    public boolean isUnited() {
        return isUnited;
    }

    public void setUnited(boolean united) {
        isUnited = united;
    }

    public String getcInfo() {
        return cInfo;
    }

    public void setcInfo(String cInfo) {
        this.cInfo = cInfo;
    }

    public String getcPic() {
        return cPic;
    }

    public void setcPic(String cPic) {
        this.cPic = cPic;
    }

    public short getcStatus() {
        return cStatus;
    }

    public void setcStatus(short cStatus) {
        this.cStatus = cStatus;
    }

    public short getcCategory1() {
        return cCategory1;
    }

    public void setcCategory1(short cCategory1) {
        this.cCategory1 = cCategory1;
    }

    public short getcCategory2() {
        return cCategory2;
    }

    public void setcCategory2(short cCategory2) {
        this.cCategory2 = cCategory2;
    }

    public short getcCategory3() {
        return cCategory3;
    }

    public void setcCategory3(short cCategory3) {
        this.cCategory3 = cCategory3;
    }
}
