package com.cq.xinyupintai.data.model;

public class Staff extends User {
    private int Staff_id;       //唯一ID
    private String Name;        //姓名
    private String Identity_no; //身份号码
    private String Mobile_phone;//手机号码
    private String Staff_no;    //工号
    private String Role;        //用户角色（O操作员Oper，A管理员Admin，B业主Boss）
    private int Privilege;      //权限（从1-127）
    private int Org_id;         //从属组织的ID

    public int getStaff_id() {
        return Staff_id;
    }

    public void setStaff_id(int staff_id) {
        Staff_id = staff_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIdentity_no() {
        return Identity_no;
    }

    public void setIdentity_no(String identity_no) {
        Identity_no = identity_no;
    }

    public String getMobile_phone() {
        return Mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        Mobile_phone = mobile_phone;
    }

    public String getStaff_no() {
        return Staff_no;
    }

    public void setStaff_no(String staff_no) {
        Staff_no = staff_no;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public int getPrivilege() {
        return Privilege;
    }

    public void setPrivilege(int privilege) {
        Privilege = privilege;
    }

    public int getOrg_id() {
        return Org_id;
    }

    public void setOrg_id(int org_id) {
        Org_id = org_id;
    }

}
