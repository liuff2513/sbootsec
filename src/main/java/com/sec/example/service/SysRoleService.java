package com.sec.example.service;

import com.sec.example.entity.SysRole;
import com.sec.example.dao.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: SysRoleService
 * Description: //TODO
 * Created by feifei.liu on 2017/10/22 13:50
 **/
@Service
public class SysRoleService {
    @Autowired(required = false)
    SysRoleMapper sysRoleMapper;
    public List<SysRole> findRolesByUsername(String username) {
        return sysRoleMapper.findRolesByUsername(username);
    }
}
