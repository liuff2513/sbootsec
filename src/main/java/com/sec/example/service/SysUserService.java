package com.sec.example.service;

import com.sec.example.entity.SysUser;
import com.sec.example.dao.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: SysUserService
 * Description: //TODO
 * Created by feifei.liu on 2017/10/22 13:19
 **/
@Service
public class SysUserService {
    @Autowired(required = false)
    SysUserMapper sysUserMapper;

    public SysUser findByUsername(String username){
//        SysUser sysUser = new SysUser();
//        sysUser.setUsername("feifei.liu@pcstars.com");
//        sysUser.setPassword(new BCryptPasswordEncoder().encode("crm123"));
//        sysUserMapper.insert(sysUser);
        return sysUserMapper.findByUsername(username);
    }
}
