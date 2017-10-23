package com.sec.example.mapper;

import com.sec.example.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * ClassName: SysUserMapper
 * Description: //TODO
 * Created by feifei.liu on 2017/10/22 13:18
 **/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    @Select("select * from sys_user where username=#{username}")
    SysUser findByUsername(String username);
}
