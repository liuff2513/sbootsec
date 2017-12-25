package com.sec.system.account.entity;

import com.sec.core.entity.IdEntity;

import java.util.Date;

/**
 * ClassName: SysRegister
 * Description:
 * Created by liuff on 2017/10/23 23:36.
 */
public class SysRegister extends IdEntity {
    private String name;
    private String username;
    private String password;
    private String email;
    private String mobilePhone;
    private Date createdTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
