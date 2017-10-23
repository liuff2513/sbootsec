package com.sec.system.accout.entity;

import com.sec.core.entity.IdEntity;

/**
 * ClassName: SysRegister
 * Description:
 * Created by liuff on 2017/10/23 23:36.
 */
public class SysRegister extends IdEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
