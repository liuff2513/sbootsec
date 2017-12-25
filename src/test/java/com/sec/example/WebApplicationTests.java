package com.sec.example;

import com.sec.core.util.SpringContextUtil;
import com.sec.system.account.service.SysRegisterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {

	@Test
	public void contextLoads() {
		SysRegisterService sysRegisterService = SpringContextUtil.getBean(SysRegisterService.class);
		System.out.println(sysRegisterService.encrypt("crm123"));
	}

}
