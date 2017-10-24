package com.sec.system.accout.service;

import com.sec.example.entity.SysRole;
import com.sec.example.entity.SysUser;
import com.sec.example.mapper.SysRoleMapper;
import com.sec.example.mapper.SysUserMapper;
import com.sec.system.accout.entity.SysRegister;
import com.sec.system.accout.mapper.SysRegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: SysRegisterService
 * Description:
 * Created by liuff on 2017/10/23 23:42.
 */
@Service
public class SysRegisterService {
    @Autowired
    private SysRegisterMapper sysRegisterMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public boolean register(SysRegister sysRegister, HttpServletRequest request) {
        try {
            String password = bCryptPasswordEncoder.encode(sysRegister.getPassword());
            sysRegister.setPassword(password);
            sysRegisterMapper.insert(sysRegister);
            SysUser sysUser = new SysUser();
            sysUser.setUsername(sysRegister.getUsername());
            sysUser.setPassword(password);
            sysUserMapper.insert(sysUser);
            SysUser sysUser1 = sysUserMapper.findByUsername(sysRegister.getUsername());
            SysRole sysRole = sysRoleMapper.findByName("ROLE_ADMIN");
            sysUserMapper.insertUserRole(sysUser1.getId(), sysRole.getId());
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
