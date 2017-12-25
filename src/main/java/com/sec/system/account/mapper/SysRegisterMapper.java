package com.sec.system.account.mapper;

import com.sec.system.account.entity.SysRegister;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * ClassName: SysRegisterMapper
 * Description:
 * Created by liuff on 2017/10/23 23:40.
 */
@Component
@Mapper
public interface SysRegisterMapper extends BaseMapper<SysRegister> {
}
