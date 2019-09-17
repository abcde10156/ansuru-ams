package com.ansuru.ams.client;

import com.ansuru.ams.common.utils.JsonUtils;
import com.ansuru.ams.svr.user.service.UserAdminService;
import com.ansuru.ams.web.security.LoginController;
import com.ansuru.ams.web.security.dto.request.RequestWebLogin;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.HttpServletRequest;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestLogin {

    private MockMvc mockMvc;


    UserAdminService userAdminService;
    @Autowired
    public void setUserAdminService(UserAdminService userAdminService) {
        this.userAdminService = userAdminService;
    }

    @Before
    public void setUp() {
        LoginController apiController = new LoginController();
        apiController.setUserAdminService(userAdminService);
        mockMvc = MockMvcBuilders.standaloneSetup(apiController).build();
    }

    @Test
    public void testGetSequence() {
        try {
            RequestWebLogin webLogin = new RequestWebLogin();
            webLogin.setUsername("admin123321321312321321321");
            webLogin.setPassword("123456");
            String s = JsonUtils.toJson(webLogin);
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                    .content(s.getBytes())
                    .contentType("Application/json")
            )
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            int status = mvcResult.getResponse().getStatus();
            System.out.println("请求状态码：" + status);
            String result = mvcResult.getResponse().getContentAsString();
            System.out.println("接口返回结果：" + result);

            // 判断接口返回json中success字段是否为true
//            Assert.assertTrue(resultObj.getBooleanValue("success"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
