package com.ansuru.ams;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class MainWeb {
    public static void startup(String path,String appName, int port) throws Exception {
        Server server = new Server(port);
        WebAppContext webapp = new WebAppContext(path, appName);
        server.setHandler(webapp);
        server.start();
        server.join();
    }//D:\JavaProject\teacher-web\src\test\java\com.noriental\Jetty_Teacher.java

    public static void main(String[] args)throws Exception{


        startup("E:\\project\\ansuru\\ansuru-ams\\ansuru-ams-web\\src\\main\\webapp", "/", 7000);
    }
}
