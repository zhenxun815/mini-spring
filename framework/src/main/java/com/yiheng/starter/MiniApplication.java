package com.yiheng.starter;

import com.yiheng.web.server.TomcatServer;
import org.apache.catalina.LifecycleException;

/**
 * @author Yiheng
 * @since 2021/12/20 20:56
 */
public class MiniApplication {
    public static void run(Class<?> cls,String[] args){
        System.out.println("My mini-spring!");

        TomcatServer tomcatServer = new TomcatServer(args);
        try {
            tomcatServer.startServer();
        }catch (LifecycleException e){
            e.printStackTrace();
        }
    }
}
