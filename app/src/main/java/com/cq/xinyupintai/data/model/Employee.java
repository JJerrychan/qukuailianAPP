package com.cq.xinyupintai.data.model;

/*
    营业员对象
 */
class Employee extends LoginUser {
    private String WorkNum;     //员工工号
    private String eName;       //员工姓名
    private String BelongToCompany; //属于哪个公司对应的id

    public Employee(String id) {
        super(id);
    }

    public String getWorkNum() {
        return WorkNum;
    }

    public void setWorkNum(String workNum) {
        WorkNum = workNum;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getBelongToCompany() {
        return BelongToCompany;
    }

    public void setBelongToCompany(String belongToCompany) {
        BelongToCompany = belongToCompany;
    }
}
