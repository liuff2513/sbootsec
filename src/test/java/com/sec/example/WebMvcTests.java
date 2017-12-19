package com.sec.example;

import com.sec.bbs.web.WelcomeController;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName: WebMvcTests
 * Description: //TODO
 * Created by feifei.liu on 2017/12/19 20:56
 **/
@RunWith(SpringRunner.class)
@WebMvcTest(WelcomeController.class)
public class WebMvcTests {
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private UserVehicleService userVehicleService;
//
//    @Test
//    public void testExample() throws Exception {
//        given(this.userVehicleService.getVehicleDetails("sboot"))
//                .willReturn(new VehicleDetails("Honda", "Civic"));
//        this.mvc.perform(get("/sboot/vehicle").accept(MediaType.TEXT_PLAIN))
//                .andExpect(status().isOk()).andExpect(content().string("Honda Civic"));
//    }

}
