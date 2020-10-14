package com.cq.xinyupintai.data.model;

public class Staff {
    private int Staff_id;
    private String Login_name;
    private String Password_hash;
    private String Name;
    private String Identity_no;
    private String Mobile_phone;
    private String Staff_no;
    private String Role;
    private int Privilege;
    private int Org_id;
    private String Gmt_create;
    private String Gmt_modified;

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

    public String getGmt_create() {
        return Gmt_create;
    }

    public void setGmt_create(String gmt_create) {
        Gmt_create = gmt_create;
    }

    public String getGmt_modified() {
        return Gmt_modified;
    }

    public void setGmt_modified(String gmt_modified) {
        Gmt_modified = gmt_modified;
    }

    public String getLogin_name() {
        return Login_name;
    }

    public void setLogin_name(String login_name) {
        Login_name = login_name;
    }

    public String getPassword_hash() {
        return Password_hash;
    }

    public void setPassword_hash(String password_hash) {
        Password_hash = password_hash;
    }
}
