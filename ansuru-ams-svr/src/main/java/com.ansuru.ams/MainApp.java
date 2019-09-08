package com.ansuru.ams;

import com.ansuru.ams.svr.user.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args)throws Exception{
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = (UserService) app.getBean("userService");
        System.out.println("userService = " + userService);

    }
}
