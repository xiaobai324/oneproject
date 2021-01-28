package com.bh.oneproject.pojo;

import java.util.Date;

/**
 * @Author:JL
 * @Date:2021/1/27
 */
public class Customer {
    private String cid;             //客户id
    private String cname;           //名字
    private String gender;          //性别
    private Date birthday;        //生日
    private String cellphone;       //电话
    private String email;           //邮箱
    private String description;     //描述
    private String ebable;          //数据的显隐
    public Customer(){}

    public Customer(String cname, String gender, String cellphone, String email) {
        this.cname = cname;
        this.gender = gender;
        this.cellphone = cellphone;
        this.email = email;
    }

    public Customer(String cid, String cname, String gender, Date birthday, String cellphone, String email, String description, String ebable) {
        this.cid = cid;
        this.cname = cname;
        this.gender = gender;
        this.birthday = birthday;
        this.cellphone = cellphone;
        this.email = email;
        this.description = description;
        this.ebable = ebable;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEbable() {
        return ebable;
    }

    public void setEbable(String ebable) {
        this.ebable = ebable;
    }
}
