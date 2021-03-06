package com.sec.example.mapper;

import com.sec.example.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * ClassName: SysRoleMapper
 * Description: //TODO
 * Created by feifei.liu on 2017/10/22 13:47
 **/
@Component
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    @Select("select r.* from sys_role r,sys_user u,sys_user_roles ru where r.id=ru.roles_id and u.id=ru.sys_user_id and u.username=#{username}")
    List<SysRole> findRolesByUsername(String username);

    @Select("select r.* from sys_role r where r.name=#{name}")
    SysRole findByName(String name);
}
